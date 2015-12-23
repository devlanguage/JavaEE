package com.foshanshop.ejb3.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

//import com.foshanshop.ejb3.bean.listener.EntityListenerLogger;

@Entity
@Table(name = "EntityLifecycle")
//@EntityListeners({EntityListenerLogger.class})
public class EntityLifecycle implements Serializable{
    private static final long serialVersionUID = 2619167645480125649L;
    private Integer id;
    private String name; 
  
    public EntityLifecycle() {}
    
    public EntityLifecycle(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable=false,length=32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
    
    @PostLoad
    public void postLoad() {
        System.out.println("������ʵ��Bean{" + this.getClass().getName( ) + "}");
    }
    
    @PrePersist
    public void PreInsert() {
        System.out.println("��ʵ��Bean{" + this.getClass().getName( )+ "}������EntityManager.persist()��������");
    }
    
    @PostPersist
    public void postInsert() {
        System.out.println("��JDBC API���ʵ��Bean{" + this.getClass().getName( )+ "}ִ���˲������,������δ�ύ");
    }

    @PreUpdate
    public void PreUpdate() {
        System.out.println("��ʵ��Bean{" + this.getClass().getName( )+ "}������EntityManager.merge()��������");
    }
    
    @PostUpdate
    public void PostUpdate() {
        System.out.println("��JDBC API���ʵ��Bean{" + this.getClass().getName( )+ "}ִ���˸��²���,������δ�ύ");
    }

    @PreRemove
    public void PreRemove() {
        System.out.println("��ʵ��Bean{" + this.getClass().getName( )+ "}������EntityManager.remove()����ɾ��");
    }
    
    @PostRemove
    public void PostRemove() {
        System.out.println("ʵ��Bean{" + this.getClass().getName( )+ "}�Ѿ������ݿ���ɾ��");
    }
}
