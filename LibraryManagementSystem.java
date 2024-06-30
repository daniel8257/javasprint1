import java.util.ArrayList;
import java.util.List;
class LibraryManagementSystem {
    private List<LibraryItem> items;
    private List<Author> authors;
    private List<Patron> patrons;

    public LibraryManagementSystem() {
        this.items = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.patrons = new ArrayList<>();
}
    // Getters for lists
    public List<LibraryItem> getItems() {
        return items;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    // Item management
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void editItem(String id, String title, Author author, String ISBN, String publisher, int numberOfCopies) {
        for (LibraryItem item : items) {
            if (item.getId().equals(id) || item.getTitle().equals(title) 
            || item.getAuthor().equals(author) || item.getISBN().equals(ISBN) || item.getPublisher().equals(publisher)) 
            {
                item.setTitle(title);
                item.setAuthor(author);
                item.setISBN(ISBN);
                item.setPublisher(publisher);
                item.setNumberOfCopies(numberOfCopies);
                break;
            }
        }
    }

    @SuppressWarnings("unlikely-arg-type")
    public void deleteItem(String id) {
        if(items.removeIf(item -> item.getId().equals(id) || item.getTitle().equals(id) || item.getAuthor().equals(id) || item.getISBN().equals(id) || item.getPublisher().equals(id)))
        {
            System.out.println("Item deleted successfully.");
        }
        else
        {
            System.out.println("Item not found.");
            
        };
    }

    // Author management
    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void editAuthor(String name, Date dateOfBirth) {
        for (Author author : authors) {
            if (author.getName().equals(name)) {
                author.setDateOfBirth(dateOfBirth);
                break;
            }
        }
    }

    public void deleteAuthor(String name) {
        authors.removeIf(author -> author.getName().equals(name));
    }

    // Patron management
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public void editPatron(String name, String address, String phoneNumber) {
        for (Patron patron : patrons) {
            if (patron.getName().equals(name)) {
                patron.setAddress(address);
                patron.setPhoneNumber(phoneNumber);
                break;
            }
        }
    }

    public void deletePatron(String name) {
        patrons.removeIf(patron -> patron.getName().equals(name));
    }

    // Borrowing and returning items
    public void borrowItem(Patron patron, LibraryItem item) {
        if (item.getNumberOfCopies() > 0) {
            item.setNumberOfCopies(item.getNumberOfCopies() - 1);
            patron.borrowItem(item);
        } else {
            System.out.println("Item is currently checked out.");
        }
    }

    public void returnItem(Patron patron, LibraryItem item) {
        if (patron.getBorrowedItems().contains(item)) {
            item.setNumberOfCopies(item.getNumberOfCopies() + 1);
            patron.returnItem(item);
        } else {
            System.out.println("Item not borrowed by patron.");
        }
    }

    public void searchItem(String keyword) {
        for (LibraryItem item : items) {
            if (item.getTitle().contains(keyword) || item.getAuthor().getName().contains(keyword)
                    || item.getISBN().contains(keyword)) {
                System.out.println(item);
            }
            else
            {
                System.out.println("Item not found.");
            }   
        }
    }
}
