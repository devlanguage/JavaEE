/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.basic.axis2.helloaxiom.service.HelloAxiomService.java is created on 2008-2-1
 */
package org.basic.axis2.helloaxiom.service;

import java.util.HashMap;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;

public class HelloAxiomService {

    private HashMap map = new HashMap();

    public OMElement getPrice(OMElement element) throws XMLStreamException {

        element.build();
        element.detach();

        OMElement symbolElement = element.getFirstElement();
        String symbol = symbolElement.getText();

        String returnText = "42";
        Double price = (Double) map.get(symbol);
        if (price != null) {
            returnText = "" + price.doubleValue();
        }
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://axiom.service.quickstart.samples/xsd",
                "tns");
        OMElement method = fac.createOMElement("getPriceResponse", omNs);
        OMElement value = fac.createOMElement("price", omNs);
        value.addChild(fac.createOMText(value, returnText));
        method.addChild(value);

        return method;
    }

    public void update(OMElement element) throws XMLStreamException {

        element.build();
        element.detach();

        OMElement symbolElement = element.getFirstElement();
        String symbol = symbolElement.getText();

        OMElement priceElement = (OMElement) symbolElement.getNextOMSibling();
        String price = priceElement.getText();

        map.put(symbol, new Double(price));
    }
}
