package lk.ijse.jewelryshop.business.custom.impl;

import lk.ijse.jewelryshop.business.custom.MetalStockBO;
import lk.ijse.jewelryshop.dao.DAOFactory;
import lk.ijse.jewelryshop.dao.custom.MetalDAO;
import lk.ijse.jewelryshop.dao.custom.MetalPurchaseDetailDAO;
import lk.ijse.jewelryshop.dao.custom.QueryDAO;
import lk.ijse.jewelryshop.db.DBConnection;
import lk.ijse.jewelryshop.entity.CustomEntity;
import lk.ijse.jewelryshop.entity.Metal;
import lk.ijse.jewelryshop.entity.MetalPurchaseDetail;
import lk.ijse.jewelryshop.model.MetalStockDTO;

import java.sql.Connection;
import java.util.ArrayList;

public class MetalStockBOImpl implements MetalStockBO {
    MetalDAO metalDAO=null;
    MetalPurchaseDetailDAO metalPurchaseDetailDAO=null;
    QueryDAO queryDAO=null;
    public MetalStockBOImpl() {
        metalDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.METAL);
        metalPurchaseDetailDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.METALPURCHASE);
        queryDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    }

    @Override
    public boolean addMetalStock(MetalStockDTO dto) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        conn.setAutoCommit(false);
        try{
            boolean result = metalDAO.save(new Metal(dto.getMetalId(), dto.getMetal(), dto.getCarat(),dto.getWeight()));
            if(!result){
                return false;
            }
            result = metalPurchaseDetailDAO.save(new MetalPurchaseDetail(dto.getMetalId(), dto.getBusinessmanId(), dto.getWeight(), dto.getPurchaseDate()));
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
    public ArrayList<MetalStockDTO> getMetalStockDetails() throws Exception {
        ArrayList<CustomEntity> metalStokDetail = queryDAO.getMetalStokDetail();
        ArrayList<MetalStockDTO> list=new ArrayList<>();
        for (CustomEntity c :metalStokDetail) {
            list.add(new MetalStockDTO(c.getMetalId(),c.getMetal(),c.getMetalCarat(),c.getWeight(),c.getPurchaseDate(),c.getBusinessmanId(),c.getBusinessmanName()));
        }
        return list;
    }

    @Override
    public boolean removeMetalStock(String id) throws Exception {
        return metalDAO.delete(id);
    }

    @Override
    public boolean updateMetalStock(MetalStockDTO dto) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        conn.setAutoCommit(false);
        try{
            boolean result = metalDAO.update(new Metal(dto.getMetalId(), dto.getMetal(), dto.getCarat(),dto.getWeight()));
            if(!result){
                return false;
            }
            result = metalPurchaseDetailDAO.update(new MetalPurchaseDetail(dto.getMetalId(), dto.getBusinessmanId(), dto.getWeight(), dto.getPurchaseDate()));
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
    public ArrayList<MetalStockDTO> searchMetalStockUsingBusinessmanId(String id) throws Exception {
        ArrayList<CustomEntity> metalStokDetail = queryDAO.searchMetalStockUsingBusinessmanId(id);
        ArrayList<MetalStockDTO> list=new ArrayList<>();
        for (CustomEntity c :metalStokDetail) {
            list.add(new MetalStockDTO(c.getMetalId(),c.getMetal(),c.getMetalCarat(),c.getWeight(),c.getPurchaseDate(),c.getBusinessmanId(),c.getBusinessmanName()));
        }
        return list;
    }

    @Override
    public ArrayList<MetalStockDTO> searchMetalStockUsingBusinessmanName(String name) throws Exception {
        ArrayList<CustomEntity> metalStokDetail = queryDAO.searchMetalStockUsingBusinessmanName(name);
        ArrayList<MetalStockDTO> list=new ArrayList<>();
        for (CustomEntity c :metalStokDetail) {
            list.add(new MetalStockDTO(c.getMetalId(),c.getMetal(),c.getMetalCarat(),c.getWeight(),c.getPurchaseDate(),c.getBusinessmanId(),c.getBusinessmanName()));
        }
        return list;
    }

    @Override
    public ArrayList<MetalStockDTO> searchMetalStockUsingCarat(int carat) throws Exception {
        ArrayList<CustomEntity> metalStokDetail = queryDAO.searchMetalStockUsingCarat(carat);
        ArrayList<MetalStockDTO> list=new ArrayList<>();
        for (CustomEntity c :metalStokDetail) {
            list.add(new MetalStockDTO(c.getMetalId(),c.getMetal(),c.getMetalCarat(),c.getWeight(),c.getPurchaseDate(),c.getBusinessmanId(),c.getBusinessmanName()));
        }
        return list;
    }

    @Override
    public ArrayList<MetalStockDTO> searchMetalStockUsingMetal(String metal) throws Exception {
        ArrayList<CustomEntity> metalStokDetail = queryDAO.searchMetalStockUsingMetal(metal);
        ArrayList<MetalStockDTO> list=new ArrayList<>();
        for (CustomEntity c :metalStokDetail) {
            list.add(new MetalStockDTO(c.getMetalId(),c.getMetal(),c.getMetalCarat(),c.getWeight(),c.getPurchaseDate(),c.getBusinessmanId(),c.getBusinessmanName()));
        }
        return list;
    }

    @Override
    public ArrayList<MetalStockDTO> searchMetalStockUsingMetalId(String id) throws Exception {
        ArrayList<CustomEntity> metalStokDetail = queryDAO.searchMetalStockUsingMetalId(id);
        ArrayList<MetalStockDTO> list=new ArrayList<>();
        for (CustomEntity c :metalStokDetail) {
            list.add(new MetalStockDTO(c.getMetalId(),c.getMetal(),c.getMetalCarat(),c.getWeight(),c.getPurchaseDate(),c.getBusinessmanId(),c.getBusinessmanName()));
        }
        return list;
    }

    @Override
    public ArrayList<MetalStockDTO> searchMetalStockUsingPurchaseDate(String date) throws Exception {
        ArrayList<CustomEntity> metalStokDetail = queryDAO.searchMetalStockUsingPurchaseDate(date);
        ArrayList<MetalStockDTO> list=new ArrayList<>();
        for (CustomEntity c :metalStokDetail) {
            list.add(new MetalStockDTO(c.getMetalId(),c.getMetal(),c.getMetalCarat(),c.getWeight(),c.getPurchaseDate(),c.getBusinessmanId(),c.getBusinessmanName()));
        }
        return list;
    }

    @Override
    public ArrayList<MetalStockDTO> searchMetalStockUsingWeight(double weight) throws Exception {
        ArrayList<CustomEntity> metalStokDetail = queryDAO.searchMetalStockUsingWeight(weight);
        ArrayList<MetalStockDTO> list=new ArrayList<>();
        for (CustomEntity c :metalStokDetail) {
            list.add(new MetalStockDTO(c.getMetalId(),c.getMetal(),c.getMetalCarat(),c.getWeight(),c.getPurchaseDate(),c.getBusinessmanId(),c.getBusinessmanName()));
        }
        return list;
    }
}
