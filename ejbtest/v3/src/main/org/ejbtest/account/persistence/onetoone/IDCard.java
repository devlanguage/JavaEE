package org.ejbtest.account.persistence.onetoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity(name = "IDCard")
@Table(name = "ejb_relation_oto_IDCard")
public class IDCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(nullable = false, length = 18, unique = true)
    private String cardNo;

    @OneToOne(optional = false, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "card_person_id", referencedColumnName = "person_id", unique = false)
    private Person person;

    public IDCard() {

    }

    public IDCard(String cardno) {

        this.cardNo = cardno;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getCardNo() {

        return cardNo;
    }

    public void setCardNo(String cardno) {

        this.cardNo = cardno;
    }

    public Person getPerson() {

        return person;
    }

    public void setPerson(Person person) {

        this.person = person;
    }

}
