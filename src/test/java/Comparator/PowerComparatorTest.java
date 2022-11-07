package Comparator;

import Superhero.Database;
import Superhero.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PowerComparatorTest {
    private Database database;

    @BeforeEach
    public void setup(){
        database  = new Database();

    }

    @Test
    void testGreaterThan() {
        // Arrange
        ArrayList<Superhero> results = new ArrayList<Superhero>();
        CreationYearComparator creationYearComparator = new CreationYearComparator();

        Superhero s2 = database.createSuperHero("Bruce Wayne", "Batman",1939,"Stærk",true,2);
        Superhero s1 = database.createSuperHero("Clark Kent", "Superman", 1998, "Superhuman strength", true, 4);

        results.add(s1);
        results.add(s2);


        int expected = 1;

        int actual = creationYearComparator.compare(s1,s2);

        assertEquals(expected,actual);

    }

    @Test
    void testEquals() {
        // Arrange
        ArrayList<Superhero> results = new ArrayList<Superhero>();
        CreationYearComparator creationYearComparator = new CreationYearComparator();

        Superhero s2 = database.createSuperHero("Bruce Wayne", "Batman",1939,"Stærk",true,2);
        Superhero s1 = database.createSuperHero("Clark Kent", "Superman", 1939, "Superhuman strength", true, 1);

        results.add(s1);
        results.add(s2);


        int expected = 0;

        int actual = creationYearComparator.compare(s1,s2);

        assertEquals(expected,actual);

    }

    @Test
    void testLessThan() {
        // Arrange
        ArrayList<Superhero> results = new ArrayList<Superhero>();
        CreationYearComparator creationYearComparator = new CreationYearComparator();

        Superhero s2 = database.createSuperHero("Bruce Wayne", "Batman",1939,"Stærk",true,4);
        Superhero s1 = database.createSuperHero("Clark Kent", "Superman", 1921, "Superhuman strength", true, 4);

        results.add(s1);
        results.add(s2);


        int expected = -1;

        int actual = creationYearComparator.compare(s1,s2);

        assertEquals(expected,actual);

    }
}