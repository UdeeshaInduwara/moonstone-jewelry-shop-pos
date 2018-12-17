package lk.ijse.jewelryshop.business.custom;

import lk.ijse.jewelryshop.business.SuperBO;
import lk.ijse.jewelryshop.model.JewelryMakerDTO;

import java.util.ArrayList;

public interface JewelryMakerBO extends SuperBO {
    public boolean addJewelryMaker(JewelryMakerDTO dto) throws Exception;
    public ArrayList<JewelryMakerDTO> getAllJewelryMakers() throws Exception;
    public boolean removeJewelryMaker(String id) throws Exception;
    public JewelryMakerDTO searchJewelryMakerUseId(String id)throws Exception;
    public JewelryMakerDTO searchJewelryMakerUseName(String name)throws Exception;
    public boolean updateJewelryMaker(JewelryMakerDTO dto) throws Exception;
    public ArrayList<String> getJewelryMakersIDs() throws Exception;
    public ArrayList<String> getJewelryMakersNames() throws Exception;
    public ArrayList<JewelryMakerDTO> searchUsingName(String jewelryMakerName) throws Exception;
    public ArrayList<JewelryMakerDTO> searchUsingId(String jewelryMakerId) throws Exception;
}
