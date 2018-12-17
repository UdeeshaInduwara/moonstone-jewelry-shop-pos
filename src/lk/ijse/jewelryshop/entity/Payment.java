package lk.ijse.jewelryshop.entity;

public class Payment {
    String paymentId;
    String orderId;
    double amount;
    double discount;

    public Payment() {
    }

    public Payment(String paymentId, String orderId, double amount, double discount) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.discount = discount;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", discount=" + discount +
                '}';
    }
}
