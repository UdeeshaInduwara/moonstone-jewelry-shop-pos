package lk.ijse.jewelryshop.model;

public class MetalStockDTO {
    private String metalId;
    private String metal;
    private int carat;
    private double weight;
    private String purchaseDate;
    private String businessmanId;
    private String businessmanName;

    public MetalStockDTO() {
    }

    public MetalStockDTO(String metalId, String metal, int carat, double weight, String purchaseDate, String businessmanId, String businessmanName) {
        this.metalId = metalId;
        this.metal = metal;
        this.carat = carat;
        this.weight = weight;
        this.purchaseDate = purchaseDate;
        this.businessmanId = businessmanId;
        this.businessmanName = businessmanName;
    }

    public String getMetalId() {
        return metalId;
    }

    public void setMetalId(String metalId) {
        this.metalId = metalId;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public int getCarat() {
        return carat;
    }

    public void setCarat(int carat) {
        this.carat = carat;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getBusinessmanId() {
        return businessmanId;
    }

    public void setBusinessmanId(String businessmanId) {
        this.businessmanId = businessmanId;
    }

    public String getBusinessmanName() {
        return businessmanName;
    }

    public void setBusinessmanName(String businessmanName) {
        this.businessmanName = businessmanName;
    }

    @Override
    public String toString() {
        return "MetalStockDTO{" +
                "metalId='" + metalId + '\'' +
                ", metal='" + metal + '\'' +
                ", carat=" + carat +
                ", weight=" + weight +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", businessmanId='" + businessmanId + '\'' +
                ", businessmanName='" + businessmanName + '\'' +
                '}';
    }
}
