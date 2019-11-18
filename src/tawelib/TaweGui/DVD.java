/**
 * DVD.java
 * - no copyright
 * - creation date 17/11/2018
 * - last modified 22/11/2018
 * @author Ben Farrington
 * @version 1.1
 * @since 22/11/2018
 */

/**
 * DVD is a subclass of the class Resources, which holds the data and methods relevant to only
 * DVD and no other Resources subclasses. 
 * This class models the physical object of a DVD owned by TaweLib.
 */
package tawelib.TaweGui;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity//Defining the class as a persistent entity allowing the hibernate API to interact with it 
@PrimaryKeyJoinColumn(name="id")//Defining that this entity's primary key is imported from another class, Resources
public class DVD extends Resources{

    private String director;			//director of the DVD
    private int runTime;				//runtime of the DVD
    private String language;			//language(s) of the DVD
    private String subtitleLanguage;	//subtitle language(s) of the DVD

    /**
     * On creation initializes all required attributes.
     * @param director name of director.
     * @param runTime run time of  DVD in seconds.
     * @param language language of the DVD's audio
     * @param subtitleLanguage language of the DVD's subtitles.
     */
    public DVD() {}
    public void setDirector(String director) {
		this.director = director;
	}
	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setSubtitleLanguage(String subtitleLanguage) {
		this.subtitleLanguage = subtitleLanguage;
	}
	public DVD(String year,String title,String thumbnailImagePath,String director, int runTime, String language, String subtitleLanguage){
    	super();
    	this.year = year;
        this.title = title;
        this.thumbnailImagePath = thumbnailImagePath;
    	this.director = director;
        this.runTime = runTime;
        this.language = language;
        this.subtitleLanguage = subtitleLanguage;
    }

    /**
     * Gets the director.
     * @return name of director.
     */
    public String getDirector() {
        return director;
    }
    

    /**
     * Gets the DVD's runtime
     * @return runtime in seconds.
     */
    public int getRunTime() {
        return runTime;
    }

    /**
     * Gets the DVD's language.
     * @return audio language.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Gets the DVD's subtitle language.
     * @return subtitle language.
     */
    public String getSubtitleLanguage() {
        return subtitleLanguage;
    }
}
