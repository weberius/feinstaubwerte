package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import de.illilli.jdbc.Select;

public class SelectSensorDataById implements Select<SensorDataDTO> {

	private final static String sqlFileName = "/sql/selectSensorDataById.sql";
	private int id;

	public SelectSensorDataById(int id) {
		this.id = id;
	}

	@Override
	public String getSql() throws IOException {
		InputStream inputStream = InsertMeasurement.class.getResourceAsStream(sqlFileName);
		return IOUtils.toString(inputStream);
	}

	@Override
	public Object[] getParameter() {
		return new Object[] { id };
	}

	@Override
	public Class<SensorDataDTO> getDtoClazz() {
		return SensorDataDTO.class;
	}
}
