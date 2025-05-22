// Lösung für Stream-API – Task I
package streamapi;

import java.util.List;

public class Main {

    /**
     * Berechnet die Summe aller ECTS-Punkte (=cps) in der Liste der Studenten.
     *
     * @param students Liste von Student-Objekten
     * @return Summe der cps-Werte
     */
    public static int students(List<Student> students) {
        return students.stream()
            .mapToInt(Student::cps)
            .sum();
    }

    public static void main(String[] args) {
        List<Student> list = List.of(
            new Student("Alice", 30, Enrollment.IFM),
            new Student("Bob", 20, Enrollment.IFM),
            new Student("Chris", 10, Enrollment.IFM)
        );
        System.out.println("Summe der ECTS: " + students(list));
    }
}
