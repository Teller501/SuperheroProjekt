import Superhero.Superhero;
import Superhero.Controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTest {

    private Controller controller;

    @BeforeEach
    public void setup() {

        controller = new Controller();

    }


    @Test
    void createOneSuperHero() {
        //Arrange
        ArrayList<Superhero> results = new ArrayList<>();

        controller.createSuperHero("Bruce Wayne", "Batman", 1939, "None", true, 2);


        int expected = 1;

        //act
        int actual = controller.getAllSuperheroes().size();

        //assert
        assertEquals(expected,actual);

    }

    @Test
    void createMultipleSuperheroes(){
        controller.createSuperHero("Bruce Wayne", "Batman", 1939, "None", true, 2);
        controller.createSuperHero("Clark Kent", "Superman", 1938, "Superhuman strength", true, 4);
        controller.createSuperHero("Peter Parker", "Spider-Man", 1962, "Spider-Sense", true, 3);
        controller.createSuperHero("Diana Prince", "Wonder Woman", 1941, "Flight", true, 2.5);

        int expected = 4;

        //Act
        int actual = controller.getAllSuperheroes().size();

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void searchForZeroSuperhero() {

        ArrayList<Superhero> results = controller.searchForSuperhero("Black Panther");

        int expected = 0;

        int actual = results.size();

        assertEquals(expected,actual);
    }

    @Test
    void searchForOneSuperhero() {
        //Arrange
        controller.createSuperHero("Bruce Wayne", "Batman", 1939, "None", true, 2);
        ArrayList<Superhero> results = controller.searchForSuperhero("Batman");

        int expected = 1;

        int actual = results.size();

        assertEquals(expected,actual);
    }

    @Test
    void searchForMultipleSuperheroes() {

        //act
        controller.createSuperHero("Bruce Wayne", "Batman", 1939, "None", true, 2);
        controller.createSuperHero("Clark Kent", "Superman", 1939, "None", true, 2);
        controller.createSuperHero("Peter Parker", "Spider-man", 1939, "None", true, 2);
        ArrayList<Superhero> results = controller.searchForSuperhero("man");

        int expected = 3;
        int actual = results.size();

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    void searchForCase() {
        //Arrange
        controller.createSuperHero("Bruce Wayne", "Batman", 1939, "None", true, 2);
        ArrayList<Superhero> results = controller.searchForSuperhero("BaTmAn");

        int expected = 1;

        int actual = results.size();

        assertEquals(expected,actual);
    }

    @Test
    void searchForWhitespace() {
        //Arrange
        controller.createSuperHero("Bruce Wayne", "Batman", 1939, "None", true, 2);
        ArrayList<Superhero> results = controller.searchForSuperhero("  Batman  ");

        int expected = 1;

        int actual = results.size();

        assertEquals(expected,actual);
    }

    @Test
    void deleteSuperhero(){
        ArrayList<Superhero> results = controller.getAllSuperheroes();
        Superhero superhero = controller.getAllSuperheroes().get(0);
        int expectedSize = results.size() - 1;
        //boolean actualResult = controller.deleteSuperhero( superhero );

        boolean expectedResult = true;


        //assertEquals(actualResult, expectedResult);



        ArrayList<Superhero> resultsAfterDelete = controller.getAllSuperheroes();

        int actualSize = resultsAfterDelete.size();

        assertEquals(expectedSize, actualSize);
    }
}