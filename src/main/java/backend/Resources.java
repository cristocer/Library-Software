
package backend;
import javax.persistence.*;

/**
 * Resources.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 07/12/2018
 * @author Ryan WIlliams
 * @version 1.5
 * @since 07/12/2018
 */

/**
 * The Resources abstract class is used to store attributes and abstract methods used within
 * its subclasses: Book, DVD and, Laptop. 
 */

@Entity //Defining the class as a persistent entity allowing the hibernate API to interact with it 
@Inheritance(strategy=InheritanceType.JOINED) //Defining which method of mapping inheritance is going to be used with the subclasses
public abstract class Resources {

    @Id //specifying which variable is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // specifying the type of auto-incrementation for the PK, in this case "IDENTITY" uses identifies and uses the type specified in the linked table
    public int resourceUID;					//Unique ID of the resource.
    public String year;						//Year the resource was released.
    public String title;					//Title of the resource.
    public String thumbnailImagePath;		//File path of the resource thumbnail image.
    
    /**
     * 
     */
    public void editResource() {
    }

    /**
	 * Method to get the resources Unique ID number.
	 * @return The resources' ID number.
	 */
    public int getResourceUID() {
        return resourceUID;
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