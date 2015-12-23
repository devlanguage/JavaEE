/**
 * 
 */
package sample.pojo.data;

/**
 * @author ygong
 * 
 */
public class Address {

    private String city;
    private String postCode;

    @Override
    public String toString() {

        return new StringBuffer(this.getClass().getName()).append(":[city=").append(this.city)
                .append(", postCode=").append(this.postCode).append("]").toString();
    }

    /**
     * @return the city
     */
    public String getCity() {

        return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(String city) {

        this.city = city;
    }

    /**
     * @return the postCode
     */
    public String getPostCode() {

        return postCode;
    }

    /**
     * @param postCode
     *            the postCode to set
     */
    public void setPostCode(String postCode) {

        this.postCode = postCode;
    }

}
