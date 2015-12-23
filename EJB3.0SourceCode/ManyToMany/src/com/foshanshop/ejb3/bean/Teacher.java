package com.foshanshop.ejb3.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Teacher")
public class Teacher implements Serializable{
    private Integer teacherid;
    private String TeacherName;    
    private Set<Student> students = new HashSet<Student>();
  
    public Teacher() {}
    
    public Teacher(String teacherName) {
        TeacherName = teacherName;
    }
    
    @Id
    @GeneratedValue
    public Integer getTeacherid() {
        return teacherid;
    }
    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    } 
    
    @Column(nullable=false, length=32)
    public String getTeacherName() {
        return TeacherName;
    }
    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }
    
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY) 
    @JoinTable(name = "Teacher_Student",
        joinColumns = {@JoinColumn(name = "Teacher_ID", referencedColumnName = "teacherid")},
        inverseJoinColumns = {@JoinColumn(name = "Student_ID", referencedColumnName = "studentid")})
    public Set<Student> getStudents() {
        return students;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    
    public void addStudent(Student student) {
        if (!this.students.contains(student)) {
             this.students.add(student);
        }
    }

     public void removeStudent(Student student) {
         this.students.remove(student);
    } 
}
