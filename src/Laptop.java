/**
 * Laptop.java
 * @author Cristian Neacsu
 * -no copyright
 * @version 1.1
 * Version History 1.1
 * Creation Date 18/11/2018
 * Last Modified date 22/11/2018
 */
//package main;

/**
 * Laptop is a subclass of the class Resources, which holds the data and methods relevant to only
 * laptop and no other Resources subclasses. 
 * This class models the physical object of a real laptop owned by TaweLib.
 */

public class Laptop extends Resources {
    
    private String operatingSystem;
    private String manufacturer;
    private String model;
    /**
     * Creates a laptop.
     * @param year The year when the laptop was build.
     * @param title The title(name) of the laptop.
     * @param thumbnailImagePath The path to the thumbnail image of the each individual laptop.
     * @param operatingSystem The operating system of the laptop.
     * @param manufacturer The manufacturer of the laptop.
     * @param model The model of the laptop.
     */
    public Laptop (String year,String title,String thumbnailImagePath,String operatingSystem,String manufacturer,String model) {
//    	super (,title,year,thumbnailImagePath);//get resourceUID from db too call super
    	this.operatingSystem = operatingSystem;
    	this.manufacturer = manufacturer;
    	this.model = model;
    }
    
    //Method to convert a laptop to a string.(if need)    
	
    /**
     * @return The operating system of the laptop.
     */
    public String getOperatingSystem() {
        return operatingSystem;
    }
    
	/**
     * @return The manufacturer of the laptop.
     */
    public String getManufacturer() {
        return manufacturer;
    }
    
	/**
     * @return The model of the laptop.
     */
    public String getModel() {
        return model;
    }
}
