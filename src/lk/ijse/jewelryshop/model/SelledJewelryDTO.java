package lk.ijse.jewelryshop.model;

public class SelledJewelryDTO {
    private String jewelryTypeId;
    private String jewelryType;
    private String jewelryId;
    private String metal;
    private int carat;
    private double weight;
    private double size;
    private String gem;
    private String purchaseDate;
    private String customerId;
    private String customerName;
    private double price;

    public SelledJewelryDTO() {
    }

    public SelledJewelryDTO(String jewelryTypeId, String jewelryType, String jewelryId, String metal, int carat, double weight, double size, String gem, String purchaseDate, String customerId, String customerName, double price) {
        this.jewelryTypeId = jewelryTypeId;
        this.jewelryType = jewelryType;
        this.jewelryId = jewelryId;
        this.metal = metal;
        this.carat = carat;
        this.weight = weight;
        this.size = size;
        this.gem = gem;
        this.purchaseDate = purchaseDate;
        this.customerId = customerId;
        this.customerName = customerName;
        this.price = price;
    }

    public String getJewelryType() {
        return jewelryType;
    }

    public void setJewelryType(String jewelryType) {
        this.jewelryType = jewelryType;
    }

    public String getJewelryTypeId() {
        return jewelryTypeId;
    }

    public void setJewelryTypeId(String jewelryTypeId) {
        this.jewelryTypeId = jewelryTypeId;
    }

    public String getJewelryId() {
        return jewelryId;
    }

    public void setJewelryId(String jewelryId) {
        this.jewelryId = jewelryId;
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

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getGem() {
        return gem;
    }

    public void setGem(String gem) {
        this.gem = gem;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "SelledJewelryDTO{" +
                "jewelryType='" + jewelryType + '\'' +
                ", jewelryTypeId='" + jewelryTypeId + '\'' +
                ", jewelryId='" + jewelryId + '\'' +
                ", metal='" + metal + '\'' +
                ", carat=" + carat +
                ", weight=" + weight +
                ", size=" + size +
                ", gem='" + gem + '\'' +
                ", price=" + price +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
