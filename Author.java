import java.util.Date;
import java.util.ArrayList;
import java.util.List;

class Author {
    private String name;
    private Date dateOfBirth;
    private List<LibraryItem> items;

    public Author(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.items = new ArrayList<>();
    }


	// Getters and Setters
    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public List<LibraryItem> getItems() {
        return items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void addItem(LibraryItem item) {
        this.items.add(item);
    }

    public void removeItem(LibraryItem item) {
        this.items.remove(item);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Date of Birth: " + dateOfBirth;
    }
}
