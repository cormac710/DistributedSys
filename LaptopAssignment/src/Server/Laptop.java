package Server;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Laptop {
	
	private int id;
	private String make;
	private String model;
	private int price;
	private int ram;
	private String processor;
	
	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(final String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(final String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(final int price) {
		this.price = price;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(final int ram) {
		this.ram = ram;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(final String processor) {
		this.processor = processor;
	}

}
