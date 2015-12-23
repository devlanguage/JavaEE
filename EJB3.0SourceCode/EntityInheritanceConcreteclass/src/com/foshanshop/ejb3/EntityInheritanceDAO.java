package com.foshanshop.ejb3;

import com.foshanshop.ejb3.bean.Camion;
import com.foshanshop.ejb3.bean.Car;
import com.foshanshop.ejb3.bean.Vehicle;

public interface EntityInheritanceDAO {
    public void initializeData();    
    public Vehicle getLastVehicle(); 
    public Car getLastCar();    
    public Camion getLastCamion();
    public void deleteVehicle();
}
