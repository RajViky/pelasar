package org.logistic.pelasar.fi.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

        private static final SessionFactory sessionFactory = buildSessionFactory();
        public HibernateUtil(){
        	
        }
        
        @SuppressWarnings("deprecation")
		private static SessionFactory buildSessionFactory() {
                try {
                        // Create the SessionFactory from hibernate.cfg.xml
                        return new Configuration().configure().buildSessionFactory();
               /*         Configuration configuration = new Configuration().configure();
                    	ServiceRegistryBuilder builder = new ServiceRegistryBuilder().
                    	applySettings(configuration.getProperties());
                    	SessionFactory factory = configuration.buildSessionFactory(builder.buildServiceRegistry());
                    	return factory;*/
                } catch (Throwable ex) {
                        // Make sure you log the exception, as it might be swallowed
                        System.err.println("Initial SessionFactory creation failed." + ex);
                        throw new ExceptionInInitializerError(ex);
                }
        }
        
        public static SessionFactory getSessionFactory() {
                return sessionFactory;
        }

        public static void shutdown() {
                // Close caches and connection pools
                getSessionFactory().close();
        }
}