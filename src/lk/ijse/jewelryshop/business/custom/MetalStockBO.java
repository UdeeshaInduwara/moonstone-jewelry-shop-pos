package lk.ijse.jewelryshop.business.custom;

import lk.ijse.jewelryshop.business.SuperBO;
import lk.ijse.jewelryshop.model.MetalStockDTO;

import java.util.ArrayList;

public interface MetalStockBO extends SuperBO {
    public boolean addMetalStock(MetalStockDTO dto) throws Exception;
    public ArrayList<MetalStockDTO> getMetalStockDetails() throws Exception;
    public boolean removeMetalStock(String id) throws Exception;
    public boolean updateMetalStock(MetalStockDTO dto) throws Exception;
    public ArrayList<MetalStockDTO> searchMetalStockUsingBusinessmanId(String id) throws Exception;
    public ArrayList<MetalStockDTO> searchMetalStockUsingBusinessmanName(String name) throws Exception;
    public ArrayList<MetalStockDTO> searchMetalStockUsingCarat(int carat) throws Exception;
    public ArrayList<MetalStockDTO> searchMetalStockUsingMetal(String metal) throws Exception;
    public ArrayList<MetalStockDTO> searchMetalStockUsingMetalId(String id) throws Exception;
    public ArrayList<MetalStockDTO> searchMetalStockUsingPurchaseDate(String date) throws Exception;
    public ArrayList<MetalStockDTO> searchMetalStockUsingWeight(double weight) throws Exception;
}
