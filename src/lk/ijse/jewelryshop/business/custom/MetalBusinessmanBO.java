package lk.ijse.jewelryshop.business.custom;

import lk.ijse.jewelryshop.business.SuperBO;
import lk.ijse.jewelryshop.model.MetalBusinessmanDTO;

import java.util.ArrayList;

public interface MetalBusinessmanBO extends SuperBO {
    public boolean addMetalBusinessman(MetalBusinessmanDTO dto) throws Exception;
    public ArrayList<MetalBusinessmanDTO> getAllMetalBusinessmen() throws Exception;
    public boolean removeMetalBusinessman(String id) throws Exception;
    public MetalBusinessmanDTO searchMetalBusinessmanUseId(String id)throws Exception;
    public MetalBusinessmanDTO searchMetalBusinessmanUseName(String name)throws Exception;
    public boolean updateMetalBusinessman(MetalBusinessmanDTO dto) throws Exception;
    public ArrayList<String> getMetalBusinessmenIds() throws Exception;
    public ArrayList<String> getMetalBusinessmenNames() throws Exception;
    public ArrayList<MetalBusinessmanDTO> searchUsingName(String metalBusinessmanName) throws Exception;
    public ArrayList<MetalBusinessmanDTO> searchUsingId(String metalBusinessmanId) throws Exception;
}
