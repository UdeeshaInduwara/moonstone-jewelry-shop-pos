package lk.ijse.jewelryshop.model;

public class JewelrySalesTableDTO {
    private String jewelryType;
    private String jewelryId;
    private double unitPrice;

    public JewelrySalesTableDTO() {
    }

    public JewelrySalesTableDTO(String jewelryType, String jewelryId, double unitPrice) {
        this.jewelryType = jewelryType;
        this.jewelryId = jewelryId;
        this.unitPrice = unitPrice;
    }

    public String getJewelryType() {
        return jewelryType;
    }

    public void setJewelryType(String jewelryType) {
        this.jewelryType = jewelryType;
    }

    public String getJewelryId() {
        return jewelryId;
    }

    public void setJewelryId(String jewelryId) {
        this.jewelryId = jewelryId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "JewelrySalesTableDTO{" +
                "jewelryType='" + jewelryType + '\'' +
                ", jewelryId='" + jewelryId + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
