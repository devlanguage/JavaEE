package org.basic.servlet.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class ChildTag extends BodyTagSupport {

    private String pname;

    /**
     * @param pname
     *            the pname to set
     */
    public void setPname(String pname) {

        this.pname = pname;
    }

    @Override
    public void setBodyContent(BodyContent arg0) {

        System.out.println(this.getClass().getSimpleName() + ".setBodyContent");
        super.setBodyContent(arg0);
    }

    @Override
    public void setParent(Tag arg0) {

        System.out.println(this.getClass().getSimpleName() + ".setParent");

        super.setParent(arg0);
    }

    @Override
    public void doInitBody() throws JspException {

        System.out.println(this.getClass().getSimpleName() + ".doInitBody ");
        super.doInitBody();
    }

    @Override
    public int doStartTag() throws JspException {

        System.out.println(this.getClass().getSimpleName() + ".doStartTag");
        return Tag.EVAL_BODY_INCLUDE;
        // return super.doStartTag();
    }

    @Override
    public int doAfterBody() throws JspException {

        System.out.println(this.getClass().getSimpleName() + ".doAfterBody");
        return Tag.EVAL_PAGE;
        // return super.doAfterBody();
    }

    @Override
    public int doEndTag() throws JspException {

        System.out.println(this.getClass().getSimpleName() + ".doEndTag");
        JspWriter out = pageContext.getOut();
        try {
           ParentTag parentTag =  (ParentTag) this.getParent();
           out.println("parentTag.pname="+parentTag.getPname());
            out.println("child.pname="+this.pname);
        } catch (IOException e) {
            e.printStackTrace();
        }       
        
        return Tag.EVAL_PAGE;
        // return super.doEndTag();
    }

    @Override
    public void release() {

        System.out.println(this.getClass().getSimpleName() + ".release");
        super.release();
    }
}
