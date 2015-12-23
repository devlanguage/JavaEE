/**
 * The file org.cxftest.helloworld.vo.UserVo.java was created by yongjie.gong on 2009-1-12
 */
package org.cxftest.user.vo;

/**
 * @author feiye
 */
public class UserVo {

    private String name;
    private int age;

    public UserVo() {

        this("Test");
    }

    public UserVo(String name) {

        this(name, 20);
    }

    public UserVo(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String toString() {

        return "UserVO: [name=" + this.name + ", age=" + this.age + "]".toString();
    }

    public static void main(String[] args) {

    }
}
