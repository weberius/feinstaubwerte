package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import de.illilli.jdbc.Select;

public class SelectSensorTypeById implements Select<SensorTypeDTO> {

	private final static String sqlFileName = "/sql/selectSensorTypeById.sql";
	private int id;

	public SelectSensorTypeById(int id) {
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
	public Class<SensorTypeDTO> getDtoClazz() {
		return SensorTypeDTO.class;
	}

}
