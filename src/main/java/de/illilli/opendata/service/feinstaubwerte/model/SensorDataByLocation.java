package de.illilli.opendata.service.feinstaubwerte.model;

import java.util.Date;

public class SensorDataByLocation {

	public int locationid;
	public String geojson;
	public double distance;
	public Date datum;
	public double temperature;
	public double humidity;
	public double p1;
	public double p2;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((geojson == null) ? 0 : geojson.hashCode());
		temp = Double.doubleToLongBits(humidity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + locationid;
		temp = Double.doubleToLongBits(p1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(p2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(temperature);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		SensorDataByLocation other = (SensorDataByLocation) obj;
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
		if (Double.doubleToLongBits(humidity) != Double.doubleToLongBits(other.humidity))
			return false;
		if (locationid != other.locationid)
			return false;
		if (Double.doubleToLongBits(p1) != Double.doubleToLongBits(other.p1))
			return false;
		if (Double.doubleToLongBits(p2) != Double.doubleToLongBits(other.p2))
			return false;
		if (Double.doubleToLongBits(temperature) != Double.doubleToLongBits(other.temperature))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SensorDataByLocationId [locationid=" + locationid + ", geojson=" + geojson + ", distance=" + distance
				+ ", datum=" + datum + ", temperature=" + temperature + ", humidity=" + humidity + ", p1=" + p1
				+ ", p2=" + p2 + "]";
	}

}
