package lk.ijse.jewelryshop.business.custom.impl;

import lk.ijse.jewelryshop.business.custom.GemSuplyBO;
import lk.ijse.jewelryshop.dao.DAOFactory;
import lk.ijse.jewelryshop.dao.custom.GemDAO;
import lk.ijse.jewelryshop.dao.custom.QueryDAO;
import lk.ijse.jewelryshop.entity.CustomEntity;
import lk.ijse.jewelryshop.entity.Gem;
import lk.ijse.jewelryshop.model.GemSuplyDTO;

import java.util.ArrayList;

public class GemSuplyBOImpl implements GemSuplyBO {
    GemDAO gemDAO=null;
    QueryDAO queryDAO=null;
    public GemSuplyBOImpl() {
        gemDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.GEM);
        queryDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    }

    @Override
    public boolean addGem(GemSuplyDTO dto) throws Exception {
        return gemDAO.save(new Gem(dto.getGemid(),dto.getCarat(),dto.getSuplyDate(),dto.getMakerId()));
    }

    @Override
    public boolean removeGem(String id) throws Exception {
        return gemDAO.delete(id);
    }

    @Override
    public boolean updateGem(GemSuplyDTO dto) throws Exception {
        return gemDAO.update(new Gem(dto.getGemid(),dto.getCarat(),dto.getSuplyDate(),dto.getMakerId()));
    }

    @Override
    public ArrayList<GemSuplyDTO> getAllGemDetails() throws Exception {
        ArrayList<CustomEntity> allGemDetails = queryDAO.getAllGemDetails();
        ArrayList<GemSuplyDTO> gemSuplyDTOS =new ArrayList<>();
        for (CustomEntity c :allGemDetails) {
            gemSuplyDTOS.add(new GemSuplyDTO(c.getGemid(),c.getCarat(),c.getSuplyDate(),c.getMakerId(),c.getMakerName()));
        }
        return gemSuplyDTOS;
    }

    @Override
    public ArrayList<GemSuplyDTO> searchGemUsingCarat(double carat) throws Exception {
        ArrayList<CustomEntity> allGemDetails = queryDAO.searchGemDetailUsingCarat(carat);
        ArrayList<GemSuplyDTO> gemSuplyDTOS =new ArrayList<>();
        for (CustomEntity c :allGemDetails) {
            gemSuplyDTOS.add(new GemSuplyDTO(c.getGemid(),c.getCarat(),c.getSuplyDate(),c.getMakerId(),c.getMakerName()));
        }
        return gemSuplyDTOS;
    }

    @Override
    public ArrayList<GemSuplyDTO> searchGemUsingGemId(String gemId) throws Exception {
        ArrayList<CustomEntity> allGemDetails = queryDAO.searchGemDetailUsingGemId(gemId);
        ArrayList<GemSuplyDTO> gemSuplyDTOS =new ArrayList<>();
        for (CustomEntity c :allGemDetails) {
            gemSuplyDTOS.add(new GemSuplyDTO(c.getGemid(),c.getCarat(),c.getSuplyDate(),c.getMakerId(),c.getMakerName()));
        }
        return gemSuplyDTOS;
    }

    @Override
    public ArrayList<GemSuplyDTO> searchGemUsingMakerId(String makerId) throws Exception {
        ArrayList<CustomEntity> allGemDetails = queryDAO.searchGemDetailUsingMakerId(makerId);
        ArrayList<GemSuplyDTO> gemSuplyDTOS =new ArrayList<>();
        for (CustomEntity c :allGemDetails) {
            gemSuplyDTOS.add(new GemSuplyDTO(c.getGemid(),c.getCarat(),c.getSuplyDate(),c.getMakerId(),c.getMakerName()));
        }
        return gemSuplyDTOS;
    }

    @Override
    public ArrayList<GemSuplyDTO> searchGemUsingMakerName(String makerName) throws Exception {
        ArrayList<CustomEntity> allGemDetails = queryDAO.searchGemDetailUsingMakerName(makerName);
        ArrayList<GemSuplyDTO> gemSuplyDTOS =new ArrayList<>();
        for (CustomEntity c :allGemDetails) {
            gemSuplyDTOS.add(new GemSuplyDTO(c.getGemid(),c.getCarat(),c.getSuplyDate(),c.getMakerId(),c.getMakerName()));
        }
        return gemSuplyDTOS;
    }

    @Override
    public ArrayList<GemSuplyDTO> searchGemUsingSuplyDate(String saplyDate) throws Exception {
        ArrayList<CustomEntity> allGemDetails = queryDAO.searchGemDetailUsingSuplyDate(saplyDate);
        ArrayList<GemSuplyDTO> gemSuplyDTOS =new ArrayList<>();
        for (CustomEntity c :allGemDetails) {
            gemSuplyDTOS.add(new GemSuplyDTO(c.getGemid(),c.getCarat(),c.getSuplyDate(),c.getMakerId(),c.getMakerName()));
        }
        return gemSuplyDTOS;
    }
}
