package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import de.illilli.jdbc.ConnectionEnvironment;
import de.illilli.jdbc.ConnectionFactory;
import de.illilli.jdbc.InsertDao;
import de.illilli.opendata.service.feinstaubwerte.jdbc.InsertLocation;
import de.illilli.opendata.service.feinstaubwerte.jdbc.Location2DTO;
import de.illilli.opendata.service.feinstaubwerte.jdbc.LocationDTO;
import de.illilli.opendata.service.feinstaubwerte.model.Location;

/**
 * Dies ist kein Test für das automatisierte Testen. Es ist aber per main
 * möglich manuell die Funktion zu prüfen.
 *
 */
public class InsertLocationTest {

	public static void main(String[] args) throws SQLException, NamingException, IOException {

		ConnectionEnvironment.setUpConnectionForJndi();
		Connection conn = ConnectionFactory.getConnection();
		conn.setAutoCommit(false);
		LocationDTO dto = new Location2DTO(getLocationForTest());
		int actual = new InsertDao(new InsertLocation(dto), conn).execute();
		conn.rollback();
		conn.close();
		System.out.println(actual);
	}

	static Location getLocationForTest() {
		Location location = new Location();
		location.id = -1;
		location.latitude = "5.0002";
		location.longitude = "51.0001";
		return location;
	}

}
