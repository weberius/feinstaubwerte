package de.illilli.opendata.service.feinstaubwerte;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.feinstaubwerte.askfor.AskForFeinstaubdaten;
import de.illilli.opendata.service.feinstaubwerte.jdbc.LoadMeasurementData;
import de.illilli.opendata.service.feinstaubwerte.model.Measurement;

public class LoadFacade implements Facade {

	private static final Logger logger = Logger.getLogger(LoadFacade.class);
	private String msg;

	public LoadFacade() throws IOException, SQLException, NamingException, ParseException {
		AskFor<Measurement[]> askfor = new AskForFeinstaubdaten();
		loadData(askfor.getData());
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
