/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file org.jpa.hello.Message.java is
 * created on 2008-7-10
 */
package org.ejbtest.jpa.manytomany;

import java.util.HashSet;
import java.util.Set;

public class Student {

    private static final long serialVersionUID = -7660981805652763488L;

    private Long id;
    private String name;
    private String version;

    private Set<Teacher> teachers;

    /**
     * @return get method for the field teachers
     */
    public Set<Teacher> getTeachers() {

        if (this.teachers == null) {
            this.teachers = new HashSet<Teacher>();
        }
        return this.teachers;
    }

    public void addTeacher(Teacher teacher) {

        this.getTeachers().add(teacher);
    }

    /**
     * @param teachers
     *            the teachers to set
     */
    public void setTeachers(Set<Teacher> teachers) {

        this.teachers = teachers;
    }

    public Student() {

    }

    public Student(String text) {

        this.name = text;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String text) {

        this.name = text;
    }

    /**
     * @return get method for the field version
     */
    public String getVersion() {

        return this.version;
    }

    /**
     * @param version
     *            the version to set
     */
    public void setVersion(String version) {

        this.version = version;
    }

    @Override
    public String toString() {

        return Student.class.getSimpleName() + ": id=" + this.id + ", text=" + this.name
                + ", version=" + this.version;
    }

}
