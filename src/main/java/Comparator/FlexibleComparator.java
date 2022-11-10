package Comparator;

import Superhero.Superhero;

import java.util.Comparator;

public class FlexibleComparator implements Comparator<Superhero> {
    private String sortBy;
    public FlexibleComparator(String sortBy){
        this.sortBy = sortBy;
    }

    @Override
    public int compare(Superhero o1, Superhero o2) {
        switch(sortBy){
            case "creationYear"->{
                return Integer.compare(o1.getCreationYear(),o2.getCreationYear());
            }
            case "heroName"->{
                return o1.getHeroName().compareTo(o2.getHeroName());
            }
            case "power"-> {
                return Double.compare(o1.getPower(),o2.getPower());
            }
            case "realName"->{
                return o1.getRealName().compareTo(o2.getRealName());
            }
            case "superPower"->{
                return o1.getSuperPower().compareTo(o2.getSuperPower());
            }
            case "isHuman" -> {
                return Boolean.compare(o1.isHuman(),o2.isHuman());
            }
        }
        return 0;
    }
}
