package com.foshanshop.ejb3;

import java.util.Date;
import java.util.List;

import com.foshanshop.ejb3.bean.Person;

public interface PersonDAO {
    public boolean insertPerson(String name, boolean sex,short age, Date birthday);
    public String getPersonNameByID(int personid);
    public boolean updatePerson(Person person);
    public Person getPersonByID(int personid);
    public List getPersonList();
}
