package projects.intermediate.librarySystem;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }

    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return title + "," + author + "," + ISBN + "," + isAvailable;
    }

    public static Book fromString(String bookData) {
        String[] data = bookData.split(",");
        Book book = new Book(data[0], data[1], data[2]);
        book.isAvailable = Boolean.parseBoolean(data[3]);
        return book;
    }
}
