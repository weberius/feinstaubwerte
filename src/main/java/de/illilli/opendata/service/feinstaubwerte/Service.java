package de.illilli.opendata.service.feinstaubwerte;

import java.io.IOException;
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

	/**
	 * <p>Dieser Service holt die Feinstaubwerte vom Server und persistiert sie in der Datenbank.</p>
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
	public String load()
			throws IOException, SQLException, NamingException, ParseException {

		logger.info("/load called");
		Facade facade = new LoadFacade();
		return facade.getJson();
	}

}
