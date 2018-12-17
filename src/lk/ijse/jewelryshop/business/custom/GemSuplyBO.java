package lk.ijse.jewelryshop.business.custom;

import lk.ijse.jewelryshop.business.SuperBO;
import lk.ijse.jewelryshop.model.GemSuplyDTO;

import java.util.ArrayList;

public interface GemSuplyBO extends SuperBO {
    public boolean addGem(GemSuplyDTO dto) throws Exception;
    public boolean removeGem(String id) throws Exception;
    public boolean updateGem(GemSuplyDTO dto) throws Exception;
    public ArrayList<GemSuplyDTO> getAllGemDetails() throws Exception;
    public ArrayList<GemSuplyDTO> searchGemUsingCarat(double carat) throws Exception;
    public ArrayList<GemSuplyDTO> searchGemUsingGemId(String gemId) throws Exception;
    public ArrayList<GemSuplyDTO> searchGemUsingMakerId(String makerId) throws Exception;
    public ArrayList<GemSuplyDTO> searchGemUsingMakerName(String makerName) throws Exception;
    public ArrayList<GemSuplyDTO> searchGemUsingSuplyDate(String saplyDate) throws Exception;
}
