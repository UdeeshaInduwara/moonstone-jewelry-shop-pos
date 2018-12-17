package lk.ijse.jewelryshop.dao.custom.impl;

import lk.ijse.jewelryshop.dao.CrudUtil;
import lk.ijse.jewelryshop.dao.custom.MetalPurchaseDetailDAO;
import lk.ijse.jewelryshop.entity.MetalPurchaseDetail;
import lk.ijse.jewelryshop.entity.MetalPurchaseDetail_PK;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MetalPurchaseDetailDAOImpl implements MetalPurchaseDetailDAO {

    @Override
    public boolean save(MetalPurchaseDetail entity) throws Exception {
        return CrudUtil.executeUpdate("insert into metalPurchaseDetail values(?,?,?,?)",
                entity.getMetalPurchaseDetail_pk().getMetalId(),
                entity.getMetalPurchaseDetail_pk().getMetalBusinessmanId(),
                entity.getWeight(),entity.getPurchaseDate()) >0;
    }

    @Override
    public boolean update(MetalPurchaseDetail entity) throws Exception {
        return CrudUtil.executeUpdate("update metalPurchaseDetail set metbid=?,weight=?,purchaseDate=? where metid=? ",
                entity.getMetalPurchaseDetail_pk().getMetalBusinessmanId(),
                entity.getWeight(),entity.getPurchaseDate(),
                entity.getMetalPurchaseDetail_pk().getMetalId()) >0;
    }

    @Override
    public boolean delete(MetalPurchaseDetail_PK metalPurchaseDetail_pk) throws Exception {
        return CrudUtil.executeUpdate("delete from metalPurchaseDetail where metid=? ",metalPurchaseDetail_pk.getMetalId()) > 0;
    }

    @Override
    public MetalPurchaseDetail search(MetalPurchaseDetail_PK metalPurchaseDetail_pk) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from metalPurchaseDetail where metid=? ", metalPurchaseDetail_pk.getMetalId());
        if (rst.next()){
            return new MetalPurchaseDetail(rst.getString(1),rst.getString(2),rst.getDouble(3),rst.getString(4));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<MetalPurchaseDetail> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from metalPurchaseDetail");
        ArrayList<MetalPurchaseDetail> list=new ArrayList<>();
        while (rst.next()){
            list.add(new MetalPurchaseDetail(rst.getString(1),rst.getString(2),rst.getDouble(3),rst.getString(4)));
        }
        return list;
    }
}
