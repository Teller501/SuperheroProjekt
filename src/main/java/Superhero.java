public class Superhero {
    private String realName;
    private String heroName;
    private int creationYear;
    private String superPower;
    private boolean isHuman;


    public Superhero(String realName, String heroName, int creationYear, String superPower, boolean isHuman){
        this.realName = realName;
        this.heroName = heroName;
        this.creationYear = creationYear;
        this.superPower = superPower;
        this.isHuman = isHuman;
    }


    @Override
    public String toString() {
        return "Superhero{" +
                "realName='" + realName + '\'' +
                ", heroName='" + heroName + '\'' +
                ", creationYear=" + creationYear +
                ", superPower='" + superPower + '\'' +
                ", isHuman=" + isHuman +
                '}';
    }
}
