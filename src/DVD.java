public class DVD extends Resources{

    private String director;
    private int runTime;
    private String language;
    private String subtitleLanguage;

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
