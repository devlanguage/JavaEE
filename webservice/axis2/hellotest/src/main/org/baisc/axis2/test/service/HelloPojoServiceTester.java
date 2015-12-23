package org.baisc.axis2.test.service;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.basic.axis2.common.bean.Share;

public class HelloPojoServiceTester {

    private static EndpointReference END_POINT = new EndpointReference(
            "http://localhost:8087/axis2/services/HelloPojoService");
    private final static String BASIC_TARGET_NS = "http://axis2.basic.org/service/hellopojo";

    public static void main(String[] args) {

        try {
            RPCServiceClient rpcClient = new RPCServiceClient();

            Options options = rpcClient.getOptions();
            options.setTo(END_POINT);
            options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
            testHello(rpcClient);

            // QName opHelloQName = new QName(BASIC_TARGET_NS, "hello");
            // Object[] paramsHello = new Object[] { "zhangsan" };
            // Object resultHello = rpcClient.invokeBlocking(opHelloQName,
            // paramsHello, new Class[] { String.class })[0];
            // System.out.println(resultHello);
            //
            // QName opGetShareQName = new QName(BASIC_TARGET_NS, "getShare");
            // Object[] paramsGetShare = new Object[] { 2 };
            // Object resultGetShare = rpcClient.invokeBlocking(opGetShareQName,
            // paramsGetShare,
            // new Class[] { Share.class })[0];
            // System.out.println(resultGetShare);

            // QName opGetAllShareListQName = new QName(BASIC_TARGET_NS,
            // "getAllShareList");
            // Object[] paramsGetAllShareList = new Object[] {};
            // OMElement resultGetAllShareList =
            // rpcClient.invokeBlocking(opGetAllShareListQName,
            // paramsGetAllShareList);
            // System.out.println(resultGetAllShareList);
            //            
            // QName opGetAllShareListQName = new QName(BASIC_TARGET_NS,
            // "getAllShareList");
            // Object[] paramsGetAllShareList = new Object[] {};
            // List resultGetAllShareList = (List)
            // rpcClient.invokeBlocking(opGetAllShareListQName,
            // paramsGetAllShareList,
            // new Class[] { List.class, Share.class })[0];
            // System.out.println(resultGetAllShareList);

            // for (OMElement omElement : resultGetAllShareList) {
            // System.out.println(omElement.getParent());
            // }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final static void testHello(RPCServiceClient rpcClient) throws Exception {

        QName methodHello = new QName(BASIC_TARGET_NS, "hello");
        Object[] paramsHello = new Object[] { "zhangsan" };
        Object resultHello = rpcClient.invokeBlocking(methodHello, paramsHello, new Class[] { String.class })[0];
        System.out.println(resultHello);
    }
}