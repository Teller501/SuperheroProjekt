import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    private Database database;

    @BeforeEach
    public void setup() {
        database = new Database();
    }


    @Test
    void createOneSuperHero() {
        //Arrange
        database.createSuperHero("Bruce Wayne", "Batman", 1939, "None", true, 2);
        int expected = 1;

        //act
        int actual = database.getAllSuperheroes().size();

        //assert
        assertEquals(expected,actual);

    }

    @Test
    void createMultipleSuperheroes(){
        //Arange
        database.createSuperHero("Bruce Wayne", "Batman", 1939, "None", true, 2);
        database.createSuperHero("Clark Kent", "Superman", 1938, "Superhuman strength", true, 4);
        database.createSuperHero("Peter Parker", "Spider-Man", 1962, "Spider-Sense", true, 3);
        database.createSuperHero("Diana Prince", "Wonder Woman", 1941, "Flight", true, 2.5);

        int expected = 4;

        //Act
        int actual = database.getAllSuperheroes().size();

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void searchForZeroSuperhero() {
        ArrayList<Superhero> results = database.searchForSuperhero("man");

        int expected = 0;

        int actual = results.size();

        assertEquals(expected,actual);
    }

    @Test
    void searchForOneSuperhero() {
        //Arrange
        database.createSuperHero("Bruce Wayne", "Batman", 1939, "None", true, 2);
        ArrayList<Superhero> results = database.searchForSuperhero("man");

        int expected = 1;

        int actual = results.size();

        assertEquals(expected,actual);
    }

    @Test
    void searchForMultipleSuperheroes() {
        //Arrange
        database.createSuperHero("Bruce Wayne", "Batman", 1939, "None", true, 2);
        database.createSuperHero("Clark Kent", "Superman", 1938, "Superhuman strength", true, 4);
        database.createSuperHero("Peter Parker", "Spider-Man", 1962, "Spider-Sense", true, 3);
        database.createSuperHero("Diana Prince", "Wonder Woman", 1941, "Flight", true, 2.5);

        //act
        ArrayList<Superhero> results = database.searchForSuperhero("man");

        int expected = 4;
        int actual = results.size();

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    void searchForCase() {
        //Arrange
        database.createSuperHero("Bruce Wayne", "Batman", 1939, "None", true, 2);
        ArrayList<Superhero> results = database.searchForSuperhero("BaTmAn");

        int expected = 1;

        int actual = results.size();

        assertEquals(expected,actual);
    }

    @Test
    void searchForWhitespace() {
        //Arrange
        database.createSuperHero("Bruce Wayne", "Batman", 1939, "None", true, 2);
        ArrayList<Superhero> results = database.searchForSuperhero("  Batman  ");

        int expected = 1;

        int actual = results.size();

        assertEquals(expected,actual);
    }
}