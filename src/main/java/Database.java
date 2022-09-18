import java.util.ArrayList;

public class Database {

    // attributes
    private ArrayList<Superhero> superheroes = new ArrayList<>();


    // TEST DATA - Delete when done
    public void createTestData(){
        createSuperHero("Bruce Wayne", "Batman", 2001, "Rig", true,2);
        createSuperHero("Tony Stark", "Iron Man", 1998, "Flyve", true,2);
        createSuperHero("Ved ikke", "Black Panther", 2001, "Rig", true,2);
        createSuperHero("Ved ikke", "Iron Panther", 2001, "Rig", true,2);
        createSuperHero("Ved ikke", "Superman", 2001, "Rig", true,2);
    }

    // creating superhero from parameters
    public void createSuperHero(String realName, String heroName,
                                int creationYear, String superPower, boolean isHuman, double power){
        Superhero newSuperHero = new Superhero(realName, heroName, creationYear, superPower, isHuman, power);
        superheroes.add(newSuperHero);

    }

    // getter for superhero ArrayList
    public ArrayList<Superhero> getAllSuperheroes(){
        return superheroes;
    }
    ArrayList<Superhero> searchResults = new ArrayList<>();
    public Superhero searchForSuperhero(String searchTerm){
        Superhero searchResult = null;

        // Loop through arraylist of superheroes, return if matching searchTerm
        for (Superhero superhero : superheroes){
            String name = superhero.getHeroName().toLowerCase(); // making all characters in superhero name lower case
            if (name.contains(searchTerm.toLowerCase())){ // if superhero contains searchTerm, return superhero
                searchResults.add(superhero);
                searchResult = superhero;
            }
        }
        // none found, return null
        return searchResult;
    }

    public ArrayList<Superhero> getSearchResults() {
        return searchResults;
    }
}
