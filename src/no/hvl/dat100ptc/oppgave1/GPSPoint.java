package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;



public class GPSPoint {

	// TODO - objektvariable
	public int time;
	private double latitude;
	private double longitude;
	private double elevation;

	public GPSPoint(int time, double latitude, double longitude, double elevation) {

			// TODO - konstruktør
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation; 
			
	}



	public GPSPoint(String time2, String latitude2, String longitude2, String elevation2) {
		// TODO Auto-generated constructor stub
	}



	// TODO - get/set metoder
	public int getTime() {
		
		return time;
		
	}

	public void setTime(int time) {
				
		this.time = time;

	}

	public double getLatitude() {
		return latitude;
		
	}

	public void setLatitude(double latitude) {
		
		this.latitude = latitude;
		
	}

	public double getLongitude() {
		
		return longitude;
	}

	public void setLongitude(double longitude) {
		
		this.longitude = longitude;
	}

	public double getElevation() {
		
		return elevation;
	}

	public void setElevation(double elevation) {
		
		this.elevation = elevation;
	}
	
	public String toString() {
		
		// TODO - start
		String str = "GPS TIME: " + time + "Latitude: " + latitude + " Longitude: " + longitude + " ELevation: " + elevation;
		
		// TODO - slutt
		return str;
	}
}
