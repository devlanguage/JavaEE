package org.ejbtest.account.persistence.onetomany;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity(name = "Order")
@Table(name = "ejb_Relation_OTM_Order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "order_id", nullable = false)
    private Integer orderid;
    @Column(name = "amount")
    private Float amount;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "id ASC")
    private Set<OrderItem> orderItems = new HashSet<OrderItem>();

    @Column(name = "create_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdate;

    /**
     * <pre>
     * JPA，在@OneToMany里加入mappedBy属性避免生成中间表 使用JPA的时候，如果A, B两个实体间是一对多, 多对一的关系,
     * 如果不在@OneToMany里加入mappedBy属性会导致自动生成一个多余的中间表. 比如：
     * 
     * @Entity public class A {
     * @OneToMany(mappedBy="a") public Set<B> bs = new HashSet<B>(0); }
     * 
     * @Entity public class B {
     * @ManyToOne public A a; }
     * 
     * 这样写会只成生成表A和表B，B中会有一个到表A的外键。但是如果不加mappedBy=”a”， 那么就会再生成一张A_B表 。
     * </pre>
     */
    public Set<OrderItem> getOrderItems() {

        return orderItems;
    }

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

    public void setOrderItems(Set<OrderItem> orderItems) {

        this.orderItems = orderItems;
    }

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
