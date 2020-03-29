package no.hiof.larseknu.oblig4.repository;


import no.hiof.larseknu.oblig4.controller.PlanetController;
import no.hiof.larseknu.oblig4.controller.PlanetSystemController;
import no.hiof.larseknu.oblig4.model.CelestialBody;
import no.hiof.larseknu.oblig4.model.Planet;
import no.hiof.larseknu.oblig4.model.PlanetSystem;
import no.hiof.larseknu.oblig4.model.Star;

import javax.crypto.spec.PSource;
import java.io.*;
import java.util.*;

public class UniverseCSVRepository implements IUniversityRepository {
    private String fileName;
    private BufferedReader br = null;

    public void UniverseCSVReository() {

        File kilde = new File("planets_100.csv");
        HashMap<String, PlanetSystem> planetSystemerFraFil = lesFraCSV(kilde);
        //HashMap<String, PlanetSystem> planetSystemerFraFil = skrivTilCSVFil(kilde);

    }


    public UniverseCSVRepository(String fileName) {
        this.fileName = fileName;
        lesFraCSV(new File("planets_100.csv"));

    }


    private static HashMap<String, PlanetSystem> lesFraCSV(File filSomLesesFra) {
        HashMap<String, PlanetSystem> planetSystemerFraFil = new HashMap<>();


        try (BufferedReader bufretLeser = new BufferedReader(new FileReader(filSomLesesFra))) {
            String linje;

            while ((linje = bufretLeser.readLine()) != null) {
                String[] deler = linje.split(",");

                Star star = new Star(deler[2], Double.parseDouble(deler[3]), Double.parseDouble(deler[4]), Double.parseDouble(deler[5]), deler[6]);

                Planet planet = new Planet(deler[7], Double.parseDouble(deler[8]), Double.parseDouble(deler[9]), Double.parseDouble(deler[10]),
                        Double.parseDouble(deler[11]), Double.parseDouble(deler[12]), star , deler[13]);

                PlanetSystem Systems = new PlanetSystem(deler[0], star , deler[1]);
                Systems.addPlanet(planet);

                if (!planetSystemerFraFil.containsKey(Systems.getName())) {
                    planetSystemerFraFil.put(Systems.getName(), Systems);

                 //}else if (planetSystemerFraFil.containsKey(Systems.getName())){
                    //continue;
                }else {
                    planetSystemerFraFil.get(Systems.getName()).addPlanet(planet);

                }


                System.out.println("*******************");
                System.out.println(planetSystemerFraFil.get("Solar System"));//.getPlanets()); /////////////////////////////
                //bufretLeser.close();//slutter å lese, da viser mercury bare en gang istedenfor 100 ganger.

            }
            //System.out.println("******kaos*****");
            //System.out.println(planetSystemerFraFil);//det her printer ut andre planet systemer med en no.hiof.lark..path


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioexc) {
            System.out.println(ioexc.getLocalizedMessage());
        }
        return planetSystemerFraFil;

    }



    @Override
    public PlanetSystem getPlanetSystem(String planetSystemName) {
        return null;
    }

    @Override
    public ArrayList<PlanetSystem> getPlanetSystems() {
        return null;
    }

    @Override
    public Planet getPlanet(String planetSystemName, String planetName) {
        return getPlanetSystem(planetSystemName).getPlanet(planetName);
    }

    @Override
    public ArrayList<Planet> getPlanets(String planetSystemName) {
        return getPlanetSystem(planetSystemName).getPlanets();
    }

    @Override
    public HashMap<String, PlanetSystem> planetSystemerFraFil(File filSomLesesFra) {
        return lesFraCSV(new File("planets_100.csv"));
    }
}













