package com.foshanshop.ejb3;

import java.util.Date;

import com.foshanshop.ejb3.bean.Person;

public interface OneToOneDAO {
    
    public void insertPerson(String name, boolean sex,short age, Date birthday,String cardID);
    public Person getPersonByID(Integer orderid);
    public void updatePersonInfo(Integer personid, String newname, String newIDcard);
    public void deletePerson(Integer personid);
    
}
