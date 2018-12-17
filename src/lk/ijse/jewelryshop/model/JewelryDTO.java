package lk.ijse.jewelryshop.model;

public class JewelryDTO {
    private String jewelryId;
    private String metal;
    private int carat;
    private double weight;
    private double jewelrySize;
    private String embroidedgem;
    private double price;
    private String jewelryTypeId;

    public JewelryDTO() {
    }

    public JewelryDTO(String jewelryId, String metal, int carat, double weight, double jewelrySize, String embroidedgem, double price, String jewelryTypeId) {
        this.jewelryId = jewelryId;
        this.metal = metal;
        this.carat = carat;
        this.weight = weight;
        this.jewelrySize = jewelrySize;
        this.embroidedgem = embroidedgem;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getJewelryTypeId() {
        return jewelryTypeId;
    }

    public void setJewelryTypeId(String jewelryTypeId) {
        this.jewelryTypeId = jewelryTypeId;
    }

    @Override
    public String toString() {
        return "JewelryDTO{" +
                "jewelryId='" + jewelryId + '\'' +
                ", metal='" + metal + '\'' +
                ", carat=" + carat +
                ", weight=" + weight +
                ", jewelrySize=" + jewelrySize +
                ", embroidedgem='" + embroidedgem + '\'' +
                ", price=" + price +
                ", jewelryTypeId='" + jewelryTypeId + '\'' +
                '}';
    }
}
