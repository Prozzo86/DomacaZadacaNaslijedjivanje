import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /*
    Upravljanje Zaposlenicima i Izračun Plaće:

    - Napravite aplikaciju koja prati različite vrste zaposlenika i izračunava njihove plaće
      ovisno o uvjetima rada i radnim satima.

    Upute:

    1. Kreirajte osnovnu klasu koja će sadržavati osnovne podatke o zaposleniku, kao što su:
        - ime zaposlenika,
        - osnovna plaća (tipa BigDecimal),
        - broj radnih sati zaposlenika.

    2. Definirajte metode koje će omogućiti ispis podataka zaposlenika i izračun plaće.

    3. Na temelju osnovne klase, kreirajte dvije specifične vrste zaposlenika, npr. "Stalni" i "Sezonski":
        - Prva vrsta zaposlenika prima bonus od 15% na osnovnu plaću ako broj radnih sati prelazi 160.

        - Druga vrsta zaposlenika ima izračun po satu. Ako zaposlenik radi više od 200 sati,
          ostvaruje dodatni bonus od 10% na ukupnu plaću.

    4. Omogućite unos podataka za svakog zaposlenika putem konzole:
        - Korisnik unosi ime, osnovnu plaću, broj radnih sati i vrstu zaposlenika.

    5. Ovisno o vrsti zaposlenika, koristi se odgovarajući način izračuna plaće.

    6. Kreirajte glavni program u kojem:
        - Spremate zaposlenike u listu (List).
        - Nakon unosa, program prolazi kroz listu i ispisuje podatke o svakom zaposleniku,
          uključujući izračun plaće prema definiranim pravilima.
    */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List <Zaposlenik> zaposlenici = new ArrayList<>();

        boolean unosZavrsen = false;

        while (!unosZavrsen){
            System.out.println("Unesi ime zaposlenika: ");
            String ime = scanner.nextLine();

            System.out.println("Unesi osnovnu placu zaposlenika: ");
            BigDecimal placa;

            try {
                placa = new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Neispravan unos za placu. Molimo unesite decimalni broj.");
                continue;
            }

            System.out.println("Unesi broj radnih sati zaposlenika: ");
            int brojSati;
            try {
                brojSati = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Neispravan unos za broj radnih sati. Molimo unesite cijeli broj.");
                continue;
            }

            System.out.println("Unesi tip zaposlenika (stalni/sezonski): ");
            String tipZaposlenika = scanner.nextLine().trim().toLowerCase();

            Zaposlenik zaposlenik;
            if (tipZaposlenika.equals("stalni")) {
                zaposlenik = new StalniZaposlenik(ime, placa, brojSati);
            } else if (tipZaposlenika.equals("sezonski")) {
                zaposlenik = new SezonskiZaposlenik(ime, placa, brojSati);
            } else {
                System.out.println("Nepoznat tip zaposlenika. Molimo unesite 'stalni' ili 'sezonski'.");
                continue;
            }

            zaposlenici.add(zaposlenik);

            System.out.println("Zelite li unijeti jos zaposlenika? (da/ne)");
            String odgovor = scanner.nextLine().trim().toLowerCase();
            if (odgovor.equals("ne")) {
                unosZavrsen = true;
            }
        }

        System.out.println("\nPodaci o zaposlenicima:");
        for (Zaposlenik zaposlenik : zaposlenici) {
            zaposlenik.ispisPodatakaZaposlenika();
            System.out.println("-------------------------------------------------------------");
        }
    }
}