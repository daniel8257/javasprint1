import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Author");
            System.out.println("2. Add Book");
            System.out.println("3. Add Patron");
            System.out.println("4. Borrow Item");
            System.out.println("5. Return Item");
            System.out.println("6. Search Item");
            System.out.println("7. Edit Item");
            System.out.println("8. Delete Item");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Author
                    try {
                        System.out.print("Enter author name: ");
                        String authorName = scanner.nextLine();
                        System.out.print("Enter author date of birth (dd/MM/yyyy): ");
                        String dob = scanner.nextLine();
                        Date dateOfBirth = dateFormat.parse(dob);
                        Author author = new Author(authorName, dateOfBirth);
                        library.addAuthor(author);
                        System.out.println("Author added successfully.");
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please try again.");
                    }
                    break;

                case 2:
                    // Add Book
                    try {
                        System.out.print("Enter book ID: ");
                        String bookId = scanner.nextLine();
                        System.out.print("Enter book title: ");
                        String bookTitle = scanner.nextLine();
                        System.out.print("Enter author name: ");
                        String authorName = scanner.nextLine();
                        Author author = library.getAuthors().stream()
                                .filter(a -> a.getName().equals(authorName))
                                .findFirst()
                                .orElse(null);
                        if (author == null) {
                            System.out.println("Author not found. Please add the author first.");
                            break;
                        }
                        System.out.print("Enter ISBN: ");
                        String ISBN = scanner.nextLine();
                        System.out.print("Enter publisher: ");
                        String publisher = scanner.nextLine();
                        System.out.print("Enter number of copies: ");
                        int copies = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter format (Printed/Electronic/Audio): ");
                        String format = scanner.nextLine();
                        Book book = new Book(bookId, bookTitle, author, ISBN, publisher, copies, format);
                        library.addItem(book);
                        author.addItem(book);
                        System.out.println("Book added successfully.");
                    } catch (Exception e) {
                        System.out.println("An error occurred. Please try again.");
                    }
                    break;

                case 3:
                    // Add Patron
                    System.out.print("Enter patron name: ");
                    String patronName = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter patron type (Student/Employee): ");
                    String type = scanner.nextLine();
                    Patron patron;
                    if (type.equalsIgnoreCase("Student")) {
                        patron = new Student(patronName, address, phoneNumber);
                    } else {
                        patron = new Employee(patronName, address, phoneNumber);
                    }
                    library.addPatron(patron);
                    System.out.println("Patron added successfully.");
                    break;

                case 4:
                    // Borrow Item
                    System.out.print("Enter patron name: ");
                    String borrowerName = scanner.nextLine();
                    Patron borrower = library.getPatrons().stream()
                            .filter(p -> p.getName().equals(borrowerName))
                            .findFirst()
                            .orElse(null);
                    if (borrower == null) {
                        System.out.println("Patron not found.");
                        break;
                    }
                    System.out.print("Enter item ID: ");
                    String itemId = scanner.nextLine();
                    LibraryItem itemToBorrow = library.getItems().stream()
                            .filter(i -> i.getId().equals(itemId))
                            .findFirst()
                            .orElse(null);
                    if (itemToBorrow == null) {
                        System.out.println("Item not found.");
                        break;
                    }
                    library.borrowItem(borrower, itemToBorrow);
                    System.out.println("Item borrowed successfully.");
                    break;

                case 5:
                    // Return Item
                    System.out.print("Enter patron name: ");
                    String returnerName = scanner.nextLine();
                    Patron returner = library.getPatrons().stream()
                            .filter(p -> p.getName().equals(returnerName))
                            .findFirst()
                            .orElse(null);
                    if (returner == null) {
                        System.out.println("Patron not found.");
                        break;
                    }
                    System.out.print("Enter item ID: ");
                    String itemIdToReturn = scanner.nextLine();
                    LibraryItem itemToReturn = returner.getBorrowedItems().stream()
                            .filter(i -> i.getId().equals(itemIdToReturn))
                            .findFirst()
                            .orElse(null);
                    if (itemToReturn == null) {
                        System.out.println("Item not found.");
                        break;
                    }
                    library.returnItem(returner, itemToReturn);
                    System.out.println("Item returned successfully.");
                    break;

                case 6:
                    // Search Item
                    System.out.print("Enter search keyword (title, author, or ISBN): ");
                    String keyword = scanner.nextLine();
                    library.searchItem(keyword);
                    break;

                case 7:
                    // Edit Item
                    System.out.print("Enter item (id, title, author, isbn, publisher) to edit: ");
                    String itemIdToEdit = scanner.nextLine();
                    LibraryItem itemToEdit = library.getItems().stream()
                            .filter(i -> i.getId().equals(itemIdToEdit))
                            .findFirst()
                            .orElse(null);
                    if (itemToEdit == null) {
                        System.out.println("Item not found.");
                        break;
                    }
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new author name: ");
                    String newAuthorName = scanner.nextLine();
                    Author newAuthor = library.getAuthors().stream()
                            .filter(a -> a.getName().equals(newAuthorName))
                            .findFirst()
                            .orElse(null);
                    if (newAuthor == null) {
                        System.out.println("Author not found.");
                        break;
                    }
                    System.out.print("Enter new ISBN: ");
                    String newISBN = scanner.nextLine();
                    System.out.print("Enter new publisher: ");
                    String newPublisher = scanner.nextLine();
                    System.out.print("Enter new number of copies: ");
                    int newCopies = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.editItem(itemIdToEdit, newTitle, newAuthor, newISBN, newPublisher, newCopies);
                    System.out.println("Item edited successfully.");
                    break;

                case 8:
                    // Delete Item
                    System.out.print("Enter item (id, title, author, isbn, publisher) to delete: ");
                    String itemIdToDelete = scanner.nextLine();
                    library.deleteItem(itemIdToDelete);
                    break;

                case 9:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
