package Server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum LaptopDao {
	instance;

	private Map<Integer, Laptop> laptopsDb = new HashMap<Integer, Laptop>();

	private LaptopDao() {
		Laptop laptop = new Laptop();
		laptop.setId(1);
		laptop.setMake("Lenovo");
		laptop.setModel("G50");
		laptop.setRam(4);
		laptop.setPrice(750);
		laptop.setProcessor("Intel i3");

		laptopsDb.put(1, laptop);

		laptop = new Laptop();
		laptop.setId(1);
		laptop.setMake("HP");
		laptop.setModel("Pavillion");
		laptop.setRam(8);
		laptop.setPrice(820);
		laptop.setProcessor("Intel i5");

		laptopsDb.put(2, laptop);
	}

	public List<Laptop> getAllLaptop() {
		List<Laptop> laptops = new ArrayList<Laptop>();
		laptops.addAll(laptopsDb.values());
		return laptops;
	}

	public Laptop getLaptop(int id) {
		return laptopsDb.get(id);
	}

	public void create(Laptop laptop) {
		laptopsDb.put(laptop.getId(), laptop);
	}

	public void delete(int id) {
		if (laptopsDb.remove(id) != null) {
			System.out.println("Deleted");
		} else {
			System.out.println("Not Deleted");
		}
	}

}
