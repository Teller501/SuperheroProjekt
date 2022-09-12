import java.util.Scanner;

public class Main {
    static Scanner keyb = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Opret en superhelt");

        System.out.print("Indtast superheltens rigtige navn: ");
        String realName = keyb.next();

        System.out.print("Hvornår blev superhelten skabt? ");
        int creationYear = keyb.nextInt();

        System.out.print("Hvilket superkræfter besidder superhelten? ");
        String superPower = keyb.next();


    }
}
