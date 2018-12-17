package lk.ijse.jewelryshop.model;

public class SalesReportDTO {
    private String typeName;
    private int totalCount;

    public SalesReportDTO() {
    }

    public SalesReportDTO(String typeName, int totalCount) {
        this.typeName = typeName;
        this.totalCount = totalCount;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "SalesReportDTO{" +
                "typeName='" + typeName + '\'' +
                ", totalCount=" + totalCount +
                '}';
    }
}
