import javax.persistence.*;

@Entity
@Table(name = "Resources")
@Inheritance( strategy = InheritanceType.JOINED)
public abstract class Resources {

    //Setting the tables primary key to be auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int resourceUID;

    @Column(name = "year")
    public String year;

    @Column(name = "title")
    public String title;

    @Column(name = "thumbnail_Image_Path")
    public String thumbnailImagePath;

    //Set up the entity manager
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityManager em = emf.createEntityManager();

    private void editResource(int resourceUID, String year, String title, String thumbnailImagePath){

        this.year = year;
        this.title = title;
        this.thumbnailImagePath = thumbnailImagePath;

        //Update table with new entry
        em.getTransaction().begin();
        em.persist(this);
        em.getTransaction().commit();
    }

    private int getResourceUID() {
        return resourceUID;
    }

    private String getYear() {
        return year;
    }

    private String getTitle() {
        return title;
    }

    private String getThumbnailImagePath() {
        return thumbnailImagePath;
    }

    private void setThumbnailImagePath(String thumbnailImagePath) {
        this.thumbnailImagePath = thumbnailImagePath;
    }
}
