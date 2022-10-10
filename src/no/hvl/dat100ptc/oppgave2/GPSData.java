package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;
	
	// Lager referansetabell fra Klassen GPSPoint
	public GPSData(int n) {

		// TODO - START
		antall = 0;
		gpspoints = new GPSPoint[n];
		// TODO - Dette konstrutøren
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;

		// TODO - START
		if (antall<gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			inserted = true;
		}
		
		return inserted;

		// TODO - SLUTT
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		gpspoints = GPSPoint;
		boolean inserted = insertGPS(gpspoints);
		
		return inserted;

		// TODO - START
		

		// TODO - SLUTT
		
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");
		
		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
		// System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
