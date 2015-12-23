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
package sample.pojo.data;

import java.math.BigDecimal;

public class Weather {

    private static final long serialVersionUID = -7498287089753865813L;

    protected double temperature;
    protected String forecast;
    protected boolean rain;
    protected BigDecimal howMuchRain;

    protected Address address;

    /**
     * @return the address
     */
    public Address getAddress() {

        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(Address address) {

        this.address = address;
    }

    public Weather() {

    }

    public Weather(String forecast) {

        this.forecast = forecast;

    }

    @Override
    public String toString() {

        return new StringBuffer(this.getClass().getName()).append(":[forecast=").append(
                this.forecast).append(", temperature=").append(this.temperature).append(
                ", howMuchRain=").append(this.howMuchRain).append(", rain=").append(this.rain)
                .append(", address=").append(this.address).append("]").toString();
    }

    /**
     * @return the forecast
     */
    public String getForecast() {

        return forecast;
    }

    /**
     * @param forecast
     *            the forecast to set
     */
    public void setForecast(String forecast) {

        this.forecast = forecast;
    }

    /**
     * @return the howMuchRain
     */
    public BigDecimal getHowMuchRain() {

        return howMuchRain;
    }

    /**
     * @param howMuchRain
     *            the howMuchRain to set
     */
    public void setHowMuchRain(BigDecimal howMuchRain) {

        this.howMuchRain = howMuchRain;
    }

    /**
     * @return the rain
     */
    public boolean isRain() {

        return rain;
    }

    /**
     * @param rain
     *            the rain to set
     */
    public void setRain(boolean rain) {

        this.rain = rain;
    }

    /**
     * @return the temperature
     */
    public double getTemperature() {

        return temperature;
    }

    /**
     * @param temperature
     *            the temperature to set
     */
    public void setTemperature(double temperature) {

        this.temperature = temperature;
    }

}