package de.illilli.opendata.service.feinstaubwerte.jdbc;

import org.postgis.PGgeometry;

/**
 * <pre>
 CREATE TABLE LOCATION (
  id           integer PRIMARY KEY, 
  modtime      timestamp DEFAULT current_timestamp
 );
 SELECT AddGeometryColumn ('public','location','geom',4326,'POINT',2);
 * 
 * </pre>
 */
public class LocationDTO {

	private int id;
	private PGgeometry geom;
	private String geojson;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PGgeometry getGeom() {
		return geom;
	}

	public void setGeom(PGgeometry geom) {
		this.geom = geom;
	}

	public String getGeojson() {
		return geojson;
	}

	public void setGeojson(String geojson) {
		this.geojson = geojson;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((geojson == null) ? 0 : geojson.hashCode());
		result = prime * result + ((geom == null) ? 0 : geom.hashCode());
		result = prime * result + id;
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
		LocationDTO other = (LocationDTO) obj;
		if (geojson == null) {
			if (other.geojson != null)
				return false;
		} else if (!geojson.equals(other.geojson))
			return false;
		if (geom == null) {
			if (other.geom != null)
				return false;
		} else if (!geom.equals(other.geom))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LocationDTO [id=" + id + ", geom=" + geom + ", geojson=" + geojson + "]";
	}

}
