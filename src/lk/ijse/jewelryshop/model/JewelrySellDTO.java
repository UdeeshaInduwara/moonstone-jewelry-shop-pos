package lk.ijse.jewelryshop.model;

import java.util.ArrayList;

public class JewelrySellDTO {
    private String orderId;
    private String sellingDate;
    private String customerId;
    private String customerName;
    private String passportNo;
    private String country;
    private String hotelId;
    private String paymentId;
    private double amount;
    private double discount;
    private ArrayList<JewelryPurchaseDetailDTO> jewelryPurchaseDetailDTOS;

    public JewelrySellDTO() {
    }

    public JewelrySellDTO(String orderId, String sellingDate, String customerId, String customerName, String passportNo, String country, String hotelId, String paymentId, double amount, double discount, ArrayList<JewelryPurchaseDetailDTO> jewelryPurchaseDetailDTOS) {
        this.orderId = orderId;
        this.sellingDate = sellingDate;
        this.customerId = customerId;
        this.customerName = customerName;
        this.passportNo = passportNo;
        this.country = country;
        this.hotelId = hotelId;
        this.paymentId = paymentId;
        this.amount = amount;
        this.discount = discount;
        this.jewelryPurchaseDetailDTOS = jewelryPurchaseDetailDTOS;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(String sellingDate) {
        this.sellingDate = sellingDate;
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

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public ArrayList<JewelryPurchaseDetailDTO> getJewelryPurchaseDetailDTOS() {
        return jewelryPurchaseDetailDTOS;
    }

    public void setJewelryPurchaseDetailDTOS(ArrayList<JewelryPurchaseDetailDTO> jewelryPurchaseDetailDTOS) {
        this.jewelryPurchaseDetailDTOS = jewelryPurchaseDetailDTOS;
    }

    @Override
    public String toString() {
        return "JewelrySellDTO{" +
                "orderId='" + orderId + '\'' +
                ", sellingDate='" + sellingDate + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", passportNo='" + passportNo + '\'' +
                ", country='" + country + '\'' +
                ", hotelId='" + hotelId + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", discount=" + discount +
                ", jewelryPurchaseDetailDTOS=" + jewelryPurchaseDetailDTOS +
                '}';
    }
}
