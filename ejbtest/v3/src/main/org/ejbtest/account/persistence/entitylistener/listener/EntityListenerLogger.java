/**
 * The file org.ejbtest.account.persistence.entitylistener.EntityListenerLogger.java was created by yongjie.gong on 2008-7-3
 */
package org.ejbtest.account.persistence.entitylistener.listener;

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
        System.out.println("载入了实体Bean{" + entity.getClass().getName() + "}");
    }

    @PrePersist
    public void PreInsert(Object entity) {

        System.out.println("对实体Bean{" + entity.getClass().getName() + "}调用了EntityManager.persist()或级联保存");
    }

    @PostPersist
    public void postInsert(Object entity) {

        System.out.println("在JDBC API层对实体Bean{" + entity.getClass().getName() + "}执行了插入操作,但事务还未提交");
    }

    @PreUpdate
    public void PreUpdate(Object entity) {

        System.out.println("对实体Bean{" + entity.getClass().getName() + "}调用了EntityManager.merge()或级联更新");
    }

    @PostUpdate
    public void PostUpdate(Object entity) {

        System.out.println("在JDBC API层对实体Bean{" + entity.getClass().getName() + "}执行了更新操作,但事务还未提交");
    }

    @PreRemove
    public void PreRemove(Object entity) {

        System.out.println("对实体Bean{" + entity.getClass().getName() + "}调用了EntityManager.remove()或级联删除");
    }

    @PostRemove
    public void PostRemove(Object entity) {

        System.out.println("实体Bean{" + entity.getClass().getName() + "}已经从数据库中删除");
    }
}
