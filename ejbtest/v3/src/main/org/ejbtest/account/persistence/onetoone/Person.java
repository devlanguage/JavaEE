package org.ejbtest.account.persistence.onetoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity(name = "Person")
@Table(name = "ejb_relation_oto_Person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "person_id")
    private Integer personid;

    @Column(name = "person_name", nullable = false, length = 32)
    private String name;
    @Column(name = "enum_sex", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Sex sex;
    private Short age;

    @Temporal(value = TemporalType.DATE)
    private java.util.Date birthday;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", unique = true, nullable = false, updatable = false)
    private IDCard idcard;

    public Integer getPersonid() {

        return personid;
    }

    public void setPersonid(Integer personid) {

        this.personid = personid;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Sex getSex() {

        return sex;
    }

    public void setSex(Sex sex) {

        this.sex = sex;
    }

    @Column(nullable = false)
    public Short getAge() {

        return age;
    }

    public void setAge(Short age) {

        this.age = age;
    }

    public java.util.Date getBirthday() {

        return birthday;
    }

    public void setBirthday(java.util.Date birthday) {

        this.birthday = birthday;
    }

    public IDCard getIdcard() {

        return idcard;
    }

    public void setIdcard(IDCard idcard) {

        this.idcard = idcard;
    }

}
