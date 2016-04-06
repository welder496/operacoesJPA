package hibernateApp;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BookHeader {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
