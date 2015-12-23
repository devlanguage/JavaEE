package org.cxftest.hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

@WebService(endpointInterface = "org.cxftest.hello.HelloService")
public class HelloServiceImpl implements HelloService {

    public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }

    public List<String> getList() {
        List<String> list = new ArrayList<String>();
        list.add("listElement_01");
        list.add("listElement_02");
        list.add("listElement_03");
        return list;
    }

    public String[] getArray() {
        String[] array = new String[] { "arrayString_01", "arrayString_02" };
        return array;
    }

    public HashMap<String, String> getMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        return map;

    }
}
