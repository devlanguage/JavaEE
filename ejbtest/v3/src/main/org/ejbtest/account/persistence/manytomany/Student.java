package org.ejbtest.account.persistence.manytomany;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ejb_relation_mtm_Student")
@NamedNativeQuery(name = "findStudents", query = "SELECT stu.stu_id as studentid, stu.stu_name as studentName, thr.teachername as teacherName"
        + " FROM ejb_relation_mtm_Student stu, ejb_relation_mtm_teacher thr, ejb_relation_mtm_Teach_Stu ts"
        + " WHERE stu.stu_id=ts.student_Id and thr.thr_id = ts.teacher_id", resultSetMapping = "Student_Mapping")
@SqlResultSetMapping(name = "Student_Mapping", entities = { @EntityResult(entityClass = Student.class) }, columns = { @ColumnResult(name = "CC_NUM") })
public class Student implements Serializable {
    @Id
    @SequenceGenerator(name = "stu_Id_sequence", sequenceName = "EJB_SEQ_Student_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stu_Id_sequence")
    @Column(name = "stu_id", nullable = false)
    private Integer studentid;
    @Column(name = "stu_name", nullable = false, length = 32)
    private String StudentName;
    
    @ManyToMany(mappedBy = "students")    
    private Set<Teacher> teachers = new HashSet<Teacher>();

    public Student() {

    }

    public Student(String studentName) {

        StudentName = studentName;
    }

    public Integer getStudentid() {

        return studentid;
    }

    public void setStudentid(Integer studentid) {

        this.studentid = studentid;
    }

    public String getStudentName() {

        return StudentName;
    }

    public void setStudentName(String studentName) {

        StudentName = studentName;
    }

    public Set<Teacher> getTeachers() {

        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {

        this.teachers = teachers;
    }
}
