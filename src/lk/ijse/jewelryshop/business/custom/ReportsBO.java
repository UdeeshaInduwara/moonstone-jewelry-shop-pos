package lk.ijse.jewelryshop.business.custom;

import lk.ijse.jewelryshop.business.SuperBO;
import lk.ijse.jewelryshop.model.CustomerDTO;
import lk.ijse.jewelryshop.model.SalesReportDTO;
import lk.ijse.jewelryshop.model.SelledJewelryDTO;

import java.util.ArrayList;

public interface ReportsBO extends SuperBO {
    public ArrayList<SelledJewelryDTO> getAllSelledJewelry() throws Exception;
    public ArrayList<CustomerDTO> getAllCustomerDetail() throws Exception;
    public ArrayList<SalesReportDTO> getCurrentMonthJewelrySales() throws Exception;
    public ArrayList<SalesReportDTO> getMonthlyJewelrySales() throws Exception;
    public ArrayList<SalesReportDTO> getCurrentMonthHotelsSentCustomers() throws Exception;
    public ArrayList<SalesReportDTO> getMonthlyCustomersArrival() throws Exception;
    public ArrayList<SalesReportDTO> getMonthlyIncome() throws Exception;
}
