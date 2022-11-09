package Superhero;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import Comparator.FlexibleComparator;

public class Controller {
    Database database = new Database();
    FileHandler fileHandler = new FileHandler();

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

        try {
            fileHandler.saveData(database.getAllSuperheroes());
        }
        catch (FileNotFoundException e) {
            System.out.println("File do not exist");
        }
    }

    public void loadData() {
        try {
            fileHandler.loadData(database.getAllSuperheroes());
        }
        catch (FileNotFoundException e) {
            System.out.println("File do not exist");
        }
        
    }

    public ArrayList<Superhero> sort(String sortInput) {
        Comparator comparator = new FlexibleComparator(sortInput);
        database.getAllSuperheroes().sort(comparator);
        return database.getAllSuperheroes();
    }
    public ArrayList<Superhero> sort(String primary, String secondary) {
        Comparator comparator = new FlexibleComparator(primary);
        database.getAllSuperheroes().sort(comparator.thenComparing(new FlexibleComparator(secondary)));
        return database.getAllSuperheroes();
    }

    public boolean isChanges(){
        return database.isChanges();
    }

    public void setChanges(boolean changes){
        database.setChanges(changes);
    }
}
