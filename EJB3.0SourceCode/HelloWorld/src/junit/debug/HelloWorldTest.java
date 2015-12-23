package junit.debug;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.HelloWorld;

public class HelloWorldTest {
    protected static HelloWorld helloworld;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
       helloworld = (HelloWorld)EJBFactory.getEJB("HelloWorldBean/remote");
    }

    @Test
    public void testSayHello() {
       assertEquals("��ɽ��˵�����!����,�����ҵĵ�һ��EJB3Ŷ.", helloworld.SayHello("��ɽ��"));
    }
}
