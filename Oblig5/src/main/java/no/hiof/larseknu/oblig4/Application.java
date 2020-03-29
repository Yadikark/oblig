package no.hiof.larseknu.oblig4;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.rendering.vue.VueComponent;
import no.hiof.larseknu.oblig4.controller.PlanetController;
import no.hiof.larseknu.oblig4.controller.PlanetSystemController;
import no.hiof.larseknu.oblig4.model.PlanetSystem;
import no.hiof.larseknu.oblig4.repository.UniverseCSVRepository;
import no.hiof.larseknu.oblig4.repository.UniverseJSONRepository;
import no.hiof.larseknu.oblig4.repository.UniverseJSONRepository2;
import no.hiof.larseknu.oblig4.repository.UniverseRepository;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class Application {



    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7001);

        app.config.enableWebjars();

        app.before("/", ctx -> ctx.redirect("/planet-systems"));


        //prøver
        UniverseRepository universeRepository = new UniverseRepository();
        UniverseJSONRepository2 universeJSONRepository2 = new UniverseJSONRepository2("planets_100.json");
        PlanetSystemController planetSystemController = new PlanetSystemController(universeJSONRepository2);
        PlanetController planetController = new PlanetController(universeJSONRepository2);



        /*UniverseRepository universeRepository = new UniverseRepository();
        UniverseJSONRepository universeJSONRepository = new UniverseJSONRepository("planets_100.json");
        PlanetSystemController planetSystemController = new PlanetSystemController(universeJSONRepository);
        PlanetController planetController = new PlanetController(universeJSONRepository);*/


        /*UniverseCSVRepository universeCSVRepository = new UniverseCSVRepository("planets_100.csv");
        PlanetSystemController planetSystemController = new PlanetSystemController(universeCSVRepository);
        PlanetController planetController = new PlanetController(universeCSVRepository);*/




        app.get("/planet-systems", new VueComponent("planet-system-overview"));
        app.get("/planet-systems/:planet-system-id", new VueComponent("planet-system-detail"));
        app.get("/planet-systems/:planet-system-id/planets/:planet-id", new VueComponent("planet-detail"));


        app.get("api/planet-systems", planetSystemController::getAllPlanetSystems);
        app.get("api/planet-systems/:planet-system-id", planetSystemController::getPlanetSystem);

        app.get("/api/planet-systems/:planet-system-id/planets", planetController::getPlanets);
        app.get("/api/planet-systems/:planet-system-id/planets/:planet-id", planetController::getPlanet);



    }
}
