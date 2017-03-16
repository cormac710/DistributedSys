package myApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum LaptopDao {
	instance;

	private Map<Integer, Laptop> laptopsMap = new HashMap<Integer, Laptop>();

	private LaptopDao() {

		Laptop laptop = new Laptop();
		laptop.setId(1);
		laptop.setMake("lenovo");
		laptop.setModel("Q50");
		laptop.setPrice(1250);

		laptopsMap.put(1, laptop);

		Laptop laptop2 = new Laptop();
		laptop2.setId(2);
		laptop2.setMake("lenovo");
		laptop2.setModel("Q50");
		laptop2.setPrice(1250);

		laptopsMap.put(2, laptop2);
	}

	public List<Laptop> getLaptops() {
		List<Laptop> laptops = new ArrayList<Laptop>();
		laptops.addAll(laptopsMap.values());
		return laptops;
	}

	public Laptop getLaptop(int id) {
		return laptopsMap.get(id);
	}

	public void create(Laptop laptop) {
		laptopsMap.put(laptop.getId(), laptop);
	}

	public void delete(int id) {
		if (laptopsMap.remove(id) != null) {
			System.out.println("Removed");
		} else {
			System.out.println("Not Removed");
		}
	}

}
