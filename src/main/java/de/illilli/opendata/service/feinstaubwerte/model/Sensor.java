package de.illilli.opendata.service.feinstaubwerte.model;

/**
 * <pre>
  "sensor":{
    "id":249,
    "pin":"1",
    "sensor_type":{"id":14,"name":"SDS011","manufacturer":"Nova"}
  }
 * 
 * </pre>
 */
public class Sensor {

	public int id;
	public String pin;
	public SensorType sensor_type;

	@Override
	public String toString() {
		return "Sensor [id=" + id + ", pin=" + pin + ", sensor_type=" + sensor_type + "]";
	}

}
