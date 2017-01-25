package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.io.IOUtils;

import de.illilli.jdbc.InsertOrUpdate;

public class Measurement2Location implements InsertOrUpdate {

	static final String sqlFileName = "/sql/insertMeasurement2Location.sql";
	private int measurementId;
	private int locationId;

	public Measurement2Location(int measurementId, int locationId) throws SQLException, IOException, NamingException {
		this.measurementId = measurementId;
		this.locationId = locationId;
	}

	static Object[] getParams(int measurementId, int locationId) {
		return new Object[] { measurementId, locationId };
	}

	@Override
	public Object[] getParameter() {
		return new Object[] { measurementId, locationId };
	}

	@Override
	public String getSql() throws IOException {
		InputStream inputStream = InsertMeasurement.class.getResourceAsStream(sqlFileName);
		return IOUtils.toString(inputStream);
	}

}
