package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);

		
		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {
		
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
	
		double ystep = MAPXSIZE / (Math.abs(maxlat - minlat));
		
		// TODO - START
		
		return ystep;
		// TODO - SLUTT
		
	}

	public void showRouteMap(int ybase) {

        double xstep = this.xstep();
        double ystep = this.ystep();
        System.out.println("xstep: " + xstep + " ystep: " + ystep);

        double minlong = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
        double minlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
        System.out.println("minlong: " + minlong + "minlat: " + minlat);

        int points = gpspoints.length;
        double[] longs = new double [points];
        double[] lats = new double [points];

        for(int i = 0; i < points; i++) {
            longs[i] = gpspoints[i].getLongitude() - minlong;
        }
        for(int i = 0; i < points; i++) {
        lats[i] = gpspoints[i].getLatitude() - minlat;
        }

        setColor(0,225,0);
        for(int i = 0; i < points; i++) {
            int x = (int) (MARGIN + (longs[i]xstep));
            int y = (int) (ybase - (lats[i]ystep));
            if (i == points - 1) {
                setColor(0,0,225);
                fillCircle(x,y,5);
            }
            else { 
                int nextX = (int) (MARGIN + (longs[i+1]xstep));
                int nextY = (int) (ybase - (lats[i+1]ystep));
                if ( i == 0) {
                    setColor(225,0,0);
                    fillCircle(x,y,5);
                    setColor(0,225,0);
                    drawLine(x,y,nextX,nextY);
                } else {
                    fillCircle(x,y,3);
                    drawLine(x,y,nextX,nextY);
                }
            }
        }

    }


	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		// TODO - START
		
		
		// TODO - SLUTT;
	}

}
