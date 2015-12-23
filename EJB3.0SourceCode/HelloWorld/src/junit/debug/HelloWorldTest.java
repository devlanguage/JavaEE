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
       assertEquals("佛山人说：你好!世界,这是我的第一个EJB3哦.", helloworld.SayHello("佛山人"));
    }
}
