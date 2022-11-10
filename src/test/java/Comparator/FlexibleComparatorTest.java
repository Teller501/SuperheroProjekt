package Comparator;

import Superhero.Database;
import Superhero.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class FlexibleComparatorTest {

    private Database database;

    @BeforeEach
    public void setup(){
        database  = new Database();

    }

    @Test
    void testGreaterThanCreationYear() {
        // Arrange
        ArrayList<Superhero> results = new ArrayList<Superhero>();
        Comparator creationYearComparator = new FlexibleComparator("creationYear");

        Superhero s2 = database.createSuperHero("Bruce Wayne", "Batman",1939,"Stærk",true,2);
        Superhero s1 = database.createSuperHero("Clark Kent", "Superman", 1998, "Superhuman strength", true, 4);

        results.add(s1);
        results.add(s2);


        int expected = 1;

        int actual = creationYearComparator.compare(s1,s2);

        assertEquals(expected,actual);

    }

    @Test
    void testEqualsCreationYear() {
        // Arrange
        ArrayList<Superhero> results = new ArrayList<Superhero>();
        Comparator creationYearComparator = new FlexibleComparator("creationYear");

        Superhero s2 = database.createSuperHero("Bruce Wayne", "Batman",1939,"Stærk",true,2);
        Superhero s1 = database.createSuperHero("Clark Kent", "Superman", 1939, "Superhuman strength", true, 4);

        results.add(s1);
        results.add(s2);


        int expected = 0;

        int actual = creationYearComparator.compare(s1,s2);

        assertEquals(expected,actual);

    }

    @Test
    void testLessThanCreationYear() {
        // Arrange
        ArrayList<Superhero> results = new ArrayList<Superhero>();
        Comparator creationYearComparator = new FlexibleComparator("creationYear");

        Superhero s2 = database.createSuperHero("Bruce Wayne", "Batman",1939,"Stærk",true,2);
        Superhero s1 = database.createSuperHero("Clark Kent", "Superman", 1921, "Superhuman strength", true, 4);

        results.add(s1);
        results.add(s2);


        int expected = -1;

        int actual = creationYearComparator.compare(s1,s2);

        assertEquals(expected,actual);

    }

    @Test
    void testGreaterThanPower() {
        // Arrange
        ArrayList<Superhero> results = new ArrayList<Superhero>();
        Comparator powerComparator = new FlexibleComparator("power");

        Superhero s2 = database.createSuperHero("Bruce Wayne", "Batman",1939,"Stærk",true,2);
        Superhero s1 = database.createSuperHero("Clark Kent", "Superman", 1998, "Superhuman strength", true, 4);

        results.add(s1);
        results.add(s2);


        int expected = 1;

        int actual = powerComparator.compare(s1,s2);

        assertEquals(expected,actual);

    }

    @Test
    void testEqualsPower() {
        // Arrange
        ArrayList<Superhero> results = new ArrayList<Superhero>();
        Comparator powerComparator = new FlexibleComparator("power");

        Superhero s2 = database.createSuperHero("Bruce Wayne", "Batman",1939,"Stærk",true,2);
        Superhero s1 = database.createSuperHero("Clark Kent", "Superman", 1939, "Superhuman strength", true, 4);

        results.add(s1);
        results.add(s2);


        int expected = 0;

        int actual = powerComparator.compare(s1,s2);

        assertEquals(expected,actual);

    }

    @Test
    void testLessThanPower() {
        // Arrange
        ArrayList<Superhero> results = new ArrayList<Superhero>();
        Comparator powerComparator = new FlexibleComparator("power");

        Superhero s2 = database.createSuperHero("Bruce Wayne", "Batman",1939,"Stærk",true,2);
        Superhero s1 = database.createSuperHero("Clark Kent", "Superman", 1921, "Superhuman strength", true, 4);

        results.add(s1);
        results.add(s2);


        int expected = -1;

        int actual = powerComparator.compare(s1,s2);

        assertEquals(expected,actual);

    }

    @Test
    void testEqualsHeroName() {
        // Arrange
        ArrayList<Superhero> results = new ArrayList<Superhero>();
        Comparator heroNameComparator = new FlexibleComparator("heroName");

        Superhero s2 = database.createSuperHero("Bruce Wayne", "Batman",1939,"Stærk",true,2);
        Superhero s1 = database.createSuperHero("Clark Kent", "Batman", 1939, "Superhuman strength", true, 4);

        results.add(s1);
        results.add(s2);


        int expected = 0;

        int actual = heroNameComparator.compare(s1,s2);

        assertEquals(expected,actual);

    }



}