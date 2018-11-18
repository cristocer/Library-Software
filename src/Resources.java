public abstract class Resources {

    private int resourceUID;
    private String year;
    private String title;
    private String thumbnailImagePath;

    //wont work
    private void editResource(int resourceUID, String year, String title, String thumbnailImagePath){
        this.year = year;
        this.title = title;
        this.thumbnailImagePath = thumbnailImagePath;
    }

    //wont work
    private int createResourceID(){
        this.resourceUID = generateNewUID;
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
