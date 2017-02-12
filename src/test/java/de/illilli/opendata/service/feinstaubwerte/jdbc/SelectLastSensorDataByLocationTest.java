package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import de.illilli.jdbc.ConnectionEnvironment;
import de.illilli.jdbc.ConnectionFactory;
import de.illilli.jdbc.Select;
import de.illilli.jdbc.SelectListDao;

public class SelectLastSensorDataByLocationTest {

	public static void main(String[] args) throws IOException, SQLException, NamingException {

		ConnectionEnvironment.setUpConnectionForJndi();
		Connection connection = ConnectionFactory.getConnection();
		connection.setAutoCommit(false);

		double lng = 7.0;
		double lat = 50.959;

		Select<SensorDataByLocationIdDTO> select = new SelectLastSensorDataByLocation(lng, lat);
		List<SensorDataByLocationIdDTO> dtoList = new SelectListDao<>(select, connection).execute();

		for (SensorDataByLocationIdDTO dto : dtoList) {
			System.out.println(dto);
		}
	}

}
