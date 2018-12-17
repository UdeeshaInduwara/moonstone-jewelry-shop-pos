package lk.ijse.jewelryshop.entity;

public class JewelryPurchaseDetail {
    private JewelryPurchaseDetail_PK jewelryPurchaseDetail_pk;
    private String jewelryTypeId;
    private String metal;
    private int carat;
    private double weight;
    private double jewelrySize;
    private String embroidedgem;
    private double unitPrice;

    public JewelryPurchaseDetail() {
    }

    public JewelryPurchaseDetail(JewelryPurchaseDetail_PK jewelryPurchaseDetail_pk, String jewelryTypeId, String metal, int carat, double weight, double jewelrySize, String embroidedgem, double unitPrice) {
        this.jewelryPurchaseDetail_pk = jewelryPurchaseDetail_pk;
        this.jewelryTypeId = jewelryTypeId;
        this.metal = metal;
        this.carat = carat;
        this.weight = weight;
        this.jewelrySize = jewelrySize;
        this.embroidedgem = embroidedgem;
        this.unitPrice = unitPrice;
    }

    public JewelryPurchaseDetail(String orderId, String jewelryId, String jewelryTypeId, String metal, int carat, double weight, double jewelrySize, String embroidedgem, double unitPrice) {
        this.jewelryPurchaseDetail_pk = new JewelryPurchaseDetail_PK(orderId,jewelryId);
        this.jewelryTypeId = jewelryTypeId;
        this.metal = metal;
        this.carat = carat;
        this.weight = weight;
        this.jewelrySize = jewelrySize;
        this.embroidedgem = embroidedgem;
        this.unitPrice = unitPrice;
    }

    public JewelryPurchaseDetail_PK getJewelryPurchaseDetail_pk() {
        return jewelryPurchaseDetail_pk;
    }

    public void setJewelryPurchaseDetail_pk(JewelryPurchaseDetail_PK jewelryPurchaseDetail_pk) {
        this.jewelryPurchaseDetail_pk = jewelryPurchaseDetail_pk;
    }

    public String getJewelryTypeId() {
        return jewelryTypeId;
    }

    public void setJewelryTypeId(String jewelryTypeId) {
        this.jewelryTypeId = jewelryTypeId;
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

    public double getJewelrySize() {
        return jewelrySize;
    }

    public void setJewelrySize(double jewelrySize) {
        this.jewelrySize = jewelrySize;
    }

    public String getEmbroidedgem() {
        return embroidedgem;
    }

    public void setEmbroidedgem(String embroidedgem) {
        this.embroidedgem = embroidedgem;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "JewelryPurchaseDetail{" +
                "jewelryPurchaseDetail_pk=" + jewelryPurchaseDetail_pk +
                ", jewelryTypeId='" + jewelryTypeId + '\'' +
                ", metal='" + metal + '\'' +
                ", carat=" + carat +
                ", weight=" + weight +
                ", jewelrySize=" + jewelrySize +
                ", embroidedgem='" + embroidedgem + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
