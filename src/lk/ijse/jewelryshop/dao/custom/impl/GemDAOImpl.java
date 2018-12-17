package lk.ijse.jewelryshop.dao.custom.impl;

import lk.ijse.jewelryshop.dao.CrudUtil;
import lk.ijse.jewelryshop.dao.custom.GemDAO;
import lk.ijse.jewelryshop.entity.Gem;

import java.sql.ResultSet;
import java.util.ArrayList;

public class GemDAOImpl implements GemDAO {
    @Override
    public boolean save(Gem entity) throws Exception {
        return CrudUtil.executeUpdate("insert into gem values(?,?,?,?)",
                entity.getGemid(),
                entity.getCarat(),
                entity.getSuplyDate(),
                entity.getMakerId()) >0;
    }

    @Override
    public boolean update(Gem entity) throws Exception {
        return CrudUtil.executeUpdate("update gem set carat=?,suplydate=?,jmid=? where gemid=? ",
                entity.getCarat(),
                entity.getSuplyDate(),
                entity.getMakerId(),
                entity.getGemid()) >0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("delete from gem where gemid=? ",s) > 0;
    }

    @Override
    public Gem search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from gem where gemid=? ", s);
        if (rst.next()){
            return new Gem(rst.getString(1),rst.getDouble(2),rst.getString(3),rst.getString(4));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Gem> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from gem");
        ArrayList<Gem> gems=new ArrayList<>();
        while (rst.next()){
            gems.add(new Gem(rst.getString(1),rst.getDouble(2),rst.getString(3),rst.getString(4)));
        }
        return gems;
    }
}
