import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTest {

    private Controller controller;

    @BeforeEach
    public void setup() {

        controller = new Controller();
        controller.createSuperHero("Bruce Wayne", "Batman", 1939, "None", true, 2);
        controller.createSuperHero("Clark Kent", "Superman", 1938, "Superhuman strength", true, 4);
        controller.createSuperHero("Peter Parker", "Spider-Man", 1962, "Spider-Sense", true, 3);
        controller.createSuperHero("Diana Prince", "Wonder Woman", 1941, "Flight", true, 2.5);
    }


    @Test
    void createOneSuperHero() {
        //Arrange
        ArrayList<Superhero> results = new ArrayList<>();

        //Superhero s1 = controller.createSuperHero("Bruce Wayne", "Batman", 1939, "None", true, 2);
       // results.add(s1);

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
        ArrayList<Superhero> results = controller.searchForSuperhero("Batman");

        int expected = 1;

        int actual = results.size();

        assertEquals(expected,actual);
    }

    @Test
    void searchForMultipleSuperheroes() {

        //act
        ArrayList<Superhero> results = controller.searchForSuperhero("man");

        int expected = 4;
        int actual = results.size();

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    void searchForCase() {
        //Arrange
        ArrayList<Superhero> results = controller.searchForSuperhero("BaTmAn");

        int expected = 1;

        int actual = results.size();

        assertEquals(expected,actual);
    }

    @Test
    void searchForWhitespace() {
        //Arrange
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