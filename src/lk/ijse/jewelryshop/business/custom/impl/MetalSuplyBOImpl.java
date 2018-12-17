package lk.ijse.jewelryshop.business.custom.impl;

import lk.ijse.jewelryshop.business.custom.MetalSuplyBO;
import lk.ijse.jewelryshop.dao.DAOFactory;
import lk.ijse.jewelryshop.dao.custom.MetalDAO;
import lk.ijse.jewelryshop.dao.custom.MetalSuplyDetailDAO;
import lk.ijse.jewelryshop.dao.custom.QueryDAO;
import lk.ijse.jewelryshop.db.DBConnection;
import lk.ijse.jewelryshop.entity.CustomEntity;
import lk.ijse.jewelryshop.entity.Metal;
import lk.ijse.jewelryshop.entity.MetalSuplyDetail;
import lk.ijse.jewelryshop.model.MetalDTO;
import lk.ijse.jewelryshop.model.MetalSuplyDTO;

import java.sql.Connection;
import java.util.ArrayList;

public class MetalSuplyBOImpl implements MetalSuplyBO {
    MetalDAO metalDAO=null;
    MetalSuplyDetailDAO metalSuplyDetailDAO=null;
    QueryDAO queryDAO=null;
    public MetalSuplyBOImpl() {
        metalDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.METAL);
        metalSuplyDetailDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.METALSUPLYDETAIL);
        queryDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    }

    @Override
    public boolean addMetalSuplies(MetalSuplyDTO dto) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        conn.setAutoCommit(false);
        try{
            boolean result = metalSuplyDetailDAO.save(new MetalSuplyDetail(dto.getMetalSuplyId(),dto.getMetalId(),dto.getMakerId(),dto.getSupliedWeight(),dto.getSupliedDate()));
            if(!result){
                return false;
            }
            result = metalDAO.updateQuantity(dto.getMetalId(),dto.getSupliedWeight());
            if(!result){
                conn.rollback();
                return false;
            }
            conn.commit();
            return true;
        }finally {
            conn.setAutoCommit(true);
        }
    }

    @Override
    public MetalDTO searchMetal(String id) throws Exception {
        Metal metal = metalDAO.search(id);
        return new MetalDTO(metal.getMetid(),metal.getMetalType(),metal.getCarat(),metal.getAvailableWeight());
    }

    @Override
    public ArrayList<MetalSuplyDTO> getAllMetalSuplies() throws Exception {
        ArrayList<CustomEntity> allMetalSuplies = queryDAO.getAllMetalSuplies();
        ArrayList<MetalSuplyDTO>  suplyDTOS=new ArrayList<>();
        for (CustomEntity c :allMetalSuplies) {
            suplyDTOS.add(new MetalSuplyDTO(c.getMetalSuplyId(),c.getSupliedMetalId(),c.getSupliedMetal(),c.getSupliedCarat(),c.getSupliedWeight(),c.getSupliedMetalMakerId(),c.getSupliedMetalMakerName(),c.getMetalSupliedDate()));
        }
        return suplyDTOS;
    }

    @Override
    public boolean removeMetalSuplies(String id) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        conn.setAutoCommit(false);
        try{
            MetalSuplyDetail list = metalSuplyDetailDAO.search(id);
            boolean result = metalDAO.resetQuantity(list.getMetalId(),list.getWeight());
            if(!result){
                return false;
            }
            result = metalSuplyDetailDAO.delete(id);
            if(!result){
                conn.rollback();
                return false;
            }
            conn.commit();
            return true;
        }finally {
            conn.setAutoCommit(true);
        }
    }

    @Override
    public boolean updateMetalSuplies(MetalSuplyDTO dto) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        conn.setAutoCommit(false);
        try{
            MetalSuplyDetail metalSuplyDetail = metalSuplyDetailDAO.search(dto.getMetalSuplyId());
            boolean result = metalSuplyDetailDAO.update(new MetalSuplyDetail(dto.getMetalSuplyId(),dto.getMetalId(),dto.getMakerId(),dto.getSupliedWeight(),dto.getSupliedDate()));
            if(!result){
                return false;
            }
            double currentWeight=metalSuplyDetail.getWeight();
            double updatedWeight=currentWeight-dto.getSupliedWeight();
            result = metalDAO.resetQuantity(dto.getMetalId(),updatedWeight);
            if(!result){
                conn.rollback();
                return false;
            }
            conn.commit();
            return true;
        }finally {
            conn.setAutoCommit(true);
        }
    }

    @Override
    public ArrayList<MetalDTO> getAllMetalDetails() throws Exception {
        ArrayList<Metal> list = metalDAO.getAll();
        ArrayList<MetalDTO> metalDTOS=new ArrayList<>();
        for (Metal m :list) {
            metalDTOS.add(new MetalDTO(m.getMetid(),m.getMetalType(),m.getCarat(),m.getAvailableWeight()));
        }
        return metalDTOS;
    }

    @Override
    public ArrayList<MetalSuplyDTO> searchMetalSuplyUsingCarat(int carat) throws Exception {
        ArrayList<CustomEntity> allMetalSuplies = queryDAO.searchMetalSuplyUsingCarat(carat);
        ArrayList<MetalSuplyDTO>  suplyDTOS=new ArrayList<>();
        for (CustomEntity c :allMetalSuplies) {
            suplyDTOS.add(new MetalSuplyDTO(c.getMetalSuplyId(),c.getSupliedMetalId(),c.getSupliedMetal(),c.getSupliedCarat(),c.getSupliedWeight(),c.getSupliedMetalMakerId(),c.getSupliedMetalMakerName(),c.getMetalSupliedDate()));
        }
        return suplyDTOS;
    }

    @Override
    public ArrayList<MetalSuplyDTO> searchMetalSuplyUsingMakerId(String makerId) throws Exception {
        ArrayList<CustomEntity> allMetalSuplies = queryDAO.searchMetalSuplyUsingMakerId(makerId);
        ArrayList<MetalSuplyDTO>  suplyDTOS=new ArrayList<>();
        for (CustomEntity c :allMetalSuplies) {
            suplyDTOS.add(new MetalSuplyDTO(c.getMetalSuplyId(),c.getSupliedMetalId(),c.getSupliedMetal(),c.getSupliedCarat(),c.getSupliedWeight(),c.getSupliedMetalMakerId(),c.getSupliedMetalMakerName(),c.getMetalSupliedDate()));
        }
        return suplyDTOS;
    }

    @Override
    public ArrayList<MetalSuplyDTO> searchMetalSuplyUsingMakerName(String makerName) throws Exception {
        ArrayList<CustomEntity> allMetalSuplies = queryDAO.searchMetalSuplyUsingMakerName(makerName);
        ArrayList<MetalSuplyDTO>  suplyDTOS=new ArrayList<>();
        for (CustomEntity c :allMetalSuplies) {
            suplyDTOS.add(new MetalSuplyDTO(c.getMetalSuplyId(),c.getSupliedMetalId(),c.getSupliedMetal(),c.getSupliedCarat(),c.getSupliedWeight(),c.getSupliedMetalMakerId(),c.getSupliedMetalMakerName(),c.getMetalSupliedDate()));
        }
        return suplyDTOS;
    }

    @Override
    public ArrayList<MetalSuplyDTO> searchMetalSuplyUsingMetal(String metal) throws Exception {
        ArrayList<CustomEntity> allMetalSuplies = queryDAO.searchMetalSuplyUsingMetal(metal);
        ArrayList<MetalSuplyDTO>  suplyDTOS=new ArrayList<>();
        for (CustomEntity c :allMetalSuplies) {
            suplyDTOS.add(new MetalSuplyDTO(c.getMetalSuplyId(),c.getSupliedMetalId(),c.getSupliedMetal(),c.getSupliedCarat(),c.getSupliedWeight(),c.getSupliedMetalMakerId(),c.getSupliedMetalMakerName(),c.getMetalSupliedDate()));
        }
        return suplyDTOS;
    }

    @Override
    public ArrayList<MetalSuplyDTO> searchMetalSuplyUsingMetalId(String metalId) throws Exception {
        ArrayList<CustomEntity> allMetalSuplies = queryDAO.searchMetalSuplyUsingMetalId(metalId);
        ArrayList<MetalSuplyDTO>  suplyDTOS=new ArrayList<>();
        for (CustomEntity c :allMetalSuplies) {
            suplyDTOS.add(new MetalSuplyDTO(c.getMetalSuplyId(),c.getSupliedMetalId(),c.getSupliedMetal(),c.getSupliedCarat(),c.getSupliedWeight(),c.getSupliedMetalMakerId(),c.getSupliedMetalMakerName(),c.getMetalSupliedDate()));
        }
        return suplyDTOS;
    }

    @Override
    public ArrayList<MetalSuplyDTO> searchMetalSuplyUsingSuplyDate(String date) throws Exception {
        ArrayList<CustomEntity> allMetalSuplies = queryDAO.searchMetalSuplyUsingSuplyDate(date);
        ArrayList<MetalSuplyDTO>  suplyDTOS=new ArrayList<>();
        for (CustomEntity c :allMetalSuplies) {
            suplyDTOS.add(new MetalSuplyDTO(c.getMetalSuplyId(),c.getSupliedMetalId(),c.getSupliedMetal(),c.getSupliedCarat(),c.getSupliedWeight(),c.getSupliedMetalMakerId(),c.getSupliedMetalMakerName(),c.getMetalSupliedDate()));
        }
        return suplyDTOS;
    }

    @Override
    public ArrayList<MetalSuplyDTO> searchMetalSuplyUsingSuplyId(String suplyId) throws Exception {
        ArrayList<CustomEntity> allMetalSuplies = queryDAO.searchMetalSuplyUsingSuplyId(suplyId);
        ArrayList<MetalSuplyDTO>  suplyDTOS=new ArrayList<>();
        for (CustomEntity c :allMetalSuplies) {
            suplyDTOS.add(new MetalSuplyDTO(c.getMetalSuplyId(),c.getSupliedMetalId(),c.getSupliedMetal(),c.getSupliedCarat(),c.getSupliedWeight(),c.getSupliedMetalMakerId(),c.getSupliedMetalMakerName(),c.getMetalSupliedDate()));
        }
        return suplyDTOS;
    }

    @Override
    public ArrayList<MetalSuplyDTO> searchMetalSuplyUsingWeight(double weight) throws Exception {
        ArrayList<CustomEntity> allMetalSuplies = queryDAO.searchMetalSuplyUsingWeight(weight);
        ArrayList<MetalSuplyDTO>  suplyDTOS=new ArrayList<>();
        for (CustomEntity c :allMetalSuplies) {
            suplyDTOS.add(new MetalSuplyDTO(c.getMetalSuplyId(),c.getSupliedMetalId(),c.getSupliedMetal(),c.getSupliedCarat(),c.getSupliedWeight(),c.getSupliedMetalMakerId(),c.getSupliedMetalMakerName(),c.getMetalSupliedDate()));
        }
        return suplyDTOS;
    }
}
