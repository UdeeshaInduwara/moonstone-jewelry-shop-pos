package lk.ijse.jewelryshop.entity;

public class CustomEntity {
    private String gemid;
    private double carat;
    private String suplyDate;
    private String makerId;
    private String makerName;

    private String metalId;
    private String metal;
    private int metalCarat;
    private double weight;
    private String purchaseDate;
    private String businessmanId;
    private String businessmanName;

    private String jewelryType;
    private String jewelryTypeId;
    private String jewelryId;
    private String jewelryMetal;
    private int jewelryCarat;
    private double jewelryWeight;
    private double jewelrySize;
    private String jewelryEmbGem;
    private double jewelryPrice;
    private String jewelryMakerId;
    private String jewelryMakerName;
    private String date;

    private String metalSuplyId;
    private String supliedMetalId;
    private String supliedMetal;
    private int supliedCarat;
    private double supliedWeight;
    private String supliedMetalMakerId;
    private String supliedMetalMakerName;
    private String metalSupliedDate;

    private String selledJewelryTypeId;
    private String selledJewelryType;
    private String selledJewelryId;
    private String selledJewelryMetal;
    private int selledJewelryCarat;
    private double selledJewelryWeight;
    private double selledJewelrySize;
    private String selledJewelryGem;
    private String selledDate;
    private String selledCustomerId;
    private String selledCustomerName;
    private double selledPrice;

    private String typeName;
    private int totalCount;

    public CustomEntity(String typeName, int totalCount) {
        this.typeName = typeName;
        this.totalCount = totalCount;
    }

    public CustomEntity(String selledJewelryTypeId, String selledJewelryType, String selledJewelryId, String selledJewelryMetal, int selledJewelryCarat, double selledJewelryWeight, double selledJewelrySize, String selledJewelryGem, String selledDate, String selledCustomerId, String selledCustomerName, double selledPrice) {
        this.selledJewelryTypeId = selledJewelryTypeId;
        this.selledJewelryType = selledJewelryType;
        this.selledJewelryId = selledJewelryId;
        this.selledJewelryMetal = selledJewelryMetal;
        this.selledJewelryCarat = selledJewelryCarat;
        this.selledJewelryWeight = selledJewelryWeight;
        this.selledJewelrySize = selledJewelrySize;
        this.selledJewelryGem = selledJewelryGem;
        this.selledDate = selledDate;
        this.selledCustomerId = selledCustomerId;
        this.selledCustomerName = selledCustomerName;
        this.selledPrice = selledPrice;
    }

    public CustomEntity(String metalSuplyId, String supliedMetalId, String supliedMetal, int supliedCarat, double supliedWeight, String supliedMetalMakerId, String supliedMetalMakerName, String metalSupliedDate) {
        this.metalSuplyId = metalSuplyId;
        this.supliedMetalId = supliedMetalId;
        this.supliedMetal = supliedMetal;
        this.supliedCarat = supliedCarat;
        this.supliedWeight = supliedWeight;
        this.supliedMetalMakerId = supliedMetalMakerId;
        this.supliedMetalMakerName = supliedMetalMakerName;
        this.metalSupliedDate = metalSupliedDate;
    }

    public CustomEntity(String jewelryType, String jewelryTypeId, String jewelryId, String jewelryMetal, int jewelryCarat, double jewelryWeight, double jewelrySize, String jewelryEmbGem, double jewelryPrice, String jewelryMakerId, String jewelryMakerName, String date) {
        this.jewelryType = jewelryType;
        this.jewelryTypeId = jewelryTypeId;
        this.jewelryId = jewelryId;
        this.jewelryMetal = jewelryMetal;
        this.jewelryCarat = jewelryCarat;
        this.jewelryWeight = jewelryWeight;
        this.jewelrySize = jewelrySize;
        this.jewelryEmbGem = jewelryEmbGem;
        this.jewelryPrice = jewelryPrice;
        this.jewelryMakerId = jewelryMakerId;
        this.jewelryMakerName = jewelryMakerName;
        this.date = date;
    }

    public CustomEntity(String gemid, double carat, String suplyDate, String makerId, String makerName) {
        this.gemid = gemid;
        this.carat = carat;
        this.suplyDate = suplyDate;
        this.makerId = makerId;
        this.makerName = makerName;
    }

    public CustomEntity(String metalId, String metal, int metalCarat, double weight, String purchaseDate, String businessmanId, String businessmanName) {
        this.metalId = metalId;
        this.metal = metal;
        this.metalCarat = metalCarat;
        this.weight = weight;
        this.purchaseDate = purchaseDate;
        this.businessmanId = businessmanId;
        this.businessmanName = businessmanName;
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

    public String getSelledJewelryTypeId() {
        return selledJewelryTypeId;
    }

    public void setSelledJewelryTypeId(String selledJewelryTypeId) {
        this.selledJewelryTypeId = selledJewelryTypeId;
    }

    public String getSelledJewelryType() {
        return selledJewelryType;
    }

    public void setSelledJewelryType(String selledJewelryType) {
        this.selledJewelryType = selledJewelryType;
    }

    public String getSelledJewelryId() {
        return selledJewelryId;
    }

    public void setSelledJewelryId(String selledJewelryId) {
        this.selledJewelryId = selledJewelryId;
    }

    public String getSelledJewelryMetal() {
        return selledJewelryMetal;
    }

    public void setSelledJewelryMetal(String selledJewelryMetal) {
        this.selledJewelryMetal = selledJewelryMetal;
    }

    public int getSelledJewelryCarat() {
        return selledJewelryCarat;
    }

    public void setSelledJewelryCarat(int selledJewelryCarat) {
        this.selledJewelryCarat = selledJewelryCarat;
    }

    public double getSelledJewelryWeight() {
        return selledJewelryWeight;
    }

    public void setSelledJewelryWeight(double selledJewelryWeight) {
        this.selledJewelryWeight = selledJewelryWeight;
    }

    public double getSelledJewelrySize() {
        return selledJewelrySize;
    }

    public void setSelledJewelrySize(double selledJewelrySize) {
        this.selledJewelrySize = selledJewelrySize;
    }

    public String getSelledJewelryGem() {
        return selledJewelryGem;
    }

    public void setSelledJewelryGem(String selledJewelryGem) {
        this.selledJewelryGem = selledJewelryGem;
    }

    public String getSelledDate() {
        return selledDate;
    }

    public void setSelledDate(String selledDate) {
        this.selledDate = selledDate;
    }

    public String getSelledCustomerId() {
        return selledCustomerId;
    }

    public void setSelledCustomerId(String selledCustomerId) {
        this.selledCustomerId = selledCustomerId;
    }

    public String getSelledCustomerName() {
        return selledCustomerName;
    }

    public void setSelledCustomerName(String selledCustomerName) {
        this.selledCustomerName = selledCustomerName;
    }

    public double getSelledPrice() {
        return selledPrice;
    }

    public void setSelledPrice(double selledPrice) {
        this.selledPrice = selledPrice;
    }

    public String getMetalSuplyId() {
        return metalSuplyId;
    }

    public void setMetalSuplyId(String metalSuplyId) {
        this.metalSuplyId = metalSuplyId;
    }

    public String getGemid() { return gemid; }

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

    public int getMetalCarat() {
        return metalCarat;
    }

    public void setMetalCarat(int metalCarat) {
        this.metalCarat = metalCarat;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getBusinessmanId() {
        return businessmanId;
    }

    public void setBusinessmanId(String businessmanId) {
        this.businessmanId = businessmanId;
    }

    public String getBusinessmanName() {
        return businessmanName;
    }

    public void setBusinessmanName(String businessmanName) {
        this.businessmanName = businessmanName;
    }

    public String getJewelryType() {
        return jewelryType;
    }

    public void setJewelryType(String jewelryType) {
        this.jewelryType = jewelryType;
    }

    public String getJewelryTypeId() {
        return jewelryTypeId;
    }

    public void setJewelryTypeId(String jewelryTypeId) {
        this.jewelryTypeId = jewelryTypeId;
    }

    public String getJewelryId() {
        return jewelryId;
    }

    public void setJewelryId(String jewelryId) {
        this.jewelryId = jewelryId;
    }

    public String getJewelryMetal() {
        return jewelryMetal;
    }

    public void setJewelryMetal(String jewelryMetal) {
        this.jewelryMetal = jewelryMetal;
    }

    public int getJewelryCarat() {
        return jewelryCarat;
    }

    public void setJewelryCarat(int jewelryCarat) {
        this.jewelryCarat = jewelryCarat;
    }

    public double getJewelryWeight() {
        return jewelryWeight;
    }

    public void setJewelryWeight(double jewelryWeight) {
        this.jewelryWeight = jewelryWeight;
    }

    public double getJewelrySize() {
        return jewelrySize;
    }

    public void setJewelrySize(double jewelrySize) {
        this.jewelrySize = jewelrySize;
    }

    public String getJewelryEmbGem() {
        return jewelryEmbGem;
    }

    public void setJewelryEmbGem(String jewelryEmbGem) {
        this.jewelryEmbGem = jewelryEmbGem;
    }

    public double getJewelryPrice() {
        return jewelryPrice;
    }

    public void setJewelryPrice(double jewelryPrice) {
        this.jewelryPrice = jewelryPrice;
    }

    public String getJewelryMakerId() {
        return jewelryMakerId;
    }

    public void setJewelryMakerId(String jewelryMakerId) {
        this.jewelryMakerId = jewelryMakerId;
    }

    public String getJewelryMakerName() {
        return jewelryMakerName;
    }

    public void setJewelryMakerName(String jewelryMakerName) {
        this.jewelryMakerName = jewelryMakerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSupliedMetalId() {
        return supliedMetalId;
    }

    public void setSupliedMetalId(String supliedMetalId) {
        this.supliedMetalId = supliedMetalId;
    }

    public String getSupliedMetal() {
        return supliedMetal;
    }

    public void setSupliedMetal(String supliedMetal) {
        this.supliedMetal = supliedMetal;
    }

    public int getSupliedCarat() {
        return supliedCarat;
    }

    public void setSupliedCarat(int supliedCarat) {
        this.supliedCarat = supliedCarat;
    }

    public double getSupliedWeight() {
        return supliedWeight;
    }

    public void setSupliedWeight(double supliedWeight) {
        this.supliedWeight = supliedWeight;
    }

    public String getSupliedMetalMakerId() {
        return supliedMetalMakerId;
    }

    public void setSupliedMetalMakerId(String supliedMetalMakerId) {
        this.supliedMetalMakerId = supliedMetalMakerId;
    }

    public String getSupliedMetalMakerName() {
        return supliedMetalMakerName;
    }

    public void setSupliedMetalMakerName(String supliedMetalMakerName) {
        this.supliedMetalMakerName = supliedMetalMakerName;
    }

    public String getMetalSupliedDate() {
        return metalSupliedDate;
    }

    public void setMetalSupliedDate(String metalSupliedDate) {
        this.metalSupliedDate = metalSupliedDate;
    }
}
