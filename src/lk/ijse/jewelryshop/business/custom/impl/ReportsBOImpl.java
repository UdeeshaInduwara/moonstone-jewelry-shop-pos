package lk.ijse.jewelryshop.business.custom.impl;

import lk.ijse.jewelryshop.business.custom.ReportsBO;
import lk.ijse.jewelryshop.dao.DAOFactory;
import lk.ijse.jewelryshop.dao.custom.CustomerDAO;
import lk.ijse.jewelryshop.dao.custom.QueryDAO;
import lk.ijse.jewelryshop.entity.CustomEntity;
import lk.ijse.jewelryshop.entity.Customer;
import lk.ijse.jewelryshop.model.CustomerDTO;
import lk.ijse.jewelryshop.model.SalesReportDTO;
import lk.ijse.jewelryshop.model.SelledJewelryDTO;

import java.util.ArrayList;

public class ReportsBOImpl implements ReportsBO {
    QueryDAO queryDAO=null;
    CustomerDAO customerDAO=null;
    public ReportsBOImpl() {

        queryDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
        customerDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    }

    @Override
    public ArrayList<SelledJewelryDTO> getAllSelledJewelry() throws Exception {
        ArrayList<CustomEntity> list = queryDAO.getAllSelledJewelry();
        ArrayList<SelledJewelryDTO> dtos=new ArrayList<>();
        for (CustomEntity c :list) {
            dtos.add(new SelledJewelryDTO(c.getSelledJewelryTypeId(),c.getSelledJewelryType(),c.getSelledJewelryId(),c.getSelledJewelryMetal(),c.getSelledJewelryCarat(),c.getSelledJewelryWeight(),c.getSelledJewelrySize(),c.getSelledJewelryGem(),c.getSelledDate(),c.getSelledCustomerId(),c.getSelledCustomerName(),c.getSelledPrice()));
        }
        return dtos;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomerDetail() throws Exception {
        ArrayList<Customer> list = customerDAO.getAll();
        ArrayList<CustomerDTO> dtos=new ArrayList<>();
        for (Customer c :list) {
            dtos.add(new CustomerDTO(c.getCustomerId(),c.getPassportNo(),c.getName(),c.getCountry(),c.getSenderId()));
        }
        return dtos;
    }

    @Override
    public ArrayList<SalesReportDTO> getCurrentMonthJewelrySales() throws Exception {
        ArrayList<CustomEntity> monthlyJewelrySales = queryDAO.getCurrentMonthJewelrySales();
        ArrayList<SalesReportDTO> dtos=new ArrayList<>();
        for (CustomEntity c :monthlyJewelrySales) {
            dtos.add(new SalesReportDTO(c.getTypeName(),c.getTotalCount()));
        }
        return dtos;
    }

    @Override
    public ArrayList<SalesReportDTO> getMonthlyJewelrySales() throws Exception {
        ArrayList<CustomEntity> monthlyJewelrySales = queryDAO.getMonthlyJewelrySales();
        ArrayList<SalesReportDTO> dtos=new ArrayList<>();
        for (CustomEntity c :monthlyJewelrySales) {
            dtos.add(new SalesReportDTO(c.getTypeName(),c.getTotalCount()));
        }
        return dtos;
    }

    @Override
    public ArrayList<SalesReportDTO> getCurrentMonthHotelsSentCustomers() throws Exception {
        ArrayList<CustomEntity> monthlyJewelrySales = queryDAO.getCurrentMonthHotelsSentCustomers();
        ArrayList<SalesReportDTO> dtos=new ArrayList<>();
        for (CustomEntity c :monthlyJewelrySales) {
            dtos.add(new SalesReportDTO(c.getTypeName(),c.getTotalCount()));
        }
        return dtos;
    }

    @Override
    public ArrayList<SalesReportDTO> getMonthlyCustomersArrival() throws Exception {
        ArrayList<CustomEntity> monthlyJewelrySales = queryDAO.getMonthlyCustomersArrival();
        ArrayList<SalesReportDTO> dtos=new ArrayList<>();
        for (CustomEntity c :monthlyJewelrySales) {
            dtos.add(new SalesReportDTO(c.getTypeName(),c.getTotalCount()));
        }
        return dtos;
    }

    @Override
    public ArrayList<SalesReportDTO> getMonthlyIncome() throws Exception {
        ArrayList<CustomEntity> monthlyJewelrySales = queryDAO.getMonthlyIncome();
        ArrayList<SalesReportDTO> dtos=new ArrayList<>();
        for (CustomEntity c :monthlyJewelrySales) {
            dtos.add(new SalesReportDTO(c.getTypeName(),c.getTotalCount()));
        }
        return dtos;
    }
}
