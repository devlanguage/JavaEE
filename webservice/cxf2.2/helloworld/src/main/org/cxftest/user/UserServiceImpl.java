package org.cxftest.user;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.jws.WebService;

import org.cxftest.user.vo.UserVo;

@WebService(endpointInterface = "org.cxftest.user.UserService", serviceName = "UserService"
//  name, targetNamespace, serviceName, wsdlLocation, endpointInterface,portName
)
//  @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE, style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public class UserServiceImpl implements UserService {

    Map<Integer, UserVo> users = new LinkedHashMap<Integer, UserVo>();

    public String sayStudent(String text) {
        return "Student: " + text;
    }

    public String sayTeacher(String text) {
        return "Teacher: " + text;
    }

    public String sayCounselor(String text) {
        return "Counselor: " + text;
    }

    public String sayMentor(String text) {
        return "Mentor: " + text;
    }

    public String sayHiToUser(UserVo user) {

        System.out.println("sayHiToUser called");
        users.put(users.size() + 1, user);
        return "Hello " + user.getName();
    }

    public UserVo getUser(Integer id) {

        return users.get(id);
    }

    public Map<Integer, UserVo> getUsers() {

        return users;
    }

    public Collection<UserVo> listUsers() {

        return users.values();
    }

}