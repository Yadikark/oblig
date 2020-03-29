package no.hiof.larseknu.oblig4.repository;


import com.fasterxml.jackson.databind.ObjectMapper;
import no.hiof.larseknu.oblig4.model.Planet;
import no.hiof.larseknu.oblig4.model.PlanetSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class UniverseJSONRepository implements IUniversityRepository {
    private String fileName;
    private ArrayList<PlanetSystem> planetSystems = new ArrayList<>();

    public UniverseJSONRepository(String fileName) {
        this.fileName = fileName;
        lesFraJson();
        skrivTilJson();
    }

    public void lesFraJson() {
        try {

            ObjectMapper objectMapper = new ObjectMapper();

            PlanetSystem[] planetSystemerArray = objectMapper.readValue(new File(this.fileName), PlanetSystem[].class);

            Collections.addAll(planetSystems, planetSystemerArray);

        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        System.out.println(planetSystems);
    }

    
   public void skrivTilJson() {
        try {
            System.out.println(planetSystems);

            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(this.fileName), planetSystems);

        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public PlanetSystem getPlanetSystem(String planetSystemName) {
        for (PlanetSystem planetSystem : planetSystems) {
            if (planetSystem.getName().equals(planetSystemName)) {
                return planetSystem;
            }
        }

        return null;
    }

    @Override
    public ArrayList<PlanetSystem> getPlanetSystems() {
        return new ArrayList<>(planetSystems);
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
        return null;
    }
}









































    /*public static ArrayList<PlanetSystem> lesFraJSONFil(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();

        ArrayList<PlanetSystem> planetListFromFile = new ArrayList<>();

        //hva med andre filen?
        try {
            PlanetSystem[] planetsArray = objectMapper.readValue(new File(fileName), PlanetSystem[].class);

            planetListFromFile.addAll(Arrays.asList(planetsArray));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return planetListFromFile;
    }*/

    /*public static List<Planet> lesFraJson(String filnavn) {
        List<PlanetSystem> karakterer = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Karakter[] karakterArray = objectMapper.readValue(new File(filnavn), Karakter[].class);

            karakterer = Arrays.asList(karakterArray);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        return karakterer;
    }*/

    //oppgave 2d
   /* public UniverseJSONRepository(String path, String cmd)  {
       this.path = path;
       this.cmd = cmd;

    }

    private void checkCmd(){
        switch (cmd){
            case("planets_100.json"):
                break;
            case("planets_4000.json"):
                break;
            default:
                System.out.println("Error: Feil kommando");
        }
    }

    private void write100Planets(){
        try {
            FileWriter fWriter = new FileWriter("C:\\Users\\Daniel\\Documents\\Prog2\\Oblig5\\Oblig5\\planets_100");

            BufferedWriter bWritter = new BufferedWriter(fWriter);

            for()



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void write4000Planets(){
        try {
            FileWriter fWriter = new FileWriter("C:\\Users\\Daniel\\Documents\\Prog2\\Oblig5\\Oblig5\\planets_4000");

            BufferedWriter bWritter = new BufferedWriter(fWriter);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/




