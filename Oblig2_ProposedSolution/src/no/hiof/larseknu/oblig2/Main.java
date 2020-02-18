package no.hiof.larseknu.oblig2;

public class Main {

	public static void main(String[] args) {
		Star theSun = new Star("Sun", 695700, 1.98892E30, 5777);

		PlanetSystem solarSystem = new PlanetSystem("Solar System", theSun);

		// Instansierer og legger planetene direkte til i planetsystemet
		solarSystem.addPlanet(new Planet("Mercury", 3.283E23, 2439.7,0.387,0.206,88,theSun));
		solarSystem.addPlanet(new Planet("Venus", 4.867E24, 6051.8, 0.723, 0.007, 225, theSun));
		solarSystem.addPlanet(new Planet("Earth", 5.972E24, 6371, 1, 0.017, 365, theSun));
		solarSystem.addPlanet(new Planet("Mars", 6.39E23, 3389.5, 1.524, 0.093, 687,theSun));
		solarSystem.addPlanet(new Planet("Jupiter", 1.898E27, 71492, 5.20440, 0.049, 4380,theSun));
		solarSystem.addPlanet(new Planet("Saturn", 5.683E26, 58232, 9.5826, 0.057, 10585, theSun));
		solarSystem.addPlanet(new Planet("Uranus", 8.681E25, 25362, 19.2184, 0.046, 30660,theSun));
		solarSystem.addPlanet(new Planet("Neptune", 1.024E26, 24622, 30.11, 0.010, 60225,theSun));

		System.out.println(solarSystem);

		// Henter ut en referanse til hver planet
		Planet mercury = solarSystem.getPlanets().get(0);
		Planet venus = solarSystem.getPlanets().get(1);
		Planet earth = solarSystem.getPlanets().get(2);
		Planet mars = solarSystem.getPlanets().get(3);
		Planet jupiter = solarSystem.getPlanets().get(4);
		Planet saturn = solarSystem.getPlanets().get(5);
		Planet uranus = solarSystem.getPlanets().get(5);
		Planet neptune = solarSystem.getPlanets().get(7);


		System.out.println("First planet: " + mercury);
		System.out.println("Third planet: " + earth);

		System.out.println("----Mjup & Rjup---");
		System.out.println(String.format("%s has a Jupiter Mass of %f and a Jupiter Radius of %f", saturn.getName(), saturn.getMassInMjup(), saturn.getRadiusInRjup()));

		System.out.println("----Msun & Rsun---");
		System.out.println(String.format("%s has a Solar Mass of %f and a Solar Radius of %f ", theSun.getName(), theSun.getMassInMsun(), theSun.getReadiusInRsun()));

		System.out.println("----Mearth & Rearth---");
		System.out.println(String.format("%s has a Earth Mass of %f and a Earth Radius of %f ", mars.getName(), mars.getMassInMearth(), mars.getRadiusInRearth()));

		System.out.println("----Surface gravity---");
		System.out.println("The surface gravity of " + earth.getName() + " is " + earth.getSurfaceGravity());
		System.out.println("The surface gravity of " + neptune.getName() + " is " + neptune.getSurfaceGravity());

		System.out.println("----Largest and Smallest---");
		Planet smallestPlanet = solarSystem.getSmallestPlanet();
		Planet largestPlanet = solarSystem.getLargestPlanet();

		System.out.println(smallestPlanet.getName() + " is the smallest planet in the " + solarSystem.getName());
		System.out.println(largestPlanet.getName() + " is the largest planet in the " + solarSystem.getName());

		System.out.println("----oppgave 2.2---");
		System.out.println("Planet " + neptune.getName() + " has a radius of " + neptune.getRadius() +
				"km and a mass of " + neptune.getMass() + "kg");

		System.out.println("Planet " + mercury.getName() + " has a radius of " + mercury.getRadius() +
				"km and a mass of " + mercury.getMass() + "kg");


		//oppgave 2.5b:
		System.out.println("---oppgave2.5b---");
		System.out.println("Earth has a distance of " + earth.distanceTOCentralBody(0) + "km to the Sun at 0 degrees.");
		System.out.println("Earth has a distance of " + earth.distanceTOCentralBody(90) + "km to the Sun at 90 degrees.");
		System.out.println("Earth has a distance of " + earth.distanceTOCentralBody(180) + "km to the Sun at 180 degrees.");
		System.out.println("Earth has a distance of " + earth.distanceTOCentralBody(270) + "km to the Sun at 270 degrees.");
		System.out.println("Earth has a distance of " + earth.distanceTOCentralBody(3600) + "km to the Sun at 360 degrees.");

		// oppgave 2.6:
		System.out.println("---oppgave2.6b---");
		System.out.println("At a distance of " + earth.distanceTOCentralBody(0) + " km," + " Earth has a velocity of " + earth.orbitingVelocity(earth.distanceTOCentralBody(0)) + " km/s");
		System.out.println("At a distance of " + earth.distanceTOCentralBody(45) + " km," + " Earth has a velocity of " + earth.orbitingVelocity(earth.distanceTOCentralBody(45))+ " km/s");
		System.out.println("At a distance of " + earth.distanceTOCentralBody(90) + " km," + " Earth has a velocity of " + earth.orbitingVelocity(earth.distanceTOCentralBody(90))+ " km/s");
		System.out.println("At a distance of " + earth.distanceTOCentralBody(135) + " km," + " Earth has a velocity of " + earth.orbitingVelocity(earth.distanceTOCentralBody(135))+ " km/s");
		System.out.println("At a distance of " + earth.distanceTOCentralBody(180) + " km," + " Earth has a velocity of " + earth.orbitingVelocity(earth.distanceTOCentralBody(180))+ " km/s");

	}



}
