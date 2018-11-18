
public class Book {
	private String author;
    private String publisher;
    private int isbn;
    private String genre;
    private String language;
    
    private Book(String author, String publisher, int isbn, String genre, String language) {
		this.author = author;
		this.publisher = publisher;
		this.isbn = isbn;
		this.genre = genre;
		this.language = language;
	}
    
    public String getAuthor() {
        return author;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public int isbn() {
        return isbn;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public String getLanguage() {
        return language;
    }
}
