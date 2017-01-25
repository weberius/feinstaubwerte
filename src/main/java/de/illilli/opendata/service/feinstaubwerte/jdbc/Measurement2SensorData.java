package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import de.illilli.jdbc.InsertOrUpdate;

public class Measurement2SensorData implements InsertOrUpdate {

	static final String sqlFileName = "/sql/insertMeasurement2SensorData.sql";
	private int measurementId;
	private int sensorDataId;

	public Measurement2SensorData(int measurementId, int sensorDataId) {
		this.measurementId = measurementId;
		this.sensorDataId = sensorDataId;
	}

	@Override
	public Object[] getParameter() {
		return new Object[] { this.measurementId, this.sensorDataId };
	}

	@Override
	public String getSql() throws IOException {
		InputStream inputStream = Measurement2Sensor.class.getResourceAsStream(sqlFileName);
		return IOUtils.toString(inputStream);
	}

}
