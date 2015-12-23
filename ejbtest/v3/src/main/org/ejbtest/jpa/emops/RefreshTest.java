//$Id: RefreshTest.java,v 1.1 2015/06/30 06:43:05 ygong Exp $
package org.ejbtest.jpa.emops;

import javax.persistence.EntityManager;

import org.ejbtest.jpa.TestCase;

/**
 * @author Emmanuel Bernard
 */
public class RefreshTest extends TestCase {

	public void testRefreshNonManaged() throws Exception {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Race race = new Race();
		em.persist( race );
		em.flush();
		em.clear();

		try {
			em.refresh( race );
			fail("Refresh should fail on a non managed entity");
		}
		catch( IllegalArgumentException e) {
			//success
		}

		em.getTransaction().rollback();
		em.close();
	}

	public Class[] getAnnotatedClasses() {
		return new Class[] {
				Race.class,
				Competitor.class
		};
	}
}
