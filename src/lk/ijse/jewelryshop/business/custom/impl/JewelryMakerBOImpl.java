package lk.ijse.jewelryshop.business.custom.impl;

import lk.ijse.jewelryshop.business.custom.JewelryMakerBO;
import lk.ijse.jewelryshop.dao.DAOFactory;
import lk.ijse.jewelryshop.dao.custom.impl.JewelryMakerDAOImpl;
import lk.ijse.jewelryshop.entity.JewelryMaker;
import lk.ijse.jewelryshop.model.JewelryMakerDTO;

import java.util.ArrayList;

public class JewelryMakerBOImpl implements JewelryMakerBO {
    JewelryMakerDAOImpl jewelryMakerDAO=null;
    public JewelryMakerBOImpl(){
        jewelryMakerDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.JEWELRYMAKER);
    }

    @Override
    public boolean addJewelryMaker(JewelryMakerDTO dto) throws Exception {
        return jewelryMakerDAO.save(new JewelryMaker(dto.getJmid(),dto.getName(),dto.getContactNo()));
    }

    @Override
    public ArrayList<JewelryMakerDTO> getAllJewelryMakers() throws Exception {
        ArrayList<JewelryMaker> jewelryMakers = jewelryMakerDAO.getAll();
        ArrayList<JewelryMakerDTO> makerList=new ArrayList<>();
        for (JewelryMaker j : jewelryMakers) {
            makerList.add(new JewelryMakerDTO(j.getId(),j.getName(),j.getContactNo()));
        }
        return makerList;
    }

    @Override
    public boolean removeJewelryMaker(String id) throws Exception {
        return jewelryMakerDAO.delete(id);
    }

    @Override
    public JewelryMakerDTO searchJewelryMakerUseId(String id) throws Exception {
        JewelryMaker jewelryMaker = jewelryMakerDAO.search(id);
        return new JewelryMakerDTO(jewelryMaker.getId(),jewelryMaker.getName(),jewelryMaker.getContactNo());
    }

    @Override
    public JewelryMakerDTO searchJewelryMakerUseName(String name) throws Exception {
        JewelryMaker jewelryMaker = jewelryMakerDAO.searchUseName(name);
        return new JewelryMakerDTO(jewelryMaker.getId(),jewelryMaker.getName(),jewelryMaker.getContactNo());
    }

    @Override
    public boolean updateJewelryMaker(JewelryMakerDTO dto) throws Exception {
        return jewelryMakerDAO.update(new JewelryMaker(dto.getJmid(),dto.getName(),dto.getContactNo()));
    }

    @Override
    public ArrayList<String> getJewelryMakersIDs() throws Exception {
        ArrayList<JewelryMaker> jewelryMakers = jewelryMakerDAO.getAll();
        ArrayList<String> idList=new ArrayList<>();
        for (JewelryMaker j : jewelryMakers) {
            idList.add(j.getId());
        }
        return idList;
    }

    @Override
    public ArrayList<String> getJewelryMakersNames() throws Exception {
        ArrayList<JewelryMaker> jewelryMakers = jewelryMakerDAO.getAll();
        ArrayList<String> nameList=new ArrayList<>();
        for (JewelryMaker j : jewelryMakers) {
            nameList.add(j.getName());
        }
        return nameList;
    }

    @Override
    public ArrayList<JewelryMakerDTO> searchUsingName(String jewelryMakerName) throws Exception {
        ArrayList<JewelryMaker> jewelryMakers = jewelryMakerDAO.searchUsingName(jewelryMakerName);
        ArrayList<JewelryMakerDTO> makerList=new ArrayList<>();
        for (JewelryMaker j : jewelryMakers) {
            makerList.add(new JewelryMakerDTO(j.getId(),j.getName(),j.getContactNo()));
        }
        return makerList;
    }

    @Override
    public ArrayList<JewelryMakerDTO> searchUsingId(String jewelryMakerId) throws Exception {
        ArrayList<JewelryMaker> jewelryMakers = jewelryMakerDAO.searchUsingId(jewelryMakerId);
        ArrayList<JewelryMakerDTO> makerList=new ArrayList<>();
        for (JewelryMaker j : jewelryMakers) {
            makerList.add(new JewelryMakerDTO(j.getId(),j.getName(),j.getContactNo()));
        }
        return makerList;
    }
}
