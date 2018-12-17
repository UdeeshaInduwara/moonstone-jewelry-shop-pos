package lk.ijse.jewelryshop.entity;

public class JewelryMakeDetail_PK {
    private String jewlryId;
    private String jewelryMakerId;

    public JewelryMakeDetail_PK() {
    }

    public JewelryMakeDetail_PK(String jewlryId, String jewelryMakerId) {
        this.jewlryId = jewlryId;
        this.jewelryMakerId = jewelryMakerId;
    }

    public String getJewlryId() {
        return jewlryId;
    }

    public void setJewlryId(String jewlryId) {
        this.jewlryId = jewlryId;
    }

    public String getJewelryMakerId() {
        return jewelryMakerId;
    }

    public void setJewelryMakerId(String jewelryMakerId) {
        this.jewelryMakerId = jewelryMakerId;
    }
}
