package com.foshanshop.ejb3;

import java.util.List;

import com.foshanshop.ejb3.bean.Order;

public interface OrderDAO {
    
    public void insertOrder();
    public Order getOrderByID(Integer orderid);
    public List getAllOrder();
    
}
