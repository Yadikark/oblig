package no.hiof.larseknu.oblig2;

public class Planet extends NaturalSatellite {

    //Oppgave 2.3: Vi har satt alle verdiene til konstanter (static final).
    private final static double Rjup = 71492;
    private final static double Mjup = 1.898E27;
    private final static double Rearth = 6371;
    private final static double Mearth = 15.972E24;
    public final static double GravKonstant = 6.67408E-11;


    public Planet(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod, CelestialBody centralCelestialBody) {
        super(name,mass,radius,semiMajorAxis,eccentricity,orbitalPeriod,centralCelestialBody);

    }


    public double getSurfaceGravity() {
        // g = GM / R^2
        return (GravKonstant * mass) / Math.pow(getRadiusInMeter(), 2);
    }


    public double getMassInMjup() {
        return mass / Mjup;
    }

    public double getRadiusInRjup() {
        return radius / Rjup;
    }

    public double getMassInMearth() {
        return mass / Mearth;
    }

    public double getRadiusInRearth() {
        return radius / Rearth;
    }



    private double getRadiusInMeter() {
        return radius * 1000;
    }

    @Override
    public String toString() {
        return String.format("%s has a radius of %.2fkm and a mass of %.2fkg", name, radius, mass);
    }






}
