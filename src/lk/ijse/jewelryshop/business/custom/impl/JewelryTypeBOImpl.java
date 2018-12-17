package lk.ijse.jewelryshop.business.custom.impl;

import lk.ijse.jewelryshop.business.custom.JewelryTypeBO;
import lk.ijse.jewelryshop.dao.DAOFactory;
import lk.ijse.jewelryshop.dao.custom.JewelryTypeDAO;
import lk.ijse.jewelryshop.entity.JewelryType;
import lk.ijse.jewelryshop.model.JewelryTypeDTO;

import java.util.ArrayList;

public class JewelryTypeBOImpl implements JewelryTypeBO {
    JewelryTypeDAO jewelryTypeDAO=null;
    public JewelryTypeBOImpl() {
        jewelryTypeDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.JEWELRYTYPE);
    }

    @Override
    public boolean saveJewelryType(JewelryTypeDTO dto) throws Exception {
        return jewelryTypeDAO.save(new JewelryType(dto.getJewelryTypeId(),dto.getName(),dto.getQuantity()));
    }

    @Override
    public boolean updateJewelryType(JewelryTypeDTO dto) throws Exception {
        return jewelryTypeDAO.update(new JewelryType(dto.getJewelryTypeId(),dto.getName(),dto.getQuantity()));
    }

    @Override
    public boolean deleteJewelrytype(String s) throws Exception {
        return jewelryTypeDAO.delete(s);
    }

    @Override
    public ArrayList<JewelryTypeDTO> getAllJewelryType() throws Exception {
        ArrayList<JewelryType> list = jewelryTypeDAO.getAll();
        ArrayList<JewelryTypeDTO> dtos=new ArrayList<>();
        for (JewelryType j :list) {
            dtos.add(new JewelryTypeDTO(j.getJewelryTypeId(),j.getName(),j.getJewelryQty()));
        }
        return dtos;
    }
}
