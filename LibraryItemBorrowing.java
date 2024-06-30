public class LibraryItemBorrowing {
    private Patron patron;
    private LibraryItem item;

    public LibraryItemBorrowing(Patron patron, LibraryItem item) {
        this.patron = patron;
        this.item = item;
    }

    public void execute() {
        patron.borrowItem(item);
    }
}
