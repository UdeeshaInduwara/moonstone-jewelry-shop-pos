package lk.ijse.jewelryshop.model;

public class JewelryPurchaseDetailDTO {
    private String orderId;
    private String jewelryId;
    private double unitPrice;

    public JewelryPurchaseDetailDTO() {
    }

    public JewelryPurchaseDetailDTO(String orderId, String jewelryId, double unitPrice) {
        this.orderId = orderId;
        this.jewelryId = jewelryId;
        this.unitPrice = unitPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
        return "JewelryPurchaseDetailDTO{" +
                "orderId='" + orderId + '\'' +
                ", jewelryId='" + jewelryId + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
