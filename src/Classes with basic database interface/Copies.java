package com.tawelib.Lib_Tawe;
import javax.persistence.*;

@Entity
@Table(name = "Copies")
public class Copies {

    //Setting the tables primary key to be auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int copyUID;

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
