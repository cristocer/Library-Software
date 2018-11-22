import javax.persistence.*;

@Entity
@Table(name = "DVD")
public class DVD extends Resources{

    @Column(name = "director")
    private String director;

    @Column(name = "run_time")
    private int runTime;

    @Column(name = "language")
    private String language;

    @Column(name = "subtitle_language")
    private String subtitleLanguage;

    /**
     * On creation initializes all required attributes.
     * @param director name of director.
     * @param runTime run time of  DVD in seconds.
     * @param language language of the DVD's audio
     * @param subtitleLanguage language of the DVD's subtitles.
     */
    public DVD(String director, int runTime, String language, String subtitleLanguage, String title,
               String thumbnailImagePath, String year){

        this.title = title;
        this.thumbnailImagePath = thumbnailImagePath;
        this.year = year;

        this.director = director;
        this.runTime = runTime;
        this.language = language;
        this.subtitleLanguage = subtitleLanguage;

        //Update table with new entry
        em.getTransaction().begin();
        em.persist(this);
        em.getTransaction().commit();
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
