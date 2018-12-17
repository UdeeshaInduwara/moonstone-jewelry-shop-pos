package lk.ijse.jewelryshop.model;

public class JewelryTypeDTO {
    private String jewelryTypeId;
    private String name;
    private int quantity;

    public JewelryTypeDTO() {
    }

    public JewelryTypeDTO(String jewelryTypeId, String name, int quantity) {
        this.jewelryTypeId = jewelryTypeId;
        this.name = name;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "JewelryTypeDTO{" +
                "jewelryTypeId='" + jewelryTypeId + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
