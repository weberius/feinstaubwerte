package de.illilli.opendata.service.feinstaubwerte;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.google.gson.Gson;

import de.illilli.jdbc.ConnectionFactory;
import de.illilli.jdbc.Select;
import de.illilli.jdbc.SelectListDao;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.feinstaubwerte.jdbc.DTO2SensorDataByLocation;
import de.illilli.opendata.service.feinstaubwerte.jdbc.SelectLastSensorDataByLocation;
import de.illilli.opendata.service.feinstaubwerte.jdbc.SensorDataByLocationIdDTO;
import de.illilli.opendata.service.feinstaubwerte.model.SensorDataByLocation;

public class SensorDataByLngLatFacade implements Facade {

	private SensorDataByLocation data = new SensorDataByLocation();

	public SensorDataByLngLatFacade(double lng, double lat) throws SQLException, NamingException, IOException {

		Connection connection = ConnectionFactory.getConnection();
		Select<SensorDataByLocationIdDTO> select = new SelectLastSensorDataByLocation(lng, lat);
		List<SensorDataByLocationIdDTO> dtoList = new SelectListDao<>(select, connection).execute();
		data = new DTO2SensorDataByLocation(dtoList).getData();
	}

	@Override
	public String getJson() {
		return new Gson().toJson(this.data);
	}

}