package Comparator;

import Superhero.Superhero;

import java.util.Comparator;

public class PowerComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero s1, Superhero s2) {
        if(s1.getPower() < s2.getPower()){
            return -1;
        } else if(s1.getPower() > s2.getPower()){
            return 1;
        }else{
            return 0;
        }
    }
}