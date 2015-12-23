//$Id: XmlTest.java,v 1.1 2015/06/30 06:43:06 ygong Exp $
package org.ejbtest.jpa.xml;

import javax.persistence.EntityManager;

import org.ejbtest.jpa.TestCase;

/**
 * @author Emmanuel Bernard
 */
public class XmlTest extends TestCase {
	public void testXmlMappingCorrectness() throws Exception {
		EntityManager em = factory.createEntityManager();
		em.close();
	}

	public Class[] getAnnotatedClasses() {
		return new Class[0];
	}

	@Override
	public String[] getEjb3DD() {
		return new String[] {
				"org/hibernate/ejb/test/xml/orm.xml",
				"org/hibernate/ejb/test/xml/orm2.xml",
		};
	}
}
