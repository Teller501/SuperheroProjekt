import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {
    Database database = new Database();

    public void createSuperHero(String realName, String heroName, int creationYear, String superPower, boolean isHuman, double power) {
        database.createSuperHero(realName,heroName,creationYear,superPower,isHuman,power);
    }

    public ArrayList<Superhero> getAllSuperheroes() {
        return database.getAllSuperheroes();
    }

    public ArrayList<Superhero> searchForSuperhero(String searchTerm) {
        return database.searchForSuperhero(searchTerm);
    }

    public void deleteSuperhero(Superhero deleteSuperhero) {
        database.deleteSuperhero(deleteSuperhero);
    }

    public void saveData() {
        FileHandler fileHandler = new FileHandler();

        try {
            fileHandler.saveData(database.getAllSuperheroes());
        }
        catch (FileNotFoundException e) {
            System.out.println("File do not exist");
        }
    }
}
