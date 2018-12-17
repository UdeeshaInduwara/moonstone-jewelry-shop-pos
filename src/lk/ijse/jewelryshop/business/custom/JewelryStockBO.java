package lk.ijse.jewelryshop.business.custom;

import lk.ijse.jewelryshop.business.SuperBO;
import lk.ijse.jewelryshop.model.JewelryStockDTO;

import java.util.ArrayList;

public interface JewelryStockBO extends SuperBO {
    public boolean addJewelryStock(JewelryStockDTO dto) throws Exception;
    public ArrayList<JewelryStockDTO> getJewelryStockDetails() throws Exception;
    public boolean removeJewelryStock(String jewelryId,String jewelryTypeId) throws Exception;
    public boolean updateJewlryStock(JewelryStockDTO dto) throws Exception;
    public ArrayList<String> getJewelryTypes() throws Exception;
    public String getJewelryTypeId(String name) throws Exception;
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingGem(String gem) throws Exception;
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingJewelryId(String jewelryId) throws Exception;
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingJewelryType(String jewelrytype) throws Exception;
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingMakeDate(String date) throws Exception;
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingMakerId(String makerId) throws Exception;
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingMetal(String metal) throws Exception;
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingPrice(double price) throws Exception;
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingSize(double size) throws Exception;
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingWeight(double weight) throws Exception;
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingCarat(int carat) throws Exception;
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingMakerName(String makerName) throws Exception;
}
