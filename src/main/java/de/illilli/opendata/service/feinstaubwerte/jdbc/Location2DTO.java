package de.illilli.opendata.service.feinstaubwerte.jdbc;

import org.postgis.Geometry;
import org.postgis.PGgeometry;
import org.postgis.Point;

import de.illilli.opendata.service.feinstaubwerte.model.Location;

public class Location2DTO extends LocationDTO {

	public Location2DTO(Location location) {

		PGgeometry geom = null;
		super.setId(location.id);
		if (location.latitude != null || location.longitude != null) {
			double latitude = Double.parseDouble(location.latitude);
			double longitude = Double.parseDouble(location.longitude);
			Geometry point = new Point(longitude, latitude);
			point.setSrid(4326);
			geom = new PGgeometry(point);
		}

		super.setGeom(geom);
	}
}
