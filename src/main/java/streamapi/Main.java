package streamapi;

import java.util.List;

public class Main {

    // Summiert alle ECTS-Punkte der Studenten
    public static int students(List<Student> students) {
        return students.stream().mapToInt(Student::cps).sum();
    }

    // Summiert ECTS-Punkte nur für IFM-Studenten (Stream-API mit Methoden-Referenzen)
    public static int ifmCps(List<Student> students) {
        return students.stream()
            .filter(Student::isIFM)
            .mapToInt(Student::cps)
            .sum();
    }

    public static void main(String[] args) {
        List<Student> list = List.of(
            new Student("Alice", 30, Enrollment.IFM),
            new Student("Bob", 20, Enrollment.IFM),
            new Student("Chris", 10, Enrollment.IFM),
            new Student("Dora", 15, Enrollment.MWI)
        );

        System.out.println("Summe der ECTS: " + students(list));
        System.out.println("Summe der IFM-ECTS: " + ifmCps(list));
    }
}
