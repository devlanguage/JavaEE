package org.cxftest.user;

import java.util.Collection;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.cxftest.user.vo.IntegerUserMapAdapter;
import org.cxftest.user.vo.UserVo;

@WebService
//endpointInterface, serviceName, portName is not allowed in the endpoint service
public interface UserService {

    /**
     * <Pre>
     * 
     * To make sure your parameter is named correctly in the xml you should use:
     * 
     * @WebService public interface HelloWorld { String
     *             sayHi(@WebParam(name="text") String text); }The
     * @WebParam annotation is necessary as java interfaces do not store the
     *           Parameter name in the .class file. So if you leave out the
     *           annotation your parameter will be named arg0.
     * 
     * </pre>
     * 
     * @param text
     * @return
     */
    @WebMethod
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE, style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
    @WebResult(partName = "studentPart")
    // http://localhost:8080/test/ws/HelloWorld/sayStudent?student=23
    String sayStudent(@WebParam(name = "student")
    String text);

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE, style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.ENCODED)
    String sayTeacher(@WebParam(name = "teacher")
    String text);

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED, style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL)
    String sayCounselor(@WebParam(name = "counselor")
    String text);

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED, style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.ENCODED)
    String sayMentor(@WebParam(name = "mentor")
    String text);

    /*
     * Advanced usecase of passing an Interface in. JAX-WS/JAXB does not support
     * interfaces directly. Special XmlAdapter classes need to be written to
     * handle them
     */
    String sayHiToUser(UserVo user);

    public UserVo getUser(Integer id);

    public Collection<UserVo> listUsers();

    /*
     * Map passing JAXB also does not support Maps. It handles Lists great, but
     * Maps are not supported directly. They also require use of a XmlAdapter to
     * map the maps into beans that JAXB can use.
     */
    @XmlJavaTypeAdapter(IntegerUserMapAdapter.class)
    Map<Integer, UserVo> getUsers();
}