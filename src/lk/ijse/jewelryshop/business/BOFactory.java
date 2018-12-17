package lk.ijse.jewelryshop.business;

import lk.ijse.jewelryshop.business.custom.impl.*;

public class BOFactory {
    public enum BOTypes{
        HOTEL,JEWELRYMAKER,METALBUSINESSMAN,GEM,
        METALSTOCK,JEWELRYSTOCK,METALSUPLY,JEWELRYSELL,
        JEWELRYTYPE,REPORTS;
    }
    private static BOFactory boFactory;
    public static BOFactory getInstance(){
        if(boFactory==null){
            boFactory=new BOFactory();
        }
        return boFactory;
    }
    private BOFactory(){
    }
    public <T extends SuperBO> T getBO(BOTypes boType){
        switch(boType){
            case HOTEL:
                return (T) new HotelBOImpl();
            case JEWELRYMAKER:
                return (T) new JewelryMakerBOImpl();
            case METALBUSINESSMAN:
                return (T) new MetalBusinessmanBOImpl();
            case GEM:
                return (T) new GemSuplyBOImpl();
            case METALSTOCK:
                return (T) new MetalStockBOImpl();
            case JEWELRYSTOCK:
                return (T) new JewelryStockBOImpl();
            case METALSUPLY:
                return (T) new MetalSuplyBOImpl();
            case JEWELRYSELL:
                return (T) new JewelrySellBOImpl();
            case JEWELRYTYPE:
                return (T) new JewelryTypeBOImpl();
            case REPORTS:
                return (T) new ReportsBOImpl();
            default:
                return null;
        }
    }
}
