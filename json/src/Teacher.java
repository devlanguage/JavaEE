import java.util.ArrayList;
import java.util.List;

import com.jsonext.stu.entity.Student;

public class Teacher {

    private String name;
    private List<Student> students = new ArrayList<Student>();
    /**
     * @return get method for the field name
     */
    public String getName() {

        return this.name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * @return get method for the field students
     */
    public List<Student> getStudents() {

        return this.students;
    }

    /**
     * @param students
     *            the students to set
     */
    public void setStudents(List<Student> students) {

        this.students = students;
    }

}
