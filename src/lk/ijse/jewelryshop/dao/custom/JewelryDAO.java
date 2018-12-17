package lk.ijse.jewelryshop.dao.custom;

import lk.ijse.jewelryshop.dao.CrudDAO;
import lk.ijse.jewelryshop.entity.Jewelry;

import java.util.ArrayList;

public interface JewelryDAO extends CrudDAO<Jewelry,String> {
    public ArrayList<String> getJewelryIds(String jewelryTypeId) throws Exception;
}
