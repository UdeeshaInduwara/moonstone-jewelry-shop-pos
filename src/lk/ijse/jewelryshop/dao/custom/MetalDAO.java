package lk.ijse.jewelryshop.dao.custom;

import lk.ijse.jewelryshop.dao.CrudDAO;
import lk.ijse.jewelryshop.entity.Metal;

public interface MetalDAO extends CrudDAO<Metal,String> {
    public boolean updateQuantity(String metalid,double weight) throws Exception;
    public boolean resetQuantity(String metalid,double weight) throws Exception;
}
