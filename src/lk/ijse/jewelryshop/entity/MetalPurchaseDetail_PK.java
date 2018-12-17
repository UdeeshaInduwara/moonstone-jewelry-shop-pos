package lk.ijse.jewelryshop.entity;

public class MetalPurchaseDetail_PK {
    private String metalId;
    private String metalBusinessmanId;

    public MetalPurchaseDetail_PK() {
    }

    public MetalPurchaseDetail_PK(String metalId, String metalBusinessmanId) {
        this.metalId = metalId;
        this.metalBusinessmanId = metalBusinessmanId;
    }

    public String getMetalId() {
        return metalId;
    }

    public void setMetalId(String metalId) {
        this.metalId = metalId;
    }

    public String getMetalBusinessmanId() {
        return metalBusinessmanId;
    }

    public void setMetalBusinessmanId(String metalBusinessmanId) {
        this.metalBusinessmanId = metalBusinessmanId;
    }

}
