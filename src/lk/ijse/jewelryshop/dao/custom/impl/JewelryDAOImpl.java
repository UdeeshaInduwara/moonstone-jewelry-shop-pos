package lk.ijse.jewelryshop.dao.custom.impl;

import lk.ijse.jewelryshop.dao.CrudUtil;
import lk.ijse.jewelryshop.dao.custom.JewelryDAO;
import lk.ijse.jewelryshop.entity.Jewelry;

import java.sql.ResultSet;
import java.util.ArrayList;

public class JewelryDAOImpl implements JewelryDAO {
    @Override
    public boolean save(Jewelry entity) throws Exception {
        return CrudUtil.executeUpdate("insert into jewelry values(?,?,?,?,?,?,?,?)",
                entity.getJewelryId(),
                entity.getMetal(),
                entity.getCarat(),
                entity.getWeight(),
                entity.getJewelrySize(),
                entity.getEmbroidedgem(),
                entity.getPrice(),
                entity.getJewelryTypeId()) >0;
    }

    @Override
    public boolean update(Jewelry entity) throws Exception {
        return CrudUtil.executeUpdate("update jewelry set metal=?,carat=?,weight=?,jewelrySize=?,embroiderdGem=?,price=?,jtid=? where jewid=? ",
                entity.getMetal(),
                entity.getCarat(),
                entity.getWeight(),
                entity.getJewelrySize(),
                entity.getEmbroidedgem(),
                entity.getPrice(),
                entity.getJewelryTypeId(),
                entity.getJewelryId()) >0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("delete from jewelry where jewid=? ",s) >0;
    }

    @Override
    public Jewelry search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from jewelry where jewid=? ", s);
        if(rst.next()){
            return new Jewelry(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4),rst.getDouble(5),rst.getString(6),rst.getDouble(7),rst.getString(8));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Jewelry> getAll() throws Exception {
        ArrayList<Jewelry> jewelries=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from jewelry");
        while (rst.next()){
            jewelries.add(new Jewelry(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4),rst.getDouble(5),rst.getString(6),rst.getDouble(7),rst.getString(8)));
        }
        return jewelries;
    }

    @Override
    public ArrayList<String> getJewelryIds(String jewelryTypeId) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select jewid from jewelry where jtid=? ", jewelryTypeId);
        ArrayList<String> idList=new ArrayList<>();
        while (rst.next()){
            idList.add(rst.getString(1));
        }
        return idList;
    }

}
