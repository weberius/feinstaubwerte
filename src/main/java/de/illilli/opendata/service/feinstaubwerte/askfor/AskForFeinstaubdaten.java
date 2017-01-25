package de.illilli.opendata.service.feinstaubwerte.askfor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.feinstaubwerte.model.Measurement;

public class AskForFeinstaubdaten implements AskFor<Measurement[]> {

	private static final String urlString = Config.getProperty("de.madavi.sensor.sds.url");
	private Measurement[] measurements = new Measurement[0];

	public AskForFeinstaubdaten() throws IOException {
		this(new URL(urlString).openStream());
	}

	public AskForFeinstaubdaten(InputStream inputStream) throws IOException {
		String json = IOUtils.toString(inputStream);
		measurements = new Gson().fromJson(json, measurements.getClass());
	}

	@Override
	public Measurement[] getData() {
		return measurements;
	}

}
