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
    private String flightno;//航班号
    private String leavetime;//起飞时间
    private String arrivetime;//到达时间
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
        })  //TopLink产品中, referencedColumnName 属性值大小写敏感
    public AirLine getAirline() {
        return airline;
    }

    public void setAirline(AirLine airline) {
        this.airline = airline;
    }
    
}
