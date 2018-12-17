package lk.ijse.jewelryshop.business.custom.impl;

import lk.ijse.jewelryshop.business.custom.MetalBusinessmanBO;
import lk.ijse.jewelryshop.dao.DAOFactory;
import lk.ijse.jewelryshop.dao.custom.MetalBusinessmanDAO;
import lk.ijse.jewelryshop.entity.MetalBusinessman;
import lk.ijse.jewelryshop.model.MetalBusinessmanDTO;

import java.util.ArrayList;

public class MetalBusinessmanBOImpl implements MetalBusinessmanBO {
    MetalBusinessmanDAO metalBusinessmanDAO=null;
    public MetalBusinessmanBOImpl(){
        metalBusinessmanDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.METALBUSINESSMAN);
    }

    @Override
    public boolean addMetalBusinessman(MetalBusinessmanDTO dto) throws Exception {
        return metalBusinessmanDAO.save(new MetalBusinessman(dto.getMetbid(),dto.getName(),dto.getContactNo(),dto.getAddress()));
    }

    @Override
    public ArrayList<MetalBusinessmanDTO> getAllMetalBusinessmen() throws Exception {
        ArrayList<MetalBusinessman> metalBusinessmen = metalBusinessmanDAO.getAll();
        ArrayList<MetalBusinessmanDTO> list=new ArrayList<>();
        for (MetalBusinessman m :metalBusinessmen) {
            list.add(new MetalBusinessmanDTO(m.getMetbid(),m.getName(),m.getContactNo(),m.getAddress()));
        }
        return list;
    }

    @Override
    public boolean removeMetalBusinessman(String id) throws Exception {
        return metalBusinessmanDAO.delete(id);
    }

    @Override
    public MetalBusinessmanDTO searchMetalBusinessmanUseId(String id) throws Exception {
        MetalBusinessman metalBusinessman = metalBusinessmanDAO.search(id);
        return new MetalBusinessmanDTO(metalBusinessman.getMetbid(),metalBusinessman.getName(),metalBusinessman.getContactNo(),metalBusinessman.getAddress());
    }

    @Override
    public MetalBusinessmanDTO searchMetalBusinessmanUseName(String name) throws Exception {
        MetalBusinessman metalBusinessman = metalBusinessmanDAO.searchUseName(name);
        return new MetalBusinessmanDTO(metalBusinessman.getMetbid(),metalBusinessman.getName(),metalBusinessman.getContactNo(),metalBusinessman.getAddress());
    }

    @Override
    public boolean updateMetalBusinessman(MetalBusinessmanDTO dto) throws Exception {
        return metalBusinessmanDAO.update(new MetalBusinessman(dto.getMetbid(),dto.getName(),dto.getContactNo(),dto.getAddress()));
    }

    @Override
    public ArrayList<String> getMetalBusinessmenIds() throws Exception {
        ArrayList<MetalBusinessman> metalBusinessmen = metalBusinessmanDAO.getAll();
        ArrayList<String> idList=new ArrayList<>();
        for (MetalBusinessman m : metalBusinessmen) {
            idList.add(m.getMetbid());
        }
        return idList;
    }

    @Override
    public ArrayList<String> getMetalBusinessmenNames() throws Exception {
        ArrayList<MetalBusinessman> metalBusinessmen = metalBusinessmanDAO.getAll();
        ArrayList<String> nameList=new ArrayList<>();
        for (MetalBusinessman m : metalBusinessmen) {
            nameList.add(m.getName());
        }
        return nameList;
    }

    @Override
    public ArrayList<MetalBusinessmanDTO> searchUsingName(String metalBusinessmanName) throws Exception {
        ArrayList<MetalBusinessman> metalBusinessmen = metalBusinessmanDAO.searchUsingName(metalBusinessmanName);
        ArrayList<MetalBusinessmanDTO> list=new ArrayList<>();
        for (MetalBusinessman m :metalBusinessmen) {
            list.add(new MetalBusinessmanDTO(m.getMetbid(),m.getName(),m.getContactNo(),m.getAddress()));
        }
        return list;
    }

    @Override
    public ArrayList<MetalBusinessmanDTO> searchUsingId(String metalBusinessmanId) throws Exception {
        ArrayList<MetalBusinessman> metalBusinessmen = metalBusinessmanDAO.searchUsingId(metalBusinessmanId);
        ArrayList<MetalBusinessmanDTO> list=new ArrayList<>();
        for (MetalBusinessman m :metalBusinessmen) {
            list.add(new MetalBusinessmanDTO(m.getMetbid(),m.getName(),m.getContactNo(),m.getAddress()));
        }
        return list;
    }
}
