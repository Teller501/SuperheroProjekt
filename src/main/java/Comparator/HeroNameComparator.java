package Comparator;

import Superhero.Superhero;

import java.util.Comparator;

public class HeroNameComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero s1, Superhero s2) {
        return s1.getHeroName().compareTo(s2.getHeroName());
    }
}
