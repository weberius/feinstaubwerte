package de.illilli.opendata.service.feinstaubwerte.model;

/**
 * <pre>
 *   "sensor_type":{
 *   	"id":14,
 *   	"name":"SDS011",
 *   	"manufacturer":"Nova"
 *   }
 * </pre>
 */
public class SensorType {

	public int id;
	public String name;
	public String manufacturer;

	@Override
	public String toString() {
		return "SensorType [id=" + id + ", name=" + name + ", manufacturer=" + manufacturer + "]";
	}

}
