package org.j2eetest.util;

import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.j2eetest.exception.BaseRuntimeException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class XmlUtil {

    static DocumentBuilderFactory dbf = null;
    static Transformer xmlTransformer = null;
    static DocumentBuilder builder = null;
    private final static LoggerUtil logger = LoggerUtil.getLogger(XmlUtil.class);

    static {
        try {
            dbf = DocumentBuilderFactory.newInstance();
            xmlTransformer = TransformerFactory.newInstance().newTransformer();
            // dbf.setValidating(true);
            // dbf.setNamespaceAware(true);
            builder = dbf.newDocumentBuilder();
        } catch (Exception e) {
            logger.log(LoggerUtil.ERROR, "static", e.getMessage(), e);
        }
    }

    public final static Document getDocument() {

        return builder.newDocument();
    }

    public static Document getDocumentFromContent(String xmlFileContent) throws BaseRuntimeException {

        try {
            return builder.parse(new InputSource(new StringReader(xmlFileContent)));
        } catch (Exception e) {
            throw new BaseRuntimeException("Failed to parse the xml content:" + xmlFileContent, e);
        }

        // ByteArrayInputStream ins = new ByteArrayInputStream(xmlFileContent.getBytes());
        // return getDocuemnt(ins);
    }

    public final static Document getDocuemnt(InputStream in) throws BaseRuntimeException {

        Document doc = null;
        try {
            doc = builder.parse(in);
        } catch (Exception e) {
            SystemUtil.handleException(logger, e, "");
            throw new BaseRuntimeException("Failed to create the Xml Document Element", e);
        }
        return doc;

    }

    /**
     * Create the W3C document element from system path.
     * 
     * @param fileName
     *            XML file full path. for example:
     *            <li> file:/Z:/test/test.xml</li>
     *            <li> Z:/test/test.xml</li>
     *            <li>http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd</li>
     * @return
     * @throws BaseRuntimeException
     */
    public static Document getDocumentFromUriPath(String fileName) throws BaseRuntimeException {

        Document document = null;
        try {
            document = builder.parse(fileName);
        } catch (Exception e) {
            throw new BaseRuntimeException("Failed to create the Xml Document Element", e);
        }
        return document;
    }

    /**
     * Create the W3C document element from system path.
     * 
     * @param fileName
     *            XML file full path based on classpath. for example:
     *            <li> /com/test/test.xml</li>
     *            <li> test/test.xml</li>
     * @return
     * @throws BaseRuntimeException
     */
    public final static Document getDocumentFromClassPath(String fileName)
            throws BaseRuntimeException {

        Document document = null;
        try {
            document = builder.parse(XmlUtil.class.getClassLoader().getResourceAsStream(fileName));
        } catch (Exception e) {
            throw new BaseRuntimeException("Failed to create the Xml Document Element", e);
        }
        return document;
    }
    
    public final static org.dom4j.Document getDom4jDocumentFromClassPath(String fileName) throws BaseRuntimeException {
        org.dom4j.io.SAXReader dom4jSaxReader = new org.dom4j.io.SAXReader ();
        org.dom4j.Document dom4jDoc= null;
        try {
            InputStream in = XmlUtil.class.getClassLoader().getResourceAsStream(fileName);
            dom4jDoc = dom4jSaxReader.read(in);
        } catch (Exception e) {            
            throw new BaseRuntimeException("Failed to construct the dom4j Document node from file "+fileName,e);
        }
        return dom4jDoc;
    }

    public static boolean isValidXmlFile(String filename) {

        boolean bValid = false;
        try {
            @SuppressWarnings("unused")
            Document document = builder.parse(filename);
            bValid = true;
        } catch (Exception e) {
            bValid = false;
            logger.log(LoggerUtil.ERROR, "XmlUtil.isValid", e.getMessage(), e);
        }
        return bValid;
    }

    public final static Element getNode(Element parent, String element) {

        assert !SystemUtil.isNullOrBlank(parent);
        NodeList nodeList = parent.getElementsByTagName(element);        
        return nodeList == null ? null : (Element) nodeList.item(0);
    }

    public final static NodeList getNodeList(Element parent, String element) {

        assert !SystemUtil.isNullOrBlank(parent);
        return parent.getElementsByTagName(element);
    }

    public final static String getNodeValue(Element parent, String element) {

        assert !SystemUtil.isNullOrBlank(parent);
        Node firstChild = getNode(parent, element);
        return firstChild == null ? null : getNodeValue(firstChild);
    }

    public final static String getNodeValue(Node node) {

        assert !SystemUtil.isNullOrBlank(node);
        String nodeValue = "";
           NodeList nodeList= node.getChildNodes();
           for(int i=0; i<nodeList.getLength(); i++){
               nodeValue = nodeList.item(i).getNodeValue();
               if(!SystemUtil.isNullOrBlank(nodeValue)){
                   break;
               }
           }
           return nodeValue;
    }

    public static Element getRootNode(Document doc) {

        return doc.getDocumentElement();
    }

    public static Element getRootNode(InputStream ins) throws BaseRuntimeException {

        return getRootNode(getDocuemnt(ins));
    }

    public static Element getRootNodeFromContent(String xmlFileContent) throws BaseRuntimeException {

        return getRootNode(getDocumentFromContent(xmlFileContent));
    }

    public static Element getRootNodeFromClassPath(String fileName)
            throws BaseRuntimeException {

        return getRootNode(getDocumentFromClassPath(fileName));
    }

    public static Element getRootNodeFromUriPath(String fileName)
            throws BaseRuntimeException {

        return getRootNode(getDocumentFromUriPath(fileName));
    }

    public final static String nodeToString(Node node) {

        DOMSource source = new DOMSource(node);
        StringWriter out = new StringWriter();
        StreamResult result = new StreamResult(out);
        try {
            xmlTransformer.transform(source, result);
            out.flush();
        } catch (TransformerException e) {
            logger.log(LoggerUtil.ERROR, "XmlUtil.nodeToString", "Failed to transform the xml Node",
                    e);
        }
        return out.toString();
    }

    public final static boolean deleteNode(Node source, Node node) {

        if (!source.hasChildNodes()) {
            return false;
        }
        NodeList list = source.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node n = list.item(i);
            if (n.equals(node)) {
                logger.log(LoggerUtil.DEBUG, "deleteNode", "a Node removed " + node.getNodeName());
                n.getParentNode().removeChild(node);
                return true;
            } else {
                if (deleteNode(n, node)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final static void deleteText(Node node) {

        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node aNode = children.item(i);
            if (aNode.getNodeType() == Node.TEXT_NODE) {
                node.removeChild(aNode);
            }
        }
    }
}
