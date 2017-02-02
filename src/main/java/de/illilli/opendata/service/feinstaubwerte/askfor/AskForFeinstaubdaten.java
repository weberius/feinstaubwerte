package de.illilli.opendata.service.feinstaubwerte.askfor;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.feinstaubwerte.model.Measurement;

public class AskForFeinstaubdaten implements AskFor<Measurement[]> {

	private Measurement[] measurements = new Measurement[0];

	public AskForFeinstaubdaten(InputStream inputStream) throws IOException {
		String json = IOUtils.toString(inputStream);
		measurements = new Gson().fromJson(json, measurements.getClass());
	}

	@Override
	public Measurement[] getData() {
		return measurements;
	}

}
