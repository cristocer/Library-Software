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
    public DVD(String director, int runTime, String language, String subtitleLanguage){
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
