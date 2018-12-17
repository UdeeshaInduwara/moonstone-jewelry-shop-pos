package lk.ijse.jewelryshop.model;

public class MetalDTO {
    private String metid;
    private String metalType;
    private int carat;
    private double availableWeight;

    public MetalDTO() {
    }

    public MetalDTO(String metid, String metalType, int carat, double availableWeight) {
        this.metid = metid;
        this.metalType = metalType;
        this.carat = carat;
        this.availableWeight = availableWeight;
    }

    public String getMetid() {
        return metid;
    }

    public void setMetid(String metid) {
        this.metid = metid;
    }

    public String getMetalType() {
        return metalType;
    }

    public void setMetalType(String metalType) {
        this.metalType = metalType;
    }

    public int getCarat() {
        return carat;
    }

    public void setCarat(int carat) {
        this.carat = carat;
    }

    public double getAvailableWeight() {
        return availableWeight;
    }

    public void setAvailableWeight(double availableWeight) {
        this.availableWeight = availableWeight;
    }

    @Override
    public String toString() {
        return "MetalDTO{" +
                "metid='" + metid + '\'' +
                ", metalType='" + metalType + '\'' +
                ", carat=" + carat +
                ", availableWeight=" + availableWeight +
                '}';
    }
}
