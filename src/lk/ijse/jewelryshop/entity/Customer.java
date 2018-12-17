package lk.ijse.jewelryshop.entity;

public class Customer {
    private String customerId;
    private String passportNo;
    private String name;
    private String country;
    private String senderId;

    public Customer() {
    }

    public Customer(String customerId, String passportNo, String name, String country, String senderId) {
        this.customerId = customerId;
        this.passportNo = passportNo;
        this.name = name;
        this.country = country;
        this.senderId = senderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", passportNo='" + passportNo + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", senderId='" + senderId + '\'' +
                '}';
    }
}
