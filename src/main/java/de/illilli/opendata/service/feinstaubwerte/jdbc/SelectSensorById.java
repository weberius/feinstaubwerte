package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import de.illilli.jdbc.Select;

public class SelectSensorById implements Select<SensorDTO> {

	private final static String sqlFileName = "/sql/selectSensorById.sql";
	private int id;

	public SelectSensorById(int id) {
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
	public Class<SensorDTO> getDtoClazz() {
		return SensorDTO.class;
	}

}
