import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Zadejte počet zařízení: ");
        int pocet = scanner.nextInt();
        scanner.nextLine(); // pohlcení Enteru po zadání čísla

        // Vytvoření pole pro zařízení
        IPrehravac[] zariadenia = new IPrehravac[pocet];

        // Načítání jednotlivých zařízení
        for (int i = 0; i < pocet; i++) {
            System.out.print("Zadejte typ zařízení (MP3, Smartphone, Radio): ");
            String typ = scanner.nextLine();

            if (typ.equalsIgnoreCase("MP3")) {
                System.out.print("Zadejte značku MP3: ");
                String znacka = scanner.nextLine();
                zariadenia[i] = new MP3(znacka);
            } else if (typ.equalsIgnoreCase("Smartphone")) {
                System.out.print("Zadejte model mobilu: ");
                String model = scanner.nextLine();
                zariadenia[i] = new Smartphone(model);
            } else if (typ.equalsIgnoreCase("Radio")) {
                zariadenia[i] = new Radio();
            } else {
                System.out.println("Neplatný typ zařízení.");
            }
        }

        // Menu pro práci s zařízeními
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Zobrazit všechna zařízení");
            System.out.println("2. Přehrát zařízení");
            System.out.println("3. Zastavit přehrávání");
            System.out.println("4. Přehrát písničku na zařízení");
            System.out.println("5. Konec");
            System.out.print("Zvolte akci: ");
            int volba = scanner.nextInt();
            scanner.nextLine(); // pohlcení Enteru po zadání čísla

            switch (volba) {
                case 1:
                    // Zobrazí všechna zařízení
                    for (int i = 0; i < zariadenia.length; i++) {
                        System.out.println(i + ": " + zariadenia[i]);
                    }
                    break;
                case 2:
                    // Přehrání zařízení
                    System.out.print("Zadejte index zařízení pro přehrání: ");
                    int indexPrehrani = scanner.nextInt();
                    if (indexPrehrani >= 0 && indexPrehrani < zariadenia.length) {
                        zariadenia[indexPrehrani].prehraj(true);
                    } else {
                        System.out.println("Neplatný index.");
                    }
                    break;
                case 3:
                    // Zastavení přehrávání
                    System.out.print("Zadejte index zařízení pro zastavení: ");
                    int indexZastaveni = scanner.nextInt();
                    if (indexZastaveni >= 0 && indexZastaveni < zariadenia.length) {
                        zariadenia[indexZastaveni].prehraj(false);
                    } else {
                        System.out.println("Neplatný index.");
                    }
                    break;
                case 4:
                    // Přehrání písničky na zařízení
                    System.out.print("Zadejte index zařízení pro přehrání písničky: ");
                    int indexPisnicky = scanner.nextInt();
                    scanner.nextLine(); // pohlcení Enteru
                    if (indexPisnicky >= 0 && indexPisnicky < zariadenia.length) {
                        System.out.print("Zadejte název písničky: ");
                        String pisnicka = scanner.nextLine();
                        zariadenia[indexPisnicky].prehraj(pisnicka);
                    } else {
                        System.out.println("Neplatný index.");
                    }
                    break;
                case 5:
                    // Konec programu
                    System.out.println("Konec programu.");
                    return;
                default:
                    System.out.println("Neplatná volba.");
            }
        }
    }
}