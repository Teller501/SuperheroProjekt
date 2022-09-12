public class Database {

    public void createSuperHero(String realName, String heroName,
                                int creationYear, String superPower, boolean isHuman){
        Superhero superhero = new Superhero(realName, heroName, creationYear, superPower, isHuman);
    }
}
