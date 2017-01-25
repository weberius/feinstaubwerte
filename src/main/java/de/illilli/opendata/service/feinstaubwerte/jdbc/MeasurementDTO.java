package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.sql.Timestamp;

/**
 * <pre>
 CREATE TABLE MEASUREMENT (
  id           integer PRIMARY KEY, 
  samplingrate varchar(256),
  datum        timestamp,
  modtime      timestamp DEFAULT current_timestamp
 );
 * 
 * </pre>
 */
public class MeasurementDTO {

	private int id;
	private String samplingrate;
	private Timestamp datum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSamplingrate() {
		return samplingrate;
	}

	public void setSamplingrate(String samplingrate) {
		this.samplingrate = samplingrate;
	}

	public Timestamp getDatum() {
		return datum;
	}

	public void setDatum(Timestamp datum) {
		this.datum = datum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + id;
		result = prime * result + ((samplingrate == null) ? 0 : samplingrate.hashCode());
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
		MeasurementDTO other = (MeasurementDTO) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (id != other.id)
			return false;
		if (samplingrate == null) {
			if (other.samplingrate != null)
				return false;
		} else if (!samplingrate.equals(other.samplingrate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MeasurementDTO [id=" + id + ", samplingrate=" + samplingrate + ", datum=" + datum + "]";
	}

}
