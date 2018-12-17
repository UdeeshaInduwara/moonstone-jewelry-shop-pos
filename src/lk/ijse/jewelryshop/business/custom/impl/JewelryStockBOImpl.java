package lk.ijse.jewelryshop.business.custom.impl;

import lk.ijse.jewelryshop.business.custom.JewelryStockBO;
import lk.ijse.jewelryshop.dao.DAOFactory;
import lk.ijse.jewelryshop.dao.custom.JewelryDAO;
import lk.ijse.jewelryshop.dao.custom.JewelryMakeDetailDAO;
import lk.ijse.jewelryshop.dao.custom.JewelryTypeDAO;
import lk.ijse.jewelryshop.dao.custom.QueryDAO;
import lk.ijse.jewelryshop.db.DBConnection;
import lk.ijse.jewelryshop.entity.CustomEntity;
import lk.ijse.jewelryshop.entity.Jewelry;
import lk.ijse.jewelryshop.entity.JewelryMakeDetail;
import lk.ijse.jewelryshop.entity.JewelryType;
import lk.ijse.jewelryshop.model.JewelryStockDTO;

import java.sql.Connection;
import java.util.ArrayList;

public class JewelryStockBOImpl implements JewelryStockBO {
    JewelryDAO jewelryDAO=null;
    JewelryTypeDAO jewelryTypeDAO=null;
    JewelryMakeDetailDAO jewelryMakeDetailDAO=null;
    QueryDAO queryDAO=null;
    public JewelryStockBOImpl() {
        jewelryDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.JEWELRY);
        jewelryTypeDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.JEWELRYTYPE);
        jewelryMakeDetailDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.JEWELRYMAKEDETAIL);
        queryDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    }

    @Override
    public boolean addJewelryStock(JewelryStockDTO dto) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        conn.setAutoCommit(false);
        try{
            boolean result = jewelryDAO.save(new Jewelry(dto.getJewelryId(),dto.getMetal(),dto.getCarat(),dto.getWeight(),dto.getSize(),dto.getGem(),dto.getPrice(),dto.getJewelryTypeId()));
            if(!result){
                return false;
            }
            result = jewelryTypeDAO.addQuantity(dto.getJewelryTypeId());
            if(!result){
                conn.rollback();
                return false;
            }
            result = jewelryMakeDetailDAO.save(new JewelryMakeDetail(dto.getJewelryId(),dto.getMakerId(),dto.getDate()));
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
    public ArrayList<JewelryStockDTO> getJewelryStockDetails() throws Exception {
        ArrayList<CustomEntity> jewelryStokDetail=queryDAO.getJewelryStockDetail();
        ArrayList<JewelryStockDTO> list=new ArrayList<>();
        for (CustomEntity c :jewelryStokDetail) {
            JewelryStockDTO dto = new JewelryStockDTO(c.getJewelryType(),c.getJewelryTypeId(),c.getJewelryId(),c.getJewelryMetal(),c.getJewelryCarat(),c.getJewelryWeight(),c.getJewelrySize(),c.getJewelryEmbGem(),c.getJewelryPrice(),c.getJewelryMakerId(),c.getJewelryMakerName(),c.getDate());
            list.add(dto);
        }
        return list;
    }

    @Override
    public boolean removeJewelryStock(String jewelryId,String jewelryTypeId) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        conn.setAutoCommit(false);
        try{
            boolean result = jewelryDAO.delete(jewelryId);
            if(!result){
                return false;
            }
            result = jewelryTypeDAO.downQuantity(jewelryTypeId);
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
    public boolean updateJewlryStock(JewelryStockDTO dto) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        conn.setAutoCommit(false);
        try{
            boolean result = jewelryDAO.update(new Jewelry(dto.getJewelryId(),dto.getMetal(),dto.getCarat(),dto.getWeight(),dto.getSize(),dto.getGem(),dto.getPrice(),dto.getJewelryTypeId()));
            if(!result){
                return false;
            }
            result = jewelryMakeDetailDAO.update(new JewelryMakeDetail(dto.getJewelryId(),dto.getMakerId(),dto.getDate()));
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
    public ArrayList<String> getJewelryTypes() throws Exception {
        ArrayList<JewelryType> list = jewelryTypeDAO.getAll();
        ArrayList<String> typeList=new ArrayList<>();
        for (JewelryType j :list) {
            typeList.add(j.getName());
        }
        return typeList;
    }

    @Override
    public String getJewelryTypeId(String name) throws Exception {
        JewelryType jewelryType = jewelryTypeDAO.search(name);
        return jewelryType.getJewelryTypeId();
    }

    @Override
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingGem(String gem) throws Exception {
        ArrayList<CustomEntity> jewelryStokDetail=queryDAO.searchJewelryStockUsingGem(gem);
        ArrayList<JewelryStockDTO> list=new ArrayList<>();
        for (CustomEntity c :jewelryStokDetail) {
            JewelryStockDTO dto = new JewelryStockDTO(c.getJewelryType(),c.getJewelryTypeId(),c.getJewelryId(),c.getJewelryMetal(),c.getJewelryCarat(),c.getJewelryWeight(),c.getJewelrySize(),c.getJewelryEmbGem(),c.getJewelryPrice(),c.getJewelryMakerId(),c.getJewelryMakerName(),c.getDate());
            list.add(dto);
        }
        return list;
    }

    @Override
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingJewelryId(String jewelryId) throws Exception {
        ArrayList<CustomEntity> jewelryStokDetail=queryDAO.searchJewelryStockUsingJewelryId(jewelryId);
        ArrayList<JewelryStockDTO> list=new ArrayList<>();
        for (CustomEntity c :jewelryStokDetail) {
            JewelryStockDTO dto = new JewelryStockDTO(c.getJewelryType(),c.getJewelryTypeId(),c.getJewelryId(),c.getJewelryMetal(),c.getJewelryCarat(),c.getJewelryWeight(),c.getJewelrySize(),c.getJewelryEmbGem(),c.getJewelryPrice(),c.getJewelryMakerId(),c.getJewelryMakerName(),c.getDate());
            list.add(dto);
        }
        return list;
    }

    @Override
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingJewelryType(String jewelrytype) throws Exception {
        ArrayList<CustomEntity> jewelryStokDetail=queryDAO.searchJewelryStockUsingJewelryType(jewelrytype);
        ArrayList<JewelryStockDTO> list=new ArrayList<>();
        for (CustomEntity c :jewelryStokDetail) {
            JewelryStockDTO dto = new JewelryStockDTO(c.getJewelryType(),c.getJewelryTypeId(),c.getJewelryId(),c.getJewelryMetal(),c.getJewelryCarat(),c.getJewelryWeight(),c.getJewelrySize(),c.getJewelryEmbGem(),c.getJewelryPrice(),c.getJewelryMakerId(),c.getJewelryMakerName(),c.getDate());
            list.add(dto);
        }
        return list;
    }

    @Override
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingMakeDate(String date) throws Exception {
        ArrayList<CustomEntity> jewelryStokDetail=queryDAO.searchJewelryStockUsingMakeDate(date);
        ArrayList<JewelryStockDTO> list=new ArrayList<>();
        for (CustomEntity c :jewelryStokDetail) {
            JewelryStockDTO dto = new JewelryStockDTO(c.getJewelryType(),c.getJewelryTypeId(),c.getJewelryId(),c.getJewelryMetal(),c.getJewelryCarat(),c.getJewelryWeight(),c.getJewelrySize(),c.getJewelryEmbGem(),c.getJewelryPrice(),c.getJewelryMakerId(),c.getJewelryMakerName(),c.getDate());
            list.add(dto);
        }
        return list;
    }

    @Override
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingMakerId(String makerId) throws Exception {
        ArrayList<CustomEntity> jewelryStokDetail=queryDAO.searchJewelryStockUsingMakerId(makerId);
        ArrayList<JewelryStockDTO> list=new ArrayList<>();
        for (CustomEntity c :jewelryStokDetail) {
            JewelryStockDTO dto = new JewelryStockDTO(c.getJewelryType(),c.getJewelryTypeId(),c.getJewelryId(),c.getJewelryMetal(),c.getJewelryCarat(),c.getJewelryWeight(),c.getJewelrySize(),c.getJewelryEmbGem(),c.getJewelryPrice(),c.getJewelryMakerId(),c.getJewelryMakerName(),c.getDate());
            list.add(dto);
        }
        return list;
    }

    @Override
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingMetal(String metal) throws Exception {
        ArrayList<CustomEntity> jewelryStokDetail=queryDAO.searchJewelryStockUsingMetal(metal);
        ArrayList<JewelryStockDTO> list=new ArrayList<>();
        for (CustomEntity c :jewelryStokDetail) {
            JewelryStockDTO dto = new JewelryStockDTO(c.getJewelryType(),c.getJewelryTypeId(),c.getJewelryId(),c.getJewelryMetal(),c.getJewelryCarat(),c.getJewelryWeight(),c.getJewelrySize(),c.getJewelryEmbGem(),c.getJewelryPrice(),c.getJewelryMakerId(),c.getJewelryMakerName(),c.getDate());
            list.add(dto);
        }
        return list;
    }

    @Override
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingPrice(double price) throws Exception {
        ArrayList<CustomEntity> jewelryStokDetail=queryDAO.searchJewelryStockUsingPrice(price);
        ArrayList<JewelryStockDTO> list=new ArrayList<>();
        for (CustomEntity c :jewelryStokDetail) {
            JewelryStockDTO dto = new JewelryStockDTO(c.getJewelryType(),c.getJewelryTypeId(),c.getJewelryId(),c.getJewelryMetal(),c.getJewelryCarat(),c.getJewelryWeight(),c.getJewelrySize(),c.getJewelryEmbGem(),c.getJewelryPrice(),c.getJewelryMakerId(),c.getJewelryMakerName(),c.getDate());
            list.add(dto);
        }
        return list;
    }

    @Override
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingSize(double size) throws Exception {
        ArrayList<CustomEntity> jewelryStokDetail=queryDAO.searchJewelryStockUsingSize(size);
        ArrayList<JewelryStockDTO> list=new ArrayList<>();
        for (CustomEntity c :jewelryStokDetail) {
            JewelryStockDTO dto = new JewelryStockDTO(c.getJewelryType(),c.getJewelryTypeId(),c.getJewelryId(),c.getJewelryMetal(),c.getJewelryCarat(),c.getJewelryWeight(),c.getJewelrySize(),c.getJewelryEmbGem(),c.getJewelryPrice(),c.getJewelryMakerId(),c.getJewelryMakerName(),c.getDate());
            list.add(dto);
        }
        return list;
    }

    @Override
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingWeight(double weight) throws Exception {
        ArrayList<CustomEntity> jewelryStokDetail=queryDAO.searchJewelryStockUsingWeight(weight);
        ArrayList<JewelryStockDTO> list=new ArrayList<>();
        for (CustomEntity c :jewelryStokDetail) {
            JewelryStockDTO dto = new JewelryStockDTO(c.getJewelryType(),c.getJewelryTypeId(),c.getJewelryId(),c.getJewelryMetal(),c.getJewelryCarat(),c.getJewelryWeight(),c.getJewelrySize(),c.getJewelryEmbGem(),c.getJewelryPrice(),c.getJewelryMakerId(),c.getJewelryMakerName(),c.getDate());
            list.add(dto);
        }
        return list;
    }

    @Override
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingCarat(int carat) throws Exception {
        ArrayList<CustomEntity> jewelryStokDetail=queryDAO.searchJewelryStockUsingCarat(carat);
        ArrayList<JewelryStockDTO> list=new ArrayList<>();
        for (CustomEntity c :jewelryStokDetail) {
            JewelryStockDTO dto = new JewelryStockDTO(c.getJewelryType(),c.getJewelryTypeId(),c.getJewelryId(),c.getJewelryMetal(),c.getJewelryCarat(),c.getJewelryWeight(),c.getJewelrySize(),c.getJewelryEmbGem(),c.getJewelryPrice(),c.getJewelryMakerId(),c.getJewelryMakerName(),c.getDate());
            list.add(dto);
        }
        return list;
    }

    @Override
    public ArrayList<JewelryStockDTO> searchJewelryStockUsingMakerName(String makerName) throws Exception {
        ArrayList<CustomEntity> jewelryStokDetail=queryDAO.searchJewelryStockUsingMakerName(makerName);
        ArrayList<JewelryStockDTO> list=new ArrayList<>();
        for (CustomEntity c :jewelryStokDetail) {
            JewelryStockDTO dto = new JewelryStockDTO(c.getJewelryType(),c.getJewelryTypeId(),c.getJewelryId(),c.getJewelryMetal(),c.getJewelryCarat(),c.getJewelryWeight(),c.getJewelrySize(),c.getJewelryEmbGem(),c.getJewelryPrice(),c.getJewelryMakerId(),c.getJewelryMakerName(),c.getDate());
            list.add(dto);
        }
        return list;
    }
}
