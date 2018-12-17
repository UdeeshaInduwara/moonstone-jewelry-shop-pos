package lk.ijse.jewelryshop.dao.custom.impl;

import lk.ijse.jewelryshop.dao.CrudUtil;
import lk.ijse.jewelryshop.dao.custom.MetalDAO;
import lk.ijse.jewelryshop.entity.Metal;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MetalDAOImpl implements MetalDAO {
    @Override
    public boolean save(Metal entity) throws Exception {
        return CrudUtil.executeUpdate("insert into metal values(?,?,?,?)",
                entity.getMetid(),
                entity.getMetalType(),
                entity.getCarat(),
                entity.getAvailableWeight()) >0;
    }

    @Override
    public boolean update(Metal entity) throws Exception {
        return CrudUtil.executeUpdate("update metal set metaltype=?,carat=?,availableWeight=? where metid=? ",
                entity.getMetalType(),
                entity.getCarat(),
                entity.getAvailableWeight(),
                entity.getMetid()) >0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("delete from metal where metid=? ",s) >0;
    }

    @Override
    public Metal search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from metal where metid=? ", s);
        if(rst.next()) {
            return new Metal(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getDouble(4));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Metal> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from metal");
        ArrayList<Metal> metals=new ArrayList<>();
        while (rst.next()){
            metals.add(new Metal(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4)));
        }
        return metals;
    }

    @Override
    public boolean updateQuantity(String metalid, double weight) throws Exception {
        return CrudUtil.executeUpdate("update metal set availableWeight=(availableWeight-?) where metid=? ",weight,metalid) >0;
    }

    @Override
    public boolean resetQuantity(String metalid, double weight) throws Exception {
        return CrudUtil.executeUpdate("update metal set availableWeight=(availableWeight+?) where metid=? ",weight,metalid) >0;
    }
}
