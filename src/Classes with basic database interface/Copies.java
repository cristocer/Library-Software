import javax.persistence.*;

@Entity
@Table(name = "Copies")
public class Copies {

    //Setting the tables primary key to be auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int copyUID;

    @OneToMany
    @JoinColumn(name  = "resourceUID")
    private int resourceUID;

    @Column(name = "loan_duration")
    private int loanDuration;

    //Set up the entity manager
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityManager em = emf.createEntityManager();

    public Copies (int copyUID, int resourceUID, int loanDuration) {
        this.copyUID = copyUID;
        this.resourceUID = resourceUID;
        this.loanDuration = loanDuration;

        //Update table with new entry
        em.getTransaction().begin();
        em.persist(this);
        em.getTransaction().commit();
    }

    public String getIssuedTo(){
    }

    public String setIssuedTo(){
    }

    public String getIssuedDate(){
    }

    public String getIssuedBy(){
    }

    public void returnItem(){
    }

    public void requestItem(){
    }

    public void houseKeeping(){
    }

    public int getCopyUID() {
        return copyUID;
    }

    public int getResourceUID() {
        return resourceUID;
    }

    public int getLoanDuration() {
        return loanDuration;
    }
}
