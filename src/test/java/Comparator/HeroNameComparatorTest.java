package Comparator;

import Superhero.Controller;
import Superhero.Superhero;
import Superhero.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HeroNameComparatorTest {

    private Database database;

    @BeforeEach
    public void setup(){
        database  = new Database();
    }

    @Test
    void compareTwo() {
        // Arrange
        ArrayList<Superhero> results = new ArrayList<Superhero>();

        Superhero s2 = database.createSuperHero("Bruce Wayne", "Batman",1939,"Stærk",true,2);
        Superhero s1 = database.createSuperHero("Clark Kent", "Superman", 1938, "Superhuman strength", true, 4);
    }
}