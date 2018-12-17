package lk.ijse.jewelryshop.dao.custom.impl;

import lk.ijse.jewelryshop.dao.CrudUtil;
import lk.ijse.jewelryshop.dao.custom.MetalBusinessmanDAO;
import lk.ijse.jewelryshop.db.DBConnection;
import lk.ijse.jewelryshop.entity.MetalBusinessman;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MetalBusinessmanDAOImpl implements MetalBusinessmanDAO {
    @Override
    public boolean save(MetalBusinessman entity) throws Exception {
        return CrudUtil.executeUpdate("insert into metalbusinessman values(?,?,?,?)",
                entity.getMetbid(),
                entity.getName(),
                entity.getContactNo(),
                entity.getAddress()) >0;
    }

    @Override
    public boolean update(MetalBusinessman entity) throws Exception {
        return CrudUtil.executeUpdate("update metalbusinessman set name=?,contactno=?,address=? where metbid=? ",
                entity.getName(),
                entity.getContactNo(),
                entity.getAddress(),
                entity.getMetbid()) >0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("delete from metalbusinessman where metbid=? ",s) > 0;
    }

    @Override
    public MetalBusinessman search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from metalbusinessman where metbid=? ", s);
        if(rst.next()){
            return new MetalBusinessman(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<MetalBusinessman> getAll() throws Exception {
        ArrayList<MetalBusinessman> metalBusinessmen=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from metalbusinessman");
        while (rst.next()){
            metalBusinessmen.add(new MetalBusinessman(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
        }
        return metalBusinessmen;
    }

    @Override
    public ArrayList<MetalBusinessman> searchUsingName(String metalBusinessmanName) throws Exception {
        ArrayList<MetalBusinessman> metalBusinessmen=new ArrayList<>();
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("select * from metalBusinessman where name like '%"+metalBusinessmanName+"%'");
        while (rst.next()){
            metalBusinessmen.add(new MetalBusinessman(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
        }
        return metalBusinessmen;
    }

    @Override
    public ArrayList<MetalBusinessman> searchUsingId(String metalBusinessmanId) throws Exception {
        ArrayList<MetalBusinessman> metalBusinessmen=new ArrayList<>();
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("select * from metalBusinessman where metbid like '%"+metalBusinessmanId+"%'");
        while (rst.next()){
            metalBusinessmen.add(new MetalBusinessman(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
        }
        return metalBusinessmen;
    }

    @Override
    public MetalBusinessman searchUseName(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from metalbusinessman where name=? ", s);
        if(rst.next()){
            return new MetalBusinessman(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
        }else {
            return null;
        }
    }
}
