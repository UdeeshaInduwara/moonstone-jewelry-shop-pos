package lk.ijse.jewelryshop.model;

public class MetalBusinessmanDTO {
    private String metbid;
    private String name;
    private String contactNo;
    private String address;

    public MetalBusinessmanDTO() {
    }

    public MetalBusinessmanDTO(String metbid, String name, String contactNo, String address) {
        this.metbid = metbid;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
    }

    public String getMetbid() {
        return metbid;
    }

    public void setMetbid(String metbid) {
        this.metbid = metbid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "MetalBusinessmanDTO{" +
                "metbid='" + metbid + '\'' +
                ", name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
