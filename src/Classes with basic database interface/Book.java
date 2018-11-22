import javax.persistence.*;

@Entity
@Table(name = "Book")
public class Book extends Resources {

    @Column(name = "author")
	private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "isbn")
    private int isbn;

    @Column(name = "genre")
    private String genre;

    @Column(name = "language")
    private String language;
    
    private Book(String author, String publisher, int isbn, String genre, String language, String title,
                 String thumbnailImagePath, String year) {

        this.title = title;
        this.thumbnailImagePath = thumbnailImagePath;
        this.year = year;

        this.author = author;
		this.publisher = publisher;
		this.isbn = isbn;
		this.genre = genre;
		this.language = language;

        //Update table with new entry
        em.getTransaction().begin();
        em.persist(this);
        em.getTransaction().commit();
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
