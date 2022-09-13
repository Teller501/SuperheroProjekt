import java.util.Scanner;

public class Main {
    public Scanner keyb = new Scanner(System.in); // Erklærer scanner
    public Database database = new Database(); // Erklærer database objekt
    public static void main(String[] args) {
        Main program = new Main();

        program.start();
    }
    public void start(){
        udskrivVelkomst();
    }

    public void udskrivVelkomst(){
        // Velkomst og menu
        System.out.println("Velkommen til kollektionen af superhelte!");
        System.out.println("1. Opret superhelt");
        System.out.println("9. Afslut");

        // Switch-statement til at håndere input fra bruger i menuen
        int menuInput = keyb.nextInt();
        keyb.nextLine();
        switch(menuInput){
            case 1:
                createSuperHero();
                break;
            case 9:
                System.exit(1);
                break;
            default:
                System.out.println("Ugyldigt Input\n");
                udskrivVelkomst();
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

        database.createSuperHero(realName, heroName, creationYear, superPower, isHuman);
        udskrivVelkomst();



    }
}
