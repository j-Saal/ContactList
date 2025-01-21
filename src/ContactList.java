import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList() {
        contacts = new ArrayList<>();
    }

    // Return contact list
    public ArrayList<Person> getContacts() {
        return contacts;
    }

    // Add a person to contact list
    public void addContact(Person p) {
        contacts.add(p);
    }

    // Print contact list
    public void printContacts() {
        for (Person p: contacts) {
            System.out.println(p);
        }
    }

    // Sort contact list by a certain paramter
    public void sort(int w) {
        int n = contacts.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                int comparison = 0;
                if (w == 0) { // Sort by firstName
                    comparison = contacts.get(j).getFirstName().compareTo(contacts.get(j+1).getFirstName());
                } else if (w == 1) { // Sort by lastName
                    comparison = contacts.get(j).getLastName().compareTo(contacts.get(j+1).getLastName());
                } else if (w == 2) { // Sort by phoneNumber
                    comparison = contacts.get(j).getPhoneNumber().compareTo(contacts.get(j+1).getPhoneNumber());
                }
                if (comparison > 0) {
                    Person temp = contacts.get(j);
                    contacts.set(j, contacts.get(j+1));
                    contacts.set(j + 1, temp);
                }
            }
        }
    }

    // Search through list by first name
    public Person searchByFirstName(String firstName) {
        for (Person p: contacts) {
            if (p.getFirstName().equalsIgnoreCase(firstName)) {
                return p;
            }
        }
        return null;
    }

    // Search through list by last name
    public Person searchByLastName(String lastName) {
        for (Person p: contacts) {
            if (p.getLastName().equalsIgnoreCase(lastName)) {
                return p;
            }
        }
        return null;
    }

    // Search through list by phone number
    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person p: contacts) {
            if (p.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                return p;
            }
        }
        return null;
    }

    // Print out all students in contact list
    public void listStudents() {
        for (Person p: contacts) {
            if (p instanceof Student) {
                System.out.println(p);
            }
        }
    }

    // Run the program and do different actions based on input
    public void run() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("1. Add Contact");
            System.out.println("2. List All Contacts By First Name");
            System.out.println("3. List All Contacts By Last Name");
            System.out.println("4. List All Contacts By Phone Number");
            System.out.println("5. List All Students");
            System.out.println("6. Search By First Name");
            System.out.println("7. Search By Last Name");
            System.out.println("8. Search By Phone Number");
            System.out.println("0. Exit");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Enter First Name: ");
                String firstName = input.nextLine();
                System.out.print("Enter Last Name: ");
                String lastName = input.nextLine();
                System.out.print("Enter Phone Number: ");
                String phoneNumber = input.nextLine();
                System.out.print("Is this a Person (1), Student (2), or Graduate (3)");
                int type = input.nextInt();
                input.nextLine();

                if (type == 2) {
                    System.out.print("Enter Grade: ");
                    int grade = input.nextInt();
                    input.nextLine();
                    addContact(new Student(firstName, lastName, phoneNumber, grade));
                } else if (type == 3) {
                    System.out.print("Enter Alma Mater: ");
                    String almaMater = input.nextLine();
                    System.out.print("Enter Debt: ");
                    double debt = input.nextDouble();
                    input.nextLine();
                    addContact(new Graduate(firstName, lastName, phoneNumber, almaMater, debt));
                } else if (type == 1) {
                    addContact(new Person(firstName, lastName, phoneNumber));
                }
            } else if (choice == 2 || choice == 3 || choice == 4) {
                sort(choice - 2); // Sort by first name
                printContacts();

            } else if (choice == 5) {
                listStudents();

            } else if (choice == 6) {
                System.out.print("Enter First Name to Search: ");
                String firstName1 = input.nextLine();
                Person result = searchByFirstName(firstName1);
                if (result != null) {
                    System.out.println(result);
                } else {
                    System.out.println(firstName1 + " is not in the list.");
                }

            } else if (choice == 7) {
                System.out.print("Enter Last Name to Search: ");
                String lastName1 = input.nextLine();
                Person result = searchByLastName(lastName1);
                if (result != null) {
                    System.out.println(result);
                } else {
                    System.out.println(lastName1 + " is not in the list.");
                }

            } else if (choice == 8) {
                System.out.print("Enter Phone Number to Search: ");
                String phoneNumber1 = input.nextLine();
                Person result = searchByPhoneNumber(phoneNumber1);
                if (result != null) {
                    System.out.println(result);
                } else {
                    System.out.println(phoneNumber1 + " is not in the list.");
                }

            } else if (choice == 0) {
                break;
            }
        }
    }
}
