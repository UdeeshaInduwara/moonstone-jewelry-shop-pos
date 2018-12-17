package lk.ijse.jewelryshop.dao.custom.impl;

import lk.ijse.jewelryshop.dao.CrudUtil;
import lk.ijse.jewelryshop.dao.custom.QueryDAO;
import lk.ijse.jewelryshop.db.DBConnection;
import lk.ijse.jewelryshop.entity.CustomEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<CustomEntity> getAllGemDetails() throws Exception {
        ResultSet rst = CrudUtil.executeQuery(
                "select gemid,carat,suplydate,j.jmid,j.name from gem g,jewelrymaker j where g.jmid=j.jmid");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getDouble(2),rst.getString(3),rst.getString(4),rst.getString(5)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> getMetalStokDetail() throws Exception {
        ResultSet rst = CrudUtil.executeQuery(
                "select m.metid,metaltype,carat,weight,purchaseDate,mb.metbid,name from metal m,metalPurchaseDetail mp,metalBusinessman mb where m.metid=mp.metid and mp.metbid=mb.metbid");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4),rst.getString(5),rst.getString(6),rst.getString(7)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> getJewelryStockDetail() throws Exception {
        ResultSet rst = CrudUtil.executeQuery(
                "select jt.name,jt.jtid,j.jewid,metal,carat,weight,jewelrySize,embroiderdGem,price,jm.jmid,jm.name,makeDate from jewelry j,jewelryType jt,jewelryMaker jm,jewelryMakeDetail jmd where j.jtid=jt.jtid and j.jewid=jmd.jewid and jmd.jmid=jm.jmid");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getDouble(6),rst.getDouble(7),rst.getString(8),rst.getDouble(9),rst.getString(10),rst.getString(11),rst.getString(12)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> getAllMetalSuplies() throws Exception {
        ResultSet rst = CrudUtil.executeQuery(
                "select metsupid,m.metid,metalType,carat,msd.weight,jm.jmid,jm.name,suplyDate from metal m,metalSuplyDetail msd,jewelryMaker jm where m.metid=msd.metid and jm.jmid=msd.jmid");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while(rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getDouble(5),rst.getString(6),rst.getString(7),rst.getString(8)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchGemDetailUsingCarat(double carat) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select gemid,carat,suplydate,j.jmid,j.name from gem g,jewelrymaker j where g.jmid=j.jmid and carat like '%"+carat+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getDouble(2),rst.getString(3),rst.getString(4),rst.getString(5)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchGemDetailUsingGemId(String gemId) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select gemid,carat,suplydate,j.jmid,j.name from gem g,jewelrymaker j where g.jmid=j.jmid and gemid like '%"+gemId+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getDouble(2),rst.getString(3),rst.getString(4),rst.getString(5)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchGemDetailUsingMakerId(String makerId) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select gemid,carat,suplydate,j.jmid,j.name from gem g,jewelrymaker j where g.jmid=j.jmid and j.jmid like '%"+makerId+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getDouble(2),rst.getString(3),rst.getString(4),rst.getString(5)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchGemDetailUsingMakerName(String makerName) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select gemid,carat,suplydate,j.jmid,j.name from gem g,jewelrymaker j where g.jmid=j.jmid and j.name like '%"+makerName+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getDouble(2),rst.getString(3),rst.getString(4),rst.getString(5)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchGemDetailUsingSuplyDate(String suplyDate) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select gemid,carat,suplydate,j.jmid,j.name from gem g,jewelrymaker j where g.jmid=j.jmid and suplydate like '%"+suplyDate+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getDouble(2),rst.getString(3),rst.getString(4),rst.getString(5)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchMetalStockUsingBusinessmanId(String id) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select m.metid,metaltype,carat,weight,purchaseDate,mb.metbid,name from metal m,metalPurchaseDetail mp,metalBusinessman mb where m.metid=mp.metid and mp.metbid=mb.metbid and mb.metbid like '%"+id+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4),rst.getString(5),rst.getString(6),rst.getString(7)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchMetalStockUsingBusinessmanName(String name) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select m.metid,metaltype,carat,weight,purchaseDate,mb.metbid,name from metal m,metalPurchaseDetail mp,metalBusinessman mb where m.metid=mp.metid and mp.metbid=mb.metbid and name like '%"+name+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4),rst.getString(5),rst.getString(6),rst.getString(7)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchMetalStockUsingCarat(int carat) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select m.metid,metaltype,carat,weight,purchaseDate,mb.metbid,name from metal m,metalPurchaseDetail mp,metalBusinessman mb where m.metid=mp.metid and mp.metbid=mb.metbid and carat like '%"+carat+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4),rst.getString(5),rst.getString(6),rst.getString(7)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchMetalStockUsingMetal(String metal) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select m.metid,metaltype,carat,weight,purchaseDate,mb.metbid,name from metal m,metalPurchaseDetail mp,metalBusinessman mb where m.metid=mp.metid and mp.metbid=mb.metbid and metaltype like '%"+metal+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4),rst.getString(5),rst.getString(6),rst.getString(7)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchMetalStockUsingMetalId(String id) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select m.metid,metaltype,carat,weight,purchaseDate,mb.metbid,name from metal m,metalPurchaseDetail mp,metalBusinessman mb where m.metid=mp.metid and mp.metbid=mb.metbid and m.metid like '%"+id+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4),rst.getString(5),rst.getString(6),rst.getString(7)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchMetalStockUsingPurchaseDate(String date) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select m.metid,metaltype,carat,weight,purchaseDate,mb.metbid,name from metal m,metalPurchaseDetail mp,metalBusinessman mb where m.metid=mp.metid and mp.metbid=mb.metbid and purchaseDate like '%"+date+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4),rst.getString(5),rst.getString(6),rst.getString(7)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchMetalStockUsingWeight(double weight) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select m.metid,metaltype,carat,weight,purchaseDate,mb.metbid,name from metal m,metalPurchaseDetail mp,metalBusinessman mb where m.metid=mp.metid and mp.metbid=mb.metbid and weight like '%"+weight+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4),rst.getString(5),rst.getString(6),rst.getString(7)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchMetalSuplyUsingCarat(int carat) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select metsupid,m.metid,metalType,carat,msd.weight,jm.jmid,jm.name,suplyDate from metal m,metalSuplyDetail msd,jewelryMaker jm where m.metid=msd.metid and jm.jmid=msd.jmid and carat like'%"+carat+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while(rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getDouble(5),rst.getString(6),rst.getString(7),rst.getString(8)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchMetalSuplyUsingMakerId(String makerId) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select metsupid,m.metid,metalType,carat,msd.weight,jm.jmid,jm.name,suplyDate from metal m,metalSuplyDetail msd,jewelryMaker jm where m.metid=msd.metid and jm.jmid=msd.jmid and jm.jmid like'%"+makerId+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while(rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getDouble(5),rst.getString(6),rst.getString(7),rst.getString(8)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchMetalSuplyUsingMakerName(String makerName) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select metsupid,m.metid,metalType,carat,msd.weight,jm.jmid,jm.name,suplyDate from metal m,metalSuplyDetail msd,jewelryMaker jm where m.metid=msd.metid and jm.jmid=msd.jmid and jm.name like'%"+makerName+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while(rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getDouble(5),rst.getString(6),rst.getString(7),rst.getString(8)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchMetalSuplyUsingMetal(String metal) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select metsupid,m.metid,metalType,carat,msd.weight,jm.jmid,jm.name,suplyDate from metal m,metalSuplyDetail msd,jewelryMaker jm where m.metid=msd.metid and jm.jmid=msd.jmid and metalType like'%"+metal+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while(rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getDouble(5),rst.getString(6),rst.getString(7),rst.getString(8)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchMetalSuplyUsingMetalId(String metalId) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select metsupid,m.metid,metalType,carat,msd.weight,jm.jmid,jm.name,suplyDate from metal m,metalSuplyDetail msd,jewelryMaker jm where m.metid=msd.metid and jm.jmid=msd.jmid and m.metid like'%"+metalId+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while(rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getDouble(5),rst.getString(6),rst.getString(7),rst.getString(8)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchMetalSuplyUsingSuplyDate(String date) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select metsupid,m.metid,metalType,carat,msd.weight,jm.jmid,jm.name,suplyDate from metal m,metalSuplyDetail msd,jewelryMaker jm where m.metid=msd.metid and jm.jmid=msd.jmid and suplyDate like'%"+date+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while(rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getDouble(5),rst.getString(6),rst.getString(7),rst.getString(8)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchMetalSuplyUsingSuplyId(String suplyId) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select metsupid,m.metid,metalType,carat,msd.weight,jm.jmid,jm.name,suplyDate from metal m,metalSuplyDetail msd,jewelryMaker jm where m.metid=msd.metid and jm.jmid=msd.jmid and metsupid like'%"+suplyId+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while(rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getDouble(5),rst.getString(6),rst.getString(7),rst.getString(8)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchMetalSuplyUsingWeight(double weight) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select metsupid,m.metid,metalType,carat,msd.weight,jm.jmid,jm.name,suplyDate from metal m,metalSuplyDetail msd,jewelryMaker jm where m.metid=msd.metid and jm.jmid=msd.jmid and msd.weight like'%"+weight+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while(rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getDouble(5),rst.getString(6),rst.getString(7),rst.getString(8)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchJewelryStockUsingGem(String gem) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select jt.name,jt.jtid,j.jewid,metal,carat,weight,jewelrySize,embroiderdGem,price,jm.jmid,jm.name,makeDate from jewelry j,jewelryType jt,jewelryMaker jm,jewelryMakeDetail jmd where j.jtid=jt.jtid and j.jewid=jmd.jewid and jmd.jmid=jm.jmid and embroiderdGem like '%"+gem+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getDouble(6),rst.getDouble(7),rst.getString(8),rst.getDouble(9),rst.getString(10),rst.getString(11),rst.getString(12)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchJewelryStockUsingJewelryId(String jewelryId) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select jt.name,jt.jtid,j.jewid,metal,carat,weight,jewelrySize,embroiderdGem,price,jm.jmid,jm.name,makeDate from jewelry j,jewelryType jt,jewelryMaker jm,jewelryMakeDetail jmd where j.jtid=jt.jtid and j.jewid=jmd.jewid and jmd.jmid=jm.jmid and j.jewid like '%"+jewelryId+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getDouble(6),rst.getDouble(7),rst.getString(8),rst.getDouble(9),rst.getString(10),rst.getString(11),rst.getString(12)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchJewelryStockUsingJewelryType(String jewelrytype) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select jt.name,jt.jtid,j.jewid,metal,carat,weight,jewelrySize,embroiderdGem,price,jm.jmid,jm.name,makeDate from jewelry j,jewelryType jt,jewelryMaker jm,jewelryMakeDetail jmd where j.jtid=jt.jtid and j.jewid=jmd.jewid and jmd.jmid=jm.jmid and jt.name like '%"+jewelrytype+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getDouble(6),rst.getDouble(7),rst.getString(8),rst.getDouble(9),rst.getString(10),rst.getString(11),rst.getString(12)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchJewelryStockUsingMakeDate(String date) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select jt.name,jt.jtid,j.jewid,metal,carat,weight,jewelrySize,embroiderdGem,price,jm.jmid,jm.name,makeDate from jewelry j,jewelryType jt,jewelryMaker jm,jewelryMakeDetail jmd where j.jtid=jt.jtid and j.jewid=jmd.jewid and jmd.jmid=jm.jmid and makeDate like '%"+date+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getDouble(6),rst.getDouble(7),rst.getString(8),rst.getDouble(9),rst.getString(10),rst.getString(11),rst.getString(12)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchJewelryStockUsingMakerId(String makerId) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select jt.name,jt.jtid,j.jewid,metal,carat,weight,jewelrySize,embroiderdGem,price,jm.jmid,jm.name,makeDate from jewelry j,jewelryType jt,jewelryMaker jm,jewelryMakeDetail jmd where j.jtid=jt.jtid and j.jewid=jmd.jewid and jmd.jmid=jm.jmid and jm.jmid like '%"+makerId+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getDouble(6),rst.getDouble(7),rst.getString(8),rst.getDouble(9),rst.getString(10),rst.getString(11),rst.getString(12)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchJewelryStockUsingMetal(String metal) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select jt.name,jt.jtid,j.jewid,metal,carat,weight,jewelrySize,embroiderdGem,price,jm.jmid,jm.name,makeDate from jewelry j,jewelryType jt,jewelryMaker jm,jewelryMakeDetail jmd where j.jtid=jt.jtid and j.jewid=jmd.jewid and jmd.jmid=jm.jmid and metal like '%"+metal+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getDouble(6),rst.getDouble(7),rst.getString(8),rst.getDouble(9),rst.getString(10),rst.getString(11),rst.getString(12)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchJewelryStockUsingPrice(double price) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select jt.name,jt.jtid,j.jewid,metal,carat,weight,jewelrySize,embroiderdGem,price,jm.jmid,jm.name,makeDate from jewelry j,jewelryType jt,jewelryMaker jm,jewelryMakeDetail jmd where j.jtid=jt.jtid and j.jewid=jmd.jewid and jmd.jmid=jm.jmid and price like '%"+price+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getDouble(6),rst.getDouble(7),rst.getString(8),rst.getDouble(9),rst.getString(10),rst.getString(11),rst.getString(12)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchJewelryStockUsingSize(double size) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("select jt.name,jt.jtid,j.jewid,metal,carat,weight,jewelrySize,embroiderdGem,price,jm.jmid,jm.name,makeDate from jewelry j,jewelryType jt,jewelryMaker jm,jewelryMakeDetail jmd where j.jtid=jt.jtid and j.jewid=jmd.jewid and jmd.jmid=jm.jmid and jewelrySize like '%"+size+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getDouble(6),rst.getDouble(7),rst.getString(8),rst.getDouble(9),rst.getString(10),rst.getString(11),rst.getString(12)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchJewelryStockUsingWeight(double weight) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select jt.name,jt.jtid,j.jewid,metal,carat,weight,jewelrySize,embroiderdGem,price,jm.jmid,jm.name,makeDate from jewelry j,jewelryType jt,jewelryMaker jm,jewelryMakeDetail jmd where j.jtid=jt.jtid and j.jewid=jmd.jewid and jmd.jmid=jm.jmid and weight like '%"+weight+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getDouble(6),rst.getDouble(7),rst.getString(8),rst.getDouble(9),rst.getString(10),rst.getString(11),rst.getString(12)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchJewelryStockUsingCarat(int carat) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select jt.name,jt.jtid,j.jewid,metal,carat,weight,jewelrySize,embroiderdGem,price,jm.jmid,jm.name,makeDate from jewelry j,jewelryType jt,jewelryMaker jm,jewelryMakeDetail jmd where j.jtid=jt.jtid and j.jewid=jmd.jewid and jmd.jmid=jm.jmid and carat like '%"+carat+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getDouble(6),rst.getDouble(7),rst.getString(8),rst.getDouble(9),rst.getString(10),rst.getString(11),rst.getString(12)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> searchJewelryStockUsingMakerName(String makerName) throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select jt.name,jt.jtid,j.jewid,metal,carat,weight,jewelrySize,embroiderdGem,price,jm.jmid,jm.name,makeDate from jewelry j,jewelryType jt,jewelryMaker jm,jewelryMakeDetail jmd where j.jtid=jt.jtid and j.jewid=jmd.jewid and jmd.jmid=jm.jmid and jm.name like '%"+makerName+"%'");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getDouble(6),rst.getDouble(7),rst.getString(8),rst.getDouble(9),rst.getString(10),rst.getString(11),rst.getString(12)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> getAllSelledJewelry() throws Exception {
        ResultSet rst = CrudUtil.executeQuery(
                "select jt.jtid,jt.name,jewid,metal,carat,weight,jewelrySize,embroiderdGem,orderdate,c.custid,c.name,unitPrice from jewelrypurchasedetail jp,orders o,customer c,jewelrytype jt where jp.oid=o.oid and o.custid=c.custid and jp.jtid=jt.jtid order by orderdate desc");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getDouble(6),rst.getDouble(7),rst.getString(8),rst.getString(9),rst.getString(10),rst.getString(11),rst.getDouble(12)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> getCurrentMonthJewelrySales() throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select jt.name,count(jp.jtid) as jewelryCount from jewelrypurchasedetail jp,orders o,jewelrytype jt where jp.oid=o.oid and jp.jtid=jt.jtid and month(curdate())=month(orderDate) and year(o.orderDate)=year(curdate()) group by jp.jtid");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getInt(2)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> getMonthlyJewelrySales() throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select monthname(o.orderDate),count(jp.jtid) from jewelrypurchasedetail jp,orders o where jp.oid=o.oid and year(o.orderDate)=year(curdate()) group by monthname(o.orderDate) order by month(o.orderDate) asc");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getInt(2)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> getCurrentMonthHotelsSentCustomers() throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select h.name,count(c.passportNo) from customer c,hotel h,orders o where c.hid=h.hid and c.custid=o.custid and month(o.orderDate)=month(curdate()) and year(orderDate)=year(curdate()) group by h.hid"
        );
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getInt(2)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> getMonthlyCustomersArrival() throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select monthname(orderDate),count(c.custid)from customer c,orders o where c.custid=o.custid and year(orderDate)=year(curdate())group by monthname(orderDate) order by month(orderDate) asc");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getInt(2)));
        }
        return list;
    }

    @Override
    public ArrayList<CustomEntity> getMonthlyIncome() throws Exception {
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(
                "select monthname(o.orderDate),sum(p.amount)from payment p,orders o where p.oid=o.oid and year(o.orderDate)=year(curdate())group by monthname(o.orderDate) order by month(o.orderDate) asc");
        ArrayList<CustomEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new CustomEntity(rst.getString(1),rst.getInt(2)));
        }
        return list;
    }
}
