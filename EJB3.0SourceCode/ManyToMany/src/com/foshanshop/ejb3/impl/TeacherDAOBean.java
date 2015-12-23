package com.foshanshop.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.foshanshop.ejb3.TeacherDAO;
import com.foshanshop.ejb3.bean.Student;
import com.foshanshop.ejb3.bean.Teacher;

@Stateless
@Remote ({TeacherDAO.class})
public class TeacherDAOBean implements TeacherDAO {
    @PersistenceContext
    protected EntityManager em;
    
    public void insertTeacher(String name, String[] studentnames) {
        Teacher teacher = new Teacher(name);
        if (studentnames!=null){
            for(int i=0;i<studentnames.length; i++){
                teacher.addStudent(new Student(studentnames[i]));
            }
        }
        em.persist(teacher);
    }

    public Teacher getTeacherByID(Integer teacherid) {
        Teacher teacher= em.find(Teacher.class, teacherid);
        if (teacher!=null) teacher.getStudents().size();
        return teacher;
    }

    public Student getStudentByID(Integer studentid) {
        Student student= em.find(Student.class, studentid);
        if (student!=null) student.getTeachers().size();
        return student;
    }
}
