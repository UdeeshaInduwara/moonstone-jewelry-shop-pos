package lk.ijse.jewelryshop.entity;

public class MetalSuplyDetail {
    private String metalSuplyId;
    private String metalId;
    private String jewelryMakerId;
    private double weight;
    private String suplyDate;

    public MetalSuplyDetail() {
    }

    public MetalSuplyDetail(String metalSuplyId, String metalId, String jewelryMakerId, double weight, String suplyDate) {
        this.metalSuplyId = metalSuplyId;
        this.metalId = metalId;
        this.jewelryMakerId = jewelryMakerId;
        this.weight = weight;
        this.suplyDate = suplyDate;
    }

    public String getMetalSuplyId() {
        return metalSuplyId;
    }

    public void setMetalSuplyId(String metalSuplyId) {
        this.metalSuplyId = metalSuplyId;
    }

    public String getMetalId() {
        return metalId;
    }

    public void setMetalId(String metalId) {
        this.metalId = metalId;
    }

    public String getJewelryMakerId() {
        return jewelryMakerId;
    }

    public void setJewelryMakerId(String jewelryMakerId) {
        this.jewelryMakerId = jewelryMakerId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSuplyDate() {
        return suplyDate;
    }

    public void setSuplyDate(String suplyDate) {
        this.suplyDate = suplyDate;
    }

    @Override
    public String toString() {
        return "MetalSuplyDetail{" +
                "metalSuplyId='" + metalSuplyId + '\'' +
                ", metalId='" + metalId + '\'' +
                ", jewelryMakerId='" + jewelryMakerId + '\'' +
                ", weight=" + weight +
                ", suplyDate='" + suplyDate + '\'' +
                '}';
    }
}
