package lk.ijse.jewelryshop.entity;

public class JewelryPurchaseDetail_PK {
    String orderId;
    String jewelryId;

    public JewelryPurchaseDetail_PK() {
    }

    public JewelryPurchaseDetail_PK(String orderId, String jewelryId) {
        this.orderId = orderId;
        this.jewelryId = jewelryId;
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
}
