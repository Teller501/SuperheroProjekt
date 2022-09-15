import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    public Scanner keyb = new Scanner(System.in).useLocale(Locale.ENGLISH); // Declaring scanner object
    public Database database = new Database(); // Declaring database object

    public void start(){
        printWelcome();
    }

    public void printWelcome(){
        database.createTestData(); // NOTE: Test Data, fjern når færdig

        // Welcome and menu
        System.out.println("Velkommen til kollektionen af superhelte!");
        System.out.println("1. Opret superhelt");
        System.out.println("2. Se liste af oprettede superhelte");
        System.out.println("3. Søg efter superhelt");
        System.out.println("9. Afslut");

        handleMenuInput();
    }

    public void handleMenuInput() {
        // Switch-statement handling userinput and calling methods
        int menuInput = keyb.nextInt();
        keyb.nextLine();
        switch(menuInput){
            case 1:
                createSuperHero();
                break;
            case 2:
                printSuperHero();
                break;
            case 3:
                searchSuperhero();
            case 9:
                System.out.println("Afslutter programmet...");
                System.exit(1);
                break;
            default:
                System.out.println("Ugyldigt Input\n");
                printWelcome();
                break;
        }
    }

    public void createSuperHero(){

        System.out.println("Opret en superhelt");

        System.out.println("Indtast superheltens rigtige navn:");
        String realName = keyb.nextLine();

        System.out.println("Indtast superheltens heltenavn:");
        String heroName = keyb.nextLine();

        System.out.println("Hvilket superkræfter besidder superhelten?");
        String superPower = keyb.nextLine();

        System.out.println("Hvornår blev superhelten skabt?");
        int creationYear = keyb.nextInt();

        System.out.println("Hvor stor en kræft har helten (hvis 1 er for et menneske) ");
        double power = keyb.nextDouble();


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
        printWelcome();

    }

    public void printSuperHero(){
        System.out.println("Liste af superhelte");
        System.out.println("------------------------------------");

        // Looping through ArrayList of superheroes, printing out in list
        for (Superhero superhero : database.getAllSuperheroes()){
            System.out.println("Superhelte navn: " + superhero.getHeroName());
            System.out.println("Superkraft: " + superhero.getSuperPower());
            System.out.println("Virkeligt navn: " + superhero.getRealName());
            System.out.println("Oprindelsesår: " + superhero.getCreationYear());
            System.out.println("Er menneske: " + superhero.isHuman());
            System.out.println("Styrke: " + superhero.getPower());
            System.out.println("------------------------------------");
        }

        printWelcome();
    }

    public void searchSuperhero() {
        System.out.println("------------------------------------");
        System.out.println("Indtast søgeord: ");
        String searchTerm = keyb.nextLine();

        // adding searchTerm from input to database for searching
        Superhero superhero = database.searchForSuperhero(searchTerm);

        // Condition checking whether superhero is found or not
        if (superhero == null){ // if no superhero found, print error message
            System.out.println("Superhelt ikke fundet");
            System.out.println("------------------------------------");
            printWelcome();
        }else{  // if found, print superhero info
            System.out.println("Superhelte navn: " + superhero.getHeroName());
            System.out.println("Superkraft: " + superhero.getSuperPower());
            System.out.println("Virkeligt navn: " + superhero.getRealName());
            System.out.println("Oprindelsesår: " + superhero.getCreationYear());
            System.out.println("Er menneske: " + superhero.isHuman());
            System.out.println("Styrke: " + superhero.getPower());
            System.out.println("------------------------------------");
            printWelcome();
        }
    }
}
