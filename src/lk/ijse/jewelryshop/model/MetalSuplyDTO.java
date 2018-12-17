package lk.ijse.jewelryshop.model;

public class MetalSuplyDTO {
    private String metalSuplyId;
    private String metalId;
    private String metal;
    private int carat;
    private double supliedWeight;
    private String makerId;
    private String makerName;
    private String supliedDate;

    public MetalSuplyDTO() {
    }

    public MetalSuplyDTO(String metalSuplyId, String metalId, String metal, int carat, double supliedWeight, String makerId, String makerName, String supliedDate) {
        this.metalSuplyId = metalSuplyId;
        this.metalId = metalId;
        this.metal = metal;
        this.carat = carat;
        this.supliedWeight = supliedWeight;
        this.makerId = makerId;
        this.makerName = makerName;
        this.supliedDate = supliedDate;
    }

    public String getMetalId() {
        return metalId;
    }

    public void setMetalId(String metalId) {
        this.metalId = metalId;
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

    public double getSupliedWeight() {
        return supliedWeight;
    }

    public void setSupliedWeight(double supliedWeight) {
        this.supliedWeight = supliedWeight;
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

    public String getSupliedDate() {
        return supliedDate;
    }

    public void setSupliedDate(String supliedDate) {
        this.supliedDate = supliedDate;
    }

    public String getMetalSuplyId() {
        return metalSuplyId;
    }

    public void setMetalSuplyId(String metalSuplyId) {
        this.metalSuplyId = metalSuplyId;
    }

    @Override
    public String toString() {
        return "MetalSuplyDTO{" +
                "metalSuplyId='" + metalSuplyId + '\'' +
                ", metalId='" + metalId + '\'' +
                ", metal='" + metal + '\'' +
                ", carat=" + carat +
                ", supliedWeight=" + supliedWeight +
                ", makerId='" + makerId + '\'' +
                ", makerName='" + makerName + '\'' +
                ", supliedDate='" + supliedDate + '\'' +
                '}';
    }
}
