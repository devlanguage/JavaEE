package org.basic.servlet.taglib;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.ValidationMessage;
import javax.servlet.jsp.tagext.VariableInfo;

public class ChildTag_Tei extends javax.servlet.jsp.tagext.TagExtraInfo {

    public ChildTag_Tei() {

    }

    @Override
    public VariableInfo[] getVariableInfo(TagData tagData) {

        System.out.println(this.getClass().getSimpleName() + ".VariableInfo[] getVariableInfo(TagData tagData)");
        System.out.println("tagData=" + tagData);
        return super.getVariableInfo(tagData);// return new VariableInfo[0];
    }

    @Override
    public boolean isValid(TagData tagData) {

        System.out.println(this.getClass().getSimpleName() + ".(boolean isValid(TagData tagData))");
        System.out.println("tagData=" + tagData);
        return super.isValid(tagData);// return true
    }

    @Override
    public ValidationMessage[] validate(TagData tagData) {

        System.out.println(this.getClass().getSimpleName() + ".(ValidationMessage[] validate(TagData tagData))");
        System.out.println("tagData=" + tagData);
        return super.validate(tagData);/*
                                        * ValidationMessage result[] = null; if(!isValid(data))
                                        * result = (new ValidationMessage[] { new
                                        * ValidationMessage(data.getId(), "isValid() == false") });
                                        * return result;
                                        */
    }
}
