package com.edia.tsearch.data;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.edia.tsearch.data.domain.Texture;
import com.edia.tsearch.data.util.DbManagerRepository;

/**
 * Unit test for simple App.
 */
public class TextureTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public TextureTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(TextureTest.class);
	}

	public void testSaveTexture() {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Texture texture = new Texture("title test", "content test");
		session.save(texture);

		session.getTransaction().commit();
		session.close();
	}

	public void testGetAll() {
		DbManagerRepository dbman = new DbManagerRepository();

		Texture texture = new Texture("title test", "content test");
		dbman.saveOrUpdate(texture);
		dbman.saveOrUpdate(texture);
		dbman.saveOrUpdate(texture);
		dbman.saveOrUpdate(texture);
		dbman.saveOrUpdate(texture);

		assert (!dbman.getAll().isEmpty());
	}
	
	public void testSelectedId() {
		DbManagerRepository dbman = new DbManagerRepository();

		Texture texture = new Texture("title test", "content test");
		dbman.saveOrUpdate(texture);
		assert (dbman.getSelectedId(1) != null);
	}
}
