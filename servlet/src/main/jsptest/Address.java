package jsptest;

public class Address {

    private String city = "DEFAULT_CITY";
    private String street = "DEFAULT_STREET";
    private String lane = "DEFAULT_LANE";

    @Override
    public String toString() {

        return "Address:[city=" + city + ",street=" + street + ",lane=" + lane + "]";
    }

    /**
     * @return get method for the field city
     */
    public String getCity() {

        return this.city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(String city) {

        this.city = city;
    }

    /**
     * @return get method for the field lane
     */
    public String getLane() {

        return this.lane;
    }

    /**
     * @param lane
     *            the lane to set
     */
    public void setLane(String lane) {

        this.lane = lane;
    }

    /**
     * @return get method for the field street
     */
    public String getStreet() {

        return this.street;
    }

    /**
     * @param street
     *            the street to set
     */
    public void setStreet(String street) {

        this.street = street;
    }
}
