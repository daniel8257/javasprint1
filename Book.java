class Book extends LibraryItem {
    private String format; // "Printed", "Electronic", "Audio"

    public Book(String id, String title, Author author, String ISBN, String publisher, int numberOfCopies,
            String format) {
        super(id, title, author, ISBN, publisher, numberOfCopies);
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return super.toString() + ", Format: " + format;
    }
}