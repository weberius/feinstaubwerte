package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import de.illilli.jdbc.InsertOrUpdate;

public class InsertSensorType implements InsertOrUpdate {

	private SensorTypeDTO dto;
	private final static String sqlFileName = "/sql/insertSensorType.sql";

	public InsertSensorType(SensorTypeDTO dto) {
		this.dto = dto;
	}

	@Override
	public Object[] getParameter() {
		return new Object[] { dto.getId(), dto.getName(), dto.getManufacturer() };
	}

	@Override
	public String getSql() throws IOException {
		InputStream inputStream = InsertMeasurement.class.getResourceAsStream(sqlFileName);
		return IOUtils.toString(inputStream);
	}

}
