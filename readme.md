#Feinstaubwerte

# Entwicklungsstand

Dieser Service befinded sich in Entwicklung.

# Schnittstellen

## /feinstaubwerte/service/sensor/{id}

nicht implementiert

## /feinstaubwerte/service/location/{lat}/{lng}

nicht implementiert

## /feinstaubwerte/service/load

Service zum Einlesen der Daten. Der Vorgang kann jederzeit wiederholt werden. 

# Datenbank

## DB User auf Postgres einrichten

    sudo -u postgres createuser -P feinstaubwerte
    
## Datenbank meinsensor anlegen

    sudo -u postgres createdb -O feinstaubwerte feinstaubwerte
    
## Postgis topology

    sudo -u postgres psql -c "CREATE EXTENSION postgis; CREATE EXTENSION postgis_topology;" feinstaubwerte

## DB-Tabellen initial einrichten

    psql -h localhost -U feinstaubwerte -d feinstaubwerte -a -f src/main/sql/feinstaubwerte.init.sql

## Verbindungsparameter

Die Datenbankverbindungsparameter werden per JNDI zur Verfügung gestellt. Dies bedeutet, dass sie im Container definiert sein müssen. Für den Online-Betrieb mit
Tomcat sind folgende Parameter zu setzen:

context.xml

    <Context>
        <ResourceLink 
             name="jdbc/feinstaubwerte" 
             global="jdbc/feinstaubwerte"
             type="javax.sql.DataSource" />
    </Context> 

server.xml

    <GlobalNamingResources>
        <Resource 
            name="jdbc/feinstaubwerte"
            auth="Container"
            driverClassName="org.postgresql.Driver"
            maxTotal="25" 
            maxIdle="10"
            username="username"
            password="password"
            type="javax.sql.DataSource"
            url="jdbc:postgresql://localhost:5432/feinstaubwerte"
            validationQuery="select 1"/>

Zu Testzwecken muss die Datei _src/test/resources/jndi.properties.template_ in _jndi.properties_ umbenannt und die Verbindungsparameter angepasst werden.


# Installation

1. git clone
2. mvn clean install
3. jetty run

## Dependencies

### tomcat

Die Webapplikation benötigt folgende PostGresSQL - Bibliotheken:

- postgis-jdbc-2.1.7.2.jar
- postgresql-9.1-901-1.jdbc4.jar
- postgresql-9.3-1104-jdbc41.jar

Für Entwicklungszwecke werden die Bibliotheken über den build-Mechanismus gezogen. Für die Ausführung auf dem Tomcat müssen sie im _tomcat/lib_ Verzeichnis liegen und dürfen nicht mit der Webapplikation ausgeliefert werden. Aus diesem Grund wird in den dependencies der scope 'provided' verwendet:

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<version>9.3-1104-jdbc41</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>net.postgis</groupId>
			<artifactId>postgis-jdbc</artifactId>
			<version>2.1.7.2</version>
			<scope>provided</scope>
		</dependency>


Die Bibliotheken können von [PostGres JDBC Driver](https://jdbc.postgresql.org/download.html) bezogen werden und müssen manuell in das Verzeichnis _&lt;tomcat-home&gt;/lib_ kopiert werden.

Anmerkung: Die Bibliothek 'postgresql-9.1-901-1.jdbc4.jar' wird über den Maven Mechanismus gezogen.

# License

<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons Lizenzvertrag" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br />Dieses Werk ist lizenziert unter einer <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Namensnennung - Weitergabe unter gleichen Bedingungen 4.0 International Lizenz</a>.
