package lk.ijse.jewelryshop.business.custom;

import lk.ijse.jewelryshop.business.SuperBO;
import lk.ijse.jewelryshop.model.MetalDTO;
import lk.ijse.jewelryshop.model.MetalSuplyDTO;

import java.util.ArrayList;

public interface MetalSuplyBO extends SuperBO {
    public boolean addMetalSuplies(MetalSuplyDTO dto) throws Exception;
    public MetalDTO searchMetal(String id) throws Exception;
    public ArrayList<MetalSuplyDTO> getAllMetalSuplies() throws Exception;
    public boolean removeMetalSuplies(String id) throws Exception;
    public boolean updateMetalSuplies(MetalSuplyDTO dto) throws Exception;
    public ArrayList<MetalDTO> getAllMetalDetails() throws Exception;
    public ArrayList<MetalSuplyDTO> searchMetalSuplyUsingCarat(int carat) throws Exception;
    public ArrayList<MetalSuplyDTO> searchMetalSuplyUsingMakerId(String makerId) throws Exception;
    public ArrayList<MetalSuplyDTO> searchMetalSuplyUsingMakerName(String makerName) throws Exception;
    public ArrayList<MetalSuplyDTO> searchMetalSuplyUsingMetal(String metal) throws Exception;
    public ArrayList<MetalSuplyDTO> searchMetalSuplyUsingMetalId(String metalId) throws Exception;
    public ArrayList<MetalSuplyDTO> searchMetalSuplyUsingSuplyDate(String date) throws Exception;
    public ArrayList<MetalSuplyDTO> searchMetalSuplyUsingSuplyId(String suplyId) throws Exception;
    public ArrayList<MetalSuplyDTO> searchMetalSuplyUsingWeight(double weight) throws Exception;
}
