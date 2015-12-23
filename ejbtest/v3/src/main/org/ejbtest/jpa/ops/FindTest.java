//$Id: FindTest.java,v 1.1 2015/06/30 06:43:06 ygong Exp $
package org.ejbtest.jpa.ops;

import javax.persistence.EntityManager;

import org.ejbtest.jpa.TestCase;

/**
 * @author Emmanuel Bernard
 */
public class FindTest extends TestCase {

	public void testSubclassWrongId() throws Exception {
		Mammal mammal = new Mammal();
		mammal.setMamalNbr( 2 );
		mammal.setName( "Human" );
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist( mammal );
		em.flush();
		assertNull( em.find(Reptile.class, 1l) );
		em.getTransaction().rollback();
		em.close();
	}

	public Class[] getAnnotatedClasses() {
		return new Class[] {
				Mammal.class,
				Reptile.class,
				Animal.class
		};
	}
}
