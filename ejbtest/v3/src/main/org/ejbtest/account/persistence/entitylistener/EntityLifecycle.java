package org.ejbtest.account.persistence.entitylistener;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.ejbtest.account.persistence.entitylistener.listener.EntityListenerLogger;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity(name = "EntityLifecycle")
@Table(name = "ejb_Entity_Lifecycle")
@EntityListeners({EntityListenerLogger.class, EntityLifecycle.class})
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries( { @NamedQuery(name = "listEntityLifecycles", query = "select object(ef) from EntityLifecycle ef") })
//@NamedNativeQueries( { @NamedNativeQuery(name = "listEntityLifecycles", query = "select * from EntityLifecycle") })
public class EntityLifecycle implements Serializable {

    private static final long serialVersionUID = 2619167645480125649L;
    private Integer id;
    private String name;

    public EntityLifecycle() {

    }

    public EntityLifecycle(String name) {

        this.name = name;
    }

    @Id
//    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE)
//    @Column()
    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    @Column(nullable = false, length = 32)
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
