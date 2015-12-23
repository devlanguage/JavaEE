package com.foshanshop.ejb3.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Flight")
public class Flight implements Serializable {
    private Integer id;  
    private String flightno;//�����
    private String leavetime;//���ʱ��
    private String arrivetime;//����ʱ��
    private AirLine airline;
    
    public Flight(){}
 
    public Flight(String flightno, String leavetime, String arrivetime) {
        this.flightno = flightno;
        this.leavetime = leavetime;
        this.arrivetime = arrivetime;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(nullable=false,length=10)
    public String getFlightno() {
        return flightno;
    }

    public void setFlightno(String flightno) {
        this.flightno = flightno;
    }
    
    @Column(length=10)
    public String getArrivetime() {
        return arrivetime;
    }

    public void setArrivetime(String arrivetime) {
        this.arrivetime = arrivetime;
    }
    
    @Column(length=10)
    public String getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(String leavetime) {
        this.leavetime = leavetime;
    }

    @ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumns ({
        @JoinColumn(name="Leave_City", referencedColumnName = "LEAVECITY", nullable=false),
        @JoinColumn(name="Arrive_City", referencedColumnName = "ARRIVECITY", nullable=false)
        })  //TopLink��Ʒ��, referencedColumnName ����ֵ��Сд����
    public AirLine getAirline() {
        return airline;
    }

    public void setAirline(AirLine airline) {
        this.airline = airline;
    }
    
}
