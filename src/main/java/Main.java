import java.util.Locale;
import java.util.Scanner;

public class Main {
    public Scanner keyb = new Scanner(System.in).useLocale(Locale.ENGLISH); // Erklærer scanner
    public Database database = new Database(); // Erklærer database objekt
    public static void main(String[] args) {
        Main program = new Main();

        program.start();
    }
    public void start(){
        printWelcome();
    }

    public void printWelcome(){
        // Velkomst og menu
        System.out.println("Velkommen til kollektionen af superhelte!");
        System.out.println("1. Opret superhelt");
        System.out.println("2. Se liste af oprettede superhelte");
        System.out.println("3. Søg efter superhelt");
        System.out.println("9. Afslut");

        // Switch-statement til at håndere input fra bruger i menuen
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
                searchSuperHero();
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

    private void searchSuperHero() {
        System.out.println("Indtast søgeord: ");
        String searchTerm = keyb.nextLine();

        database.searchForSuperhero(searchTerm);
        System.out.println();
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

        database.createSuperHero(realName, heroName, creationYear, superPower, isHuman, power);
        printWelcome();

    }

    public void printSuperHero(){
        System.out.println("Liste af superhelte");
        System.out.println("------------------------------------");

        for (Superhero superheroes : database.getAllSuperheroes()){
            System.out.println("Superhelte navn: " + superheroes.getHeroName());
            System.out.println("Superkraft: " + superheroes.getSuperPower());
            System.out.println("Virkeligt navn: " + superheroes.getRealName());
            System.out.println("Oprindelsesår: " + superheroes.getCreationYear());
            System.out.println("Er menneske: " + superheroes.isHuman());
            System.out.println("Styrke: " + superheroes.getPower());
            System.out.println("------------------------------------");
        }
    }
}
