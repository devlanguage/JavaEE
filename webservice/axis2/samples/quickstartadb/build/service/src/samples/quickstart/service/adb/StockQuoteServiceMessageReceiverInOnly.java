/**
 * StockQuoteServiceMessageReceiverInOnly.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:47 LKT)
 */
package samples.quickstart.service.adb;


/**
 *  StockQuoteServiceMessageReceiverInOnly message receiver
 */
public class StockQuoteServiceMessageReceiverInOnly extends org.apache.axis2.receivers.AbstractInMessageReceiver {
    public void invokeBusinessLogic(
        org.apache.axis2.context.MessageContext inMessage)
        throws org.apache.axis2.AxisFault {
        try {
            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(inMessage);

            StockQuoteServiceSkeletonInterface skel = (StockQuoteServiceSkeletonInterface) obj;

            //Out Envelop
            org.apache.axiom.soap.SOAPEnvelope envelope = null;

            //Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = inMessage.getOperationContext()
                                                                     .getAxisOperation();

            if (op == null) {
                throw new org.apache.axis2.AxisFault(
                    "Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            java.lang.String methodName;

            if ((op.getName() != null) &&
                    ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJava(
                            op.getName().getLocalPart())) != null)) {
                if ("update".equals(methodName)) {
                    samples.quickstart.service.adb.xsd.Update wrappedParam = (samples.quickstart.service.adb.xsd.Update) fromOM(inMessage.getEnvelope()
                                                                                                                                         .getBody()
                                                                                                                                         .getFirstElement(),
                            samples.quickstart.service.adb.xsd.Update.class,
                            getEnvelopeNamespaces(inMessage.getEnvelope()));

                    skel.update(wrappedParam);
                } else {
                    throw new java.lang.RuntimeException("method not found");
                }
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    //
    private org.apache.axiom.om.OMElement toOM(
        samples.quickstart.service.adb.xsd.Update param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(samples.quickstart.service.adb.xsd.Update.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        samples.quickstart.service.adb.xsd.GetPrice param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(samples.quickstart.service.adb.xsd.GetPrice.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        samples.quickstart.service.adb.xsd.GetPriceResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(samples.quickstart.service.adb.xsd.GetPriceResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        samples.quickstart.service.adb.xsd.GetPriceResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    samples.quickstart.service.adb.xsd.GetPriceResponse.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
        java.lang.Class type, java.util.Map extraNamespaces)
        throws org.apache.axis2.AxisFault {
        try {
            if (samples.quickstart.service.adb.xsd.Update.class.equals(type)) {
                return samples.quickstart.service.adb.xsd.Update.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (samples.quickstart.service.adb.xsd.GetPrice.class.equals(type)) {
                return samples.quickstart.service.adb.xsd.GetPrice.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (samples.quickstart.service.adb.xsd.GetPriceResponse.class.equals(
                        type)) {
                return samples.quickstart.service.adb.xsd.GetPriceResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

        return null;
    }

    /**
     *  A utility method that copies the namepaces from the SOAPEnvelope
     */
    private java.util.Map getEnvelopeNamespaces(
        org.apache.axiom.soap.SOAPEnvelope env) {
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();

        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
        }

        return returnMap;
    }
} //end of class
