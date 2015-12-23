package org.ejbtest.account.persistence.manytomany;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ejb_relation_mtm_teacher")
public class Teacher implements Serializable {
    @Id
    @SequenceGenerator(name = "Teacher_Id_Sequence", sequenceName = "EJB_SEQ_Teacher_ID")
    @GeneratedValue(generator = "Teacher_Id_Sequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "thr_id")
    private Integer teacherid;
    @Column(name = "thr_name", nullable = false, length = 32)
    private String TeacherName;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable( name = "ejb_relation_mtm_Teach_Stu", 
        joinColumns = { @JoinColumn(name = "Teacher_ID", referencedColumnName = "thr_id", table="ejb_relation_mtm_teacher") }, 
        inverseJoinColumns = { @JoinColumn(name = "Student_ID", referencedColumnName = "stu_id", table="ejb_relation_mtm_student") }
    )
    private Set<Student> students = new HashSet<Student>();

    public Teacher() {

    }

    public Teacher(String teacherName) {

        TeacherName = teacherName;
    }

    public Integer getTeacherid() {

        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {

        this.teacherid = teacherid;
    }

    public String getTeacherName() {

        return TeacherName;
    }

    public Set<Student> getStudents() {

        return students;
    }

    public void setTeacherName(String teacherName) {

        TeacherName = teacherName;
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
