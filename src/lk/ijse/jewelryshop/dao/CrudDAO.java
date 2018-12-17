package lk.ijse.jewelryshop.dao;

import java.util.ArrayList;

public interface CrudDAO<T,ID> extends SuperDAO {

    public boolean save(T entity) throws Exception;

    public boolean update(T entity) throws Exception;

    public boolean delete(ID id) throws Exception;

    public T search(ID id) throws Exception;

    public ArrayList<T> getAll() throws Exception;
}
