import java.util.ArrayList;

public class Database {

    // attributes
    private ArrayList<Superhero> superheroes;
    private int superHeroesAmount;



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

    // getter til antallet af superheroes
    public int getSuperHeroesAmount(){
        return superHeroesAmount;
    }
}
