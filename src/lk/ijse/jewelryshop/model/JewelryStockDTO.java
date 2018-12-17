package lk.ijse.jewelryshop.model;

public class JewelryStockDTO {
    private String jewelryType;
    private String jewelryTypeId;
    private String jewelryId;
    private String metal;
    private int carat;
    private double weight;
    private double size;
    private String gem;
    private double price;
    private String makerId;
    private String makerName;
    private String date;

    public JewelryStockDTO() {
    }

    public JewelryStockDTO(String jewelryType, String jewelryTypeId, String jewelryId, String metal, int carat, double weight, double size, String gem, double price, String makerId, String makerName, String date) {
        this.jewelryType = jewelryType;
        this.jewelryTypeId = jewelryTypeId;
        this.jewelryId = jewelryId;
        this.metal = metal;
        this.carat = carat;
        this.weight = weight;
        this.size = size;
        this.gem = gem;
        this.price = price;
        this.makerId = makerId;
        this.makerName = makerName;
        this.date = date;
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

    public String getMakerId() {
        return makerId;
    }

    public void setMakerId(String makerId) {
        this.makerId = makerId;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "JewelryStockDTO{" +
                "jewelryType='" + jewelryType + '\'' +
                ", jewelryTypeId='" + jewelryTypeId + '\'' +
                ", jewelryId='" + jewelryId + '\'' +
                ", metal='" + metal + '\'' +
                ", carat=" + carat +
                ", weight=" + weight +
                ", size=" + size +
                ", gem='" + gem + '\'' +
                ", price=" + price +
                ", makerId='" + makerId + '\'' +
                ", makerName='" + makerName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
