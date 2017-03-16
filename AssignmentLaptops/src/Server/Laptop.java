package Server;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Laptop {

	private int laptopId;
	private String make;
	private String model;
	private double price;
	private int ram;
	private int hardDrive;
	private String processor;

	public int getId() {
		return laptopId;
	}

	public void setId(final int laptopId) {
		this.laptopId = laptopId;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(final double price) {
		this.price = price;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(final int ram) {
		this.ram = ram;
	}

	public int getHardDrive() {
		return hardDrive;
	}

	public void setHardDrive(final int hardDrive) {
		this.hardDrive = hardDrive;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(final String processor) {
		this.processor = processor;
	}

}
