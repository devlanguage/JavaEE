/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.basic.axis2.helloaxiom.test.HelloAdbServiceTester.java is created on 2008-2-2
 */
package org.baisc.axis2.test.service;

import java.rmi.RemoteException;

import org.basic.axis2.helloadb.stub.HelloAdbServiceStub;

/**
 * 
 */
public class HelloAdbServiceTester {



    public static void main(java.lang.String args[]){   
        try{   
            HelloAdbServiceStub stub =   
                new HelloAdbServiceStub   
                ("http://localhost:8087/axis2/services/HelloAdbService");   
  
//            hell(stub);
            getShare(stub);
//            getPrice(stub);   
//            update(stub);   
  
        } catch(Exception e){   
            e.printStackTrace();   
            System.err.println("\n\n\n");   
        }   
    }

    private static void getShare(HelloAdbServiceStub stub) {
        try {
            System.out.println(stub.getShare(1));
            
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }   
  
//    /* fire and forget */  
//    public static void update(StockQuoteServiceStub stub){   
//        try{   
//            HelloAdbServiceStub.Share req = new HelloAdbServiceStub.Share();
//            req.set
//            req.setSymbol ("ABC");   
//            req.setPrice (42.35);   
//  
//            stub.update(req);   
//            System.err.println("done");   
//        } catch(Exception e){   
//            e.printStackTrace();   
//            System.err.println("\n\n\n");   
//        }   
//    }   
//  
//    /* two way call/receive */  
//    public static void getPrice(StockQuoteServiceStub stub){   
//        try{   
//            StockQuoteServiceStub.GetPrice req = new StockQuoteServiceStub.GetPrice();   
//  
//            req.setSymbol("ABC");   
//  
//            StockQuoteServiceStub.GetPriceResponse res =   
//                stub.getPrice(req);   
//  
//            System.err.println(res.get_return());   
//        } catch(Exception e){   
//            e.printStackTrace();   
//            System.err.println("\n\n\n");   
//        }   
//    }   
  

}
