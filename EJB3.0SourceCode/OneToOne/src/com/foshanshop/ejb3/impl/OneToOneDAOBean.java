package com.foshanshop.ejb3.impl;

import java.util.Date;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.foshanshop.ejb3.OneToOneDAO;
import com.foshanshop.ejb3.bean.IDCard;
import com.foshanshop.ejb3.bean.Person;

@Stateless
@Remote ({OneToOneDAO.class})
public class OneToOneDAOBean implements OneToOneDAO {
    @PersistenceContext
    protected EntityManager em;

    public void insertPerson(String name, boolean sex,short age, Date birthday,String cardID) {
        Person person = new Person();
        person.setName(name);
        person.setSex(sex);
        person.setAge(Short.valueOf(age));
        person.setBirthday(birthday);
        IDCard idcard = new IDCard(cardID);
        idcard.setPerson(person);
        person.setIdcard(idcard);
        em.persist(person);        
    }

    public Person getPersonByID(Integer personid) {
        Person person = em.find(Person.class, personid);
        return person;
    }

    public void updatePersonInfo(Integer personid, String newname, String newIDcard) {
        Person person = em.find(Person.class, personid);
        if (person!=null) {
            person.setName(newname);
            if (person.getIdcard()!=null){
                person.getIdcard().setCardno(newIDcard);
            } 
            em.merge(person);
        }
    }    

    public void deletePerson(Integer personid) {
        Person person = em.find(Person.class, personid);
        if (person!=null) em.remove(person);
    }
}
