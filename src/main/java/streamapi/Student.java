package streamapi;

public record Student(String name, int cps, Enrollment program) {

    public boolean isIFM() {
        return program == Enrollment.IFM;
    }
}
