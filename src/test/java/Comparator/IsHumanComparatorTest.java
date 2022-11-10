package Comparator;

import Superhero.Database;
import Superhero.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IsHumanComparatorTest {

    private Database database;

    @BeforeEach
    public void setup() {
        database = new Database();
    }

    @Test
    void testIsHumanEquals(){

        // Arrange
        ArrayList <Superhero> results = new ArrayList<Superhero>();
        FlexibleComparator isHumanComparator = new FlexibleComparator("isHuman");

        // Act
        Superhero superhero1 = database.createSuperHero("Bruce Wayne", "Batman", 1996,"Rich", true, 2);
        Superhero superhero2 = database.createSuperHero("Tony Stark", "Iron Man", 1997, "Rich", true, 2);

        results.add(superhero1);
        results.add(superhero2);


        int expected = 0;
        int actual = isHumanComparator.compare(superhero1,superhero2);

        // Assert
        assertEquals(expected, actual);


    }

    @Test
    void testIsHumanGreaterThan(){

        // Arrange
        ArrayList <Superhero> results = new ArrayList<Superhero>();
        FlexibleComparator isHumanComparator = new FlexibleComparator("isHuman");

        // Act
        Superhero superhero1 = database.createSuperHero("Bruce Wayne", "Batman", 1996,"Rich", true, 2);
        Superhero superhero2 = database.createSuperHero("Tony Stark", "Iron Man", 1997, "Rich", false, 2);

        results.add(superhero1);
        results.add(superhero2);


        int expected = 1;
        int actual = isHumanComparator.compare(superhero1,superhero2);

        // Assert
        assertEquals(expected, actual);


    }

    @Test
    void testIsHumanLessThan(){

        // Arrange
        ArrayList <Superhero> results = new ArrayList<Superhero>();
        FlexibleComparator isHumanComparator = new FlexibleComparator("isHuman");

        // Act
        Superhero superhero1 = database.createSuperHero("Bruce Wayne", "Batman", 1996,"Rich", false, 2);
        Superhero superhero2 = database.createSuperHero("Tony Stark", "Iron Man", 1997, "Rich", true, 2);

        results.add(superhero1);
        results.add(superhero2);


        int expected = -1;
        int actual = isHumanComparator.compare(superhero1,superhero2);

        // Assert
        assertEquals(expected, actual);


    }

}
