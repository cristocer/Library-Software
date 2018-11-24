package com.tawelib.Lib_Tawe;

import javax.persistence.*;

@Entity
@Table(name="Book")
@DiscriminatorValue("Book")
@PrimaryKeyJoinColumn(name="ResourceUID")
public class Book extends Resources {
   
	public String author;
    public String publisher;
    public int isbn;
    public String genre;
    public String language;
    
    public Book(String author, String publisher, int isbn, String genre, String language, String title, 
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

	@Override
	public String toString() {
		return "Book [author=" + author + ", publisher=" + publisher + ", isbn=" + isbn + ", genre=" + genre
				+ ", language=" + language + "]";
	}
}
