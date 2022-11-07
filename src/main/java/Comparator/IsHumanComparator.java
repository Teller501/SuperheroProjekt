package Comparator;

import Superhero.Superhero;

import java.util.Comparator;

public class IsHumanComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero s1, Superhero s2) {
        return Boolean.valueOf(s1.isHuman()).compareTo(Boolean.valueOf(s2.isHuman())); //TODO: fix compare
    }
}
