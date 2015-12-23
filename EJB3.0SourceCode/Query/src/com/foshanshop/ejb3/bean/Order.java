package com.foshanshop.ejb3.bean;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@SuppressWarnings("serial")
@Entity
@Table(name = "Orders")
public class Order implements Serializable {
    private int hashCode = Integer.MIN_VALUE;
    private Integer orderid;
    private Float amount;
    private Person ower;
    private Set<OrderItem> orderItems = new HashSet<OrderItem>();
    private Date createdate;
    
    public Order(){}
    public Order(Float amount, Person ower, Date createdate) {
        this.amount = amount;
        this.ower = ower;
        this.createdate = createdate;
    }
    
    @Id
    @GeneratedValue  
    public Integer getOrderid() {
        return orderid;
    }
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }
    
    public Float getAmount() {
        return amount;
    }    
    public void setAmount(Float amount) {
        this.amount = amount;
    }
 
    @ManyToOne(cascade=CascadeType.ALL,optional=false)
    @JoinColumn(name = "person_id")    
    public Person getOwer() {
        return ower;
    }
    public void setOwer(Person ower) {
        this.ower = ower;
    }

    @OneToMany(mappedBy="order",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "id ASC")
    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
       
    public void addOrderItem(OrderItem orderitem) {
       if (!this.orderItems.contains(orderitem)) {
            this.orderItems.add(orderitem);
            orderitem.setOrder(this);
       }
    }

    public void removeOrderItem(OrderItem orderitem) {
        orderitem.setOrder(null);
        this.orderItems.remove(orderitem);
    } 
    
    @Temporal(value=TemporalType.TIMESTAMP)
    public Date getCreatedate() {
        return createdate;
    }
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }  
    
    public boolean equals (Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof Order)) return false;
        else {
            Order mObj = (Order) obj;
            if (null == this.getOrderid() || null == mObj.getOrderid()) return false;
            else return (this.getOrderid().equals(mObj.getOrderid()));
        }
    }


    public int hashCode () {
        if (Integer.MIN_VALUE == this.hashCode) {
            if (null == this.getOrderid()) return super.hashCode();
            else {
                String hashStr = this.getClass().getName() + ":" + this.getOrderid().hashCode();
                this.hashCode = hashStr.hashCode();
            }
        }
        return this.hashCode;
    }
}
