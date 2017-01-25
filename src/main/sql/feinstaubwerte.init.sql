DROP TABLE IF EXISTS MEASUREMENT;
CREATE TABLE MEASUREMENT (
  id           integer PRIMARY KEY, 
  samplingrate varchar(256),
  datum        timestamp,
  modtime      timestamp DEFAULT current_timestamp
);

DROP TABLE IF EXISTS SENSOR;
CREATE TABLE SENSOR (
  id           integer PRIMARY KEY, 
  pin          varchar(256),
  modtime      timestamp DEFAULT current_timestamp
);

DROP TABLE IF EXISTS SENSORTYPE;
CREATE TABLE SENSORTYPE (
  id           integer PRIMARY KEY, 
  name         varchar(256),
  manufacturer varchar(256),
  modtime      timestamp DEFAULT current_timestamp
);

DROP TABLE IF EXISTS LOCATION;
CREATE TABLE LOCATION (
  id           integer PRIMARY KEY, 
  modtime      timestamp DEFAULT current_timestamp
);
SELECT AddGeometryColumn ('public','location','geom',4326,'POINT',2);

DROP TABLE IF EXISTS SENSORDATA;
CREATE TABLE SENSORDATA (
  id           integer PRIMARY KEY, 
  val          double precision,
  valtype      varchar(32),
  modtime      timestamp DEFAULT current_timestamp
);

DROP TABLE IF EXISTS MEASUREMENT2LOCATION;
CREATE TABLE MEASUREMENT2LOCATION (
  measurement  integer, 
  location     integer
);

DROP TABLE IF EXISTS MEASUREMENT2SENSOR;
CREATE TABLE MEASUREMENT2SENSOR (
  measurement  integer, 
  sensor       integer
);

DROP TABLE IF EXISTS SENSOR2SENSORTYPE;
CREATE TABLE SENSOR2SENSORTYPE (
  sensor       integer, 
  sensortype   integer
);

DROP TABLE IF EXISTS MEASUREMENT2SENSORDATA;
CREATE TABLE MEASUREMENT2SENSORDATA (
  measurement  integer, 
  sensordata   integer
);
