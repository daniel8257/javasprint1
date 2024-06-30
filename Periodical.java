class Periodical extends LibraryItem {
    private String type; // "Printed", "Electronic"

    public Periodical(String id, String title, Author author, String ISBN, String publisher, int numberOfCopies,
            String type) {
        super(id, title, author, ISBN, publisher, numberOfCopies);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: " + type;
    }
}