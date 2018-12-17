package lk.ijse.jewelryshop.dao.custom.impl;

import lk.ijse.jewelryshop.dao.CrudUtil;
import lk.ijse.jewelryshop.dao.custom.PaymentDAO;
import lk.ijse.jewelryshop.entity.Payment;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean save(Payment entity) throws Exception {
        return CrudUtil.executeUpdate("insert into payment values(?,?,?,?)",
                entity.getPaymentId(),
                entity.getOrderId(),
                entity.getAmount(),
                entity.getDiscount()) >0;
    }

    @Override
    public boolean update(Payment entity) throws Exception {
        return CrudUtil.executeUpdate("update payment set oid=?,amount=?,discount=? where payid=? ",
                entity.getOrderId(),
                entity.getAmount(),
                entity.getDiscount(),
                entity.getPaymentId()) >0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("delete from payment where payid=? ",s) > 0;
    }

    @Override
    public Payment search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from payment where payid=? ", s);
        if (rst.next()){
            return new Payment(rst.getString(1),rst.getString(2),rst.getDouble(3),rst.getDouble(4));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Payment> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from payment");
        ArrayList<Payment> list=new ArrayList<>();
        while (rst.next()){
            list.add(new Payment(rst.getString(1),rst.getString(2),rst.getDouble(3),rst.getDouble(4)));
        }
        return list;
    }
}
