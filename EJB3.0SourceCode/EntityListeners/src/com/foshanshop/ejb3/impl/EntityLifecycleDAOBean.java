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
        return em.find(EntityLifecycle.class, 1);//�˴����ᴥ��@PostLoad�¼�      
    }

    public void Persist() {
        EntityLifecycle entitylifecycle = new EntityLifecycle("����");
        em.persist(entitylifecycle);//�˴����ᴥ��@PrePersist�¼�
        //�������̵߳ȴ�5�룬������ʱ��������Բ鿴�����Ƿ��Ѿ���������ݿ�
        try {
            System.out.println("***��ǰ�߳�˯��5�룬������ʱ��������Բ鿴�����Ƿ��Ѿ���������ݿ�***");
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
            em.remove(entitylifecycle);//�˴����ᴥ��@PreRemove�¼�
            //�������̵߳ȴ�5�룬������ʱ��������Բ鿴�����Ƿ��Ѿ�ɾ��
            try {
                System.out.println("***��ǰ�߳�˯��5�룬������ʱ��������Բ鿴�����Ƿ��Ѿ�ɾ��***");
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
            entitylifecycle.setName("��Ȩ");
            em.merge(entitylifecycle); //�˴����ᴥ��@PreUpdate�¼�
            //�������̵߳ȴ�5�룬������ʱ��������Բ鿴�����Ƿ��Ѿ�����
            try {
                System.out.println("***��ǰ�߳�˯��5�룬������ʱ��������Բ鿴�����Ƿ��Ѿ�����***");
                Thread.sleep(5*1000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }
       
    }

}
