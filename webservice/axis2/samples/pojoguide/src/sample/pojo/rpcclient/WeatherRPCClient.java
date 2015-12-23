/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package sample.pojo.rpcclient;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.OperationClient;
import org.apache.axis2.client.Options;
import org.apache.axis2.databinding.utils.BeanUtil;
import org.apache.axis2.databinding.utils.MultirefHelper;
import org.apache.axis2.engine.DefaultObjectSupplier;
import org.apache.axis2.engine.ObjectSupplier;
import org.apache.axis2.rpc.client.RPCServiceClient;

import sample.pojo.data.Weather;
import sample.pojo.data.WeatherFactory;
import sample.pojo.data.WeatherWithHumidity;

public class WeatherRPCClient {

    public final static String WEATHER_SERVICE_END_POINT = "http://localhost:8080/axis2/services/WeatherService";
    public final static String WEATHER_SERVICE_NS = "http://service.pojo.sample";
    public static String testedMethod = "";

    public static void main(String[] args1) throws AxisFault {

        RPCServiceClient serviceClient = new RPCServiceClient();
        Options options = serviceClient.getOptions();
        EndpointReference targetEPR = new EndpointReference(WEATHER_SERVICE_END_POINT);
        options.setTo(targetEPR);

        // Test the method hello(traveller);
        testedMethod = "hello";
        QName helloMethod = new QName(WEATHER_SERVICE_NS, testedMethod);
        Object[] helloArgs = new Object[] { "Travller" };
        Class[] helloReturnTypes = new Class[] { String.class };
        Object[] helloResponse = serviceClient.invokeBlocking(helloMethod, helloArgs,
                helloReturnTypes);
        printReponse(helloResponse);

        // Setting the weather
        testedMethod = "createWeather";
        QName createWeatherMethod = new QName(WEATHER_SERVICE_NS, testedMethod);
        Weather weather = WeatherFactory.getInstance().createWeather();
        Object[] createWeatherArgs = new Object[] { weather };
        serviceClient.invokeRobust(createWeatherMethod, createWeatherArgs);
        printReponse(createWeatherArgs);

        // Getting the weather
        testedMethod = "getWeather";
        QName getWeatherMethod = new QName(WEATHER_SERVICE_NS, testedMethod);
        Object[] getWeatherArgs = new Object[] { 1 };
        Class[] getWeatherReturnTypes = new Class[] { Weather.class };
        Object[] getWeatherResponse = serviceClient.invokeBlocking(getWeatherMethod,
                getWeatherArgs, getWeatherReturnTypes);
        printReponse(getWeatherResponse);

        // Get the weathers as Array
        testedMethod = "getWeathers";
        QName getWeathersMethod = new QName(WEATHER_SERVICE_NS, testedMethod);
        Object[] getWeathersArgs = new Object[] {};        
        Class[] getWeathersReturnTypes = new Class[] { Weather.class, Weather.class, Weather.class,
                Weather.class };
        Object[] getWeathersResponse = serviceClient.invokeBlocking(getWeathersMethod,
                getWeathersArgs, getWeathersReturnTypes);
        printReponse(getWeathersResponse);
        // // printReponse((Object[]) getWeathersResponse[0]);
        // OMElement omElement = BeanUtil.getOMElement(getWeathersMethod, getWeathersArgs, null,
        // false, null);
        // OMElement getWeathersResponse = serviceClient.sendReceive(getWeathersMethod, omElement);
        // System.out.println(getWeathersResponse);

//        // get weathers as List
//        testedMethod = "listWeathers";
//        QName listWeathersMethod = new QName(WEATHER_SERVICE_NS, testedMethod);
//        Object[] listWeathersArgs = new Object[] {};
////        Class[] listWeathersReturnTypes = new Class[] { List.class };
//        Class[] listWeathersReturnTypes = new Class[] { List.class };
//        Object[] listWeathersResponse = serviceClient.invokeBlocking(listWeathersMethod,
//                listWeathersArgs, listWeathersReturnTypes);
//        printReponse((List) listWeathersResponse[0]);

    }

    public static Object deserialize(Class beanClass, OMElement beanElement, MultirefHelper helper,
            ObjectSupplier objectSupplier) throws AxisFault {

        return null;
    }

    public final static void nextLine() {

        System.out.println();
    }

    public final static void printReponse(Collection objects) {

        System.out.println("testedMethod: " + testedMethod);
        for (Object object : objects) {

            System.out.println("\t" + object);
        }
        nextLine();
    }

    public final static void printReponse(Object... objects) {

        System.out.println("testedMethod: " + testedMethod);
        for (Object object : objects) {
            if (object instanceof WeatherWithHumidity) {
                WeatherWithHumidity weather = (WeatherWithHumidity) object;
                System.out.println("\t" + weather);
            } else if (object instanceof Weather) {
                Weather weather = (Weather) object;
                System.out.println("\t" + weather);
            } else if (object instanceof String) {
                String string = (String) object;
                System.out.println("\t" + string);
            }

        }
        nextLine();
    }
}
