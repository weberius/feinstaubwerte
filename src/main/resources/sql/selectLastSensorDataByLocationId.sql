select 
  sensordata.id,
  sensor.id as sensorid, 
  sensortype.name as sensortype,
  location.id as locationid,
  ST_AsGeoJSON(location.geom) as geojson,
  ST_Distance(location.geom, location.geom::geography) as distance,
  measurement.datum,
  sensordata.valtype,
  sensordata.val
from sensor sensor
  join sensor2sensortype s2s on s2s.sensor = sensor.id
  join sensortype sensortype on s2s.sensortype = sensortype.id
  join measurement2sensor m2s on m2s.sensor = sensor.id
  join measurement measurement on m2s.measurement = measurement.id
  join measurement2location m2l on m2l.measurement = measurement.id
  join location location on location.id = m2l.location
  join measurement2sensordata m2d on m2d.measurement = measurement.id
  join sensordata sensordata on sensordata.id = m2d.sensordata
where 
  location.id = ?
group by
  sensordata.id,
  sensor.id, 
  sensortype.name,
  location.id, 
  location.geom, 
  measurement.datum, 
  sensordata.valtype,
  sensordata.val
order by
  measurement.datum desc
limit 7