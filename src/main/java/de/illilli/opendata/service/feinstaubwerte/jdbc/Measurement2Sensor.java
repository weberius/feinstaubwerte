package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import de.illilli.jdbc.InsertOrUpdate;

public class Measurement2Sensor implements InsertOrUpdate {

	static final String sqlFileName = "/sql/insertMeasurement2Sensor.sql";
	private int measurementId;
	private int sensorId;

	public Measurement2Sensor(int measurementId, int sensorId) {
		this.measurementId = measurementId;
		this.sensorId = sensorId;
	}

	@Override
	public Object[] getParameter() {
		return new Object[] { this.measurementId, this.sensorId };
	}

	@Override
	public String getSql() throws IOException {
		InputStream inputStream = Measurement2Sensor.class.getResourceAsStream(sqlFileName);
		return IOUtils.toString(inputStream);
	}

}
