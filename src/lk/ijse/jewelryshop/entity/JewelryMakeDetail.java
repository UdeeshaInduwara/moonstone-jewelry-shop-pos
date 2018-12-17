package lk.ijse.jewelryshop.entity;

public class JewelryMakeDetail {
    private JewelryMakeDetail_PK jewelryMakeDetail_pk;
    private String date;

    public JewelryMakeDetail() {
    }

    public JewelryMakeDetail(JewelryMakeDetail_PK jewelryMakeDetail_pk, String date) {
        this.jewelryMakeDetail_pk = jewelryMakeDetail_pk;
        this.date = date;
    }
    public JewelryMakeDetail(String jewlryId, String jewelryMakerId, String date) {
        this.jewelryMakeDetail_pk = new JewelryMakeDetail_PK(jewlryId,jewelryMakerId);
        this.date = date;
    }

    public JewelryMakeDetail_PK getJewelryMakeDetail_pk() {
        return jewelryMakeDetail_pk;
    }

    public void setJewelryMakeDetail_pk(JewelryMakeDetail_PK jewelryMakeDetail_pk) {
        this.jewelryMakeDetail_pk = jewelryMakeDetail_pk;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "JewelryMakeDetail{" +
                "jewelryMakeDetail_pk=" + jewelryMakeDetail_pk +
                ", date='" + date + '\'' +
                '}';
    }
}
