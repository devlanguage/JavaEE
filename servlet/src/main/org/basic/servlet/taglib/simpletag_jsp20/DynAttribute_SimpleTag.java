package org.basic.servlet.taglib.simpletag_jsp20;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DynAttribute_SimpleTag extends SimpleTagSupport implements DynamicAttributes {

    // 用来接收动态属性
    private Map<String, Object> keyValues = new HashMap<String, Object>();

    public void setDynamicAttribute(String uri, String name, Object value) throws JspException {

        keyValues.put(name, value);
    }

    public void doTag() throws JspException, IOException {

        JspContext jspCtx = getJspContext();
        JspWriter out = jspCtx.getOut();

        float sum = 0;
        for (Entry<String, Object> entry : keyValues.entrySet()) {
            out.print("+" + entry.getValue());
            sum = sum + Float.parseFloat(entry.getValue().toString());
        }
        out.print(" = " + sum);
        jspCtx.setAttribute("sum", Float.toString(sum));
    }
}
