import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

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
            output.print(superhero.getPower());
            output.println();
        }

        //Slutte med close:
        output.close();
    }
}
