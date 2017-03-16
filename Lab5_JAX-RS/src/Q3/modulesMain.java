package Q3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class modulesMain {
	private static final String MODULES_XML = "modules.xml";

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		List<Course> courseList = new ArrayList<Course>();

		Course c1 = new Course();
		c1.setHours(4);
		c1.setLecturer("PJ");
		c1.setName("DS");

		Course c2 = new Course();
		c2.setHours(6);
		c2.setLecturer("SK");
		c2.setName("Java");

		courseList.add(c1);
		courseList.add(c2);

		Module module = new Module();
		module.setLevel("9");
		module.setName("MASE");
		module.setModuleList(courseList);

		JAXBContext context = JAXBContext.newInstance(Module.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		m.marshal(module, System.out);
		m.marshal(module, new File(MODULES_XML));

		System.out.println();
		System.out.println("Output XML");
		Unmarshaller um = context.createUnmarshaller();
		Module module2 = (Module) um.unmarshal(new FileReader(MODULES_XML));
		List<Course> list = module2.getModuleList();
		for (Course course : list) {
			System.out.println("Course " + course.getName() + " from " + module.getName());
		}

	}

}
