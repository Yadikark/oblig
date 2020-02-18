package no.hiof.larseknu.oblig2;

import java.util.ArrayList;

public class NaturalSatellite extends CelestialBody {
    public double semiMajorAxis;
    public double eccentricity;
    public double orbitalPeriod;
    public CelestialBody centralCelestialBody;
    public final static double astronomicalUnits = 149597871;
    public double formula;


    public NaturalSatellite(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod, CelestialBody centralCelestialBody) {
        super(name, mass, radius);
        this.semiMajorAxis = semiMajorAxis;
        this.eccentricity = eccentricity;
        this.orbitalPeriod = orbitalPeriod;
        this.centralCelestialBody = centralCelestialBody;
    }


    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(double eccentricity) {
        this.eccentricity = eccentricity;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public CelestialBody getCentralCelestialBody() {
        return centralCelestialBody;
    }

    public void setCentralCelestialBody(CelestialBody centralCelestialBody) {
        this.centralCelestialBody = centralCelestialBody;
    }

    //oppgave 2.5a
    // r = (a*(1-Math.pow(e,2)))/( 1 + e*Math.cos() )

    // Metode for å regne ut avstanden mellom en naturlig sattelitt og et objekt.
    //(double degrees), Math.cos() ?????????

    public double distanceTOCentralBody(double degrees) {

        return formula =  ((semiMajorAxis * (1 - Math.pow(eccentricity, 2))) / (1 + eccentricity * Math.cos(Math.toRadians(degrees)))) * astronomicalUnits;
    }

    ///oppgave 2.6a
    // v = Math.sqrt((Gravkonstant * mass)/r)

    public double orbitingVelocity(double distance){
        double avstand;
        return avstand = (Math.sqrt(( Planet.GravKonstant * centralCelestialBody.getMass())/ (distance*1000)))/1000;
    }

    //2.7


    @Override
    public String toString() {
        return "NaturalSatellite{" + "semiMajorAxis=" + semiMajorAxis + ", eccentricity=" + eccentricity + ", orbitalPeriod=" + orbitalPeriod +
                ", centralCelestialBody=" + centralCelestialBody + ", formula=" + formula + '}';
    }
}



