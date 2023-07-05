package com.springmvc.pagination.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	
	  private static Configuration cfg =  null;
	  
	  private static SessionFactory sessionFactory = null;
	  
	  private static StandardServiceRegistryBuilder builder = null;
	  
	  private static StandardServiceRegistry registry = null;
	  
	  static{
	      if (sessionFactory == null) try {
	    	    cfg =  new Configuration();
			    cfg.configure("/src/main/resources/hibernate.cfg.xml");
	    	  
	    	  builder = new StandardServiceRegistryBuilder();
	    	  builder = builder.applySettings(cfg.getProperties());
	    	  StandardServiceRegistry registry = builder.build();
	    	  sessionFactory = cfg.buildSessionFactory(registry);
	    	  
	    } catch (Exception e) {
	      e.printStackTrace();
	      if (registry != null) {
	        StandardServiceRegistryBuilder.destroy(registry);
	      }
	    }
	  }
	  public static SessionFactory getSessionFactory() {
	    return sessionFactory;
	  }
}
