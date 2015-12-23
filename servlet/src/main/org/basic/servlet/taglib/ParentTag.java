package org.basic.servlet.taglib;

import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

public class ParentTag extends BodyTagSupport {

    // setParent
    // setPname
    // doStartTag
    // setBodyContent
    // doInitBody
    // doAfterBody
    // doEndTag
    // \
    // release
    private String pname;

    public void setPname(String pname) {

        System.out.println(this.getClass().getSimpleName() + ".setPname");
        this.pname = pname;
    }

    public String getPname() {

        return pname;
    }

    @Override
    public void setId(String arg0) {

        System.out.println(this.getClass().getSimpleName() + ".setId");
        super.setId(arg0);
    }

    @Override
    public void setValue(String arg0, Object arg1) {

        System.out.println(this.getClass().getSimpleName() + ".setValue");
        super.setValue(arg0, arg1);
    }

    @Override
    public void setParent(Tag arg0) {

        System.out.println(this.getClass().getSimpleName() + ".setParent");

        super.setParent(arg0);
    }

    @Override
    public int doStartTag() throws JspException {

        System.out.println("doStartTag");
        // return Tag.EVAL_BODY_INCLUDE; // 1
        return BodyTag.EVAL_BODY_BUFFERED; // 2 创建的新的Buffer，同时调用setBodyContent 和
                                           // doInitBody.但是如果对BodyContent不作处理，则所有的内容将不会显示。
        // IterationTag.EVAL_BODY_AGAIN 2
        // return super.doStartTag(); 2
    }

    @Override
    public void setBodyContent(BodyContent arg0) {

        System.out.println(this.getClass().getSimpleName() + ".setBodyContent");
        super.setBodyContent(arg0);
    }

    @Override
    public void doInitBody() throws JspException {

        System.out.println(this.getClass().getSimpleName() + ".doInitBody");
        super.doInitBody();
    }

    @Override
    public int doAfterBody() throws JspException {

        System.out.println(this.getClass().getSimpleName() + ".doAfterBody");
        // JspWriter writer = this.getPreviousOut();
        try {
            // Reader reader = this.getBodyContent().getReader();
            // char[] buffer = new char[4096];
            // int readSize = 0;
            // while ((readSize = reader.read(buffer, 0, 4096)) != -1) {
            // System.out.println(new String(buffer, 0, readSize));
            // }
            JspWriter pageOut = this.pageContext.getOut();
            pageOut.println("this.pageContext.println");

            // this.getBodyContent().println("this.getBodyContent().println()");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Tag.EVAL_BODY_INCLUDE;// 5
        // return super.doAfterBody();
    }

    @Override
    public int doEndTag() throws JspException {

        System.out.println(this.getClass().getSimpleName() + ".doEndTag");
        JspWriter currentOut = pageContext.getOut();
        JspWriter previousOut = this.getPreviousOut();
        try {

            System.out.println("previousOut.getBufferSize="+previousOut.getBufferSize());
            System.out.println("previousOut.getRemaining="+previousOut.getRemaining());
            previousOut.println("previousOut Test");
            previousOut.flush();

            Reader reader = this.getBodyContent().getReader();
            char[] buffer = new char[4096];
            int readSize = 0;
            while ((readSize = reader.read(buffer, 0, 4096)) != -1) {
                currentOut.println(new String(buffer, 0, readSize));
            }
            currentOut.println("doEndTag");
        } catch (Exception e) {
        }
        // return Tag.EVAL_PAGE; //5
        return Tag.EVAL_PAGE; // 6

        // return super.doEndTag(); return 6
    }

    @Override
    public void release() {

        System.out.println(this.getClass().getSimpleName() + ".release");
        super.release();
    }
}
