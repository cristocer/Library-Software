package backend;
import javax.persistence.*;

/**
 * Laptop.java
 * -GNU General Public License 2007
 * -creation date 18/11/2018
 * -last modified 07/12/2018
 * @author Cristian Neacsu
 * Creation Date 18/11/2018
 * Last Modified date 07/12/2018
 */

/**
 * Laptop is a subclass of the class Resources, which holds the data and methods relevant to only
 * laptop and no other Resources subclasses. 
 * This class models the physical object of a real laptop owned by TaweLib.
 */

@Entity//Defining the class as a persistent entity allowing the hibernate API to interact with it 
@PrimaryKeyJoinColumn(name="ResourceUID")//Defining that this entity's primary key is imported from another class, Resources
public class Laptop extends Resources {

    private String operatingSystem;		//operatingSystem of the laptop
    private String manufacturer;		//manufacturer of the laptop
    private String model;				//model of the laptop


    public Laptop (){}

    /**
     * Creates a laptop.
     * @param operatingSystem The operating system of the laptop.
     * @param manufacturer The manufacturer of the laptop.
     * @param model The model of the laptop.
     * @param title The title(name) of the laptop.
     * @param year The year when the laptop was build.
     * @param thumbnailImagePath The path to the thumbnail image of the each individual laptop.
     */
    public Laptop (String operatingSystem,String manufacturer,String model, String title,String year, 
    		String thumbnailImagePath) {

    	this.operatingSystem = operatingSystem;  
        this.manufacturer = manufacturer;
        this.model = model;
        this.title = title;
        this.year = year;
        this.thumbnailImagePath = thumbnailImagePath;
    }

    public void editResource(String operatingSystem,String manufacturer,String model, String title,String year, 
    		String thumbnailImagePath) {
    	this.operatingSystem = operatingSystem;  
        this.manufacturer = manufacturer;
        this.model = model;
        this.title = title;
        this.year = year;
        this.thumbnailImagePath = thumbnailImagePath;
    }
    
    /**
     * Gets the operating system
     * @return The operating system of the laptop.
     */
    public String getOperatingSystem() {
        return operatingSystem;
    }
    
    /**
	 * Gets the manufacturer
     * @return The manufacturer of the laptop.
     */
    public String getManufacturer() {
        return manufacturer;
    }
    
	/**
	 * Gets the model
     * @return The model of the laptop.
     */
    public String getModel() {
        return model;
    }
}
