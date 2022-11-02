public class Superhero {
    // attributes
    private String realName;
    private String heroName;
    private int creationYear;
    private String superPower;
    private boolean isHuman;
    private double power;


    // constructor
    public Superhero(String realName, String heroName, int creationYear, String superPower, boolean isHuman, double power) {
        this.realName = realName;
        this.heroName = heroName;
        this.creationYear = creationYear;
        this.superPower = superPower;
        this.isHuman = isHuman;
        this.power = power;
    }

    public Superhero() {
        //skal være tom til at loade data
    }

    // Printing out if heroName is empty
    public String getHeroName() {
        if (heroName.isEmpty()) {
            return "Intet superhelte navn";
        } else {
            return heroName;
        }
    }

    public String getRealName() {
        return realName;
    }

    public String getSuperPower() {
        return superPower;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public double getPower() {
        return power;
    }

    // Returning different than "true" or "false" when printing isHuman boolean
    public String isHuman() {
        if (isHuman) {
            return "Ja";
        } else {
            return "Nej";
        }
    }

    // setting new hero name
    public void setHeroName(String newHeroName) {
        this.heroName = newHeroName;
    }

    // setting new superpower
    public void setSuperPower(String newSuperPower) {
        this.superPower = newSuperPower;
    }

    // setting new real name
    public void setRealName(String newRealName) {
        this.realName = newRealName;
    }

    // setting new power
    public void setPower(String newPower) {
        this.power = Double.parseDouble(newPower);
    }

    // setting new creation year
    public void setCreationYear(String newCreationYear) {
        this.creationYear = Integer.parseInt(newCreationYear);
    }
}
