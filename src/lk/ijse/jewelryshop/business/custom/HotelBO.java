package lk.ijse.jewelryshop.business.custom;

import lk.ijse.jewelryshop.business.SuperBO;
import lk.ijse.jewelryshop.model.HotelDTO;

import java.util.ArrayList;

public interface HotelBO extends SuperBO {
    public boolean addHotel(HotelDTO dto) throws Exception;
    public ArrayList<HotelDTO> getAllHotels() throws Exception;
    public boolean removeHotel(String id) throws Exception;
    public HotelDTO searchHotel(String id)throws Exception;
    public boolean updateHotel(HotelDTO dto) throws Exception;
    public ArrayList<HotelDTO> searchHotelUsingName(String hotelName) throws Exception;
    public ArrayList<HotelDTO> searchHotelUsingId(String hotelId) throws Exception;
    public ArrayList<HotelDTO> searchHotelUsingCity(String hotelCity) throws Exception;
}
