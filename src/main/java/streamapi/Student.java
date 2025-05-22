package streamapi;

public record Student(String name, int cps, Enrollment enrollment) {

    /**
     * Gibt zurück, ob der Student im Studiengang IFM eingeschrieben ist.
     */
    public boolean isIFM() {
        return enrollment == Enrollment.IFM;
    }
}

