package com.edia.tsearch.data.util;

import java.util.List;

import org.hibernate.Session;

import com.edia.tsearch.data.domain.Texture;

/**
 * TODO Mehmet: needs better transaction management
 * 
 * @author mehmetyaman
 *
 */
public class DbManagerRepository implements IDbRepository<Texture>{

	/**
	 * saves or updates determined object to database 
	 */
	public void saveOrUpdate(Texture texture) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(texture);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * gets all objects as list
	 * @return
	 */
	public List<Texture> getAll() {

		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		List<Texture> textures = session.createQuery("from Texture where 1 = 1").list();
		session.close();
		return textures;
	}

	/**
	 * gets selected id object from database 
	 * 
	 * @param id
	 * @return
	 */
	public Texture getSelectedId(long id) {

		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		List<Texture> textures = session.createQuery("from Texture textu where textu.id =:id ").setParameter("id", id).list();
		session.close();
		return textures.get(0);
	}
}
