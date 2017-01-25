package de.illilli.opendata.service.feinstaubwerte.jdbc;

import de.illilli.opendata.service.feinstaubwerte.model.SensorType;

public class SensorType2DTO extends SensorTypeDTO {

	public SensorType2DTO(SensorType sensorType) {
		super.setId(sensorType.id);
		super.setManufacturer(sensorType.manufacturer);
		super.setName(sensorType.name);
	}
}
