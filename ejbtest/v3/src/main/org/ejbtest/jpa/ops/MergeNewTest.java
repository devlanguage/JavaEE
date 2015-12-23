//$Id: MergeNewTest.java,v 1.1 2015/06/30 06:43:06 ygong Exp $
package org.ejbtest.jpa.ops;

import javax.persistence.EntityManager;

import org.ejbtest.jpa.TestCase;

/**
 * @author Emmanuel Bernard
 */
public class MergeNewTest extends TestCase {

	public void testMergeNew() throws Exception {
		Workload load = new Workload();
		load.name = "Cleaning";
		load.load = 10;
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		load = em.merge( load );
		assertNotNull( load.id );
		em.flush();
		assertNotNull( load.id );
		em.getTransaction().rollback();
		em.close();
	}

	public void testMergeAfterRemove() throws Exception {
		Workload load = new Workload();
		load.name = "Cleaning";
		load.load = 10;
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		load = em.merge( load );
		em.flush();
		em.getTransaction().commit();
		em.close();
		em = factory.createEntityManager();
		em.getTransaction().begin();
		load = em.find( Workload.class, load.id );
		em.remove( load );
		em.flush();
		em.getTransaction().commit();
		em.close();
		em = factory.createEntityManager();
		em.getTransaction().begin();
		em.merge( load );
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	public Class[] getAnnotatedClasses() {
		return new Class[]{
				Workload.class
		};
	}
}
