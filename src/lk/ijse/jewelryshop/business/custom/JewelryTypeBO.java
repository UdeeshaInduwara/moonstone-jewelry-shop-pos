package lk.ijse.jewelryshop.business.custom;

import lk.ijse.jewelryshop.business.SuperBO;
import lk.ijse.jewelryshop.model.JewelryTypeDTO;

import java.util.ArrayList;

public interface JewelryTypeBO extends SuperBO {
    public boolean saveJewelryType(JewelryTypeDTO dto) throws Exception;
    public boolean updateJewelryType(JewelryTypeDTO dto) throws Exception;
    public boolean deleteJewelrytype(String s) throws Exception;
    public ArrayList<JewelryTypeDTO> getAllJewelryType() throws Exception;
}
