package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.feinstaubwerte.model.Measurement;

/**
 * Konvertierung "timestamp":"2017-01-16T14:41:01"
 */
public class Measurement2DTO extends MeasurementDTO {

	static final String timestampFormat = Config.getProperty("timestampformat");

	public Measurement2DTO(Measurement measurement) throws ParseException {
		this.setId(measurement.id);
		SimpleDateFormat sdf = new SimpleDateFormat(timestampFormat);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		long time = sdf.parse(measurement.timestamp).getTime();
		Timestamp datum = new Timestamp(time);
		this.setDatum(datum);
	}
}
