package de.illilli.opendata.service.feinstaubwerte.jdbc;

/**
 * Repräsentiert einen Sensor Eintrag in der Datenbank
 * 
 * <pre>
CREATE TABLE SENSOR (
  id           integer PRIMARY KEY, 
  pin          varchar(256),
  modtime      timestamp DEFAULT current_timestamp
);
 * </pre>
 */
public class SensorDTO {

	private int id;
	private String pin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((pin == null) ? 0 : pin.hashCode());
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
		SensorDTO other = (SensorDTO) obj;
		if (id != other.id)
			return false;
		if (pin == null) {
			if (other.pin != null)
				return false;
		} else if (!pin.equals(other.pin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SensorDTO [id=" + id + ", pin=" + pin + "]";
	}

}
