package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.util.List;

import de.illilli.opendata.service.feinstaubwerte.model.SensorDataByLocation;

public class DTO2SensorDataByLocation {

	private SensorDataByLocation data = new SensorDataByLocation();

	public DTO2SensorDataByLocation(List<SensorDataByLocationIdDTO> dtoList) {
		for (SensorDataByLocationIdDTO dto : dtoList) {
			data.locationid = dto.getLocationid();
			data.geojson = dto.getGeojson();
			data.distance = dto.getDistance();
			data.datum = dto.getDatum();
			if ("humidity".equalsIgnoreCase(dto.getValtype())) {
				data.humidity = dto.getVal();
			}
			if ("temperature".equalsIgnoreCase(dto.getValtype())) {
				data.temperature = dto.getVal();
			}
			if ("p1".equalsIgnoreCase(dto.getValtype())) {
				data.p1 = dto.getVal();
			}
			if ("p2".equalsIgnoreCase(dto.getValtype())) {
				data.p2 = dto.getVal();
			}
		}
	}

	public SensorDataByLocation getData() {
		return this.data;
	}
}
