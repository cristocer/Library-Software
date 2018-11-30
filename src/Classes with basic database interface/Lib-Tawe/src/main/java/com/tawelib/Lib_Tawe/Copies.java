package com.tawelib.Lib_Tawe;
import javax.persistence.*;

@Entity//Defining the class as a persistent entity allowing the hibernate API to interact with it 
@Table(name = "Copies")
public class Copies {

    @Id//specifying which variable is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)// specifying the type of auto-incrementation for the PK, in this cas "IDENTITY" uses identifies and uses the type specified in the linked table
    private int copyUID;

    @JoinColumn(name="resourceUID")//Defining that resourceUID is a foreign key 
    private int resourceUID;

    private int loanDuration;

    public Copies (int resourceUID, int loanDuration) {
        this.resourceUID = resourceUID;
        this.loanDuration = loanDuration;
    }

  //  public String getIssuedTo(){
  //  }

  //  public String setIssuedTo(){
  //  }

  //  public String getIssuedDate(){
  //  }

  //  public String getIssuedBy(){
  //  }

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
