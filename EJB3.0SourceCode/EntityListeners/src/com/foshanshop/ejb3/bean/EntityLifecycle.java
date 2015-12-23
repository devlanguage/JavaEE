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
        System.out.println("载入了实体Bean{" + this.getClass().getName( ) + "}");
    }
    
    @PrePersist
    public void PreInsert() {
        System.out.println("对实体Bean{" + this.getClass().getName( )+ "}调用了EntityManager.persist()或级联保存");
    }
    
    @PostPersist
    public void postInsert() {
        System.out.println("在JDBC API层对实体Bean{" + this.getClass().getName( )+ "}执行了插入操作,但事务还未提交");
    }

    @PreUpdate
    public void PreUpdate() {
        System.out.println("对实体Bean{" + this.getClass().getName( )+ "}调用了EntityManager.merge()或级联更新");
    }
    
    @PostUpdate
    public void PostUpdate() {
        System.out.println("在JDBC API层对实体Bean{" + this.getClass().getName( )+ "}执行了更新操作,但事务还未提交");
    }

    @PreRemove
    public void PreRemove() {
        System.out.println("对实体Bean{" + this.getClass().getName( )+ "}调用了EntityManager.remove()或级联删除");
    }
    
    @PostRemove
    public void PostRemove() {
        System.out.println("实体Bean{" + this.getClass().getName( )+ "}已经从数据库中删除");
    }
}
