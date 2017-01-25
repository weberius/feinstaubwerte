package de.illilli.opendata.service.feinstaubwerte.jdbc;

import org.junit.Assert;
import org.junit.Test;

import de.illilli.opendata.service.feinstaubwerte.jdbc.Location2DTO;
import de.illilli.opendata.service.feinstaubwerte.jdbc.LocationDTO;
import de.illilli.opendata.service.feinstaubwerte.model.Location;

public class Location2DTOTest {

	@Test
	public void testLatitude() {

		double delta = 0.0;

		Location location = getLocationForTest();
		LocationDTO dto = new Location2DTO(location);
		double expected = Double.parseDouble(location.latitude);
		double actual = dto.getGeom().getGeometry().getFirstPoint().y;
		Assert.assertEquals(expected, actual, delta);

	}

	Location getLocationForTest() {
		Location location = new Location();
		location.id = 1;
		location.latitude = "5.0002";
		location.longitude = "51.0001";
		return location;
	}

}
