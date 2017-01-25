package de.illilli.opendata.service.feinstaubwerte.jdbc;

import org.apache.commons.lang3.math.NumberUtils;

import de.illilli.opendata.service.feinstaubwerte.model.SensorData;

public class SensorData2DTO extends SensorDataDTO {

	public SensorData2DTO(SensorData data) {
		setId(data.id);
		double val = NumberUtils.toDouble(data.value);
		setVal(val);
		setValtype(data.value_type);
	}
}
