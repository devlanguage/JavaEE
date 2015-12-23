/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.ejbtest.jpa.manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * A very simple, stand-alone program that stores a new entity in the database and then performs a
 * query to retrieve it.
 */
public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // Create a new EntityManagerFactory using the System properties.
        // The "relations" name will be used to configure based on the
        // corresponding name in the META-INF/persistence.xml file
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate.jpa", System
                .getProperties());

        // Create a new EntityManager from the EntityManagerFactory. The
        // EntityManager is the main object in the persistence API, and is
        // used to create, delete, and query objects, as well as access
        // the current transaction
        EntityManager em = factory.createEntityManager();

        // deleteStudent(em);
        createStudent(em);
        listStudent(em);

        // It is always good to clean up after ourselves
        em.close();
        factory.close();
    }
    @SuppressWarnings({"cast","boxing"})
    public final static void listStudent(EntityManager em) {

        // Query textParamQuery = em
        // .createQuery("SELECT Object(hm) from org.jpa.hello.Student hm where hm.id>:id or
        // hm.name=:name");
        // textParamQuery.setParameter("id", 2L);
        // textParamQuery.setParameter("name", "test1");
        //
        // Query positionParamQuery = em
        // .createQuery("SELECT distinct Object(hm) from org.jpa.hello.Student hm where (hm.id>?1 or
        // hm.id=?1) and hm.name=?2");
        // positionParamQuery.setParameter(1, 15L);
        // positionParamQuery.setParameter(2, "test1");
        //
        // Query namedQueryListStudents = em.createNamedQuery("listStudents");
        // List studentList = namedQueryListStudents.getResultList();
        // for (Object attrList : studentList) {
        // Object[] attrArray = (Object[]) attrList;
        // for (Object attr : attrArray) {
        // System.out.println(attr);
        // }
        // }
        //
        // List<Student> messageList = positionParamQuery.getResultList();
        // for (Student hm : messageList) {
        // hm.setVersion("23");
        // System.out.println(hm);
        // }


        Student o = (Student) em.find(Student.class, 1L);
        System.out.println(o);
        System.err.println(o.getTeachers());

    }

    public final static void createStudent(EntityManager em) {

        javax.persistence.EntityTransaction tran = em.getTransaction();
        tran.begin();
        Student stu = new Student("test1");

        Teacher teacher = new Teacher("Chinese");
        stu.addTeacher(teacher);
        em.persist(stu);
        em.persist(teacher);

        tran.commit();
    }

    /**
     * Creates a partial family tree of the Greek dieties.
     * 
     * @param em
     *            the EntityManager to use in the persistence process
     */
    public static void deleteStudent(EntityManager em) {

        // First delete all the members from the database the clean up
        em.getTransaction().begin();
        em.createQuery("delete from Student").executeUpdate();
        em.getTransaction().commit();
    }

}
