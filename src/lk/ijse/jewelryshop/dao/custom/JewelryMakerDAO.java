package lk.ijse.jewelryshop.dao.custom;

import lk.ijse.jewelryshop.dao.CrudDAO;
import lk.ijse.jewelryshop.entity.JewelryMaker;

import java.util.ArrayList;

public interface JewelryMakerDAO extends CrudDAO<JewelryMaker,String> {
    public ArrayList<JewelryMaker> searchUsingName(String jewelryMakerName) throws Exception;
    public ArrayList<JewelryMaker> searchUsingId(String jewelryMakerId) throws Exception;
    public JewelryMaker searchUseName(String s) throws Exception ;
}
