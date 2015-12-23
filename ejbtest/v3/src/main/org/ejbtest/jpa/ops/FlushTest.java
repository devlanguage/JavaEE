//$Id: FlushTest.java,v 1.1 2015/06/30 06:43:06 ygong Exp $
package org.ejbtest.jpa.ops;

import org.ejbtest.jpa.EJB3TestCase;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Emmanuel Bernard
 */
public class FlushTest extends EJB3TestCase {

	public void testPersistCascasde() {
		Session s = openSession();
		Transaction t = s.beginTransaction();

		Parent p = new Parent( "Marc" );
		Parent p2 = new Parent( "Nathalie" );

		// FAILS
		s.persist( p );
		s.persist( p2 );

		Child c = new Child( "Elvira" );
		Child c2 = new Child( "Blase" );
		p.getChildren().add( c );
		c.setParent( p );
		p.getChildren().add( c2 );
		c2.setParent( p );

		// WORKS
		//s.persist(p);
		//s.persist(p2);

		t.commit();
		s.close();

	}

	public FlushTest(String x) {
		super( x );
	}

	protected String[] getMappings() {
		return new String[]{
				"ops/ParentChild.hbm.xml"
		};
	}
}
