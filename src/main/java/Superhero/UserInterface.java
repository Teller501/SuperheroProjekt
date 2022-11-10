package Superhero;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class UserInterface {
    private Scanner keyb = new Scanner(System.in).useLocale(Locale.ENGLISH); // Declaring scanner object
    private Controller controller = new Controller(); // Declaring database object

    public void start() {
        printWelcome();
    }

    public void printWelcome() {


        // Input for menu choice
        int menuInput = 0;
        boolean inputError;
        while (menuInput != 9) {
            // Welcome and menu
            System.out.println("Velkommen til kollektionen af superhelte!");
            System.out.println("1. Opret superhelt");
            System.out.println("2. Se liste af oprettede superhelte");
            System.out.println("3. Søg efter superhelt");
            System.out.println("4. Rediger superhelt");
            System.out.println("5. Slet superhelt");
            System.out.println("6. Gem data");
            System.out.println("7. Load gemt data");
            System.out.println("8. Vis alle superhelte sorteret");
            System.out.println("9. Afslut");

            // DO-while loop that keeps looping if input error is true
            do {
                // Try Catch that takes input from user in the menu, and handling if the input is not an int
                try {
                    menuInput = keyb.nextInt();
                    keyb.nextLine();
                    handleMenuInput(menuInput);
                    inputError = false;
                } catch (InputMismatchException e) {
                    System.out.println("Ugyldig input prøv venligst igen!");
                    inputError = true;
                    keyb.nextLine();
                }
            } while (inputError);
        }
    }

    public void handleMenuInput(int menuInput) {
        // Switch-statement handling userinput and calling methods
        switch (menuInput) {
            case 1 -> createSuperHero();
            case 2 -> printSuperHero();
            case 3 -> searchSuperhero();
            case 4 -> updateSuperhero();
            case 5 -> deleteSuperhero();
            case 6 -> saveData();
            case 7 -> loadData();
            case 8 -> sortHeroesInput();
            case 9 -> {
                System.out.println("Afslutter programmet...");
                System.exit(1); // Terminating program
            }
            default -> System.out.println("Ugyldigt Input\n"); // by default if none of the above is input, print error


        }
    }

    public void createSuperHero() {

        System.out.println("Opret en superhelt");

        System.out.println("Indtast superheltens rigtige navn:");
        String realName = keyb.nextLine(); // Inputting real name of superhero

        System.out.println("Indtast superheltens heltenavn:");
        String heroName = keyb.nextLine();

        // A while loop that keeps looping if user does not input the name of a hero
        while (heroName.isEmpty()) {
            heroName = keyb.nextLine(); // Inputting hero name of superhero
            if (heroName.isEmpty()) {
                System.out.println("Du skal indtaste et navn");
            }
        }


        System.out.println("Hvilket superkræfter besidder superhelten?");
        String superPower = keyb.nextLine(); // Inputting superpowers of hero

        int creationYear = 0;
        boolean creationYearInputError = false;
        // Handling input error on creationYear
        do {
            // Catching NumberFormatException if user does not input an int
            try {
                System.out.println("Hvornår blev superhelten skabt?");
                creationYear = Integer.parseInt(keyb.nextLine()); // Inputting creation year of superhero
                creationYearInputError = false;
            } catch (NumberFormatException e) {
                System.out.println("Ugyldigt input, prøv igen");
                creationYearInputError = true;
            }

        } while (creationYearInputError);

        double power = 0;
        boolean powerInputError = false;

        // Handling input error on power
        do {
            // Catching NumberFormatException if user does not input an int
            try {
                System.out.println("Hvor stor en kræft har helten (hvis 1 er for et menneske) ");
                power = Double.parseDouble(keyb.nextLine()); // Inputting power of superhero
                powerInputError = false;
            } catch (NumberFormatException e) {
                System.out.println("Ugyldigt input, prøv igen");
                powerInputError = true;
            }

        } while (powerInputError);

        // boolean for checking if superhero is human
        boolean isHuman = false;
        char humanStatus;

        // loop checking the human status
        do {
            System.out.print("Er superhelten menneske? (j/n) ");
            humanStatus = keyb.next().charAt(0);
            System.out.println();

            if (humanStatus == 'j') { // if input is j then the hero is human
                isHuman = true;
            } else if (humanStatus == 'n') { // if input is n then the hero is not human
                isHuman = false;
            } else {
                System.out.println("ugyldigt input");
            }
        } while (humanStatus != 'j' && humanStatus != 'n');

        // Creating superhero from database class
        controller.createSuperHero(realName, heroName, creationYear, superPower, isHuman, power);

    }

    public void printSuperHero() {
        System.out.println("Liste af superhelte");
        System.out.println("------------------------------------");

        ArrayList<Superhero> allSuperheroes = controller.getAllSuperheroes();

        // Checking if ArrayList is empty
        if (allSuperheroes.isEmpty()) { // If empty, print message
            System.out.println("Ingen superhelte i databasen.");
            System.out.println("------------------------------------");
        } else {
            // Looping through ArrayList of superheroes, printing out in list
            for (Superhero superhero : allSuperheroes) {
                System.out.println("Superhelte navn: " + superhero.getHeroName());
                System.out.println("Superkraft: " + superhero.getSuperPower());
                System.out.println("Virkeligt navn: " + superhero.getRealName());
                System.out.println("Oprindelsesår: " + superhero.getCreationYear());
                System.out.println("Er " + (superhero.isHuman()?"":"ikke ") + "menneske!");
                System.out.println("Styrke: " + superhero.getPower());
                System.out.println("------------------------------------");
            }
        }
    }

    public void searchSuperhero() {
        System.out.println("------------------------------------");
        System.out.println("Indtast søgeord: ");
        String searchTerm = keyb.nextLine();

        // adding searchTerm from input to database for searching
        ArrayList<Superhero> searchResults = controller.searchForSuperhero(searchTerm);

        // Printing out all superheroes matching search term
        int index = 1;
        if (searchResults.isEmpty()) {
            System.out.println("Ingen fundet");
        } else {
            for (Superhero searchResult : searchResults) {
                System.out.println(index++ + ": " + searchResult.getHeroName());
            }
            System.out.println("Vælg superhelten du vil have skrevet ud: ");
            int superheroChoice = 1;
            boolean inputError = false;
            do {
                try {
                    superheroChoice = Integer.parseInt(keyb.nextLine()); // input of what superhero you want to look at
                    inputError = false;
                    // Printing out the selected hero
                    System.out.println("Superhelte navn: " + searchResults.get(superheroChoice - 1).getHeroName());
                    System.out.println("Superkraft: " + searchResults.get(superheroChoice - 1).getSuperPower());
                    System.out.println("Virkeligt navn: " + searchResults.get(superheroChoice - 1).getRealName());
                    System.out.println("Oprindelsesår: " + searchResults.get(superheroChoice - 1).getCreationYear());
                    System.out.println("Er menneske: " + searchResults.get(superheroChoice - 1).isHuman());
                    System.out.println("Styrke: " + searchResults.get(superheroChoice - 1).getPower() + "\n");
                } catch (IndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Ugyldigt input, prøv igen");
                    inputError = true;
                }
            } while (inputError);
        }
    }

    public void updateSuperhero() {
        System.out.println("------------------------------------");
        System.out.println("Indtast søgeord: ");
        String searchTerm = keyb.nextLine();

        // adding searchTerm from input to database for searching
        ArrayList<Superhero> searchResults = controller.searchForSuperhero(searchTerm);


        if (searchResults.isEmpty()) {
            System.out.println("Ingen fundet");
        } else {
            // Printing out all superheroes matching search term
            int index = 1;
            for (Superhero searchResult : searchResults) {
                System.out.println(index++ + ": " + searchResult.getHeroName());
            }


            System.out.println("Vælg superhelten du vil redigere: ");

            int superheroChoice = 1;
            boolean inputError = false;
            superheroChoice = Integer.parseInt(keyb.nextLine()); // input of what superhero to update
            Superhero editSuperhero = searchResults.get(superheroChoice - 1);
            System.out.println("Redigere: " + editSuperhero.getHeroName());

            System.out.println("------------------------------------");

            System.out.println("Indtast data der skal ændres og klik ENTER. Skal data ikke ændres, klik blot ENTER.");

            System.out.println("Navn: " + editSuperhero.getHeroName());
            String newHeroName = keyb.nextLine();
            if (!newHeroName.isEmpty()) { // if the input is not empty, set new data
                editSuperhero.setHeroName(newHeroName);
            }

            System.out.println("Superkræft(er): " + editSuperhero.getSuperPower());
            String newSuperPower = keyb.nextLine();
            if (!newSuperPower.isEmpty()) { // if the input is not empty, set new data
                editSuperhero.setSuperPower(newSuperPower);
            }

            System.out.println("Rigtige navn: " + editSuperhero.getRealName());
            String newRealName = keyb.nextLine();
            if (!newRealName.isEmpty()) { // if the input is not empty, set new data
                editSuperhero.setRealName(newRealName);
            }

            System.out.println("Styrke: " + editSuperhero.getPower());

            do {
                try {
                    String newPower = keyb.nextLine();
                    if (!newPower.isEmpty()) { // if the input is not empty, set new data
                        editSuperhero.setPower(newPower);
                    }
                    inputError = false;
                } catch (NumberFormatException e) {
                    System.out.println("Du skal indtaste et tal (f.eks. 2.3)");
                    inputError = true;
                }
            } while (inputError);


            System.out.println("Oprindelsesår: " + editSuperhero.getCreationYear());
            do {
                try {
                    String newCreationYear = keyb.nextLine().trim();
                    if (!newCreationYear.isEmpty()) { // if the input is not empty, set new data
                        editSuperhero.setCreationYear(newCreationYear);
                    }
                    inputError = false;
                } catch (NumberFormatException e) {
                    System.out.println("Du skal indtaste et tal (f.eks. 1998)");
                    inputError = true;
                }
            } while (inputError);

            controller.setChanges(true);

        }
    }

    public void deleteSuperhero() {
        System.out.println("------------------------------------");
        System.out.println("Indtast søgeord: ");
        String searchTerm = keyb.nextLine();

        // adding searchTerm from input to database for searching
        ArrayList<Superhero> searchResults = controller.searchForSuperhero(searchTerm);


        if (searchResults.isEmpty()) {
            System.out.println("Ingen fundet");
        } else {
            // Printing out all superheroes matching search term
            int index = 1;
            for (Superhero searchResult : searchResults) {
                System.out.println(index++ + ": " + searchResult.getHeroName());
            }


            System.out.println("Vælg superhelten du vil slette: ");

            int superheroChoice = 1;
            boolean inputError = false;
            do {
                try {
                    superheroChoice = Integer.parseInt(keyb.nextLine()); // input of what superhero to delete
                    Superhero deleteSuperhero = searchResults.get(superheroChoice - 1);

                    controller.deleteSuperhero(deleteSuperhero);
                    System.out.println(deleteSuperhero.getHeroName() + " er slettet fra databasen");
                    inputError = false;
                } catch (NumberFormatException e) {
                    System.out.println("Ugyldigt input, indtast venligst tallet på superhelten du ønsker slettet.");
                    inputError = true;
                }
            } while (inputError);

        }
    }

    // Saves the data if changes has been made
    private void saveData() {
        if (controller.isChanges()){
            controller.saveData();
            System.out.println("Data is saved");
        }else{
            System.out.println("Data is not saved, no changes made.");
        }
    }

    // Loading data from superheroes.csv
    private void loadData() {
        controller.loadData();
        System.out.println("Data loaded");
    }

    // Sorting heroes
    private void sortHeroesInput(){
        Scanner scanner = new Scanner(System.in);

        int input = 0;
        boolean inputError;
        String sortInput = "";

        while(input!= 9){
            // Menu for selecting sort attribute
            System.out.println("Sorter superhelte");
            System.out.println("1. sorter data efter superhelte navn");
            System.out.println("2. sorter data efter superheltens rigtige navn");
            System.out.println("3. sorter data efter superheltens oprindelsesår");
            System.out.println("4. sorter data efter superheltens styrke");
            System.out.println("5. sorter data efter superheltens superpower");
            System.out.println("6. sorter data efter superheltens menneskestatus");
            System.out.println("8. sorter data efter primær og sekundær attributter"); // Sorts after two attributes
            System.out.println("9. exit");
            // DO-while loop that keeps looping if input error is true
            do {
                // Try Catch that takes input from user in the menu, and handling if the input is not an int
                try {
                    input = scanner.nextInt();
                    scanner.nextLine();
                    // Sets the sortInput to corrosponding attribute, so it can be used in the sorting method
                    switch (input){
                        case 1 -> sortInput = "heroName";
                        case 2-> sortInput = "realName";
                        case 3-> sortInput = "creationYear";
                        case 4-> sortInput = "power";
                        case 5-> sortInput = "superPower";
                        case 6-> sortInput = "isHuman";
                        case 8 -> sortHeroesWith2Attributes();
                    }
                    ArrayList<Superhero> sortedList = controller.sort(sortInput); // Calls sorting method with the sortInput
                    printSorted(sortedList); // Prints the list of sorted heroes
                    inputError = false;
                } catch (InputMismatchException e) {
                    System.out.println("Ugyldig input prøv venligst igen!");
                    inputError = true;
                    scanner.nextLine();
                }
            } while (inputError);
        }
    }

    // Same as above method, just taking 2 inputs and sorting after those attributes
    private void sortHeroesWith2Attributes() {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        String primary = ""; // For primary attribute
        String secondary = ""; // For secondary input
        boolean inputError;

        while(input!= 9){
            // Menu
            System.out.println("Sorter superhelte efter primær og sekundær attribut");
            System.out.println("""
                    1. superhelte navn
                    2. superhelens rigtige navn
                    3. superheltens oprindelsesår
                    4. superheltens kræfter
                    5. superheltens superkræfter
                    6. superheltens menneskestatus""");

            System.out.println("9. exit");
            // DO-while loop that keeps looping if input error is true
            do {
                // Try Catch that takes input from user in the menu, and handling if the input is not an int
                try {
                    input = scanner.nextInt();
                    scanner.nextLine();
                    // Switch on the first input for primary attribute
                    switch (input){
                        case 1 -> primary = "heroName";
                        case 2-> primary = "realName";
                        case 3-> primary = "creationYear";
                        case 4-> primary = "power";
                        case 5-> primary = "superPower";
                        case 6-> primary = "isHuman";
                    }
                    System.out.println("Vælg næste attribut");
                    System.out.println("""
                    1. superhelte navn
                    2. superhelens rigtige navn
                    3. superheltens oprindelsesår
                    4. superheltens kræfter
                    5. superheltens superkræfter
                    6. superheltens menneskestatus""");
                    int secondInput = scanner.nextInt();
                    scanner.nextLine();

                    // Checks if the secondInput is not the same as first input
                    if (secondInput != input){
                        // Then sets the secondary attribute
                        switch (secondInput){
                            case 1 -> secondary = "heroName";
                            case 2-> secondary = "realName";
                            case 3-> secondary = "creationYear";
                            case 4-> secondary = "power";
                            case 5-> secondary = "superPower";
                            case 6-> secondary = "isHuman";
                        }
                        ArrayList<Superhero> sortedList = controller.sort(primary,secondary); // Sort method for two attributes
                        System.out.println("Sorteret superhelte efter: " + primary + " og " + secondary);
                        printSorted(sortedList);
                    }else {
                        System.out.println("Sekundær attribut kan ikke være samme som primær!");
                        inputError = true;
                    }
                    inputError = false;
                } catch (InputMismatchException e) {
                    System.out.println("Ugyldig input prøv venligst igen!");
                    inputError = true;
                    scanner.nextLine();
                }
            } while (inputError);
        }
    }

    private void printSorted(ArrayList<Superhero> sortedSuperheroes){
        // Looping through ArrayList of superheroes, printing out in list
        for (Superhero superhero : sortedSuperheroes){
            System.out.println("Superhelte navn: " + superhero.getHeroName());
            System.out.println("Superkraft: " + superhero.getSuperPower());
            System.out.println("Virkeligt navn: " + superhero.getRealName());
            System.out.println("Oprindelsesår: " + superhero.getCreationYear());
            System.out.println("Er " + (superhero.isHuman()?"":"ikke ") + "menneske!");
            System.out.println("Styrke: " + superhero.getPower());
            System.out.println("------------------------------------");
        }
    }
}
