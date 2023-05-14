package constraints.xor;

public class RegularCustomer {

    private int visitNumbers;

    public RegularCustomer(int visitNumbers) {
        setVisitNumbers(visitNumbers);
    }

    public int getVisitNumbers() {
        return visitNumbers;
    }

    public void setVisitNumbers(int visitNumbers) {
        if (visitNumbers < 0) {
            throw new IllegalArgumentException("Value cannot be less than zero");
        }
        this.visitNumbers = visitNumbers;
    }
}
