package streamapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Main {

    /**
     * Lädt eine Datei aus dem Ressourcenordner als InputStream.
     */
    public static InputStream getResourceAsStream(String filename) {
        return Main.class.getResourceAsStream("/" + filename);
    }

    /**
     * Liest Zeilen, filtert nach Anfang 'a' und Länge ≥ 2, gibt Ergebnis als String zurück.
     */
    public static String resources(InputStream input) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            return reader.lines()
                .filter(Main::isValidLine)
                .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Lesen", e);
        }
    }

    // Filter: Zeile beginnt mit 'a' und hat mind. 2 Zeichen
    private static boolean isValidLine(String line) {
        return line.startsWith("a") && line.length() >= 2;
    }

    public static void main(String[] args) {
        InputStream input = getResourceAsStream("daten.txt");
        if (input == null) {
            System.out.println("Datei 'daten.txt' nicht gefunden!");
            return;
        }
        String result = resources(input);
        System.out.println("Gefilterte Zeilen:\n" + result);
    }
}

