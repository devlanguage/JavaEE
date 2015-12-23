package com.foshanshop.ejb3.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {
    private int hashCode = Integer.MIN_VALUE;
    private Integer productid;
    private String name; 
    private Float price;
    
    public Product() {}  
    
    public Product(String name, Float price) {
        this.name = name;
        this.price = price;
    }
    
    @Id
    @GeneratedValue
    public Integer getProductid() {
        return productid;
    }
    public void setProductid(Integer productid) {
        this.productid = productid;
    }  
     
    @Column(name = "ProductName",nullable=false,length=50)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(nullable=false)
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    
    public boolean equals (Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof Product)) return false;
        else {
            Product mObj = (Product) obj;
            if (null == this.getProductid() || null == mObj.getProductid()) return false;
            else return (this.getProductid().equals(mObj.getProductid()));
        }
    }

    public int hashCode () {
        if (Integer.MIN_VALUE == this.hashCode) {
            if (null == this.getProductid()) return super.hashCode();
            else {
                String hashStr = this.getClass().getName() + ":" + this.getProductid().hashCode();
                this.hashCode = hashStr.hashCode();
            }
        }
        return this.hashCode;
    }
}
