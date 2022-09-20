import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    public Scanner keyb = new Scanner(System.in).useLocale(Locale.ENGLISH); // Declaring scanner object
    public Database database = new Database(); // Declaring database object

    public void start(){
        database.createTestData(); // NOTE: Test Data, fjern når færdig
        printWelcome();
    }

    public void printWelcome(){


        // Welcome and menu
        System.out.println("Velkommen til kollektionen af superhelte!");
        System.out.println("1. Opret superhelt");
        System.out.println("2. Se liste af oprettede superhelte");
        System.out.println("3. Søg efter superhelt");
        System.out.println("4. Rediger superhelt");
        System.out.println("9. Afslut");

        // Input for menu choice
        int menuInput = 0;
        boolean inputError;
        while(menuInput != 9){
            do {
                try{
                    menuInput = keyb.nextInt();
                    keyb.nextLine();
                    handleMenuInput(menuInput);
                    inputError = false;
                }
                catch(InputMismatchException e){
                    System.out.println("Ugyldig input prøv venligst igen!");
                    keyb.nextLine();
                    inputError = true;
                }
            }while(inputError == true);
        }
    }

    public void handleMenuInput(int menuInput) {
        // Switch-statement handling userinput and calling methods
        switch(menuInput){
            case 1:
                createSuperHero();
                break;
            case 2:
                printSuperHero();
                break;
            case 3:
                searchSuperhero();
                break;
            case 4:
                updateSuperhero();
            case 9:
                System.out.println("Afslutter programmet...");
                System.exit(1); // Terminating program
                break;
            default:
                System.out.println("Ugyldigt Input\n"); // by default if none of the above is input, print error
                printWelcome(); // Return to menu
                break;
        }
    }


    public void createSuperHero(){

        System.out.println("Opret en superhelt");

        System.out.println("Indtast superheltens rigtige navn:");
        String realName = keyb.nextLine(); // Inputting real name of superhero

        System.out.println("Indtast superheltens heltenavn:");
        String heroName = keyb.nextLine(); // Inputting hero name of superhero

        System.out.println("Hvilket superkræfter besidder superhelten?");
        String superPower = keyb.nextLine(); // Inputting superpowers of hero

        int creationYear = 0;
        boolean creationYearInputError = false;
        do {
            try{
                System.out.println("Hvornår blev superhelten skabt?");
                creationYear = Integer.parseInt(keyb.nextLine()); // Inputting creation year of superhero
                creationYearInputError = false;
            }
            catch (NumberFormatException e){
                System.out.println("Ugyldigt input, prøv igen");
                creationYearInputError = true;
            }

        }while(creationYearInputError == true);

        double power = 0;
        boolean powerInputError = false;
        do {
            try{
                System.out.println("Hvor stor en kræft har helten (hvis 1 er for et menneske) ");
                power = Double.parseDouble(keyb.nextLine()); // Inputting power of superhero
                powerInputError = false;
            }
            catch (NumberFormatException e){
                System.out.println("Ugyldigt input, prøv igen");
                powerInputError = true;
            }

        }while(powerInputError == true);

        // boolean for checking if superhero is human
        boolean isHuman = false;
        char humanStatus;

        // loop checking the human status
        do {
            System.out.print("Er superhelten menneske? (j/n) ");
            humanStatus = keyb.next().charAt(0);
            System.out.println();

            if (humanStatus == 'j') {
                isHuman = true;
            } else if (humanStatus == 'n') {
                isHuman = false;
            } else {
                System.out.println("ugyldigt input");
            }
        } while (humanStatus != 'j' && humanStatus != 'n');

        // Creating superhero from database class
        database.createSuperHero(realName, heroName, creationYear, superPower, isHuman, power);

    }

    public void printSuperHero(){
        System.out.println("Liste af superhelte");
        System.out.println("------------------------------------");

        ArrayList<Superhero> allSuperheroes = database.getAllSuperheroes();

        // Checking if ArrayList is empty
        if (allSuperheroes.isEmpty()){ // If empty, print message
            System.out.println("Ingen superhelte i databasen.");
            System.out.println("------------------------------------");
        }else {
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
            if (searchResults.isEmpty()){
                System.out.println("Ingen fundet");
            }else {
                for (Superhero searchResult : searchResults) {
                    System.out.println(index++ + ": " + searchResult.getHeroName());
                }
                System.out.println("Vælg superhelten du vil have skrevet ud: ");
                int superheroChoice = 1;
                boolean inputError = false;
                do{
                    try{
                        superheroChoice = Integer.parseInt(keyb.nextLine()); // input of what superhero you want to look at
                        inputError = false;
                        // Printing out the selected hero
                        System.out.println("Superhelte navn: " + searchResults.get(superheroChoice-1).getHeroName());
                        System.out.println("Superkraft: " + searchResults.get(superheroChoice-1).getSuperPower());
                        System.out.println("Virkeligt navn: " + searchResults.get(superheroChoice-1).getRealName());
                        System.out.println("Oprindelsesår: " + searchResults.get(superheroChoice-1).getCreationYear());
                        System.out.println("Er menneske: " + searchResults.get(superheroChoice-1).isHuman());
                        System.out.println("Styrke: " + searchResults.get(superheroChoice-1).getPower()+"\n");
                    }
                    catch (IndexOutOfBoundsException | NumberFormatException e){
                        System.out.println("Ugyldigt input, prøv igen");
                        inputError = true;
                    }
                }while(inputError == true);
            }
    }

    public void updateSuperhero() {
        System.out.println("------------------------------------");
        System.out.println("Indtast søgeord: ");
        String searchTerm = keyb.nextLine();

        // adding searchTerm from input to database for searching
        ArrayList<Superhero> searchResults = database.searchForSuperhero(searchTerm);



        if (searchResults.isEmpty()){
            System.out.println("Ingen fundet");
        }else {
            // Printing out all superheroes matching search term
            int index = 1;
            for (Superhero searchResult : searchResults){
                System.out.println(index++ + ": "+searchResult.getHeroName());
            }


            System.out.println("Vælg superhelten du vil redigere: ");

            int superheroChoice = 1;
            boolean inputError = false;
            do {
                try{
                    superheroChoice = Integer.parseInt(keyb.nextLine()); // input of what superhero to update
                    Superhero editSuperhero = searchResults.get(superheroChoice-1);
                    System.out.println("Redigere: " + editSuperhero.getHeroName());

                    System.out.println("------------------------------------");

                    System.out.println("Indtast data der skal ændres og klik ENTER. Skal data ikke ændres, klik blot ENTER.");

                    System.out.println("Navn: " + editSuperhero.getHeroName());
                    String newHeroName = keyb.nextLine();
                    if (!newHeroName.isEmpty()){ // if the input is not empty, set new data
                        editSuperhero.setHeroName(newHeroName);
                    }

                    System.out.println("Superkræft(er): " + editSuperhero.getSuperPower());
                    String newSuperPower = keyb.nextLine();
                    if (!newSuperPower.isEmpty()){ // if the input is not empty, set new data
                        editSuperhero.setSuperPower(newSuperPower);
                    }

                    System.out.println("Rigtige navn: " + editSuperhero.getRealName());
                    String newRealName = keyb.nextLine();
                    if (!newRealName.isEmpty()){ // if the input is not empty, set new data
                        editSuperhero.setRealName(newRealName);
                    }

                    System.out.println("Styrke: " + editSuperhero.getPower());
                    String newPower = keyb.nextLine();
                    if (!newPower.isEmpty()){ // if the input is not empty, set new data
                        editSuperhero.setPower(newPower);
                    }

                    System.out.println("Oprindelsesår: " + editSuperhero.getCreationYear());
                    String newCreationYear = keyb.nextLine();
                    if (!newCreationYear.isEmpty()){ // if the input is not empty, set new data
                        editSuperhero.setCreationYear(newCreationYear);
                    }
                    inputError = false;
                }
                catch(IndexOutOfBoundsException | NumberFormatException e){
                    System.out.println("Ugyldigt input, prøv igen");
                    inputError = true;
                }
            }while(inputError == true);
        }






    }
}
