package com.foshanshop.ejb3.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foshanshop.ejb3.EntityLifecycleDAO;
import com.foshanshop.ejb3.bean.EntityLifecycle;

@Stateless
@Remote ({EntityLifecycleDAO.class})
public class EntityLifecycleDAOBean implements EntityLifecycleDAO {
    @PersistenceContext
    protected EntityManager em;
    
    public EntityLifecycle Load() {
        return em.find(EntityLifecycle.class, 1);//此处将会触发@PostLoad事件      
    }

    public void Persist() {
        EntityLifecycle entitylifecycle = new EntityLifecycle("孙丽");
        em.persist(entitylifecycle);//此处将会触发@PrePersist事件
        //下面让线程等待5秒，在五秒时间内你可以查看数据是否已经插入进数据库
        try {
            System.out.println("***当前线程睡眠5秒，在五秒时间内你可以查看数据是否已经插入进数据库***");
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void Remove() {
        Query query = em.createQuery("from EntityLifecycle e");
        List result = query.getResultList();
        if (result!=null && result.size()>1){
            EntityLifecycle entitylifecycle = (EntityLifecycle)result.get(result.size()-1);
            em.remove(entitylifecycle);//此处将会触发@PreRemove事件
            //下面让线程等待5秒，在五秒时间内你可以查看数据是否已经删除
            try {
                System.out.println("***当前线程睡眠5秒，在五秒时间内你可以查看数据是否已经删除***");
                Thread.sleep(5*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void Update() {
        Query query = em.createQuery("from EntityLifecycle e");
        List result = query.getResultList();
        if (result!=null && result.size()>0){
            EntityLifecycle entitylifecycle = (EntityLifecycle)result.get(result.size()-1);
            entitylifecycle.setName("张权");
            em.merge(entitylifecycle); //此处将会触发@PreUpdate事件
            //下面让线程等待5秒，在五秒时间内你可以查看数据是否已经更新
            try {
                System.out.println("***当前线程睡眠5秒，在五秒时间内你可以查看数据是否已经更新***");
                Thread.sleep(5*1000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }
       
    }

}
