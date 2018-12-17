package lk.ijse.jewelryshop.business.custom.impl;

import lk.ijse.jewelryshop.business.custom.HotelBO;
import lk.ijse.jewelryshop.dao.DAOFactory;
import lk.ijse.jewelryshop.dao.custom.HotelDAO;
import lk.ijse.jewelryshop.entity.Hotel;
import lk.ijse.jewelryshop.model.HotelDTO;

import java.util.ArrayList;

public class HotelBOImpl implements HotelBO {
    HotelDAO hotelDAO=null;
    public HotelBOImpl() {

        hotelDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.HOTEL);
    }

    @Override
    public boolean addHotel(HotelDTO dto) throws Exception {
        return hotelDAO.save(new Hotel(dto.getHid(),dto.getName(),dto.getCity(),dto.getContactNo()));
    }

    @Override
    public ArrayList<HotelDTO> getAllHotels() throws Exception {
        ArrayList<Hotel> hotels = hotelDAO.getAll();
        ArrayList<HotelDTO> hotelList=new ArrayList<>();
        for (Hotel h : hotels) {
            hotelList.add(new HotelDTO(h.getHid(), h.getName(), h.getContactNo(), h.getCity()));
        }
        return hotelList;
    }

    @Override
    public boolean removeHotel(String id) throws Exception {
        return hotelDAO.delete(id);
    }

    @Override
    public HotelDTO searchHotel(String id) throws Exception {
        Hotel hotel = hotelDAO.search(id);
        return new HotelDTO(hotel.getHid(),hotel.getName(),hotel.getContactNo(),hotel.getCity());
    }

    @Override
    public boolean updateHotel(HotelDTO dto) throws Exception {
        return hotelDAO.update(new Hotel(dto.getHid(),dto.getName(),dto.getCity(),dto.getContactNo()));
    }

    @Override
    public ArrayList<HotelDTO> searchHotelUsingName(String hotelName) throws Exception {
        ArrayList<Hotel> hotels = hotelDAO.searchUsingName(hotelName);
        ArrayList<HotelDTO> hotelList=new ArrayList<>();
        for (Hotel h : hotels) {
            hotelList.add(new HotelDTO(h.getHid(), h.getName(), h.getContactNo(), h.getCity()));
        }
        return hotelList;
    }

    @Override
    public ArrayList<HotelDTO> searchHotelUsingId(String hotelId) throws Exception {
        ArrayList<Hotel> hotels = hotelDAO.searchUsingId(hotelId);
        ArrayList<HotelDTO> hotelList=new ArrayList<>();
        for (Hotel h : hotels) {
            hotelList.add(new HotelDTO(h.getHid(), h.getName(), h.getContactNo(), h.getCity()));
        }
        return hotelList;
    }

    @Override
    public ArrayList<HotelDTO> searchHotelUsingCity(String hotelCity) throws Exception {
        ArrayList<Hotel> hotels = hotelDAO.searchUsingCity(hotelCity);
        ArrayList<HotelDTO> hotelList=new ArrayList<>();
        for (Hotel h : hotels) {
            hotelList.add(new HotelDTO(h.getHid(), h.getName(), h.getContactNo(), h.getCity()));
        }
        return hotelList;
    }
}
