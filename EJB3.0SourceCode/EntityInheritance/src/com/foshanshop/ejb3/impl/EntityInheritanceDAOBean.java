package com.foshanshop.ejb3.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foshanshop.ejb3.EntityInheritanceDAO;
import com.foshanshop.ejb3.bean.Car;
import com.foshanshop.ejb3.bean.Vehicle;
import com.foshanshop.ejb3.bean.Camion;

@Stateless
@Remote ({EntityInheritanceDAO.class})
public class EntityInheritanceDAOBean implements EntityInheritanceDAO {
    @PersistenceContext
    protected EntityManager em;
  
    public void initializeData(){
        //添加Vehicle
        Vehicle vehicle = new Vehicle();
            vehicle.setSpeed((short)100);
        em.persist(vehicle);
        //添加Car
        Car car = new Car();
            car.setSpeed((short)300);
            car.setEngine("A发动机");
        em.persist(car);
        //添加Camion
        Camion camion = new Camion();
            camion.setSpeed((short)200);
            camion.setEngine("B发动机");
            camion.setContainer("2吨集装箱");
        em.persist(camion);
    }
    
    public Vehicle getLastVehicle() { 
        //查询所有Vehicle时，因为他是最继承树中的根，查询结果会得到所有继承于Vehicle类的记录
        //转绎成的SQL片断：select * from Vehicle_Hierarchy      
        Query query = em.createQuery("from Vehicle v");
        List result = query.getResultList();
        if (result!=null && result.size()>0)
            return (Vehicle)result.get(result.size()-1);
        return null;
    }    
    
    public Car getLastCar() { 
        //查询所有Car时，除了得到Car类的记录，也会得到所有继承于Car类的记录
        //构造的SQL Where部分：where Discriminator in ('Car', 'Camion')
        Query query = em.createQuery("from Car c");
        List result = query.getResultList();
        if (result!=null && result.size()>0)
            return (Car)result.get(result.size()-1);
        return null;
    }  
    
    public Camion getLastCamion() {        
        Query query = em.createQuery("from Camion c");
        List result = query.getResultList();
        if (result!=null && result.size()>0)
            return (Camion)result.get(result.size()-1);
        return null;
    }  
    
    public void deleteVehicle() {  
        //执行该操作会删除自身对应记录，还会删除所有继承Vehicle的记录，
        //因为他是最继承树中的根，就相当于清除整个表的数据
        Query query = em.createQuery("delete from Vehicle v");
        query.executeUpdate();
    }  
}
