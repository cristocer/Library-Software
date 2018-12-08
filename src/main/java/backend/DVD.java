/**
 * DVD.java
 * - GNU General Public License 2007
 * - creation date 17/11/2018
 * - last modified 07/12/2018
 * @author Ben Farrington
 * @version 1.5
 * @since 07/12/2018
 */

package backend;
import javax.persistence.*;
/**
 * DVD is a subclass of the class Resources, which holds the data and methods relevant to only
 * DVD and no other Resources subclasses. 
 * This class models the physical object of a DVD owned by TaweLib.
 */

@Entity//Defining the class as a persistent entity allowing the hibernate API to interact with it 
@PrimaryKeyJoinColumn(name="ResourceUID")//Defining that this entity's primary key is imported from another class, Resources
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
     * @param title The title of the DVD.
     * @param year The year the DVD was first released.
     * @param thumbnailImagePath The file path of the resources thumbnail image.
     */
    public DVD(String director, int runTime, String language, String subtitleLanguage, String title, String year,	
               String thumbnailImagePath){

        this.director = director;
        this.runTime = runTime;
        this.language = language;
        this.subtitleLanguage = subtitleLanguage;
        this.title = title;
        this.year = year;
        this.thumbnailImagePath = thumbnailImagePath;
    }

    /**
     * When called replaces variables tied to the DVD resource with newly input variables.
     * @param director name of director.
     * @param runTime run time of  DVD in seconds.
     * @param language language of the DVD's audio
     * @param subtitleLanguage language of the DVD's subtitles.
     * @param title The title of the DVD.
     * @param year The year the DVD was first released.
     * @param thumbnailImagePath The file path of the resources thumbnail image.
     */
    public void editResource(String director, int runTime, String language, String subtitleLanguage, String title, String year,	
            String thumbnailImagePath){
        this.director = director;
        this.runTime = runTime;
        this.language = language;
        this.subtitleLanguage = subtitleLanguage;
        this.title = title;
        this.year = year;
        this.thumbnailImagePath = thumbnailImagePath;
    }
    
    /**
     * Gets the director of the DVD.
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
