package lk.ijse.jewelryshop.dao.custom;

import lk.ijse.jewelryshop.dao.SuperDAO;
import lk.ijse.jewelryshop.entity.CustomEntity;

import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    public ArrayList<CustomEntity> getAllGemDetails() throws Exception;
    public ArrayList<CustomEntity> getMetalStokDetail() throws Exception;
    public ArrayList<CustomEntity> getJewelryStockDetail() throws Exception;
    public ArrayList<CustomEntity> getAllMetalSuplies() throws Exception;

    public ArrayList<CustomEntity> searchGemDetailUsingCarat(double carat) throws Exception;
    public ArrayList<CustomEntity> searchGemDetailUsingGemId(String gemId) throws Exception;
    public ArrayList<CustomEntity> searchGemDetailUsingMakerId(String makerId) throws Exception;
    public ArrayList<CustomEntity> searchGemDetailUsingMakerName(String makerName) throws Exception;
    public ArrayList<CustomEntity> searchGemDetailUsingSuplyDate(String suplyDate) throws Exception;

    public ArrayList<CustomEntity> searchMetalStockUsingBusinessmanId(String id) throws Exception;
    public ArrayList<CustomEntity> searchMetalStockUsingBusinessmanName(String name) throws Exception;
    public ArrayList<CustomEntity> searchMetalStockUsingCarat(int carat) throws Exception;
    public ArrayList<CustomEntity> searchMetalStockUsingMetal(String metal) throws Exception;
    public ArrayList<CustomEntity> searchMetalStockUsingMetalId(String id) throws Exception;
    public ArrayList<CustomEntity> searchMetalStockUsingPurchaseDate(String date) throws Exception;
    public ArrayList<CustomEntity> searchMetalStockUsingWeight(double weight) throws Exception;

    public ArrayList<CustomEntity> searchMetalSuplyUsingCarat(int carat) throws Exception;
    public ArrayList<CustomEntity> searchMetalSuplyUsingMakerId(String makerId) throws Exception;
    public ArrayList<CustomEntity> searchMetalSuplyUsingMakerName(String makerName) throws Exception;
    public ArrayList<CustomEntity> searchMetalSuplyUsingMetal(String metal) throws Exception;
    public ArrayList<CustomEntity> searchMetalSuplyUsingMetalId(String metalId) throws Exception;
    public ArrayList<CustomEntity> searchMetalSuplyUsingSuplyDate(String date) throws Exception;
    public ArrayList<CustomEntity> searchMetalSuplyUsingSuplyId(String suplyId) throws Exception;
    public ArrayList<CustomEntity> searchMetalSuplyUsingWeight(double weight) throws Exception;

    public ArrayList<CustomEntity> searchJewelryStockUsingGem(String gem) throws Exception;
    public ArrayList<CustomEntity> searchJewelryStockUsingJewelryId(String jewelryId) throws Exception;
    public ArrayList<CustomEntity> searchJewelryStockUsingJewelryType(String jewelrytype) throws Exception;
    public ArrayList<CustomEntity> searchJewelryStockUsingMakeDate(String date) throws Exception;
    public ArrayList<CustomEntity> searchJewelryStockUsingMakerId(String makerId) throws Exception;
    public ArrayList<CustomEntity> searchJewelryStockUsingMetal(String metal) throws Exception;
    public ArrayList<CustomEntity> searchJewelryStockUsingPrice(double price) throws Exception;
    public ArrayList<CustomEntity> searchJewelryStockUsingSize(double size) throws Exception;
    public ArrayList<CustomEntity> searchJewelryStockUsingWeight(double weight) throws Exception;
    public ArrayList<CustomEntity> searchJewelryStockUsingCarat(int carat) throws Exception;
    public ArrayList<CustomEntity> searchJewelryStockUsingMakerName(String makerName) throws Exception;

    public ArrayList<CustomEntity> getAllSelledJewelry() throws Exception;
    public ArrayList<CustomEntity> getCurrentMonthJewelrySales() throws Exception;
    public ArrayList<CustomEntity> getMonthlyJewelrySales() throws Exception;
    public ArrayList<CustomEntity> getCurrentMonthHotelsSentCustomers() throws Exception;
    public ArrayList<CustomEntity> getMonthlyCustomersArrival() throws Exception;
    public ArrayList<CustomEntity> getMonthlyIncome() throws Exception;
}
