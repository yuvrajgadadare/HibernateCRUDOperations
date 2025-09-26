package mypackage;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

 

public class HibernateUtils {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
		Configuration configure=new Configuration();
		try {
				Properties settings=new Properties();
				settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/javaprojectdb");
				settings.put("hibernate.connection.username", "root");
				settings.put("hibernate.connection.password", "tiger");
				settings.put("hibernate.show.sql", "true");
				settings.put("hibernate.hbm2ddl.auto", "update");
				configure.setProperties(settings);
				
				   
				  configure.addAnnotatedClass(Employee.class);
				  
				  
				StandardServiceRegistryBuilder serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configure.getProperties());
				sessionFactory =configure.buildSessionFactory(serviceRegistry.build());
				
				
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		}
		return sessionFactory;
	}
	
}
