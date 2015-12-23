package com.foshanshop.ejb3.impl;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foshanshop.ejb3.PersonDAO;
import com.foshanshop.ejb3.bean.Person;

@Stateless
@Remote (PersonDAO.class)
public class PersonDAOBean implements PersonDAO {

    @PersistenceContext
    protected EntityManager em;

    public String getPersonNameByID(int personid) {
        Person person = em.find(Person.class, Integer.valueOf(personid));
        return person.getName();
    }

    public boolean insertPerson(String name, boolean sex,short age, Date birthday) {
        try {
            Person person = new Person();
            person.setName(name);
            person.setSex(sex);
            person.setAge(Short.valueOf(age));
            person.setBirthday(birthday);
            em.persist(person);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
        return true;
    }

    public Person getPersonByID(int personid) {       
        return em.find(Person.class, personid);
    }
    
    public boolean updatePerson(Person person) {
        try {
            em.merge(person);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
        return true;
    }
    
    public List getPersonList() {
         Query query = em.createQuery("from Person order by personid asc");
         List list = query.getResultList();
         return list;        
    } 
}
