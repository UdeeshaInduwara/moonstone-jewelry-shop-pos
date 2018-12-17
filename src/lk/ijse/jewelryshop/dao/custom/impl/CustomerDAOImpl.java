package lk.ijse.jewelryshop.dao.custom.impl;

import lk.ijse.jewelryshop.dao.CrudUtil;
import lk.ijse.jewelryshop.dao.custom.CustomerDAO;
import lk.ijse.jewelryshop.entity.Customer;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean save(Customer entity) throws Exception {
        return CrudUtil.executeUpdate("insert into customer values(?,?,?,?,?)",
                entity.getCustomerId(),
                entity.getPassportNo(),
                entity.getName(),
                entity.getCountry(),
                entity.getSenderId()) >0;
    }

    @Override
    public boolean update(Customer entity) throws Exception {
        return CrudUtil.executeUpdate("update customer set passportno=?,name=?,country=?,hid=? where custid=? ",
                entity.getPassportNo(),
                entity.getName(),
                entity.getCountry(),
                entity.getSenderId(),
                entity.getCustomerId()) >0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("delete from customer where custid=? ",s) > 0;
    }

    @Override
    public Customer search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from customer where custid=? ", s);
       if (rst.next()){
           return new Customer(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5));
       }else {
           return null;
       }
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        ArrayList<Customer> customers=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from customer");
        while (rst.next()){
            customers.add(new Customer(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5)));
        }
        return customers;
    }
}
