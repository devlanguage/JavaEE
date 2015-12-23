//$Id: Author.java,v 1.1 2015/06/30 06:43:07 ygong Exp $
package org.ejbtest.jpa.cascade;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;

/**
 * @author Emmanuel Bernard
 */
@Entity
public class Author {
	@Id 	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENTITY2_SEQ")
	@SequenceGenerator(name = "ENTITY2_SEQ")
 private Long id;

}
