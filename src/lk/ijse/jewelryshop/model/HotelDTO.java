package lk.ijse.jewelryshop.model;

public class HotelDTO {
    private String hid;
    private String name;
    private String contactNo;
    private String city;

    public HotelDTO(String hid, String name, String contactNo, String city) {
        this.hid = hid;
        this.name = name;
        this.contactNo = contactNo;
        this.city = city;
    }

    public HotelDTO() {
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHid() {

        return hid;
    }

    public String getName() {
        return name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "HotelDTO{" +
                "hid='" + hid + '\'' +
                ", name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
