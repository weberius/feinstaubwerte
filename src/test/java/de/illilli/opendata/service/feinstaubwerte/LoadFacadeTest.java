package de.illilli.opendata.service.feinstaubwerte;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.naming.NamingException;

import de.illilli.jdbc.ConnectionEnvironment;

public class LoadFacadeTest {

	public static void main(String[] args) throws IOException, ParseException, SQLException, NamingException {

		ConnectionEnvironment.setUpConnectionForJndi();
		new LoadFacade(LoadFacadeTest.class.getResourceAsStream("/sds-data.json"));
	}

}
