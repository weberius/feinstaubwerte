package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import de.illilli.jdbc.InsertOrUpdate;

/**
 * Insertiert ein MeasurementDTO Object in die Datenbank. Es wird keine
 * Kontrolle übernommen, ob das Objekt bereits existiert.
 * 
 * @author wolfram
 *
 */
public class InsertMeasurement implements InsertOrUpdate {

	static final String sqlFileName = "/sql/insertMeasurement.sql";
	private MeasurementDTO dto;

	public InsertMeasurement(MeasurementDTO dto) {
		this.dto = dto;
	}

	static Object[] getParams(MeasurementDTO dto) {
		return new Object[] { dto.getId(), dto.getDatum() };
	}

	@Override
	public Object[] getParameter() {
		return new Object[] { dto.getId(), dto.getDatum() };
	}

	@Override
	public String getSql() throws IOException {
		InputStream inputStream = InsertMeasurement.class.getResourceAsStream(sqlFileName);
		return IOUtils.toString(inputStream);
	}

}
