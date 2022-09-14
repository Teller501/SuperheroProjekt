import java.util.ArrayList;

public class Database {

    // attributes
    private ArrayList<Superhero> superheroes = new ArrayList<>();



    // method der opretter en superhero i arrayet
    public void createSuperHero(String realName, String heroName,
                                int creationYear, String superPower, boolean isHuman, double power){
        Superhero newSuperHero = new Superhero(realName, heroName, creationYear, superPower, isHuman, power);
        superheroes.add(newSuperHero);

    }

    // getter til superhero arrayet
    public ArrayList<Superhero> getAllSuperheroes(){
        return superheroes;
    }

    public Superhero searchForSuperhero(String searchTerm){
        for (Superhero superhero : superheroes){
            String name = superhero.getHeroName().toLowerCase();
            if (name.contains(searchTerm.toLowerCase())){
                return superhero;
            }else{
                return null;
            }
        }
        return null;
    }

}
