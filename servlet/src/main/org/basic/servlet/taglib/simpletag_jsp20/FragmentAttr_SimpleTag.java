package org.basic.servlet.taglib.simpletag_jsp20;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FragmentAttr_SimpleTag extends SimpleTagSupport {

    private int count = 0;// 重复的次数
    // javax.servlet.jsp.tagext.JspFragment
    private javax.servlet.jsp.tagext.JspFragment fragment;// 重复的内容

    public void setCount(int count) {

        this.count = count;
    }

    public void setFragment(javax.servlet.jsp.tagext.JspFragment fragment) {

        this.fragment = fragment;
    }

    public void doTag() throws JspException, IOException {

        JspContext ctx = getJspContext();
        JspWriter out = ctx.getOut();
//        getJspBody().invoke(null);
        out.println("count=" + count + ", fragment=" + fragment);
         for (int i = 0; i < count; i++) {
            fragment.invoke(null);// 表示将fragment的内容显示出来
        }
    }
}
