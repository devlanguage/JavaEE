//$Id: GetReferenceTest.java,v 1.1 2015/06/30 06:43:05 ygong Exp $
package org.ejbtest.jpa.emops;

import javax.persistence.EntityManager;

import org.ejbtest.jpa.TestCase;


/**
 * @author Emmanuel Bernard
 */
public class GetReferenceTest extends TestCase {

	public void testWrongIdType() throws Exception {
		EntityManager em = factory.createEntityManager();
		try {
			Competitor c = em.getReference( Competitor.class, new String("30") );
			fail("Expected IllegalArgumentException");
		}
		catch (IllegalArgumentException e) {
			//success
		}
		catch ( Exception e ) {
			fail("Wrong exception: " + e );
		}

		try {
			Mail c = em.getReference( Mail.class, 1 );
			fail("Expected IllegalArgumentException");
		}
		catch (IllegalArgumentException e) {
			//success
		}
		catch ( Exception e ) {
			fail("Wrong exception: " + e );
		}
		em.close();
	}

	public Class[] getAnnotatedClasses() {
		return new Class[] {
				Competitor.class,
				Race.class,
				Mail.class
		};
	}
}
