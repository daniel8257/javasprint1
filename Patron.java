import java.util.ArrayList;
import java.util.List;

abstract class Patron {
    private String name;
    private String address;
    private String phoneNumber;
    private List<LibraryItem> borrowedItems;

    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedItems = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void borrowItem(LibraryItem item) {
        this.borrowedItems.add(item);
    }

    public void returnItem(LibraryItem item) {
        this.borrowedItems.remove(item);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", Phone: " + phoneNumber;
    }
}

class Student extends Patron {
    public Student(String name, String address, String phoneNumber) {
        super(name, address, phoneNumber);
    }
}

class Employee extends Patron {
    public Employee(String name, String address, String phoneNumber) {
        super(name, address, phoneNumber);
    }
}
