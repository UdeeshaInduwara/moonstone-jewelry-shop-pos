package lk.ijse.jewelryshop.entity;

public class Hotel {
    private String hid;
    private String name;
    private String city;
    private String contactNo;

    @Override
    public String toString() {
        return "Hotel{" +
                "hid='" + hid + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Hotel(String hid, String name, String city, String contactNo) {

        this.hid = hid;
        this.name = name;
        this.city = city;
        this.contactNo = contactNo;
    }

    public Hotel() {

    }
}
