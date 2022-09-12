import javax.xml.crypto.Data;

public class Database {

    private Superhero[] superheroes;
    private int antalSuperHeroes;

    public Database(){
        superheroes = new Superhero[5];
        antalSuperHeroes = 0;
    }

    public void createSuperHero(String realName, String heroName,
                                int creationYear, String superPower, boolean isHuman){
        Superhero newSuperHero = new Superhero(realName, heroName, creationYear, superPower, isHuman);
        superheroes[antalSuperHeroes++] = newSuperHero;
    }
}
