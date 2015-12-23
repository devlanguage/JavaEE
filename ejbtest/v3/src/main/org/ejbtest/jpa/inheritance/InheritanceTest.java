//$Id: InheritanceTest.java,v 1.1 2015/06/30 06:43:21 ygong Exp $
package org.ejbtest.jpa.inheritance;

import javax.persistence.EntityManager;

import org.ejbtest.jpa.TestCase;

/**
 * @author Emmanuel Bernard
 */
public class InheritanceTest extends TestCase {

	public void testFind() throws Exception {
		EntityManager firstSession = factory.createEntityManager( );
        Strawberry u = new Strawberry();
		u.setSize( 12l );
		firstSession.getTransaction().begin();
        firstSession.persist(u);
        firstSession.getTransaction().commit();
        Long newId = u.getId();
        firstSession.clear();

		firstSession.getTransaction().begin();
        // 1.
        Strawberry result1 = firstSession.find(Strawberry.class, newId);
        assertNotNull( result1 );

        // 2.
        Strawberry result2 = (Strawberry) firstSession.find(Fruit.class, newId);
        System.out.println("2. result is:" + result2);

        firstSession.getTransaction().commit();
        firstSession.close();
	}
	public Class[] getAnnotatedClasses() {
		return new Class[] {
				Fruit.class,
				Strawberry.class
		};
	}
}
