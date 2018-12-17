package lk.ijse.jewelryshop.model;

public class JewelryMakerDTO {
    private String jmid;
    private String name;
    private String contactNo;

    public String getJmid() {
        return jmid;
    }

    public void setJmid(String jmid) {
        this.jmid = jmid;
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

    public JewelryMakerDTO(String jmid, String name, String contactNo) {
        this.jmid = jmid;
        this.name = name;
        this.contactNo = contactNo;
    }

    public JewelryMakerDTO() {
    }

    @Override
    public String toString() {
        return "JewelryMakerDTO{" +
                "jmid='" + jmid + '\'' +
                ", name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }
}
