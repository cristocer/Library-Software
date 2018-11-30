/*
* Resources.java
 * This abstract class is used to store attributes and abstract methods used within its 
 * subclasses: Laptop, Book and DVD. 
 * - Last Modified: 
 * - no copyright
 * - No Previous Versions
 * @version 1.0.0
 * @since 
 * @author Ryan WIlliams
 */

package com.tawelib.Lib_Tawe;
import javax.persistence.*;

@Entity //Defining the class as a persistent entity allowing the hibernate API to interact with it 
@Inheritance(strategy=InheritanceType.JOINED) //Defining which method of mapping inheritance is going to be used with the subclasses
public abstract class Resources {

    @Id //specifying which variable is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // specifying the type of auto-incrementation for the PK, in this case "IDENTITY" uses identifies and uses the type specified in the linked table
    public int resourceUID;
	public String year;
    public String title;
    public String thumbnailImagePath;
    
    public void editResource() {
    }

    public int getResourceUID() {
        return resourceUID;
    }

    public String getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnailImagePath() {
        return thumbnailImagePath;
    }

    public void setThumbnailImagePath(String thumbnailImagePath) {
        this.thumbnailImagePath = thumbnailImagePath;
    }
}