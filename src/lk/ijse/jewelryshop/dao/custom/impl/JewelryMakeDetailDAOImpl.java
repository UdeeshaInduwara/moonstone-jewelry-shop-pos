package lk.ijse.jewelryshop.dao.custom.impl;

import lk.ijse.jewelryshop.dao.CrudUtil;
import lk.ijse.jewelryshop.dao.custom.JewelryMakeDetailDAO;
import lk.ijse.jewelryshop.entity.JewelryMakeDetail;
import lk.ijse.jewelryshop.entity.JewelryMakeDetail_PK;

import java.sql.ResultSet;
import java.util.ArrayList;

public class JewelryMakeDetailDAOImpl implements JewelryMakeDetailDAO {
    @Override
    public boolean save(JewelryMakeDetail entity) throws Exception {
        return CrudUtil.executeUpdate("insert into jewelryMakeDetail values(?,?,?)",
                entity.getJewelryMakeDetail_pk().getJewlryId(),
                entity.getJewelryMakeDetail_pk().getJewelryMakerId(),
                entity.getDate()) >0;
    }

    @Override
    public boolean update(JewelryMakeDetail entity) throws Exception {
        return CrudUtil.executeUpdate("update jewelryMakeDetail set jmid=?,makeDate=? where jewid=? ",
                entity.getJewelryMakeDetail_pk().getJewelryMakerId(),
                entity.getDate(),
                entity.getJewelryMakeDetail_pk().getJewlryId()) >0;
    }

    @Override
    public boolean delete(JewelryMakeDetail_PK jewelryMakeDetail_pk) throws Exception {
        return CrudUtil.executeUpdate("delete from jewelryMakeDetail where jewid=? ",jewelryMakeDetail_pk.getJewlryId()) > 0;
    }

    @Override
    public JewelryMakeDetail search(JewelryMakeDetail_PK jewelryMakeDetail_pk) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from jewelryMakeDetail where jewid=? ", jewelryMakeDetail_pk.getJewlryId());
        if (rst.next()){
            return new JewelryMakeDetail(rst.getString(1),rst.getString(2),rst.getString(3));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<JewelryMakeDetail> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from jewelryMakeDetail");
        ArrayList<JewelryMakeDetail> list=new ArrayList<>();
        while (rst.next()){
            list.add(new JewelryMakeDetail(rst.getString(1),rst.getString(2),rst.getString(3)));
        }
        return list;
    }
}
