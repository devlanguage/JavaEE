package com.foshanshop.ejb3;

import com.foshanshop.ejb3.bean.Student;
import com.foshanshop.ejb3.bean.Teacher;

public interface TeacherDAO {
    public void insertTeacher(String name, String[] studentnames);
    public Teacher getTeacherByID(Integer teacherid);
    public Student getStudentByID(Integer studentid);
}
