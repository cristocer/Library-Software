package com.tawelib.Lib_Tawe;
import javax.persistence.*;

/**
 * Laptop.java
 * @author Cristian Neacsu
 * -no copyright
 * @version 1.0
 * Version History 1.0 
 * Creation Date 18/11/2018
 * Last Modified date 18/11/2018
 */
//package main;

/**
 * Laptop is a subclass of the class Resources, which holds the data and methods relevant to only
 * laptop and no other Resources subclasses. 
 * This class models the physical object of a real laptop owned by TaweLib.
 */

@Entity
@Table(name = "Laptop")
@DiscriminatorValue("Laptop")
@PrimaryKeyJoinColumn(name="ResourceUID")
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
    public Laptop (String operatingSystem,String manufacturer,String model, String title,String year, 
    		String thumbnailImagePath) {

    	this.operatingSystem = operatingSystem;  
        this.manufacturer = manufacturer;
        this.model = model;
        this.title = title;
        this.year = year;
        this.thumbnailImagePath = thumbnailImagePath;
    }
    
    /**
     * Method to convert a laptop to a string.(if need)
     */    
	
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
