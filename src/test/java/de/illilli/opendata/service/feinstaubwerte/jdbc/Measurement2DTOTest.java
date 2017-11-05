package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.feinstaubwerte.model.Measurement;

public class Measurement2DTOTest {

	static final String timestampFormat = Config.getProperty("timestampformat");

	@Test
	public void testTimestampToDate() throws ParseException {

		MeasurementDTO dto = new Measurement2DTO(Measurement2DTOTest.getMeasurementForTest());
		long time = new SimpleDateFormat(timestampFormat).parse("2017-01-16 15:41:01").getTime();
		Timestamp expected = new Timestamp(time);
		Timestamp actual = dto.getDatum();
		Assert.assertEquals(expected, actual);

	}

	static Measurement getMeasurementForTest() {
		Measurement measurement = new Measurement();
		measurement.id = 101;
		measurement.timestamp = "2017-01-16 14:41:01";
		return measurement;
	}

}
