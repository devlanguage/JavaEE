package org.ejbtest.account.persistence.onetomany;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity(name = "OrderItem")
@Table(name = "ejb_Relation_OTM_OrderItem")
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="Order_Item_ID")
    private Integer id;
    private String productname;
    private Float price;
    
    @ManyToOne(cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderItem() {

    }

    public OrderItem(String productname, Float price) {

        this.productname = productname;
        this.price = price;
    }

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

    public Order getOrder() {

        return order;
    }

    public void setOrder(Order order) {

        this.order = order;
    }

}
