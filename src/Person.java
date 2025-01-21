public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // Return First name
    public String getFirstName() {
        return firstName;
    }

    // Return Last Name
    public String getLastName() {
        return lastName;
    }

    // Return Phone Number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Return formatted toString
    public String toString() {
        return firstName + " " + lastName + " - #" + phoneNumber;
    }
}
