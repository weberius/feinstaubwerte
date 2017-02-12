package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

import de.illilli.jdbc.Select;

public class SelectLastSensorDataByLocation implements Select<SensorDataByLocationIdDTO> {

	private final static String sqlFileName = "/sql/selectLastSensorDataByLocation.sql";
	private double lng;
	private double lat;
	private List<SensorDataByLocationIdDTO> sensorDataList;

	public SelectLastSensorDataByLocation(double lng, double lat) {
		this.lng = lng;
		this.lat = lat;
	}

	@Override
	public String getSql() throws IOException {
		InputStream inputStream = InsertMeasurement.class.getResourceAsStream(sqlFileName);
		return IOUtils.toString(inputStream);
	}

	@Override
	public Object[] getParameter() {
		return new Object[] { lng, lat, lng, lat };
	}

	@Override
	public Class<SensorDataByLocationIdDTO> getDtoClazz() {
		return SensorDataByLocationIdDTO.class;
	}

}
