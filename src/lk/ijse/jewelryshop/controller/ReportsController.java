package lk.ijse.jewelryshop.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.jewelryshop.business.BOFactory;
import lk.ijse.jewelryshop.business.custom.ReportsBO;
import lk.ijse.jewelryshop.db.DBConnection;
import lk.ijse.jewelryshop.model.CustomerDTO;
import lk.ijse.jewelryshop.model.SalesReportDTO;
import lk.ijse.jewelryshop.model.SelledJewelryDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportsController implements Initializable {
    ReportsBO reportsBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.REPORTS);

    @FXML
    private TableView<SelledJewelryDTO> tblSelldJewelry;

    @FXML
    private TableView<CustomerDTO> tblCustomer;

    @FXML
    private PieChart chartCurrentMonthlSales;

    @FXML
    private LineChart<String, Number> chartMonthlySales;

    @FXML
    private BarChart<String, Number> chartHotelsSendingCustomers;

    @FXML
    private LineChart<String,Number> chartMonthlyCustomersArrival;

    @FXML
    private BarChart<String,Number> chartMonthlyIncome;

    @FXML
    private Label lblMonthlySalesPrcentage;

    @FXML
    void loadCustomerDetailReport(ActionEvent event) {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/jewelryshop/reports/CustomerDetail.jasper");

        HashMap map= new HashMap();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (JRException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void loadSelledJewelryDetailReport(ActionEvent event) {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/jewelryshop/reports/SelledJewelryDetail.jasper");

        HashMap map= new HashMap();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (JRException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void loadCurrentMonthHotelsSentCustomersReport(ActionEvent event) {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/jewelryshop/reports/CurrentMonthHotelsSentCustomersDetail.jasper");

        HashMap map= new HashMap();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (JRException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void loadCurrentMonthJewelrySalesReport(ActionEvent event) {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/jewelryshop/reports/CurrentMonthJewelrySalesDetail.jasper");

        HashMap map= new HashMap();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (JRException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void loadMonthlyCustomersArrivalReport(ActionEvent event) {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/jewelryshop/reports/MonthlyCustomersArrivalDetail.jasper");

        HashMap map= new HashMap();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (JRException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void loadMonthlyJewelrySalesReport(ActionEvent event) {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/jewelryshop/reports/MonthlyJewelrySalesDetail.jasper");

        HashMap map= new HashMap();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (JRException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void loadMonthlyIncomeDetailReport(ActionEvent event) {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/jewelryshop/reports/MonthlyIncomeDetail.jasper");

        HashMap map= new HashMap();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (JRException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadSelledJewelryTable();
        loadCustomerTable();
        loadCurrentMonthSalesChart();
        loadMonthlySalesChart();
        loadCurrentMonthHotelsSentCustomersChart();
        loadMonthlyCustomersArrivalChart();
        loadMonthlyIncomeChart();
    }

    private void loadMonthlyIncomeChart() {
        try {
            XYChart.Series<String,Number> series=new XYChart.Series<String,Number>();
            ArrayList<SalesReportDTO> list = reportsBO.getMonthlyIncome();
            for (SalesReportDTO s :list) {
                series.getData().add(new XYChart.Data<String,Number>(s.getTypeName(),s.getTotalCount()));
            }
            chartMonthlyIncome.getData().add(series);
        } catch (Exception e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadMonthlyCustomersArrivalChart() {
        try {
            XYChart.Series<String,Number> series=new XYChart.Series<String,Number>();
            ArrayList<SalesReportDTO> list = reportsBO.getMonthlyCustomersArrival();
            for (SalesReportDTO s :list) {
                series.getData().add(new XYChart.Data<String,Number>(s.getTypeName(),s.getTotalCount()));
            }
            chartMonthlyCustomersArrival.getData().add(series);
        } catch (Exception e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadCurrentMonthHotelsSentCustomersChart() {
        try {
            XYChart.Series<String,Number> series=new XYChart.Series<String,Number>();
            ArrayList<SalesReportDTO> list = reportsBO.getCurrentMonthHotelsSentCustomers();
            for (SalesReportDTO s :list) {
                series.getData().add(new XYChart.Data<String,Number>(s.getTypeName(),s.getTotalCount()));
            }
            chartHotelsSendingCustomers.getData().add(series);
        } catch (Exception e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadMonthlySalesChart() {
        try {
            XYChart.Series<String,Number> series=new XYChart.Series<String,Number>();
            ArrayList<SalesReportDTO> list = reportsBO.getMonthlyJewelrySales();
            for (SalesReportDTO s :list) {
                series.getData().add(new XYChart.Data<String,Number>(s.getTypeName(),s.getTotalCount()));
            }
            chartMonthlySales.getData().add(series);
        } catch (Exception e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadCurrentMonthSalesChart() {
        try {
            ArrayList<SalesReportDTO> dto = reportsBO.getCurrentMonthJewelrySales();
            ObservableList<PieChart.Data>  list=FXCollections.observableArrayList();
            for (SalesReportDTO m : dto) {
                list.add(new PieChart.Data(m.getTypeName(),m.getTotalCount()));
            }
            chartCurrentMonthlSales.setData(list);
        } catch (Exception e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        }

        for (PieChart.Data data :chartCurrentMonthlSales.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    lblMonthlySalesPrcentage.setText(Double.toString(data.getPieValue()));
                }
            });
        }
    }

    private void loadCustomerTable() {
        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("customerId"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("passportNo"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("country"));
        tblCustomer.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("senderId"));

        try {
            tblCustomer.setItems(FXCollections.observableArrayList(reportsBO.getAllCustomerDetail()));
        } catch (Exception e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadSelledJewelryTable() {
        tblSelldJewelry.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("jewelryTypeId"));
        tblSelldJewelry.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("jewelryType"));
        tblSelldJewelry.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("jewelryId"));
        tblSelldJewelry.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("metal"));
        tblSelldJewelry.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("carat"));
        tblSelldJewelry.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("weight"));
        tblSelldJewelry.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("size"));
        tblSelldJewelry.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("gem"));
        tblSelldJewelry.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));
        tblSelldJewelry.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("customerId"));
        tblSelldJewelry.getColumns().get(10).setCellValueFactory(new PropertyValueFactory<>("customerName"));
        tblSelldJewelry.getColumns().get(11).setCellValueFactory(new PropertyValueFactory<>("price"));

        try {
            tblSelldJewelry.setItems(FXCollections.observableArrayList(reportsBO.getAllSelledJewelry()));
        } catch (Exception e) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
