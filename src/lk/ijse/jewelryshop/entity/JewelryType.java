package lk.ijse.jewelryshop.entity;

public class JewelryType {
    private String jewelryTypeId;
    private String name;
    private int jewelryQty;

    public JewelryType() {
    }

    public JewelryType(String jewelryTypeId, String name, int jewelryQty) {
        this.jewelryTypeId = jewelryTypeId;
        this.name = name;
        this.jewelryQty = jewelryQty;
    }

    public String getJewelryTypeId() {
        return jewelryTypeId;
    }

    public void setJewelryTypeId(String jewelryTypeId) {
        this.jewelryTypeId = jewelryTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJewelryQty() {
        return jewelryQty;
    }

    public void setJewelryQty(int jewelryQty) {
        this.jewelryQty = jewelryQty;
    }

    @Override
    public String toString() {
        return "JewelryType{" +
                "jewelryTypeId='" + jewelryTypeId + '\'' +
                ", name='" + name + '\'' +
                ", jewelryQty=" + jewelryQty +
                '}';
    }
}
