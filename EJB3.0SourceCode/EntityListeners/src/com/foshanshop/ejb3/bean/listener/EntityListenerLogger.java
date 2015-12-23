package com.foshanshop.ejb3.bean.listener;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class EntityListenerLogger {
 
    @PostLoad
    public void postLoad(Object entity) {
        System.out.println("������ʵ��Bean{" + entity.getClass().getName( ) + "}");
    }
    
    @PrePersist
    public void PreInsert(Object entity) {
        System.out.println("��ʵ��Bean{" + entity.getClass().getName( )+ "}������EntityManager.persist()��������");
    }
    
    @PostPersist
    public void postInsert(Object entity) {
        System.out.println("��JDBC API���ʵ��Bean{" + entity.getClass().getName( )+ "}ִ���˲������,������δ�ύ");
    }

    @PreUpdate
    public void PreUpdate(Object entity) {
        System.out.println("��ʵ��Bean{" + entity.getClass().getName( )+ "}������EntityManager.merge()��������");
    }
    
    @PostUpdate
    public void PostUpdate(Object entity) {
        System.out.println("��JDBC API���ʵ��Bean{" + entity.getClass().getName( )+ "}ִ���˸��²���,������δ�ύ");
    }

    @PreRemove
    public void PreRemove(Object entity) {
        System.out.println("��ʵ��Bean{" + entity.getClass().getName( )+ "}������EntityManager.remove()����ɾ��");
    }
    
    @PostRemove
    public void PostRemove(Object entity) {
        System.out.println("ʵ��Bean{" + entity.getClass().getName( )+ "}�Ѿ������ݿ���ɾ��");
    }
}
