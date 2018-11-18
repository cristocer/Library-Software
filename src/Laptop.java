
public class Laptop {
	private String operatingSystem;
	private String manufacturer;
	private String model;
	
	private Laptop(String operatingSystem, String manufacturer, String model) {
		this.operatingSystem = operatingSystem;
		this.manufacturer = manufacturer;
		this.model = model;
	}
	
	public String getOperatingSystem() {
        return operatingSystem;
    }
	
	public String getManufacturer() {
        return manufacturer;
    }
	
	public String getModel() {
        return model;
    }
}
