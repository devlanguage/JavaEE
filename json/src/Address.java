public class Address {

    String city;
    String street;
    private String zip;
    private String phoneNumber1;
    private String phoneNumber2;

    public Address(String street, String city, String zip, String phone1, String phone2) {
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.phoneNumber1 = phone1;
        this.phoneNumber2 = phone2;

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
     * @return get method for the field phoneNumber1
     */
    public String getPhoneNumber1() {

        return this.phoneNumber1;
    }

    /**
     * @param phoneNumber1
     *            the phoneNumber1 to set
     */
    public void setPhoneNumber1(String phoneNumber1) {

        this.phoneNumber1 = phoneNumber1;
    }

    /**
     * @return get method for the field phoneNumber2
     */
    public String getPhoneNumber2() {

        return this.phoneNumber2;
    }

    /**
     * @param phoneNumber2
     *            the phoneNumber2 to set
     */
    public void setPhoneNumber2(String phoneNumber2) {

        this.phoneNumber2 = phoneNumber2;
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

    /**
     * @return get method for the field zip1
     */
    public String getZip() {

        return this.zip;
    }

    /**
     * @param zip1
     *            the zip1 to set
     */
    public void setZip(String zip1) {

        this.zip = zip1;
    }

}
