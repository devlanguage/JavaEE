package com.foshanshop.ejb3.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "OrderItems")
public class OrderItem implements Serializable {

    private Integer id;
    private String productname;
    private Float price;
    private Order order;
    
    public OrderItem() {
    }
 
    public OrderItem(String productname, Float price) {
        this.productname = productname;
        this.price = price;
    }

    @Id
    @GeneratedValue 
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    } 
    
    public String getProductname() {
        return productname;
    }
    public void setProductname(String productname) {
        this.productname = productname;
    }
    
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    
    @ManyToOne(cascade=CascadeType.REFRESH,optional=false)
    @JoinColumn(name = "order_id")  
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {        
        this.order = order;
    }
    
}
