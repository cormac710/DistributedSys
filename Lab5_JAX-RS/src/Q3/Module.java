package Q3;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import Q2.Book;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Module {
	@XmlElementWrapper(name = "modules")
	@XmlElement(name = "module")
	private List<Course> moduleList;
	private String level;
	private String name;

	public List<Course> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<Course> moduleList) {
		this.moduleList = moduleList;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
