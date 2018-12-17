package lk.ijse.jewelryshop.entity;

public class MetalPurchaseDetail {
    private MetalPurchaseDetail_PK metalPurchaseDetail_pk;
    private double weight;
    private String purchaseDate;

    public MetalPurchaseDetail() {
    }

    public MetalPurchaseDetail(MetalPurchaseDetail_PK metalPurchaseDetail_pk, double weight, String purchaseDate) {
        this.metalPurchaseDetail_pk = metalPurchaseDetail_pk;
        this.weight = weight;
        this.purchaseDate = purchaseDate;
    }

    public MetalPurchaseDetail(String metalId, String metalBusinessmanId, double weight, String purchaseDate) {
        this.metalPurchaseDetail_pk = new MetalPurchaseDetail_PK(metalId,metalBusinessmanId);
        this.weight = weight;
        this.purchaseDate = purchaseDate;
    }

    public MetalPurchaseDetail_PK getMetalPurchaseDetail_pk() {
        return metalPurchaseDetail_pk;
    }

    public void setMetalPurchaseDetail_pk(MetalPurchaseDetail_PK metalPurchaseDetail_pk) {
        this.metalPurchaseDetail_pk = metalPurchaseDetail_pk;
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

    @Override
    public String toString() {
        return "MetalPurchaseDetail{" +
                "metalPurchaseDetail_pk=" + metalPurchaseDetail_pk +
                ", weight=" + weight +
                ", purchaseDate='" + purchaseDate + '\'' +
                '}';
    }
}
