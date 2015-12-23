/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.basic.axis2.helloxmlbeans.bean.Share.java is created on 2008-2-1
 */
package org.basic.axis2.common.bean;

import java.io.Serializable;

/**
 * 
 */
public class Share extends BaseBean implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -361912024451658518L;
    private static final String DEFAULT_NUMBER = "1";
    private static final String DEFAULT_PRICE = "1.2";
    private String price;
    private String number;

    public Share() {

        this(DEFAULT_NUMBER, DEFAULT_PRICE);
    }

    public Share(String number) {

        this(number, DEFAULT_PRICE);
    }

    public Share(String number, String price) {

        this.setNumber(number);
        this.setPrice(price);
    }

    /**
     * @return get method for the field number
     */
    public String getNumber() {

        return this.number;
    }

    /**
     * @param number
     *            the number to set
     */
    public void setNumber(String number) {

        this.number = number;
    }

    /**
     * @return get method for the field price
     */
    public String getPrice() {

        return this.price;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(String price) {

        this.price = price;
    }

    public static void main(String[] args) {

        Share s = new Share();
        System.out.println(s);
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        sb.append(getClass().getSimpleName()).append(":[");
        sb.append("number=").append(this.number);
        sb.append(", price=").append(this.price);
        sb.append("]");
        return sb.toString();
    }

}
