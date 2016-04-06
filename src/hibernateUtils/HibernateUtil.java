package hibernateUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

public class HibernateUtil {

	private static EntityManagerFactory emf=null;

	
	public static EntityManager getEntityManager(){
		EntityManager em=null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernateApp");
			em = emf.createEntityManager();
		}catch (HibernateException he){
			he.printStackTrace();
		}finally{
			emf.close();
		}
		return em;
	}
	
	
}
