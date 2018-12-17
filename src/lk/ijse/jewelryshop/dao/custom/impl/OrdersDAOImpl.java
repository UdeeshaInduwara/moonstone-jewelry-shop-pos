package lk.ijse.jewelryshop.dao.custom.impl;

import lk.ijse.jewelryshop.dao.CrudUtil;
import lk.ijse.jewelryshop.dao.custom.OrdersDAO;
import lk.ijse.jewelryshop.entity.Orders;

import java.sql.ResultSet;
import java.util.ArrayList;

public class OrdersDAOImpl implements OrdersDAO {
    @Override
    public boolean save(Orders entity) throws Exception {
        return CrudUtil.executeUpdate("insert into orders values(?,?,?)",
                entity.getOrderId(),
                entity.getCustomerId(),
                entity.getOrderDate()) >0;
    }

    @Override
    public boolean update(Orders entity) throws Exception {
        return CrudUtil.executeUpdate("update orders set custid=?,orderdate=? where oid=? ",
                entity.getCustomerId(),
                entity.getOrderDate(),
                entity.getOrderId()) >0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("delete from orders where oid=? ",s) > 0;
    }

    @Override
    public Orders search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from orders where oid=? ", s);
        if (rst.next()){
            return new Orders(rst.getString(1),rst.getString(2),rst.getString(3));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Orders> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from orders");
        ArrayList<Orders> list=new ArrayList<>();
        while (rst.next()){
            list.add(new Orders(rst.getString(1),rst.getString(2),rst.getString(3)));
        }
        return list;
    }
}
