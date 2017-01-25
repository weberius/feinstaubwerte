package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import de.illilli.jdbc.InsertOrUpdate;

public class InsertSensorData implements InsertOrUpdate {

	static final String sqlFileName = "/sql/insertSensorData.sql";
	private SensorDataDTO dto;

	public InsertSensorData(SensorDataDTO dto) {
		this.dto = dto;
	}

	@Override
	public Object[] getParameter() {
		return new Object[] { dto.getId(), dto.getVal(), dto.getValtype() };
	}

	@Override
	public String getSql() throws IOException {
		InputStream inputStream = InsertMeasurement.class.getResourceAsStream(sqlFileName);
		return IOUtils.toString(inputStream);
	}

}
