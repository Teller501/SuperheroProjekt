public class Database {

    private Superhero[] superheroes;
    private int superHeroesAmount;

    public Database(){
        superheroes = new Superhero[5];
        superHeroesAmount = 0;
    }

    public void createSuperHero(String realName, String heroName,
                                int creationYear, String superPower, boolean isHuman){
        Superhero newSuperHero = new Superhero(realName, heroName, creationYear, superPower, isHuman);
        superheroes[superHeroesAmount++] = newSuperHero;
    }

    public Superhero[] getSuperHero(){
        return superheroes;
    }

    public int getSuperHeroesAmount(){
        return superHeroesAmount;
    }
}
