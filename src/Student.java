public class Student extends Person {
    private int grade;

    public Student (String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    // Return formatted to String
    public String toString() {
        return super.toString() + " Grade:" + grade;
    }
}
