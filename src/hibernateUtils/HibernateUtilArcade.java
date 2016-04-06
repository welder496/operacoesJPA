package hibernateUtils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtilArcade {

	private static SessionFactory sessionFactory = buildSessionFactory();
	
	/*Deprecated version of building Session Factory
	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory(){
		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex){
			System.err.println("SessionFactory creation asset failed "+ex);
			throw new ExceptionInInitializerError(ex);
		}
		return sessionFactory;
	}
	*/
	
	private synchronized static SessionFactory buildSessionFactory(){
		try {
			Configuration cfg=new Configuration().configure();
			StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
			return cfg.buildSessionFactory(serviceRegistry.build());
		} catch (Exception e){
			System.err.println("SessionFactory creation asset failed "+e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory() throws HibernateException {
		return sessionFactory;
	}
	
}
