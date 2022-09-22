import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private Scanner keyb = new Scanner(System.in).useLocale(Locale.ENGLISH); // Declaring scanner object
    private Database database = new Database(); // Declaring database object

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
        String heroName = "";

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

        } while (creationYearInputError == true);

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
        database.createSuperHero(realName, heroName, creationYear, superPower, isHuman, power);

    }

    public void printSuperHero() {
        System.out.println("Liste af superhelte");
        System.out.println("------------------------------------");

        ArrayList<Superhero> allSuperheroes = database.getAllSuperheroes();

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
                System.out.println("Er menneske: " + superhero.isHuman());
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
        ArrayList<Superhero> searchResults = database.searchForSuperhero(searchTerm);

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
            } while (inputError == true);
        }
    }

    public void updateSuperhero() {
        System.out.println("------------------------------------");
        System.out.println("Indtast søgeord: ");
        String searchTerm = keyb.nextLine();

        // adding searchTerm from input to database for searching
        ArrayList<Superhero> searchResults = database.searchForSuperhero(searchTerm);


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
            } while (inputError == true);


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
            } while (inputError == true);

        }
    }

    public void deleteSuperhero() {
        System.out.println("------------------------------------");
        System.out.println("Indtast søgeord: ");
        String searchTerm = keyb.nextLine();

        // adding searchTerm from input to database for searching
        ArrayList<Superhero> searchResults = database.searchForSuperhero(searchTerm);


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

                    database.deleteSuperhero(deleteSuperhero);
                    System.out.println(deleteSuperhero.getHeroName() + " er slettet fra databasen");
                    inputError = false;
                } catch (NumberFormatException e) {
                    System.out.println("Ugyldigt input, indtast venligst tallet på superhelten du ønsker slettet.");
                    inputError = true;
                }
            } while (inputError);

        }
    }
}
