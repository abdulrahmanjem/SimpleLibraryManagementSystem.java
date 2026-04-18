import java.util.Scanner;

/**
 * Simple Library Management System
 * Author: Abdulrahman Jihad Shunnar
 * University ID: 120255681
 * Supervisor: Eng. Fawzi Faraj Abdelal
 * Course: Java Programming – Final Project
 */
public class SimpleLibrary_120255681 {

    // Arrays to store books and their status
    static String[] books = new String[20];
    static String[] status = new String[20];
    static int count = 0;

    // Array to store requested books
    static String[] requests = new String[20];
    static int requestCount = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Initialize books and status
        books[0] = "Programming";
        status[0] = "Borrowed";
        books[1] = "Networking Fundamentals";
        status[1] = "Available";
        books[2] = "Data Science";
        status[2] = "Borrowed";
        books[3] = "English Language";
        status[3] = "Available";
        books[4] = "Information Age Ethics";
        status[4] = "Available";

        count = 5;

        int choice;
        do {
            menu();
            choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1: displayBooks(); break;
                case 2: searchBook(input); break;
                case 3: borrowBook(input); break;
                case 4: returnBook(input); break;
                case 5: deleteBook(input); break;
                case 6: askForBook(input); break;
                case 7: support(); break;
                case 8: aboutLibrary(); break;
                case 9: end(); break;
                default: System.out.println("Invalid choice, please select from the menu.");
            }
        } while (choice != 9);

        input.close();
    }

    // Main menu
    public static void menu() {
        System.out.println("============================");
        System.out.println("===== Main Library Menu =====");
        System.out.println("1. Display Books");
        System.out.println("2. Search for a Book");
        System.out.println("3. Borrow a Book");
        System.out.println("4. Return a Book");
        System.out.println("5. Delete a Book");
        System.out.println("6. Request a Book");
        System.out.println("7. Complaints and Support");
        System.out.println("8. About the Library");
        System.out.println("9. Exit");
        System.out.print("Choose: ");
    }

    // Display all books
    public static void displayBooks() {
        if (count == 0) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("\n--- Book List ---");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + books[i] + " | Status: " + status[i]);
        }
    }

    // Search for a book
    public static void searchBook(Scanner input) {
        System.out.print("Enter book name: ");
        String name = input.nextLine();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (books[i].equalsIgnoreCase(name)) {
                System.out.println("Found: " + books[i] + " | Status: " + status[i]);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Book not found.");
    }

    // Borrow a book
    public static void borrowBook(Scanner input) {
        System.out.print("Enter book name to borrow: ");
        String name = input.nextLine();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (books[i].equalsIgnoreCase(name)) {
                found = true;
                if (status[i].equals("Available")) {
                    status[i] = "Borrowed";
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("Book is already borrowed.");
                }
                break;
            }
        }
        if (!found) System.out.println("Book not found.");
    }

    // Return a book
    public static void returnBook(Scanner input) {
        System.out.print("Enter book name to return: ");
        String name = input.nextLine();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (books[i].equalsIgnoreCase(name)) {
                found = true;
                if (status[i].equals("Borrowed")) {
                    status[i] = "Available";
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book was not borrowed.");
                }
                break;
            }
        }
        if (!found) System.out.println("Book not found.");
    }

    // Delete a book
    public static void deleteBook(Scanner input) {
        System.out.print("Enter book name to delete: ");
        String name = input.nextLine();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (books[i].equalsIgnoreCase(name)) {
                found = true;
                for (int j = i; j < count - 1; j++) {
                    books[j] = books[j + 1];
                    status[j] = status[j + 1];
                }
                count--;
                System.out.println("Book deleted successfully.");
                break;
            }
        }
        if (!found) System.out.println("Book not found.");
    }

    // Request a book
    public static void askForBook(Scanner input) {
        System.out.print("Enter the name of the book you want to request: ");
        String name = input.nextLine();
        requests[requestCount++] = name;
        System.out.println("Your request has been saved. We will try to provide the book soon.");
    }

    // Complaints and support
    public static void support() {
        System.out.println("\n--- Complaints and Support ---");
        System.out.println("Complaints Hotline: 400");
        System.out.println("Your information will remain confidential.");
        System.out.println("Technical Support: 700");
    }

    // About the library
    public static void aboutLibrary() {
        System.out.println("\n--- About the Library ---");
        System.out.println("University: UCAS – Computer Engineering Faculty");
        System.out.println("Diploma: Information Security");
        System.out.println("Project: Simple Library Management System");
        System.out.println("Author: Abdulrahman Jihad Shunnar (ID: 120255681)");
        System.out.println("Supervisor: Eng. Fawzi Faraj Abdelal");
        System.out.println("Course: Java Programming – Final Project");
        System.out.println("Features: Arrays, if/else, Methods, Scanner");
    }

    // Exit
    public static void end() {
        System.out.println("\nThank you for using our Library System!");
        System.out.println("Visit our website for more projects.");
    }
}
