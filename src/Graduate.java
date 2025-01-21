public class Graduate extends Person {
    private String almaMater;
    private double debt;

    public Graduate(String firstName, String lastName, String phoneNumber, String almaMater, double debt) {
        super(firstName, lastName, phoneNumber);
        this.almaMater = almaMater;
        this.debt = debt;
    }

    // Return almaMater
    public String getAlmaMater() {
        return almaMater;
    }

    // Return student debt
    public double getDebt() {
        return debt;
    }

    // Return formatted toString
    public String toString() {
        return super.toString() + "Attended " + almaMater + " and still has $" + debt + " in debt";
    }
}
