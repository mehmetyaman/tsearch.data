package com.edia.tsearch.data.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * utilization for hibernate operations 
 * 
 * @author mehmetyaman
 *
 */
public class HibernateUtil {

	/**
	 * singleton instance generates only once time
	 */
	private static HibernateUtil instance = new HibernateUtil();

	private SessionFactory sessionFactory;

	private HibernateUtil() {
		this.sessionFactory = buildSessionFactory();
	}

	
	/**
	 * TODO Mehmet: has to change with not deprecated version
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private synchronized static SessionFactory buildSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}

	public static HibernateUtil getInstance() {
		if (instance == null) {
			return new HibernateUtil();
		}
		return instance;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}