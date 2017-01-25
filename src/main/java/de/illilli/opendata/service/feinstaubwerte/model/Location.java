package de.illilli.opendata.service.feinstaubwerte.model;

/**
 * <pre>
 *  "location":{
 *    "id":109,
 *    "latitude":"19.807",
 *    "longitude":"-70.704"
 *  }
 * </pre>
 */
public class Location {

	public int id;
	public String latitude;
	public String longitude;

	@Override
	public String toString() {
		return "Location [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
