package no.hiof.larseknu.oblig4.repository;

import no.hiof.larseknu.oblig4.model.Planet;
import no.hiof.larseknu.oblig4.model.PlanetSystem;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public interface IUniversityRepository {
    PlanetSystem getPlanetSystem(String planetSystemName);
    ArrayList<PlanetSystem> getPlanetSystems();
    Planet getPlanet(String planetSystemName, String planet);
    ArrayList<Planet> getPlanets(String planetSystemName);
    HashMap<String, PlanetSystem> planetSystemerFraFil(File filSomLesesFra);


    //Opprette en planet

    //Oppdatere en planet

    //Slette en planet
}
