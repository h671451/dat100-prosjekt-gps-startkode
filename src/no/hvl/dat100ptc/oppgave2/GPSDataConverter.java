package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
    // skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26 
	
	private static int TIME_STARTINDEX = 11; // posisjon for start av tidspunkt i timestr

	public static int toSeconds(String timestr) { // DAT
		String time = timestr.substring(TIME_STARTINDEX,13);
		int i = Integer.parseInt(time);
		
		String minutter = timestr.substring(14,16);
		int j = Integer.parseInt(minutter);
		
		String sekunder = timestr.substring(17,19);
		int x = Integer.parseInt(sekunder);


		int hr = i; // da får du timene
		int min = j; // da får du minuttene
		int secs = x; // da får du sekundene
		int omregning = hr * 60 * 60 + min * 60 + secs;  

		
	

		// OPPGAVE - SLUTT
		return omregning;
	}
	

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {//ADAM

		
		int time = toSeconds(timeStr);

		double latitude = Double.parseDouble(latitudeStr);
		
		double longitude = Double.parseDouble(longitudeStr);
		
		double elevation = Double.parseDouble(elevationStr);
		
		GPSPoint gpspoint = new GPSPoint(time, latitude, longitude, elevation);//lager nytt objekt
	
		
		// TODO - START ;
		
		return gpspoint;
		// OPPGAVE - SLUTT ;
	    
	}
	
}
