package projects.intermediate.librarySystem;

import java.io.IOException;
import java.util.Scanner;

public class LibrarySystem {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Load data from files
        try {
            library.loadData("books.txt", "members.txt");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }

        while (true) {
            showMenu();
            int choice = getChoice();
            handleChoice(choice);
        }
    }

    private static void showMenu() {
        System.out.println("\nLibrary System Menu:");
        System.out.println("1. Add Book");
        System.out.println("2. Add Member");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. List Available Books");
        System.out.println("6. List Members");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return choice;
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                addMember();
                break;
            case 3:
                borrowBook();
                break;
            case 4:
                returnBook();
                break;
            case 5:
                listAvailableBooks();
                break;
            case 6:
                listMembers();
                break;
            case 7:
                exitSystem();
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
        }
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String ISBN = scanner.nextLine();
        Book newBook = new Book(title, author, ISBN);
        library.addBook(newBook);
        System.out.println("Book added successfully.");
    }

    private static void addMember() {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        Member newMember = new Member(name, memberId);
        library.addMember(newMember);
        System.out.println("Member added successfully.");
    }

    private static void borrowBook() {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String ISBN = scanner.nextLine();
        library.borrowBook(memberId, ISBN);
    }

    private static void returnBook() {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String ISBN = scanner.nextLine();
        library.returnBook(memberId, ISBN);
    }

    private static void listAvailableBooks() {
        System.out.println("Available books:");
        library.listAvailableBooks();
    }

    private static void listMembers() {
        System.out.println("Library members:");
        library.listMembers();
    }

    private static void exitSystem() {
        try {
            library.saveData("books.txt", "members.txt");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
        System.out.println("Exiting the system. Goodbye!");
        scanner.close();
        System.exit(0);
    }
}
