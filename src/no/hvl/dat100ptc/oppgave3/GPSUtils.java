package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {



	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;
		
		min = da[0];
		

		// TODO - START

		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;
		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double [] newlatitude = new double[gpspoints.length];
		
		for(int i = 0; i<gpspoints.length; i ++) {
			newlatitude[i] = gpspoints[i].getLatitude();
		}
		
		
		return newlatitude;
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double [] newgetlongitude = new double[gpspoints.length];
		
		for(int i = 0; i<gpspoints.length; i ++) {
			newgetlongitude[i] = gpspoints[i].getLongitude();
		}
		
		
		return newgetlongitude;

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d; //avstand mellom gpspoint1 til gpspoint2
		double latitude1, longitude1, latitude2, longitude2;
		
		latitude1 = gpspoint1.getLatitude();
		latitude2 = gpspoint2.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		longitude2 = gpspoint2.getLongitude();
				// TODO - START
		double a = pow(sin(toRadians(latitude2-latitude1)/2),2) + (cos(toRadians(latitude1)) * cos(toRadians(latitude2)) * pow(sin(toRadians(longitude2-longitude1)/2),2));
		double c = 2*(atan2(sqrt(a),sqrt(1-a))) ; 

		d = R * c;

		// TODO - SLUTT
		return d;


	}
//SPEED metoden kalkulerer gjennomsnittet mellom punkt 1 og punkt 2
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		
		int secs;
		double speed;
		
		double distance = distance(gpspoint1, gpspoint2);
		
		secs = gpspoint2.getTime() - gpspoint1.getTime();


		speed = (distance/secs)*3.6;
		
		System.out.println(speed);
		

		return speed;


	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		int hr = secs/3600; //gir timene
		int min = (secs%3600)/60; // gir minuttene
		int sek = (secs%3600)%60; // gir sekundene
		
		timestr = String.format("  %02d" + TIMESEP + "%02d" + TIMESEP + "%02d", hr, min ,sek);


		// TODO - START

		return timestr;
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;
		
		
		
		str = String.format("%10.2f",d);
		
		
		return str;

		// TODO - START


		// TODO - SLUTT
		
	}
}
