package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import de.illilli.jdbc.InsertOrUpdate;

public class Sensor2SensorType implements InsertOrUpdate {

	private final static String sqlFileName = "/sql/insertSensor2SensorType.sql";
	int sensorId;
	int sensorTypeId;

	public Sensor2SensorType(int sensorId, int sensorTypeId) {
		this.sensorId = sensorId;
		this.sensorTypeId = sensorTypeId;
	}

	@Override
	public Object[] getParameter() {
		return new Object[] { sensorId, sensorTypeId };
	}

	@Override
	public String getSql() throws IOException {
		InputStream inputStream = InsertMeasurement.class.getResourceAsStream(sqlFileName);
		return IOUtils.toString(inputStream);
	}

}
