package com.tawelib.Lib_Tawe;
import javax.persistence.*;

@Entity
@Table(name="Resources")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("Resources")
public abstract class Resources {

    //Setting the tables primary key to be auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int resourceUID;
    public String year;
    public String title;
    public String thumbnailImagePath;
    
    private void editResource(int resourceUID, String year, String title, String thumbnailImagePath){
    	this.year = year;
        this.title = title;
        this.thumbnailImagePath = thumbnailImagePath;
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