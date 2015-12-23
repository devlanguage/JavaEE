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
        //���Vehicle
        Vehicle vehicle = new Vehicle();
            vehicle.setId((long)1);
            vehicle.setSpeed((short)100);
        em.persist(vehicle);
        //���Car
        Car car = new Car();
            car.setId((long)2);
            car.setSpeed((short)300);
            car.setEngine("A������");
        em.persist(car);
        //���Camion
        Camion camion = new Camion();
            camion.setId((long)3);
            camion.setSpeed((short)200);
            camion.setEngine("B������");
            camion.setContainer("2�ּ�װ��");
        em.persist(camion);
    }
    
    public Vehicle getLastVehicle() { 
        //��ѯ����Vehicleʱ����Ϊ������̳����еĸ�����ѯ�����õ����м̳���Vehicle��ļ�¼
        //ת��ɵ�SQLƬ�ϣ�select * from Vehicle_Hierarchy      
        Query query = em.createQuery("from Vehicle v");
        List result = query.getResultList();
        if (result!=null && result.size()>0)
            return (Vehicle)result.get(result.size()-1);
        return null;
    }    
    
    public Car getLastCar() { 
        //��ѯ����Carʱ�����˵õ�Car��ļ�¼��Ҳ��õ����м̳���Car��ļ�¼
        //�����SQL Where���֣�where Discriminator in ('Car', 'Camion')
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
        //ִ�иò�����ɾ�������Ӧ��¼������ɾ�����м̳�Vehicle�ļ�¼��
        //��Ϊ������̳����еĸ������൱����������������
        Query query = em.createQuery("delete from Vehicle v");
        query.executeUpdate();
    }  
}
