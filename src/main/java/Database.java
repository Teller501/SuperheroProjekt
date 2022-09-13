import java.util.ArrayList;

public class Database {

    // attributes
    private ArrayList<Superhero> superheroes = new ArrayList<>();



    // method der opretter en superhero i arrayet
    public void createSuperHero(String realName, String heroName,
                                int creationYear, String superPower, boolean isHuman){
        Superhero newSuperHero = new Superhero(realName, heroName, creationYear, superPower, isHuman);
        superheroes.add(newSuperHero);

    }

    // getter til superhero arrayet
    public ArrayList<Superhero> getSuperHero(){
        return superheroes;
    }

}
