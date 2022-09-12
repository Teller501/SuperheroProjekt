import java.util.Scanner;

public class Main {
    static Scanner keyb = new Scanner(System.in);
    static Database database = new Database();
    public static void main(String[] args) {
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

        System.out.print("Er superhelten menneske? (j/n) ");
        char humanStatus = keyb.next().charAt(0);

        boolean isHuman = false;
        do{
            if (humanStatus == 'j'){
                isHuman = true;
            }else if(humanStatus == 'n'){
                isHuman = false;
            } else {
                System.out.println("ugyldigt input");
            }
        }while(humanStatus != 'j' && humanStatus != 'n');

        database.createSuperHero(realName,heroName,creationYear,superPower,isHuman);


    }
}
