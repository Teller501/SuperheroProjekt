import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    private Database database;

    @BeforeEach
    public void setup() {

        database = new Database();
        database.createSuperHero("Bruce Wayne", "Batman", 1939, "None", true, 2);
        database.createSuperHero("Clark Kent", "Superman", 1938, "Superhuman strength", true, 4);
        database.createSuperHero("Peter Parker", "Spider-Man", 1962, "Spider-Sense", true, 3);
        database.createSuperHero("Diana Prince", "Wonder Woman", 1941, "Flight", true, 2.5);
    }


    @Test
    void createOneSuperHero() {
        //Arrange
        ArrayList<Superhero> results = new ArrayList<>();

        Superhero s1 = database.createSuperHero("Bruce Wayne", "Batman", 1939, "None", true, 2);
        results.add(s1);

        int expected = 1;

        //act
        int actual = results.size();

        //assert
        assertEquals(expected,actual);

    }

    @Test
    void createMultipleSuperheroes(){

        int expected = 4;

        //Act
        int actual = database.getAllSuperheroes().size();

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void searchForZeroSuperhero() {
        ArrayList<Superhero> results = database.searchForSuperhero("Black Panther");

        int expected = 0;

        int actual = results.size();

        assertEquals(expected,actual);
    }

    @Test
    void searchForOneSuperhero() {
        //Arrange
        ArrayList<Superhero> results = database.searchForSuperhero("Batman");

        int expected = 1;

        int actual = results.size();

        assertEquals(expected,actual);
    }

    @Test
    void searchForMultipleSuperheroes() {

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
        ArrayList<Superhero> results = database.searchForSuperhero("BaTmAn");

        int expected = 1;

        int actual = results.size();

        assertEquals(expected,actual);
    }

    @Test
    void searchForWhitespace() {
        //Arrange
        ArrayList<Superhero> results = database.searchForSuperhero("  Batman  ");

        int expected = 1;

        int actual = results.size();

        assertEquals(expected,actual);
    }

    @Test
    void deleteSuperhero(){
        ArrayList<Superhero> results = database.getAllSuperheroes();
        Superhero superhero = database.getAllSuperheroes().get(0);
        int expectedSize = results.size() - 1;
        boolean actualResult = database.deleteSuperhero( superhero );

        boolean expectedResult = true;


        assertEquals(actualResult, expectedResult);



        ArrayList<Superhero> resultsAfterDelete = database.getAllSuperheroes();

        int actualSize = resultsAfterDelete.size();

        assertEquals(expectedSize, actualSize);
    }
}