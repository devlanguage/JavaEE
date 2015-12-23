package com.foshanshop.ejb3.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "Person")
public class Person  implements Serializable{

    private Integer personid;
    private String name;    
    private boolean sex;
    private Short age;
    private Date birthday;
    private Set<Order> orders = new HashSet<Order>();
    
    public Person(){}
    public Person(String name, boolean sex, Short age, Date birthday) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
    }
    
    @Id
    @GeneratedValue   
    public Integer getPersonid() {
        return personid;
    }
    public void setPersonid(Integer personid) {
        this.personid = personid;
    } 
    
    @Column(name = "PersonName",nullable=false,length=32)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(nullable=false)
    public boolean getSex() {
        return sex;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }
    
    @Column(nullable=false)   
    public Short getAge() {
        return age;
    }
    public void setAge(Short age) {
        this.age = age;
    } 
    
    @Temporal(value=TemporalType.DATE)
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    @OneToMany(mappedBy="ower",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "orderid ASC")
    public Set<Order> getOrders() {
        return orders;
    }
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
