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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@SuppressWarnings("serial")
@Entity
@Table(name = "Orders")
public class Order implements Serializable {
    private Integer orderid;
    private Float amount;
    private Set<OrderItem> orderItems = new HashSet<OrderItem>();
    private Date createdate;
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
    
    @OneToMany(mappedBy="order",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "id ASC")
    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    
    @Temporal(value=TemporalType.TIMESTAMP)
    public Date getCreatedate() {
        return createdate;
    }
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
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
}
