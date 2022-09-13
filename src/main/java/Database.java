public class Database {

    // attributes
    private Superhero[] superheroes;
    private int superHeroesAmount;

    public Database(){
        superheroes = new Superhero[5];
        superHeroesAmount = 0;
    }

    // method der opretter en superhero i arrayet
    public void createSuperHero(String realName, String heroName,
                                int creationYear, String superPower, boolean isHuman){
        Superhero newSuperHero = new Superhero(realName, heroName, creationYear, superPower, isHuman);
        superheroes[superHeroesAmount++] = newSuperHero;
    }

    // getter til superhero arrayet
    public Superhero[] getSuperHero(){
        return superheroes;
    }

    // getter til antallet af superheroes
    public int getSuperHeroesAmount(){
        return superHeroesAmount;
    }
}
