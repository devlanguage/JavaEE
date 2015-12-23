/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.baisc.axis2.test.service.AXIOMClient.java is created on 2008-5-16
 */
package org.baisc.axis2.test.service;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

/**
 * 
 */
public class AXIOMClient {

    // private HashMap map = new HashMap();
    //    
    // public void update(String symbol, Double price) {
    // map.put(symbol, price);
    // }
    //  
    // public Double getPrice(String symbol) {
    // Double ret = (Double) map.get(symbol);
    // if (ret == null) {
    // ret = new Double(42.0);
    // }
    // return ret;
    // }

    private static EndpointReference targetEPR = new EndpointReference(
            "http://localhost:8087/axis2/services/HelloAdbService");

    public static OMElement hello(String symbol) {

        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://axis2.basic.org/service/helloadb",
                "tns");

        OMElement method = fac.createOMElement("hello", omNs);
        OMElement value = fac.createOMElement("param0", omNs);
        value.addChild(fac.createOMText(value, symbol));
        method.addChild(value);
        return method;
    }

    public static OMElement updatePayload(String symbol, double price) {

        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://axiom.service.quickstart.samples/xsd",
                "tns");

        OMElement method = fac.createOMElement("update", omNs);

        OMElement value1 = fac.createOMElement("symbol", omNs);
        value1.addChild(fac.createOMText(value1, symbol));
        method.addChild(value1);

        OMElement value2 = fac.createOMElement("price", omNs);
        value2.addChild(fac.createOMText(value2, Double.toString(price)));
        method.addChild(value2);
        return method;
    }

    public static void main(String[] args) {

        try {
            OMElement getPricePayload = hello("client");
            OMElement updatePayload = updatePayload("WSO", 123.42);
            Options options = new Options();
            options.setTo(targetEPR);
            options.setTransportInProtocol(Constants.TRANSPORT_HTTP);

            ServiceClient sender = new ServiceClient();
            sender.setOptions(options);

//            sender.fireAndForget(updatePayload);
//            System.err.println("done");
            
            OMElement result = sender.sendReceive(getPricePayload);
            String response = result.getFirstElement().getText();
            System.err.println("Current price of WSO: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
