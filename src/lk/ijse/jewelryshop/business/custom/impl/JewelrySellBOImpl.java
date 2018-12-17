package lk.ijse.jewelryshop.business.custom.impl;

import lk.ijse.jewelryshop.business.custom.JewelrySellBO;
import lk.ijse.jewelryshop.dao.DAOFactory;
import lk.ijse.jewelryshop.dao.custom.*;
import lk.ijse.jewelryshop.db.DBConnection;
import lk.ijse.jewelryshop.entity.*;
import lk.ijse.jewelryshop.model.JewelryDTO;
import lk.ijse.jewelryshop.model.JewelryPurchaseDetailDTO;
import lk.ijse.jewelryshop.model.JewelrySellDTO;
import lk.ijse.jewelryshop.model.JewelryTypeDTO;

import java.sql.Connection;
import java.util.ArrayList;

public class JewelrySellBOImpl implements JewelrySellBO {
    JewelryTypeDAO jewelryTypeDAO=null;
    JewelryDAO jewelryDAO=null;
    CustomerDAO customerDAO=null;
    OrdersDAO ordersDAO=null;
    PaymentDAO paymentDAO=null;
    JewelryPurchaseDetailDAO jewelryPurchaseDetailDAO=null;
    HotelDAO hotelDAO=null;
    public JewelrySellBOImpl() {
        hotelDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.HOTEL);
        jewelryTypeDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.JEWELRYTYPE);
        jewelryDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.JEWELRY);
        customerDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
        ordersDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
        paymentDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);
        jewelryPurchaseDetailDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.JEWELRYPURCHASEDETAIL);
    }

    @Override
    public boolean addSales(JewelrySellDTO dto) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        conn.setAutoCommit(false);
        try{
            boolean result = customerDAO.save(new Customer(dto.getCustomerId(),dto.getPassportNo(),dto.getCustomerName(),dto.getCountry(),dto.getHotelId()));
            if(!result){
                conn.rollback();
                return false;
            }
            result = ordersDAO.save(new Orders(dto.getOrderId(),dto.getCustomerId(),dto.getSellingDate()));
            if(!result){
                conn.rollback();
                return false;
            }
            result = paymentDAO.save(new Payment(dto.getPaymentId(),dto.getOrderId(),dto.getAmount(),dto.getDiscount()));
            if(!result){
                conn.rollback();
                return false;
            }
            ArrayList<JewelryPurchaseDetailDTO> list = dto.getJewelryPurchaseDetailDTOS();
            for (JewelryPurchaseDetailDTO p :list) {
                Jewelry jewelry = jewelryDAO.search(p.getJewelryId());
                result = jewelryPurchaseDetailDAO.save(new JewelryPurchaseDetail(p.getOrderId(),jewelry.getJewelryId(),jewelry.getJewelryTypeId(),jewelry.getMetal(),jewelry.getCarat(),jewelry.getWeight(),jewelry.getJewelrySize(),jewelry.getEmbroidedgem(),jewelry.getPrice()));
                if(!result){
                    conn.rollback();
                    return false;
                }
                result= jewelryTypeDAO.downQuantity(jewelry.getJewelryTypeId());
                if(!result){
                    conn.rollback();
                    return false;
                }
                result=jewelryDAO.delete(jewelry.getJewelryId());
                if(!result){
                    conn.rollback();
                    return false;
                }
            }
            conn.commit();
            return true;
        }finally {
            conn.setAutoCommit(true);
        }
    }

    @Override
    public ArrayList<String> getJewelryTypes() throws Exception {
        ArrayList<JewelryType> list = jewelryTypeDAO.getAll();
        ArrayList<String> typeList=new ArrayList<>();
        for (JewelryType j :list) {
            typeList.add(j.getName());
        }
        return typeList;
    }

    @Override
    public JewelryTypeDTO getJewelryTypeDetail(String name) throws Exception {
        JewelryType jewelryType = jewelryTypeDAO.search(name);
        return new JewelryTypeDTO(jewelryType.getJewelryTypeId(),jewelryType.getName(),jewelryType.getJewelryQty());
    }

    @Override
    public JewelryTypeDTO getJewelryTypeDetailUseId(String id) throws Exception {
        JewelryType jewelryType = jewelryTypeDAO.searchUsingId(id);
        return new JewelryTypeDTO(jewelryType.getJewelryTypeId(),jewelryType.getName(),jewelryType.getJewelryQty());
    }

    @Override
    public ArrayList<String> getJewelryIds(String jewelryTypeId) throws Exception {
        return jewelryDAO.getJewelryIds(jewelryTypeId);
    }

    @Override
    public ArrayList<String> getJewelryIdsList() throws Exception {
        ArrayList<Jewelry> all = jewelryDAO.getAll();
        ArrayList<String> ids=new ArrayList<>();
        for (Jewelry j :all) {
            ids.add(j.getJewelryId());
        }
        return ids;
    }

    @Override
    public JewelryDTO getJewelrDetail(String id) throws Exception {
        Jewelry jewelry = jewelryDAO.search(id);
        return new JewelryDTO(jewelry.getJewelryId(),jewelry.getMetal(),jewelry.getCarat(),jewelry.getWeight(),jewelry.getJewelrySize(),jewelry.getEmbroidedgem(),jewelry.getPrice(),jewelry.getJewelryTypeId());
    }

    @Override
    public ArrayList<String> getHotelIds() throws Exception {
        ArrayList<Hotel> hotels = hotelDAO.getAll();
        ArrayList<String> hotelIds=new ArrayList<>();
        for (Hotel h :hotels) {
            hotelIds.add(h.getHid());
        }
        return hotelIds;
    }

    @Override
    public String searchHotelUseName(String hotelName) throws Exception {
        Hotel hotel = hotelDAO.searchUseName(hotelName);
        return hotel.getHid();
    }

    @Override
    public String getHotelNames(String id) throws Exception {
        Hotel hotel = hotelDAO.search(id);
        return hotel.getName();
    }

    @Override
    public ArrayList<String> getHotelNamesList() throws Exception {
        ArrayList<Hotel> hotels = hotelDAO.getAll();
        ArrayList<String> hotelNames=new ArrayList<>();
        for (Hotel h :hotels) {
            hotelNames.add(h.getName());
        }
        return hotelNames;
    }
}
