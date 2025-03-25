import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Zadejte počet zařízení: ");
        int pocet = scanner.nextInt();
        scanner.nextLine();


        IPrehravac[] zariadenia = new IPrehravac[pocet];


        for (int i = 0; i < pocet; i++) {
            System.out.print("Zadejte typ zařízení (MP3, Smartphone, Radio): ");
            String typ = scanner.nextLine();

            switch (typ.toLowerCase()) {
                case "mp3":
                    System.out.print("Zadejte značku MP3: ");
                    zariadenia[i] = new MP3(scanner.nextLine());
                    break;
                case "smartphone":
                    System.out.print("Zadejte model mobilu: ");
                    zariadenia[i] = new Smartphone(scanner.nextLine());
                    break;
                case "radio":
                    zariadenia[i] = new Radio();
                    break;
                default:
                    System.out.println("Neplatný typ zařízení.");
                    i--;
                    break;
            }
        }


        while (true) {
            System.out.println("--- Menu ---");
            System.out.println("1. Zobrazit všechna zařízení");
            System.out.println("2. Přehrát zařízení");
            System.out.println("3. Zastavit přehrávání");
            System.out.println("4. Přehrát písničku na zařízení");
            System.out.println("5. Konec");
            System.out.print("Zvolte akci: ");
            int volba = scanner.nextInt();
            scanner.nextLine();

            switch (volba) {
                case 1:
                    for (int i = 0; i < zariadenia.length; i++) {
                        System.out.println(i + ": " + zariadenia[i]);
                    }
                    break;
                case 2:
                case 3:
                    System.out.print("Zadejte index zařízení: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < zariadenia.length) {
                        zariadenia[index].prehraj(volba == 2);
                    } else {
                        System.out.println("Neplatný index.");
                    }
                    break;
                case 4:
                    System.out.print("Zadejte index zařízení: ");
                    int indexPisnicky = scanner.nextInt();
                    scanner.nextLine();
                    if (indexPisnicky >= 0 && indexPisnicky < zariadenia.length) {
                        System.out.print("Zadejte název písničky: ");
                        String pisnicka = scanner.nextLine();
                        zariadenia[indexPisnicky].prehraj(pisnicka);
                    } else {
                        System.out.println("Neplatný index.");
                    }
                    break;
                case 5:
                    System.out.println("Konec programu.");
                    return;
                default:
                    System.out.println("Neplatná volba.");
            }
        }
    }
}