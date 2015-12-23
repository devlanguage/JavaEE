package org.ejbtest.jpa.manytomany;

import java.util.Set;

public class Teacher {

    private long id;
    private String professional;
    private Set<Student> students;

    public Teacher() {

    }

    public Teacher(String professional) {

        this.professional = professional;
    }

    /**
     * @return get method for the field id
     */
    public long getId() {

        return this.id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(long id) {

        this.id = id;
    }

    /**
     * @return get method for the field professional
     */
    public String getProfessional() {

        return this.professional;
    }

    /**
     * @param professional
     *            the professional to set
     */
    public void setProfessional(String professional) {

        this.professional = professional;
    }

    /**
     * @return get method for the field students
     */
    public Set<Student> getStudents() {

        return this.students;
    }

    /**
     * @param students
     *            the students to set
     */
    public void setStudents(Set<Student> students) {

        this.students = students;
    }

    @Override
    public String toString() {

        return Teacher.class.getSimpleName() + ": id=" + this.id + ", professional="
                + this.professional;
    }
}
