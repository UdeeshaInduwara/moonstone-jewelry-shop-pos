package lk.ijse.jewelryshop.dao.custom.impl;

import lk.ijse.jewelryshop.dao.CrudUtil;
import lk.ijse.jewelryshop.dao.custom.MetalSuplyDetailDAO;
import lk.ijse.jewelryshop.entity.MetalSuplyDetail;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MetalSuplyDetailDAOImpl implements MetalSuplyDetailDAO {
    @Override
    public boolean save(MetalSuplyDetail entity) throws Exception {
        return CrudUtil.executeUpdate("insert into metalSuplyDetail values(?,?,?,?,?)",
                entity.getMetalSuplyId(),
                entity.getMetalId(),
                entity.getJewelryMakerId(),
                entity.getWeight(),
                entity.getSuplyDate()) >0;
    }

    @Override
    public boolean update(MetalSuplyDetail entity) throws Exception {
        return CrudUtil.executeUpdate("update metalSuplyDetail set metid=?,jmid=?,weight=?,suplyDate=? where metsupid=? ",
                entity.getMetalId(),
                entity.getJewelryMakerId(),
                entity.getWeight(),
                entity.getSuplyDate(),
                entity.getMetalSuplyId()) > 0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("delete from metalSuplyDetail where metsupid=? ",s) >0;
    }

    @Override
    public MetalSuplyDetail search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from metalSuplyDetail where metsupid=? ", s);
        if(rst.next()){
            return new MetalSuplyDetail(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getString(5));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<MetalSuplyDetail> getAll() throws Exception {
        ArrayList<MetalSuplyDetail> metalSuplyDetails=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from metalSuplyDetail");
        while (rst.next()){
            metalSuplyDetails.add(new MetalSuplyDetail(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getString(5)));
        }
        return metalSuplyDetails;
    }


}
