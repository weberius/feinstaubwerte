select 
  sensor.pin, 
  location.geom, 
  sensortype.name sensortypename, 
  sensortype.manufacturer sensormanufacturer,
  measurement.datum
from sensor sensor
  join location2sensor l2s on l2s.sensor = sensor.id
  join location location on l2s.location = location.id
  join sensor2sensortype s2s on s2s.sensor = sensor.id
  join sensortype sensortype on s2s.sensortype = sensortype.id
  join sensor2measurement s2m on s2m.sensor = sensor.id
  join measurement measurement on s2m.measurement = measurement.id
where 
  location.id = 110;