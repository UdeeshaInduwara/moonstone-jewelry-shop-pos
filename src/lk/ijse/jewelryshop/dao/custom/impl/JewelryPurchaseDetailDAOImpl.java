package lk.ijse.jewelryshop.dao.custom.impl;

import lk.ijse.jewelryshop.dao.CrudUtil;
import lk.ijse.jewelryshop.dao.custom.JewelryPurchaseDetailDAO;
import lk.ijse.jewelryshop.entity.JewelryPurchaseDetail;
import lk.ijse.jewelryshop.entity.JewelryPurchaseDetail_PK;

import java.sql.ResultSet;
import java.util.ArrayList;

public class JewelryPurchaseDetailDAOImpl implements JewelryPurchaseDetailDAO {
    @Override
    public boolean save(JewelryPurchaseDetail entity) throws Exception {
        return CrudUtil.executeUpdate("insert into jewelryPurchaseDetail values(?,?,?,?,?,?,?,?,?)",
                entity.getJewelryPurchaseDetail_pk().getOrderId(),
                entity.getJewelryPurchaseDetail_pk().getJewelryId(),
                entity.getJewelryTypeId(),
                entity.getMetal(),
                entity.getCarat(),
                entity.getWeight(),
                entity.getJewelrySize(),
                entity.getEmbroidedgem(),
                entity.getUnitPrice()) > 0;
    }

    @Override
    public boolean update(JewelryPurchaseDetail entity) throws Exception {
        return CrudUtil.executeUpdate("update jewelryPurchaseDetail set oid=?,jtid=?,metal=?,carat=?,weight=?,jewelrysize=?,embroiderdgem=?,unitprice=?,jewid=? ",
                entity.getJewelryPurchaseDetail_pk().getOrderId(),
                entity.getJewelryTypeId(),
                entity.getMetal(),
                entity.getCarat(),
                entity.getWeight(),
                entity.getJewelrySize(),
                entity.getEmbroidedgem(),
                entity.getUnitPrice(),
                entity.getJewelryPurchaseDetail_pk().getJewelryId()) > 0;
    }

    @Override
    public boolean delete(JewelryPurchaseDetail_PK jewelryPurchaseDetail_pk) throws Exception {
        return CrudUtil.executeUpdate("delete from jewelryPurchaseDetail where jewid=? ",jewelryPurchaseDetail_pk.getJewelryId()) > 0;
    }

    @Override
    public JewelryPurchaseDetail search(JewelryPurchaseDetail_PK jewelryPurchaseDetail_pk) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from jewelryPurchaseDetail where jewid=? ", jewelryPurchaseDetail_pk.getJewelryId());
        if (rst.next()){
            return new JewelryPurchaseDetail(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getDouble(6),rst.getDouble(7),rst.getString(8),rst.getDouble(9));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<JewelryPurchaseDetail> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from jewelryPurchaseDetail");
        ArrayList<JewelryPurchaseDetail> list=new ArrayList<>();
        while (rst.next()){
            list.add(new JewelryPurchaseDetail(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getDouble(6),rst.getDouble(7),rst.getString(8),rst.getDouble(9)));
        }
        return list;
    }
}
