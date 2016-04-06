package hibernateUtils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerarTabelasFactory {

	public static void main(String[] args){
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hibernateApp");
		factory.close();
	}
	
}
