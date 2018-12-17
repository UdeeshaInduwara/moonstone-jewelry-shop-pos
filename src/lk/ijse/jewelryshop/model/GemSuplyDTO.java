package lk.ijse.jewelryshop.model;

public class GemSuplyDTO {
    private String gemid;
    private double carat;
    private String suplyDate;
    private String makerId;
    private String makerName;

    public GemSuplyDTO(String gemid, double carat, String suplyDate, String makerId, String makerName) {
        this.gemid = gemid;
        this.carat = carat;
        this.suplyDate = suplyDate;
        this.makerId = makerId;
        this.makerName = makerName;
    }

    public String getGemid() {
        return gemid;
    }

    public void setGemid(String gemid) {
        this.gemid = gemid;
    }

    public double getCarat() {
        return carat;
    }

    public void setCarat(double carat) {
        this.carat = carat;
    }

    public String getSuplyDate() {
        return suplyDate;
    }

    public void setSuplyDate(String suplyDate) {
        this.suplyDate = suplyDate;
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

    @Override
    public String toString() {
        return "GemSuplyDTO{" +
                "gemid='" + gemid + '\'' +
                ", carat=" + carat +
                ", suplyDate='" + suplyDate + '\'' +
                ", makerId='" + makerId + '\'' +
                ", makerName='" + makerName + '\'' +
                '}';
    }
}
