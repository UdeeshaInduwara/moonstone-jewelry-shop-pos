package lk.ijse.jewelryshop.dao.custom.impl;

import lk.ijse.jewelryshop.dao.CrudUtil;
import lk.ijse.jewelryshop.dao.custom.JewelryMakerDAO;
import lk.ijse.jewelryshop.db.DBConnection;
import lk.ijse.jewelryshop.entity.JewelryMaker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JewelryMakerDAOImpl implements JewelryMakerDAO {
    @Override
    public boolean save(JewelryMaker entity) throws Exception {
        return CrudUtil.executeUpdate("insert into jewelrymaker values(?,?,?)",
                entity.getId(),
                entity.getName(),
                entity.getContactNo()) >0;
    }

    @Override
    public boolean update(JewelryMaker entity) throws Exception {
        return CrudUtil.executeUpdate("update jewelrymaker set name=?,contactno=? where jmid=? ",
                entity.getName(),
                entity.getContactNo(),
                entity.getId()) > 0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("delete from jewelrymaker where jmid=? ",s) > 0;
    }

    @Override
    public JewelryMaker search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from jewelrymaker where jmid=? ", s);
        if(rst.next()){
            return new JewelryMaker(rst.getString(1),rst.getString(2),rst.getString(3));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<JewelryMaker> getAll() throws Exception {
        ArrayList<JewelryMaker> jewelryMakers=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from jewelrymaker");
        while (rst.next()){
            jewelryMakers.add(new JewelryMaker(rst.getString(1),rst.getString(2),rst.getString(3)));
        }
        return jewelryMakers;
    }

    @Override
    public ArrayList<JewelryMaker> searchUsingName(String jewelryMakerName) throws Exception {
        ArrayList<JewelryMaker> jewelryMakers=new ArrayList<>();
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("select * from jewelrymaker where name like '%"+jewelryMakerName+"%'");
        while (rst.next()){
            jewelryMakers.add(new JewelryMaker(rst.getString(1),rst.getString(2),rst.getString(3)));
        }
        return jewelryMakers;
    }

    @Override
    public ArrayList<JewelryMaker> searchUsingId(String jewelryMakerId) throws Exception {
        ArrayList<JewelryMaker> jewelryMakers=new ArrayList<>();
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("select * from jewelrymaker where jmid like '%"+jewelryMakerId+"%'");
        while (rst.next()){
            jewelryMakers.add(new JewelryMaker(rst.getString(1),rst.getString(2),rst.getString(3)));
        }
        return jewelryMakers;
    }

    @Override
    public JewelryMaker searchUseName(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from jewelrymaker where name=? ", s);
        if(rst.next()){
            return new JewelryMaker(rst.getString(1),rst.getString(2),rst.getString(3));
        }else {
            return null;
        }
    }
}
