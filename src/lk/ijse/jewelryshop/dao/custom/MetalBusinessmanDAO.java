package lk.ijse.jewelryshop.dao.custom;

import lk.ijse.jewelryshop.dao.CrudDAO;
import lk.ijse.jewelryshop.entity.MetalBusinessman;

import java.util.ArrayList;

public interface MetalBusinessmanDAO extends CrudDAO<MetalBusinessman,String> {
    public ArrayList<MetalBusinessman> searchUsingName(String metalBusinessmanName) throws Exception;
    public ArrayList<MetalBusinessman> searchUsingId(String metalBusinessmanId) throws Exception;
    public MetalBusinessman searchUseName(String s) throws Exception;
}
