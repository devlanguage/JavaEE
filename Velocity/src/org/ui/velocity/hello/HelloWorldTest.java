/**
 * The file org.ui.velocity.hello.HelloWorldTest.java was created by yongjie.gong on 2008-6-4
 */
package org.ui.velocity.hello;

import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.ui.velocity.bean.Customer;
import org.ui.velocity.bean.VelocityConstant;

/**
 * @author feiye
 * 
 */
public class HelloWorldTest {

    private static final String HELLO_WORLD_FILE = VelocityConstant.VELOCITY_PATH_PREFIX + "/helloworld.vm";
    private static final String HELLO_WORLD_RESULT_FILE = VelocityConstant.VELOCITY_PATH_PREFIX + "/hello_result.html";

    public static void main(String[] args) {

        List<Customer> customerList = initCustomers();

        // Instantiate the engine
        VelocityEngine ve = new VelocityEngine();
        try {
            ve.init();
            // Get template
            Template template = ve.getTemplate(HELLO_WORLD_FILE, "UTF-8");
            // Create the context and put the data
            VelocityContext ctx = new VelocityContext();
            ctx.put("customerList", customerList);
            ctx.put("customer", customerList.get(0));

            /* 现在，把模板和数据合并，输出到StringWriter */

            StringWriter writer = new StringWriter();
            template.merge(ctx, writer);
            /* 显示结果 */

            System.out.println(writer.toString());
            FileOutputStream helloResult = new FileOutputStream(HELLO_WORLD_RESULT_FILE);
            helloResult.write(writer.toString().getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static List<Customer> initCustomers() {

        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(new Customer());
        customerList.add(new Customer());
        customerList.add(new Customer());
        return customerList;
    }

}
