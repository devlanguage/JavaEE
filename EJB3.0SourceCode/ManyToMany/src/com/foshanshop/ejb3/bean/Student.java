package com.foshanshop.ejb3.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "Student")
public class Student implements Serializable{
    private Integer studentid;
    private String StudentName;    
    private Set<Teacher> teachers = new HashSet<Teacher>();
  
    public Student() {}
    
    public Student(String studentName) {
        StudentName = studentName;
    }
    
    @Id
    @GeneratedValue
    public Integer getStudentid() {
        return studentid;
    }
    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }
    
    @Column(nullable=false, length=32)
    public String getStudentName() {
        return StudentName;
    }
    public void setStudentName(String studentName) {
        StudentName = studentName;
    }
    
    @ManyToMany(mappedBy = "students") 
    public Set<Teacher> getTeachers() {
        return teachers;
    }
    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
