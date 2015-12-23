//$Id: NumberedNode.java,v 1.1 2015/06/30 06:43:05 ygong Exp $
package org.ejbtest.jpa.ops;

/**
 * @author Gavin King
 */
public class NumberedNode extends Node {

	private long id;

	public NumberedNode() {
		super();
	}


	public NumberedNode(String name) {
		super( name );
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
