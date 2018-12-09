package backend;
import javax.persistence.*;

/**
 * Book.java
 * - GNU General Public License 2007
 * - creation Date 17/11/2018
 * - last modified 07/12/2018
 * @author Keiran Hughes
 * @version 1.5
 * @since 07/12/2018
 */

/**
 * Book is a subclass of the class Resources and holds data and methods relevant to only
 * book and no other Resources subclasses. 
 * This class models the physical object of a real book owned by TaweLib.
 */

@Entity//Defining the class as a persistant entity allowing the hibernate API to interact with it 
@PrimaryKeyJoinColumn(name="ResourceUID")//Defining that this entity's primary key is imported from another class, Resources
public class Book extends Resources {
   
	private String author;		//author of the book
    private String publisher;	//publisher of the book
    private int isbn;			//international standard book number of the book
    private String genre;		//genre(s) of the book
    private String language;	//language(s) of the book


    public Book (){}

    /**
     * When called initialises all required attributes.
     * @param author name of the author of the book.
     * @param publisher name of the publisher of the book.
     * @param isbn international standard book number to identify the book.
     * @param genre type of genre the book falls under.
     * @param language The language the book is written in.
     * @param year The year the book was first published.
     * @param title The title of the book.
     * @param thumbnailImagePath The file path of the book's thumbnail.
     */
    public Book (String author, String publisher, int isbn, String genre, String language, String year,
    		String title, String thumbnailImagePath) {
		this.author = author;
		this.publisher = publisher;
		this.isbn = isbn;
		this.genre = genre;
		this.language = language;
		this.year = year;
		this.title = title;
	    this.thumbnailImagePath = thumbnailImagePath;
	}

	public void editResource(String author, String publisher, int isbn, String genre, String language, String title, 
    		String year, String thumbnailImagePath) {
        this.author = author;
		this.publisher = publisher;
		this.isbn = isbn;
		this.genre = genre;
		this.language = language;
		this.year = year;
        this.title = title;
        this.thumbnailImagePath = thumbnailImagePath;
    } 
    
	/**
     * Gets the author of the book.
     * @return name of the author.
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * Gets the publisher of the book.
     * @return name of the publisher.
     */
    public String getPublisher() {
        return publisher;
    }
    
    /**
     * Gets the genre of the book.
     * @return type of genres.
     */
    public String getGenre() {
        return genre;
    }
    
    /**
     * Gets the languages of the book.
     * @return written languages.
     */
    public String getLanguage() {
        return language;
    }
    
    /**
     * Gets the isbn of the book.
     * @return international standard book number.
     */
    public int getIsbn() {
		return isbn;
	}
}
