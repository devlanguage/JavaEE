package org.wstest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;

public class WsTest {

    private static SOAPMessage createSOAPMsgFromFile(String filename) throws Exception {

        System.out.println("Loading request payload: " + filename);

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(filename);
            return MessageFactory.newInstance().createMessage(null, fis);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

        return null;
    }

    public static void main(String[] args) {
        SOAPConnectionFactory soapCf;
        try {
            soapCf = SOAPConnectionFactory.newInstance();
            SOAPConnection sopaConn = soapCf.createConnection();

            SOAPMessage request = createSOAPMsgFromFile("soap_request.xml");
            URL endpoint = new URL("http://localhost:8080/test/HelloService");
            SOAPMessage response = sopaConn.call(request, endpoint);

            // save response to file
            saveFile(response, "soap_response.xml");

            // try unmarshalling response
            SOAPBody body = response.getSOAPBody();
            Document doc = body.extractContentAsDocument();
            SayHiResponse resp = (SayHiResponse) unmarshall(doc, SayHiResponse.class);

            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private static Object unmarshall(Document doc, Class clz) throws Exception {

        if(doc == null || clz == null) {
          return null;
        }
        
        // unmarshalls soap message to java object
        JAXBContext jc = JAXBContext.newInstance(clz);
        Unmarshaller um = jc.createUnmarshaller();
        
        // optional: do schema validation when unmarshalling service response if necessary
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("doc/xsd/t50/person/GetPerson.xsd"));
        um.setSchema(schema);

        return um.unmarshal(doc);
      }
      

    private static void saveFile(SOAPMessage msg, String filename) throws Exception {

        if (filename == null) {
            filename = "testResponse.xml";
        }

        System.out.println("Saving service response: " + filename);

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(filename);
            msg.writeTo(fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

}
