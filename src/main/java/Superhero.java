public class Superhero {
    private String realName;
    private int creationYear;
    private String superPower;
    private boolean isHuman;

    public Superhero(String realName, int creationYear, String superPower, boolean isHuman){
        this.realName = realName;
        this.creationYear = creationYear;
        this.superPower = superPower;
        this.isHuman = isHuman;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "realName='" + realName + '\'' +
                ", creationYear=" + creationYear +
                ", superPower='" + superPower + '\'' +
                ", isHuman=" + isHuman +
                '}';
    }
}
