package org.ejbtest.v2.entity;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface LocalRoleHome extends EJBLocalHome { 
    public LocalRole create (String name, String description) throws CreateException; 
    public LocalRole findByPrimaryKey (String email) throws FinderException; 
    public Collection findAll() throws FinderException; 
} 