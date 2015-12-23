//$Id: CascadeTest.java,v 1.1 2015/06/30 06:43:07 ygong Exp $
package org.ejbtest.jpa.cascade;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.ejbtest.jpa.TestCase;


/**
 * @author Max Rydahl Andersen
 */
public class CascadeTest extends TestCase {

	public void testCascade() throws Exception {
		
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Teacher teacher = null;
		
		teacher = new Teacher();

		Student student = new Student();

		teacher.setFavoriteStudent(student);
		student.setFavoriteTeacher(teacher);

		teacher.getStudents().add(student);
		student.setPrimaryTeacher(teacher);

		em.persist( teacher );
		em.getTransaction().commit();
	
		System.out.println("***************************");
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Teacher foundTeacher = (Teacher) em.createQuery( "select t from Teacher as t" ).getSingleResult();
		
		System.out.println(foundTeacher);
		System.out.println(foundTeacher.getFavoriteStudent());
		
		for (Student fstudent : foundTeacher.getStudents()) {
			System.out.println(fstudent);			
			System.out.println(fstudent.getFavoriteTeacher());
			System.out.println(fstudent.getPrimaryTeacher());
		}
		
		em.getTransaction().commit(); // here *alot* of flushes occur on an object graph that has *Zero* changes.
		em.close();
		
		
	}

	public void testNoCascadeAndMerge() throws Exception {
		Song e1 = new Song();
		Author e2 = new Author();

		e1.setAuthor(e2);

		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(e2);
		em.persist(e1);
		tx.commit();
		em.close();

		em = factory.createEntityManager();

		e1 = em.find(Song.class, e1.getId());
		e2 = null;


		tx = em.getTransaction();
		tx.begin();
		em.merge(e1);
		//em.refresh(e1);
		tx.commit();
		em.close();

	}


	public Class[] getAnnotatedClasses() {
		return new Class[]{
				Teacher.class,
				Student.class,
				Song.class,
				Author.class
		};
	}
	
	
}
