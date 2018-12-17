package lk.ijse.jewelryshop.entity;




public class Gem {
    private String gemid;
    private double carat;
    private String suplyDate;
    private String makerId;

    public Gem() {
    }

    public Gem(String gemid, double carat, String suplyDate, String makerId) {
        this.gemid = gemid;
        this.carat = carat;
        this.suplyDate = suplyDate;
        this.makerId = makerId;
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

    @Override
    public String toString() {
        return "Gem{" +
                "gemid='" + gemid + '\'' +
                ", carat=" + carat +
                ", suplyDate='" + suplyDate + '\'' +
                ", makerId='" + makerId + '\'' +
                '}';
    }
}
