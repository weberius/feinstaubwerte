package de.illilli.opendata.service.feinstaubwerte;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.Facade;

@Path("/")
public class Service {

	private final static Logger logger = Logger.getLogger(Service.class);
	public static final String ENCODING = Config.getProperty("encoding");

	@Context
	private HttpServletRequest request;
	@Context
	private HttpServletResponse response;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/ping")
	public String getEmpty() {
		logger.info("/ping called");
		return "{\"status\":\"alive\"}";
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/sensordata/{number}")
	public String getSensordataById(@PathParam("number") int number) throws UnsupportedEncodingException {

		logger.info("/feinstaubwerte/service/sensordata/" + number);
		request.setCharacterEncoding(Config.getProperty("encoding"));
		response.setCharacterEncoding(Config.getProperty("encoding"));
		return "";
	}

	/**
	 * Beispiel: <a href=
	 * "http://localhost:8080/feinstaubwerte/service/sensordata/7.0/50.959">
	 * /feinstaubwerte/service/sensordata/<lng>/<lat></a>
	 * 
	 * @param lng
	 * @param lat
	 * @return
	 * @throws SQLException
	 * @throws NamingException
	 * @throws IOException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/sensordata/{lng}/{lat}")
	public String getSensordataByLngLat(@PathParam("lng") double lng, @PathParam("lat") double lat)
			throws SQLException, NamingException, IOException {

		logger.info("/feinstaubwerte/serive/sensordata/" + lng + "/" + lat + " called");
		request.setCharacterEncoding(Config.getProperty("encoding"));
		response.setCharacterEncoding(Config.getProperty("encoding"));
		return new SensorDataByLngLatFacade(lng, lat).getJson();

	}

	/**
	 * <p>
	 * Dieser Service holt die Feinstaubwerte vom Server und persistiert sie in
	 * der Datenbank.
	 * </p>
	 * <code>curl -X PUT http://localhost:8080/feinstaubwerte/service/load</code>
	 *
	 * @param wahlgebiet
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 * @throws ParseException
	 */
	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/load")
	public String load() throws IOException, SQLException, NamingException, ParseException {

		logger.info("/load called");
		Facade facade = new LoadFacade();
		return facade.getJson();
	}

}
