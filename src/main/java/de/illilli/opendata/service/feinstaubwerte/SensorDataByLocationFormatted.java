package de.illilli.opendata.service.feinstaubwerte;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Locale;

import de.illilli.opendata.service.feinstaubwerte.model.SensorDataByLocation;

public class SensorDataByLocationFormatted {

	public String locationid;
	public String distance;
	public String datum;
	public String temperature;
	public String humidity;
	public String p1;
	public String p2;

	public SensorDataByLocationFormatted(SensorDataByLocation data, Locale locale) {
		this.locationid = data.locationid + "";
		this.distance = Double.toString(round(data.distance, 1));
		this.datum = new SimpleDateFormat("dd.MM.yyyy hh:mm", locale).format(data.datum);
		this.temperature = Double.toString(round(data.temperature, 1));
		this.humidity = Double.toString(round(data.humidity, 1));
		this.p1 = Double.toString(round(data.p1, 1));
		this.p2 = Double.toString(round(data.p2, 1));
	}

	public static double round(double value, int places) {
		if (places < 0) {
			throw new IllegalArgumentException();
		}
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((humidity == null) ? 0 : humidity.hashCode());
		result = prime * result + ((locationid == null) ? 0 : locationid.hashCode());
		result = prime * result + ((p1 == null) ? 0 : p1.hashCode());
		result = prime * result + ((p2 == null) ? 0 : p2.hashCode());
		result = prime * result + ((temperature == null) ? 0 : temperature.hashCode());
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
		SensorDataByLocationFormatted other = (SensorDataByLocationFormatted) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (humidity == null) {
			if (other.humidity != null)
				return false;
		} else if (!humidity.equals(other.humidity))
			return false;
		if (locationid == null) {
			if (other.locationid != null)
				return false;
		} else if (!locationid.equals(other.locationid))
			return false;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (p2 == null) {
			if (other.p2 != null)
				return false;
		} else if (!p2.equals(other.p2))
			return false;
		if (temperature == null) {
			if (other.temperature != null)
				return false;
		} else if (!temperature.equals(other.temperature))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SensorDataByLocationFormatted [locationid=" + locationid + ", distance=" + distance + ", datum=" + datum
				+ ", temperature=" + temperature + ", humidity=" + humidity + ", p1=" + p1 + ", p2=" + p2 + "]";
	}

}
