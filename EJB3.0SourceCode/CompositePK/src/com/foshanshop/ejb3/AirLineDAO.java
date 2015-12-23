package com.foshanshop.ejb3;

import com.foshanshop.ejb3.bean.AirLine;

public interface AirLineDAO {    
    public void insertAirLine();
    public AirLine getAirLineByID(String leavecity, String arrivecity);
}
