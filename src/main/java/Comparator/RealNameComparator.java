package Comparator;

import Superhero.Superhero;

import java.util.Comparator;

public class RealNameComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero s1, Superhero s2) {
        return s1.getRealName().compareTo(s2.getRealName());
    }
}
