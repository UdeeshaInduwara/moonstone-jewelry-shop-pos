package lk.ijse.jewelryshop.dao.custom.impl;

import lk.ijse.jewelryshop.dao.CrudUtil;
import lk.ijse.jewelryshop.dao.custom.JewelryTypeDAO;
import lk.ijse.jewelryshop.entity.JewelryType;

import java.sql.ResultSet;
import java.util.ArrayList;

public class JewelryTypeDAOImpl implements JewelryTypeDAO {
    @Override
    public boolean save(JewelryType entity) throws Exception {
        return CrudUtil.executeUpdate("insert into jewelrytype values(?,?,?)",
                entity.getJewelryTypeId(),
                entity.getName(),
                entity.getJewelryQty()) > 0;
    }

    @Override
    public boolean update(JewelryType entity) throws Exception {
        return CrudUtil.executeUpdate("update jewelrytype set name=?,qty=? where jtid=? ",
                entity.getName(),
                entity.getJewelryQty(),
                entity.getJewelryTypeId()) > 0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("delete from jewelrytype where jtid=? ",s) > 0;
    }

    @Override
    public JewelryType search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from jewelrytype where name=? ", s);
        if(rst.next()){
            return new JewelryType(rst.getString(1),rst.getString(2),rst.getInt(3));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<JewelryType> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from jewelrytype");
        ArrayList<JewelryType> list=new ArrayList<>();
        while (rst.next()){
            list.add(new JewelryType(rst.getString(1),rst.getString(2),rst.getInt(3)));
        }
        return list;
    }

    @Override
    public boolean downQuantity(String jewelryTypeId) throws Exception {
        return CrudUtil.executeUpdate("update jewelrytype set qty=(qty-1) where jtid=? ",jewelryTypeId) >0;
    }

    @Override
    public boolean addQuantity(String jewelryTypeId) throws Exception {
        return CrudUtil.executeUpdate("update jewelrytype set qty=(qty+1) where jtid=? ",jewelryTypeId) >0;
    }

    @Override
    public JewelryType searchUsingId(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from jewelrytype where jtid=? ", id);
        if(rst.next()){
            return new JewelryType(rst.getString(1),rst.getString(2),rst.getInt(3));
        }else {
            return null;
        }
    }
}
