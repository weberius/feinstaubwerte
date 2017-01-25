package de.illilli.opendata.service.feinstaubwerte.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import de.illilli.jdbc.ConnectionFactory;
import de.illilli.jdbc.InsertDao;
import de.illilli.jdbc.SelectDao;
import de.illilli.opendata.service.feinstaubwerte.model.Measurement;
import de.illilli.opendata.service.feinstaubwerte.model.SensorData;

public class LoadMeasurementData {

	private static final Logger logger = Logger.getLogger(LoadMeasurementData.class);

	public LoadMeasurementData(Measurement measurement)
			throws SQLException, NamingException, ParseException, IOException {

		// get one Connection for the whole turn
		Connection conn = ConnectionFactory.getConnection();

		boolean insertMeasurement2Location = false;
		boolean insertMeasurement2Sensor = false;
		boolean insertMeasurmenent2SensorData = false;
		boolean insertSensor2SensorType = false;

		// insert Measurement
		MeasurementDTO measurementDTO = new Measurement2DTO(measurement);
		int measurementId = new Measurement2DTO(measurement).getId();
		// insert only if data is not saved
		if (new SelectDao<MeasurementDTO>(new SelectMeasurementById(measurementId), conn).execute() == null) {
			measurementId = new InsertDao(new InsertMeasurement(measurementDTO), conn).execute();
			insertMeasurement2Location = true;
			insertMeasurement2Sensor = true;
			insertMeasurmenent2SensorData = true;
			logger.debug("insert " + measurementDTO.toString());
		}

		// insert Location
		LocationDTO locationDTO = new Location2DTO(measurement.location);
		int locationId = locationDTO.getId();
		// insert only if location is not saved
		if (new SelectDao<LocationDTO>(new SelectLocationById(locationId), conn).execute() == null) {
			locationId = new InsertDao(new InsertLocation(locationDTO), conn).execute();
			insertMeasurement2Location = true;
			logger.debug("insert " + locationDTO.toString());
		}
		// verknüpfe Measurement mit Location
		if (insertMeasurement2Location) {
			new InsertDao(new Measurement2Location(measurementId, locationId), conn).execute();
		}

		// insert Sensor
		SensorDTO sensorDTO = new Sensor2DTO(measurement.sensor);
		int sensorId = sensorDTO.getId();
		if (new SelectDao<SensorDTO>(new SelectSensorById(sensorId), conn).execute() == null) {
			sensorId = new InsertDao(new InsertSensor(sensorDTO), conn).execute();
			insertMeasurement2Sensor = true;
			insertSensor2SensorType = true;
			logger.debug("insert " + sensorDTO.toString());
		}

		// verknüpfe Measurement mit Sensor, wenn ein neuer Measurement oder
		// Sensor Datensatz vorliegt
		if (insertMeasurement2Sensor) {
			new InsertDao(new Measurement2Sensor(measurementId, sensorId), conn).execute();
		}

		// insert SensorType
		SensorTypeDTO sensorTypeDTO = new SensorType2DTO(measurement.sensor.sensor_type);
		int sensorTypeId = sensorTypeDTO.getId();
		if (new SelectDao<SensorTypeDTO>(new SelectSensorTypeById(sensorTypeId), conn).execute() == null) {
			sensorTypeId = new InsertDao(new InsertSensorType(sensorTypeDTO), conn).execute();
			insertSensor2SensorType = true;
		}
		// verknüpfe SensorType mit Sensor
		if (insertSensor2SensorType) {
			new InsertDao(new Sensor2SensorType(sensorId, sensorTypeId), conn).execute();
		}

		// insert SensorData
		for (SensorData sensorData : measurement.sensordatavalues) {
			SensorDataDTO sensorDataDTO = new SensorData2DTO(sensorData);
			int sensorDataId = sensorDataDTO.getId();
			if (new SelectDao<SensorDataDTO>(new SelectSensorDataById(sensorDataId), conn).execute() == null) {
				sensorDataId = new InsertDao(new InsertSensorData(sensorDataDTO), conn).execute();
				insertMeasurmenent2SensorData = true;
				logger.debug("insert " + sensorDataDTO.toString());
			}
			// verknüpfe Measurement mit SensorData
			if (insertMeasurmenent2SensorData) {
				new InsertDao(new Measurement2SensorData(measurementId, sensorDataId), conn).execute();
			}
		}

		// close connection
		conn.close();

	}
}
