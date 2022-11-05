package Comparator;

import Superhero.Superhero;

import java.util.Comparator;

public class CreationYearComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero s1, Superhero s2) {
        if(s1.getCreationYear() < s2.getCreationYear()){
            return -1;
        } else if(s1.getCreationYear() > s2.getCreationYear()){
            return 1;
        }else{
            return 0;
        }
    }
}

