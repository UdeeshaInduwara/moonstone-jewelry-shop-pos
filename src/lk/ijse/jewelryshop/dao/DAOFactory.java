package lk.ijse.jewelryshop.dao;


import lk.ijse.jewelryshop.business.custom.impl.MetalBusinessmanBOImpl;
import lk.ijse.jewelryshop.dao.custom.impl.*;

public class DAOFactory {
    public enum DAOTypes{
        HOTEL,JEWELRYMAKER,METALBUSINESSMAN,GEM,
        QUERY,METAL,METALPURCHASE,JEWELRY,
        JEWELRYTYPE,JEWELRYMAKEDETAIL,METALSUPLYDETAIL,CUSTOMER,
        ORDERS,PAYMENT,JEWELRYPURCHASEDETAIL;
    }
    private static DAOFactory daoFactory;
    public static DAOFactory getInstance(){
        if(daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
    private DAOFactory(){
    }
    public <T extends SuperDAO> T getDAO(DAOTypes daoType){
        switch(daoType){
            case HOTEL:
                return (T) new HotelDAOImpl();
            case JEWELRYMAKER:
                return (T) new JewelryMakerDAOImpl();
            case METALBUSINESSMAN:
                return (T) new MetalBusinessmanDAOImpl();
            case GEM:
                return (T) new GemDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            case METAL:
                return (T) new MetalDAOImpl();
            case METALPURCHASE:
                return (T) new MetalPurchaseDetailDAOImpl();
            case JEWELRY:
                return (T) new JewelryDAOImpl();
            case JEWELRYTYPE:
                return (T) new JewelryTypeDAOImpl();
            case JEWELRYMAKEDETAIL:
                return (T) new JewelryMakeDetailDAOImpl();
            case METALSUPLYDETAIL:
                return (T) new MetalSuplyDetailDAOImpl();
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case ORDERS:
                return (T) new OrdersDAOImpl();
            case PAYMENT:
                return (T) new PaymentDAOImpl();
            case JEWELRYPURCHASEDETAIL:
                return (T) new JewelryPurchaseDetailDAOImpl();
            default:
                return null;
        }
    }
}
