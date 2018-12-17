package lk.ijse.jewelryshop.dao.custom;

import lk.ijse.jewelryshop.dao.CrudDAO;
import lk.ijse.jewelryshop.entity.Hotel;

import java.util.ArrayList;

public interface HotelDAO extends CrudDAO<Hotel,String> {
    public ArrayList<Hotel> searchUsingName(String hotelName) throws Exception;
    public ArrayList<Hotel> searchUsingId(String hotelId) throws Exception;
    public ArrayList<Hotel> searchUsingCity(String hotelCity) throws Exception;
    public Hotel searchUseName(String s) throws Exception;
}
