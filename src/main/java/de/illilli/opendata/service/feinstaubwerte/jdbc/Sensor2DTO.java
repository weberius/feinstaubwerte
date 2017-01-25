package de.illilli.opendata.service.feinstaubwerte.jdbc;

import de.illilli.opendata.service.feinstaubwerte.model.Sensor;

public class Sensor2DTO extends SensorDTO {

	public Sensor2DTO(Sensor sensor) {
		setId(sensor.id);
		setPin(sensor.pin);
	}
}
