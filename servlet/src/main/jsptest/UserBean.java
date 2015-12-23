package jsptest;

public class UserBean {

    private int userId;
    private String userName;
    private Address address;

    @Override
    public String toString() {

        return "UserBean:[userId=" + userId + ",userName=" + userName + ",address=" + address + "]";
    }

    /**
     * @return get method for the field address
     */
    public Address getAddress() {

        return this.address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(Address address) {

        this.address = address;
    }

    /**
     * @return get method for the field userId
     */
    public int getUserId() {

        return this.userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(int userId) {

        this.userId = userId;
    }

    /**
     * @return get method for the field userName
     */
    public String getUserName() {

        return this.userName;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {

        this.userName = userName;
    }
}
