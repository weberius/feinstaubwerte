package de.illilli.opendata.service.feinstaubwerte.model;

import java.util.Arrays;

/**
 * <pre>
 * {
  "id":7443279,
  "sampling_rate":null,
  "timestamp":"2017-01-16T14:41:01",
  "sensordatavalues":[
    {"id":35911240,"value":"26272","value_type":"max_micro"},
    {"id":35911239,"value":"110","value_type":"min_micro"},
    {"id":35911236,"value":"47.25","value_type":"P1"},
    {"id":35911237,"value":"5.88","value_type":"P2"},
    {"id":35911238,"value":"489515","value_type":"samples"}
  ],
  "location":{"id":109,"latitude":"19.807","longitude":"-70.704"},
  "sensor":{
    "id":249,
    "pin":"1",
    "sensor_type":{"id":14,"name":"SDS011","manufacturer":"Nova"}
  }
}
 * </pre>
 */
public class Measurement {

	public int id;
	public String sampling_rate;
	public String timestamp;
	public SensorData[] sensordatavalues;
	public Location location;
	public Sensor sensor;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((sampling_rate == null) ? 0 : sampling_rate.hashCode());
		result = prime * result + ((sensor == null) ? 0 : sensor.hashCode());
		result = prime * result + Arrays.hashCode(sensordatavalues);
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Measurement other = (Measurement) obj;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (sampling_rate == null) {
			if (other.sampling_rate != null)
				return false;
		} else if (!sampling_rate.equals(other.sampling_rate))
			return false;
		if (sensor == null) {
			if (other.sensor != null)
				return false;
		} else if (!sensor.equals(other.sensor))
			return false;
		if (!Arrays.equals(sensordatavalues, other.sensordatavalues))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Measurement [id=" + id + ", sampling_rate=" + sampling_rate + ", timestamp=" + timestamp
				+ ", sensordatavalues=" + Arrays.toString(sensordatavalues) + ", location=" + location + ", sensor="
				+ sensor + "]";
	}

}
