package de.illilli.opendata.service.feinstaubwerte;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.feinstaubwerte.askfor.AskForFeinstaubdaten;
import de.illilli.opendata.service.feinstaubwerte.jdbc.LoadMeasurementData;
import de.illilli.opendata.service.feinstaubwerte.model.Measurement;

public class LoadFacade implements Facade {

	private static final Logger logger = Logger.getLogger(LoadFacade.class);
	private String msg;

	public LoadFacade() throws IOException, SQLException, NamingException, ParseException {
		File dir = new File(Config.getProperty("feinstaub.dir"));
		if (!dir.exists()) {
			logger.error("'" + Config.getProperty("feinstaub.dir") + "' does not exist");
		} else if (!dir.isDirectory()) {
			logger.error("'" + Config.getProperty("feinstaub.dir") + "' is no directory");
		} else if (dir.listFiles().length == 0) {
			logger.info("no file found in '" + Config.getProperty("feinstaub.dir") + "'");
		} else {
			File[] fileArray = dir.listFiles();
			for (File file : fileArray) {
				logger.info("read data from '" + file.getAbsolutePath() + "'");
				InputStream inputStream = new FileInputStream(file);
				AskFor<Measurement[]> askfor = new AskForFeinstaubdaten(inputStream);
				inputStream.close();
				loadData(askfor.getData());
				boolean fileDeleted = file.delete();
				if (fileDeleted) {
					logger.info("'" + file.getAbsolutePath() + "' deleted");
				} else {
					logger.error("unable to delete '" + file.getAbsolutePath() + "'");
				}
			}
		}

	}

	LoadFacade(InputStream inputStream) throws IOException, ParseException, SQLException, NamingException {
		AskFor<Measurement[]> askfor = new AskForFeinstaubdaten(inputStream);
		loadData(askfor.getData());
	}

	void loadData(Measurement[] measurements) throws IOException, SQLException, NamingException, ParseException {
		long startLoading = System.currentTimeMillis();

		for (Measurement measurement : measurements) {
			new LoadMeasurementData(measurement);
		}

		long endLoading = System.currentTimeMillis();
		long timeneeded = endLoading - startLoading;
		msg = "{data loaded in " + timeneeded / 1000 + " sec}";
		logger.info(msg);
	}

	@Override
	public String getJson() {
		return msg;
	}
}
