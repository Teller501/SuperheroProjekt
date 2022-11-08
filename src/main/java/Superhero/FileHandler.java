package Superhero;

import Comparator.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileHandler {

    public void saveData(ArrayList<Superhero> allSuperheroes) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("data/superheroes.csv"));


        for (Superhero superhero : allSuperheroes) {
            output.print(superhero.getHeroName());
            output.print(";");
            output.print(superhero.getSuperPower());
            output.print(";");
            output.print(superhero.getRealName());
            output.print(";");
            output.print(superhero.getPower());
            output.print(";");
            output.print(superhero.getCreationYear());
            output.print(";");
            output.print(superhero.isHuman());
            output.print(";");
            output.println();
        }

        //Slutte med close:
        output.close();
        output.flush();
    }

    public void loadData(ArrayList<Superhero> allSuperheroes) throws FileNotFoundException {
        // Clear list of names before load:
        //allSuperheroes.clear();

        Scanner reader = new Scanner(new File("data/superheroes.csv"));

        while(reader.hasNextLine()) {
            String line = reader.nextLine();

            Superhero dataObjekt = parseCSVLine(line);
            allSuperheroes.add(dataObjekt);

            System.out.println(line);
        }
    }

    private Superhero parseCSVLine(String line) {
        try{
            String[] parts = line.split(";");

            Superhero dataObjekt = new Superhero();
            dataObjekt.setHeroName(parts[0]);
            dataObjekt.setSuperPower(parts[1]);
            dataObjekt.setRealName(parts[2]);
            dataObjekt.setPower(parts[3]);
            dataObjekt.setCreationYear(parts[4]);
            //dataObjekt.isHuman(parts[5]);

            return dataObjekt;
        }catch(NumberFormatException e){
            System.out.println("Kan ikke loade data, fejl i input");
            return null;
        }

    }

    public ArrayList<Superhero> sort(ArrayList<Superhero> allSuperheroes, String sortInput){
        switch (sortInput){
            case "heroName" -> Collections.sort(allSuperheroes, new HeroNameComparator());
            case "realName" -> Collections.sort(allSuperheroes, new RealNameComparator());
            case "creationYear" -> Collections.sort(allSuperheroes, new CreationYearComparator());
            case "power" -> Collections.sort(allSuperheroes, new PowerComparator());
            case "superPower" -> Collections.sort(allSuperheroes, new SuperPowerComparator());
            case "isHuman" -> Collections.sort(allSuperheroes, new IsHumanComparator());
        }

        return  allSuperheroes;
    }
}
