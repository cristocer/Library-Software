/**
 * Laptop.java
 * -no copyright
 * -creation date 18/11/2018
 * -last modified 22/11/2018
 * @author Cristian Neacsu
 * @version 1.1
 * @since 22/11/2018
 */

/**
 * Laptop is a subclass of the class Resources and holds the data and methods relevant to only
 * laptop and no other Resources subclasses. 
 * This class models the physical object of a real laptop owned by TaweLib.
 */
package tawelib.TaweGui;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity//Defining the class as a persistent entity allowing the hibernate API to interact with it 
@PrimaryKeyJoinColumn(name="id")//Defining that this entity's primary key is imported from another class, Resources
public class Laptop extends Resources {
    
    private String operatingSystem;		//operatingSystem of the laptop
    private String manufacturer;		//manufacturer of the laptop
    private String model;				//model of the laptop
    
    /**
     * Creates a laptop.
     * @param year The year when the laptop was build.
     * @param title The title(name) of the laptop.
     * @param thumbnailImagePath The path to the thumbnail image of the each individual laptop.
     * @param operatingSystem The operating system of the laptop.
     * @param manufacturer The manufacturer of the laptop.
     * @param model The model of the laptop.
     */
    public Laptop() {}
    public Laptop (String year,String title,String thumbnailImagePath,String operatingSystem,String manufacturer,String model) {
    	super();
    	this.year = year;
        this.title = title;
        this.thumbnailImagePath = thumbnailImagePath;
    	this.operatingSystem = operatingSystem;
    	this.manufacturer = manufacturer;
    	this.model = model;
    }
    
    //Method to convert a laptop to a string.(if need)    
	
    public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public void setModel(String model) {
		this.model = model;
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
