import Superhero.Superhero;
import Superhero.Controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Comparator.FlexibleComparator;
import java.util.ArrayList;
import java.util.Comparator;

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

    @Test
    void sortRealName() {
        controller.createSuperHero("Anders", "test", 1, "nej",true, 1);
        controller.createSuperHero("Bob", "test", 1, "nej",true, 1);
        controller.createSuperHero("Dennis", "test", 1, "nej",true, 1);
        controller.createSuperHero("Chris", "test", 1, "nej",true, 1);
        controller.sort("realName","");

        ArrayList<Superhero> results = controller.getAllSuperheroes();

        assertEquals("Anders",results.get(0).getRealName());
        assertEquals("Bob",results.get(1).getRealName());
        assertEquals("Chris",results.get(2).getRealName());
        assertEquals("Dennis",results.get(3).getRealName());

    }
    @Test
    void sortCreationYear() {
        controller.createSuperHero("Anders", "test", 210, "nej",true, 1);
        controller.createSuperHero("Bob", "test", 910, "nej",true, 1);
        controller.createSuperHero("Dennis", "test", 400, "nej",true, 1);
        controller.createSuperHero("Chris", "test", 5000, "nej",true, 1);
        controller.sort("creationYear","");

        ArrayList<Superhero> results = controller.getAllSuperheroes();

        assertEquals(210,results.get(0).getCreationYear());
        assertEquals(400,results.get(1).getCreationYear());
        assertEquals(910,results.get(2).getCreationYear());
        assertEquals(5000,results.get(3).getCreationYear());

    }
}