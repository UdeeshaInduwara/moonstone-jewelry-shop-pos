package lk.ijse.jewelryshop.dao.custom;

import lk.ijse.jewelryshop.dao.CrudDAO;
import lk.ijse.jewelryshop.entity.JewelryType;

public interface JewelryTypeDAO extends CrudDAO<JewelryType,String> {
    public boolean downQuantity(String jewelryTypeId) throws Exception;
    public boolean addQuantity(String jewelryTypeId) throws Exception;
    public JewelryType searchUsingId(String id) throws Exception;
}
