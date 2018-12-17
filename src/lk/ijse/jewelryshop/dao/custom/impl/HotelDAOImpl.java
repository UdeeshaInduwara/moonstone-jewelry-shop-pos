package lk.ijse.jewelryshop.dao.custom.impl;

import lk.ijse.jewelryshop.dao.CrudUtil;
import lk.ijse.jewelryshop.dao.custom.HotelDAO;
import lk.ijse.jewelryshop.db.DBConnection;
import lk.ijse.jewelryshop.entity.Hotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class HotelDAOImpl implements HotelDAO {
    @Override
    public boolean save(Hotel entity) throws Exception {
        return CrudUtil.executeUpdate("insert into hotel values(?,?,?,?)",
                entity.getHid(),
                entity.getName(),
                entity.getCity(),
                entity.getContactNo()) > 0;
    }

    @Override
    public boolean update(Hotel entity) throws Exception {
        return CrudUtil.executeUpdate("update hotel set name=?,city=?,contactno=? where hid=? ",
                entity.getName(),
                entity.getCity(),
                entity.getContactNo(),
                entity.getHid()) > 0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("delete from hotel where hid=? ",s) > 0;
    }

    @Override
    public Hotel search(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from hotel where hid=? ", s);
        if(rst.next()){
            return new Hotel(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Hotel> getAll() throws Exception {
        ArrayList<Hotel> hotels=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from hotel");
        while (rst.next()){
            hotels.add(new Hotel(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
        }
        return hotels;
    }

    @Override
    public ArrayList<Hotel> searchUsingName(String hotelName) throws Exception {
        ArrayList<Hotel> hotels=new ArrayList<>();
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("select * from hotel where name like '%"+hotelName+"%'");
        while (rst.next()){
            hotels.add(new Hotel(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
        }
        return hotels;
    }

    @Override
    public ArrayList<Hotel> searchUsingId(String hotelId) throws Exception {
        ArrayList<Hotel> hotels=new ArrayList<>();
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("select * from hotel where hid like '%"+hotelId+"%'");
        while (rst.next()){
            hotels.add(new Hotel(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
        }
        return hotels;
    }

    @Override
    public ArrayList<Hotel> searchUsingCity(String hotelCity) throws Exception {
        ArrayList<Hotel> hotels=new ArrayList<>();
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("select * from hotel where city like '%"+hotelCity+"%'");
        while (rst.next()){
            hotels.add(new Hotel(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
        }
        return hotels;
    }

    @Override
    public Hotel searchUseName(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from hotel where name=? ", s);
        if(rst.next()){
            return new Hotel(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
        }else {
            return null;
        }
    }
}
