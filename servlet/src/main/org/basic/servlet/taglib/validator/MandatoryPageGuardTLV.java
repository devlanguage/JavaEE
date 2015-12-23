package org.basic.servlet.taglib.validator;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TagLibraryValidator;
import javax.servlet.jsp.tagext.ValidationMessage;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MandatoryPageGuardTLV extends TagLibraryValidator {

    public final static String PARAM_NAME_DELIMETER = "paramValueDelimeter";
    public final static String PARAM_NAME_necessaryTag = "necessaryTag";

    private String paramDelimeter;
    public final List<String> necessaryTagList = new ArrayList<String>();
    private boolean uninitialized = true;

//    @Override
//    public void setInitParameters(Map<String, Object> arg0) {
//
//        super.setInitParameters(arg0);
//        paramDelimeter = (String) this.getInitParameters().get(PARAM_NAME_DELIMETER);
//    }

    public ValidationMessage[] validate(String prefix, String uri, javax.servlet.jsp.tagext.PageData pageData) {

        System.out.println(this.getClass().getSimpleName()+".validate()"+": check JSP 文件内容");
        if (uninitialized) {
            String[] necessaryTags = ((String) this.getInitParameters().get(PARAM_NAME_necessaryTag)).split(paramDelimeter);
            for (String tagName : (necessaryTags)) {
                necessaryTagList.add(prefix + ":" + tagName);
            }
            uninitialized = false;
        }
        // create a handler that will parse the XML
        MyHandler handler = new MyHandler();
        // parse the page...
        try {

            javax.xml.parsers.SAXParserFactory factory = javax.xml.parsers.SAXParserFactory.newInstance();
            factory.setValidating(true);
            javax.xml.parsers.SAXParser parser = factory.newSAXParser();
            parser.parse(pageData.getInputStream(), handler);

        } catch (Exception e) {
            getValidationMessages(e.getClass().getName() + " parsing document: " + e.getMessage());
        }
        // ... and return the error (if any)
        return getValidationMessages(handler.getErrorMessage());

    }

    // MyHandler is a XML parser that will check if
    // the pageGuard tag is present in the page
    private class MyHandler extends DefaultHandler {

        private String errorMessage = null;
        private int foundCount = 0;

        public MyHandler() {

        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            // found the guard tag
            if (necessaryTagList.contains(qName)) {
                foundCount++;
            } // if

        } // startElement

        String getErrorMessage() {

            return this.errorMessage;
        }

        public void endDocument() throws SAXException {

            if (this.foundCount != necessaryTagList.size()) {
                this.errorMessage = necessaryTagList + " is mandatory";
            } // if
        } // endDocument

    } // private class

    // helper method
    public static ValidationMessage[] getValidationMessages(String msg) {

        if (msg == null) {
            return null;
        }
        ValidationMessage[] array = new ValidationMessage[] { new ValidationMessage(null, msg) };
        return array;
    }

} // public class
