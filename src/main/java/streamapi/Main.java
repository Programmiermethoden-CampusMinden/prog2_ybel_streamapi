package streamapi;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    /**
     * Generiert 10 zufällige Integerwerte zwischen 0 (inklusive) und 10 (exklusive)
     * und summiert diese. Verwendet Stream-API mit Methodenreferenzen.
     *
     * @return Summe der 10 Zufallszahlen im Bereich [0, 9]
     */
    public static int random() {
        Random rand = new Random();
        return IntStream.generate(() -> rand.nextInt(10))  // direkt Werte 0–9
            .limit(10)
            .sum();
    }

    public static void main(String[] args) {
        System.out.println("Ergebnis: " + random());
    }
}

