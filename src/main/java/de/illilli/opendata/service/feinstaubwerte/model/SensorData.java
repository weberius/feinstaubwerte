package de.illilli.opendata.service.feinstaubwerte.model;

/**
 * <pre>
 * {
 * 	"id":35911240,
 * 	"value":"26272",
 * 	"value_type":"max_micro"
 * }
 * </pre>
 *
 */
public class SensorData {

	public int id;
	public String value;
	public String value_type;

	@Override
	public String toString() {
		return "SensorDataValue [id=" + id + ", value=" + value + ", value_type=" + value_type + "]";
	}

}
