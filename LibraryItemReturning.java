public class LibraryItemReturning {
    private Patron patron;
    private LibraryItem item;

    public LibraryItemReturning(Patron patron, LibraryItem item) {
        this.patron = patron;
        this.item = item;
    }

    public void execute() {
        patron.returnItem(item);
    }
}
