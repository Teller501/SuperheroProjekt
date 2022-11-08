package Superhero;

import java.util.ArrayList;

public class Database {

    // attributes
    private ArrayList<Superhero> superheroes = new ArrayList<>();
    private boolean changes = false;


    // creating superhero from parameters
    public Superhero createSuperHero(String realName, String heroName,
                                     int creationYear, String superPower, boolean isHuman, double power) {
        Superhero newSuperHero = new Superhero(realName, heroName, creationYear, superPower, isHuman, power);
        superheroes.add(newSuperHero);

        changes = true;
        return newSuperHero;
    }

    // getter for superhero ArrayList
    public ArrayList<Superhero> getAllSuperheroes() {
        return superheroes;
    }

    public ArrayList<Superhero> searchForSuperhero(String searchTerm) {
        ArrayList<Superhero> searchResults = new ArrayList<>(); // creating arraylist of superheroes

        // Loop through arraylist of superheroes, return if matching searchTerm
        for (Superhero superhero : superheroes) {
            String name = superhero.getHeroName().toLowerCase(); // making all characters in superhero name lower case
            if (name.contains(searchTerm.toLowerCase().trim())) { // if superhero contains searchTerm, add superhero to arraylist
                searchResults.add(superhero);
            }
        }
        // return searchResult
        return searchResults;
    }

    public boolean deleteSuperhero(Superhero superhero) {

        getAllSuperheroes().remove(superhero);
        boolean success = true;
        changes = true;

        return success;
    }

    public boolean isChanges() {
        return changes;
    }
}
