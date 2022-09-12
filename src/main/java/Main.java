import java.util.Scanner;

public class Main {
    static Scanner keyb = new Scanner(System.in); // Erklærer scanner
    static Database database = new Database(); // Erklærer database objekt
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
        switch(menuInput){
            case 1:
                createSuperHero();
                break;
            case 9:
                System.exit(1);
        }
    }

    public void createSuperHero(){
        if (database.getSuperHeroesAmount() < database.getSuperHero().length){
            System.out.println("Opret en superhelt");

            System.out.print("Indtast superheltens rigtige navn: ");
            String realName = keyb.next();

            System.out.print("Indtast superheltens heltenavn: ");
            String heroName = keyb.next();

            System.out.println();

            System.out.print("Hvornår blev superhelten skabt? ");
            int creationYear = keyb.nextInt();

            System.out.print("Hvilket superkræfter besidder superhelten? ");
            String superPower = keyb.next();

            boolean isHuman = false;
            char humanStatus;
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
        } else {
            System.out.println("Ikke plads til flere superhelte!\n");
            udskrivVelkomst();
        }


    }
}
