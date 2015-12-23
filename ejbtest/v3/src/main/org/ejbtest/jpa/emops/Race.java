//$Id: Race.java,v 1.1 2015/06/30 06:43:05 ygong Exp $
package org.ejbtest.jpa.emops;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

import org.hibernate.annotations.IndexColumn;

/**
 * @author Emmanuel Bernard
 */
@Entity
public class Race {
	@Id @GeneratedValue public Integer id;
	@IndexColumn( name="index" ) @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@org.hibernate.annotations.Cascade( { org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN }) 
	public List<Competitor> competitors = new ArrayList<Competitor>();
	public String name;
}
