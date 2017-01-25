package de.illilli.opendata.service.feinstaubwerte.jdbc;

/**
 * <pre>
CREATE TABLE SENSORDATA (
  id           integer PRIMARY KEY, 
  val          double precision,
  val_type     varchar(8),
  modtime      timestamp DEFAULT current_timestamp
);
 * 
 * </pre>
 */
public class SensorDataDTO {

	private int id;
	private double val;
	private String valtype;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getVal() {
		return val;
	}

	public void setVal(double val) {
		this.val = val;
	}

	public String getValtype() {
		return valtype;
	}

	public void setValtype(String valtype) {
		this.valtype = valtype;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		long temp;
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
		SensorDataDTO other = (SensorDataDTO) obj;
		if (id != other.id)
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
		return "SensorDataDTO [id=" + id + ", val=" + val + ", valtype=" + valtype + "]";
	}

}
