public class Book 
{
    private final String title;
    private final String author;
    private final String isbn;
    private int copies_available;

    public Book(String title, String author, String isbn, int copies_available) 
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.copies_available = copies_available;
    }

    public String getDisplayString()
    {
        return title + " by " + author + "\nISBN: " + isbn;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getCopiesAvailable() { return copies_available; }
}
