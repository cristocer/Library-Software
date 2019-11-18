/**
 * Resources.java
 * - no copyright
 * - creation date 18/11/2018
 * - last modified 22/11/2018
 * @author 
 * @version 1.0
 * @since 22/11/2018
 */

/**
 * The Resources abstract class is used to store attributes and abstract methods used within
 * its subclasses: Book, DVD and, Laptop.  
 */
package tawelib.TaweGui;
import java.util.Random;
import javax.persistence.*;
@Entity //Defining the class as a persistent entity allowing the hibernate API to interact with it
@Inheritance(strategy=InheritanceType.JOINED)//Defining which method of mapping inheritance is going to be used with the subclasses
public class Resources {
	
	@Id  //specifying which variable is the primary key
	@Column(unique=true) // This is specifying that the following attribute has to be unique, if not the program throws an exception
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int resourceUID;				//Unique ID of the resource.
	protected String year;					//Year the resource was released.
	protected String title;					//Title of the resource.
	protected String thumbnailImagePath;	//File path of the resource thumbnail image.
	
	  /**
	   * Method to get the resources Unique ID number.
	   * @return The resources' ID number.
	   */
	protected Resources(){
		
	}
    public int getResourceUID() {
        return resourceUID;
    }

	  public void setYear(String year) {
		this.year = year;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	   * Method to get the resources' year of release.
	   * @return The resources' year of release.
	   */
    public String getYear() {
        return year;
    }

	  /**
	   * Method to get the resources title.
	   * @return The resources' title.
	   */
    public String getTitle() {
        return title;
    }

	  /**
	   * Method to get the resources Thumbnail Image file path.
	   * @return The Resources' Thumbnail Image file path.
	   */
    public String getThumbnailImagePath() {
        return thumbnailImagePath;
    }
	
    /**
	    * Method to set the resource's Thumbnail Image file path.
	    * @param thumbnailImagePath The new Thumbnail Image file path.
	    */
    public void setThumbnailImagePath(String thumbnailImagePath) {
        this.thumbnailImagePath = thumbnailImagePath;
    }
}
