package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	// beregn total distances (i meter)
	public double totalDistance() { //ADAM

		double distance = 0;
		for(int i = 0; i<gpspoints.length-1; i++) {
			if ( i<gpspoints.length) {
				distance += GPSUtils.distance(gpspoints[i], gpspoints[i+1]);
			} 
			
		}
		
		
		return distance;
		

	}

	// beregn totale høydemeter (i meter)
	public double totalElevation() {// 

		double elevation = 0;
		double mediElevation;
		
		for(int i =0; i<gpspoints.length-1; i++) {
			mediElevation = gpspoints[i+1].getElevation() - gpspoints[i].getElevation();
			if(gpspoints[i+1].getElevation() > gpspoints[i].getElevation() && gpspoints[i].getElevation() != gpspoints[i+1].getElevation()) {// dette betyr at høydegraden beveger seg oppover
				elevation += mediElevation;
			}
		}

		return elevation;

	}

	// beregn total tiden for hele turen (i sekunder)
	public int totalTime() {
		
		
		int totaltime = gpspoints[gpspoints.length-1].getTime() - gpspoints[0].getTime();
		
	
		return totaltime;


	}
		
	// beregn gjennomsnitshastighets mellom hver av gps punktene

	public double[] speeds() {
		double[] GNS = new double [gpspoints.length-1];

		
		for(int i = 0; i<gpspoints.length-1; i++) {
			
			GNS[i] = GPSUtils.speed(gpspoints[i],gpspoints[i+1]);
			
			
		}
		
		
		return GNS;

	}
	
	public double maxSpeed() {
		
		double speed[] = new double [gpspoints.length-1];
	
		
		// TODO - START
		for(int i = 0; i<gpspoints.length-1; i++) {
			speed[i] = GPSUtils.speed(gpspoints[i],gpspoints[i+1]);

		}
		return GPSUtils.findMax(speed);
		
		
		// TODO - SLUTT
	}

	public double averageSpeed() {

		double average = 0;
		average = (totalDistance()/totalTime())*3.6;

	
		return average;
		// TODO - SLUTT
		
	}

	/*
	 * bicycling, <10 mph, leisure, to work or for pleasure 4.0 bicycling,
	 * general 8.0 bicycling, 10-11.9 mph, leisure, slow, light effort 6.0
	 * bicycling, 12-13.9 mph, leisure, moderate effort 8.0 bicycling, 14-15.9
	 * mph, racing or leisure, fast, vigorous effort 10.0 bicycling, 16-19 mph,
	 * racing/not drafting or >19 mph drafting, very fast, racing general 12.0
	 * bicycling, >20 mph, racing, not drafting 16.0
	 */

	// conversion factor m/s to miles per hour
	public static double MS = 2.236936;

	// beregn kcal gitt weight og tid der kjøres med en gitt hastighet
	public double kcal(double weight, int secs, double speed) { //DAT

		double kcal;

		// MET: Metabolic equivalent of task angir (kcal x kg-1 x h-1)
		double met = 0;		
		double speedmph = speed * MS;
		double hours= secs/3600;
		
		
		if(speedmph<10) { met = 4;}
		if(speedmph>=10 && speedmph<=12) {met = 6;}
		if(speedmph>=12 && speedmph<=14) {met = 8;}
		if(speedmph>=14 && speedmph<=16) {met = 10;}
		if(speedmph>=16 && speedmph<=20){
			return met = 12;
		} else if (speedmph>20) {
			return met = 16;
		}
		
		kcal = met * weight * hours;
		
//		met = kcal*Math.pow(weight,-1)*Math.pow(secs,-1);

		return kcal;
		// TODO - SLUTT
		
	}

	public double totalKcal(double weight) {
//		int [] secs =  new int [gpspoints.length-1];

//		double totalkcal = 0;
//		double [] avgspeed = new double [gpspoints.length-1];
//		double [] x = new double [gpspoints.length-1];
//		int secs = totalTime();
//
//		
//		
//		for(int i = 0; i<gpspoints.length-1; i ++) {
//			avgspeed[i] = GPSUtils.speed(gpspoints[i], gpspoints[i+1]);//gir gjennomsnitthastigheten
//			secs[i] = gpspoints[i+1].getTime()-gpspoints[i].getTime(); //gir sekundene per gpspunkt
//			
//			x[i] += kcal(weight,secs,avgspeed[i]*MS); 
//			totalkcal += x[i];
//		}
		
		return kcal(weight,this.totalTime(),this.averageSpeed());
		// TODO - SLUTT
		
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		System.out.println("==============================================");
		System.out.println("Total Time      : " + GPSUtils.formatTime(totalTime()));
		System.out.println("Total distance  : " + GPSUtils.formatDouble(totalDistance()/1000) + " km");
		System.out.println("Total elevation : " + GPSUtils.formatDouble(totalElevation()) + " m");
		
//		System.out.println("Max Speed       : " + GPSUtils.formatDouble(this.maxSpeed()) + " km/t");

		System.out.println("Average Speed   : " + GPSUtils.formatDouble(averageSpeed()) + " km/t");
//		System.out.println("Energy  : " + GPSUtils.formatDouble(totalKcal()) + " kcal");





		


		
	}

}
