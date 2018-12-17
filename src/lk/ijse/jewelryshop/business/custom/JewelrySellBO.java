package lk.ijse.jewelryshop.business.custom;

import lk.ijse.jewelryshop.business.SuperBO;
import lk.ijse.jewelryshop.model.JewelryDTO;
import lk.ijse.jewelryshop.model.JewelrySellDTO;
import lk.ijse.jewelryshop.model.JewelryTypeDTO;

import java.util.ArrayList;

public interface JewelrySellBO extends SuperBO {
    public boolean addSales(JewelrySellDTO dto) throws Exception;
    public ArrayList<String> getJewelryTypes() throws Exception;
    public JewelryTypeDTO getJewelryTypeDetail(String name) throws Exception;
    public JewelryTypeDTO getJewelryTypeDetailUseId(String id) throws Exception;
    public ArrayList<String> getJewelryIds(String jewelryTypeId) throws Exception;
    public ArrayList<String> getJewelryIdsList() throws Exception;
    public JewelryDTO getJewelrDetail(String id) throws Exception;
    public ArrayList<String> getHotelIds() throws Exception;
    public String searchHotelUseName(String hotelName) throws Exception;
    public String getHotelNames(String id) throws Exception;
    public ArrayList<String> getHotelNamesList() throws Exception;
}
