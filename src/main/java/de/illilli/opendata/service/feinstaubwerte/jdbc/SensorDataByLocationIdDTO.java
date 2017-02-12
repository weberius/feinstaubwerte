package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.sql.Timestamp;

/**
 * <pre>
  sensordata.id,
  sensor.id as sensorid, 
  sensortype.name as sensortype,
  location.id as locationid,
  ST_AsGeoJSON(location.geom) as geojson,
  ST_Distance(location.geom, ST_MakePoint(?, ?)::geography) as distance,
  measurement.datum,
  sensordata.valtype,
  sensordata.val
 * </pre>
 */
public class SensorDataByLocationIdDTO {

	private int id;
	private int sensorid;
	private String sensortype;
	private int locationid;
	private String geojson;
	private double distance;
	private Timestamp datum;
	private String valtype;
	private double val;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSensorid() {
		return sensorid;
	}

	public void setSensorid(int sensorid) {
		this.sensorid = sensorid;
	}

	public String getSensortype() {
		return sensortype;
	}

	public void setSensortype(String sensortype) {
		this.sensortype = sensortype;
	}

	public int getLocationid() {
		return locationid;
	}

	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}

	public String getGeojson() {
		return geojson;
	}

	public void setGeojson(String geojson) {
		this.geojson = geojson;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Timestamp getDatum() {
		return datum;
	}

	public void setDatum(Timestamp datum) {
		this.datum = datum;
	}

	public String getValtype() {
		return valtype;
	}

	public void setValtype(String valtype) {
		this.valtype = valtype;
	}

	public double getVal() {
		return val;
	}

	public void setVal(double val) {
		this.val = val;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((geojson == null) ? 0 : geojson.hashCode());
		result = prime * result + id;
		result = prime * result + locationid;
		result = prime * result + sensorid;
		result = prime * result + ((sensortype == null) ? 0 : sensortype.hashCode());
		temp = Double.doubleToLongBits(val);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((valtype == null) ? 0 : valtype.hashCode());
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
		SensorDataByLocationIdDTO other = (SensorDataByLocationIdDTO) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (Double.doubleToLongBits(distance) != Double.doubleToLongBits(other.distance))
			return false;
		if (geojson == null) {
			if (other.geojson != null)
				return false;
		} else if (!geojson.equals(other.geojson))
			return false;
		if (id != other.id)
			return false;
		if (locationid != other.locationid)
			return false;
		if (sensorid != other.sensorid)
			return false;
		if (sensortype == null) {
			if (other.sensortype != null)
				return false;
		} else if (!sensortype.equals(other.sensortype))
			return false;
		if (Double.doubleToLongBits(val) != Double.doubleToLongBits(other.val))
			return false;
		if (valtype == null) {
			if (other.valtype != null)
				return false;
		} else if (!valtype.equals(other.valtype))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SensorDataByLocationIdDTO [id=" + id + ", sensorid=" + sensorid + ", sensortype=" + sensortype
				+ ", locationid=" + locationid + ", geojson=" + geojson + ", distance=" + distance + ", datum=" + datum
				+ ", valtype=" + valtype + ", val=" + val + "]";
	}

}
