/**
 * Book.java
 * @author Keiran Hughes
 * -no copyright
 * @version 1.1
 * Version History 1.1
 * Creation Date 17/11/2018
 * Last Modified date 22/11/2018
 */

/**
 * Book is a subclass of the class Resources, which holds the data and methods relevant to only
 * book and no other Resources subclasses. 
 * This class models the physical object of a real book owned by TaweLib.
 */

public class Book extends Resources {
	private String author;
    private String publisher;
    private int isbn;
    private String genre;
    private String language;
    
    /**
     * When called initialises all required attributes.
     * @param author name of the author of the book.
     * @param publisher name of the publisher of the book.
     * @param isbn international standard book number to identify the book.
     * @param genre type of genre the book falls under.
     * @param language language the book is written in.
     */
    
    private Book(String author, String publisher, int isbn, String genre, String language) {
		this.author = author;
		this.publisher = publisher;
		this.isbn = isbn;
		this.genre = genre;
		this.language = language;
	}
    
    /**
     * Gets the author.
     * @return name of the author.
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * Gets the publisher.
     * @return name of the publisher.
     */
    public String getPublisher() {
        return publisher;
    }
    
    /**
     * Gets the isbn.
     * @return international standard book number.
     */
    public int isbn() {
        return isbn;
    }
    
    /**
     * Gets the genre.
     * @return type of genres.
     */
    public String getGenre() {
        return genre;
    }
    
    /**
     * Gets the language.
     * @return written languages.
     */
    public String getLanguage() {
        return language;
    }
}
