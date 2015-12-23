package org.ejbtest.jpa.onetomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // Create a new EntityManagerFactory using the System properties.
        // The "relations" name will be used to configure based on the
        // corresponding name in the META-INF/persistence.xml file
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate.jpa",
                System.getProperties());

        // Create a new EntityManager from the EntityManagerFactory. The
        // EntityManager is the main object in the persistence API, and is
        // used to create, delete, and query objects, as well as access
        // the current transaction
        EntityManager em = factory.createEntityManager();

        // deleteTopic(em);
        createTopic(em);
        // listTopic(em);

        // It is always good to clean up after ourselves
        em.close();
        factory.close();

    }

    private static void createTopic(EntityManager em) {

        em.getTransaction().begin();
        
        PollTopic pollTopic = new PollTopic();
        PollOption option1 = new PollOption();
        pollTopic.addPollOption(option1);
        PollOption option2 = new PollOption();
        pollTopic.addPollOption(option2);
        
        em.persist(pollTopic);
        em.getTransaction().commit();
    }

    private static void listTopic(EntityManager em) {

    }

}
