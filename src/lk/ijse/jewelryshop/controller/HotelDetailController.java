package lk.ijse.jewelryshop.controller;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.jewelryshop.business.BOFactory;
import lk.ijse.jewelryshop.business.custom.HotelBO;
import lk.ijse.jewelryshop.controller.utils.Notification;
import lk.ijse.jewelryshop.db.DBConnection;
import lk.ijse.jewelryshop.generator.IDGenerator;
import lk.ijse.jewelryshop.model.HotelDTO;
import lk.ijse.jewelryshop.validation.Validator;
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

public class HotelDetailController implements Initializable {
    HotelBO hotelBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.HOTEL);

    @FXML
    private TextField txtSearchHotelID;

    @FXML
    private TextField txtSearchHotelName;

    @FXML
    private TextField txtViewCity;

    @FXML
    private TableView<HotelDTO> tblHotelDetail;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXTextField txtHotelID;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtContactNo;

    @FXML
    private JFXTextField txtCity;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnReport;

    @FXML
    void loadHotelDetailReport(ActionEvent event) {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/jewelryshop/reports/HotelDetail.jasper");

        HashMap map= new HashMap();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException e) {
            Logger.getLogger(HotelDetailController.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(HotelDetailController.class.getName()).log(Level.SEVERE, null, e);
        } catch (JRException e) {
            Logger.getLogger(HotelDetailController.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(HotelDetailController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingHotelID(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchHotelName.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtViewCity.requestFocus();
        }
        if(event.getCode()== KeyCode.DOWN){
            txtHotelID.requestFocus();
        }

        String hotelIDText = txtSearchHotelID.getText();
        try {
            ArrayList<HotelDTO> dtos = hotelBO.searchHotelUsingId(hotelIDText);
            tblHotelDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(HotelDetailController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingName(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtViewCity.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchHotelID.requestFocus();
        }
        if(event.getCode()== KeyCode.DOWN){
            txtHotelID.requestFocus();
        }

        String hotelNameText = txtSearchHotelName.getText();
        try {
            ArrayList<HotelDTO> dtos = hotelBO.searchHotelUsingName(hotelNameText);
            tblHotelDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(HotelDetailController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingCity(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchHotelID.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchHotelName.requestFocus();
        }
        if(event.getCode()== KeyCode.DOWN){
            txtHotelID.requestFocus();
        }

        String cityText = txtViewCity.getText();
        try {
            ArrayList<HotelDTO> dtos = hotelBO.searchHotelUsingCity(cityText);
            tblHotelDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(HotelDetailController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void txtHotelIdOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            txtName.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchHotelID.requestFocus();
        }
    }

    @FXML
    void txtNameOnAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            try {
                if (!Validator.nameValidation(txtName.getText())) {
                    txtName.selectAll();

                    Notification.showAttrntionMessage("Fill the Hotel Name Correctly");
                } else {
                    txtContactNo.requestFocus();
                }
            }catch (NullPointerException e){
                txtName.selectAll();

                Notification.showAttrntionMessage("Fill the Hotel Name Correctly");
            }
        }
        if(event.getCode()== KeyCode.LEFT){
            txtHotelID.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchHotelID.requestFocus();
        }
    }

    @FXML
    void txtContactNoOnACtion(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if(!Validator.contactNoValidation(txtContactNo.getText())){
                    txtContactNo.selectAll();

                    Notification.showAttrntionMessage("Fill the Contact Number Correctly");
                }else {
                    txtCity.requestFocus();
                }
            }catch (NullPointerException e){
                txtContactNo.selectAll();

                Notification.showAttrntionMessage("Fill the Contact Number Correctly");
            }
        }
        if(event.getCode()== KeyCode.LEFT){
            txtName.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchHotelID.requestFocus();
        }
    }

    @FXML
    void txtCityOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try{
                if(Validator.nameValidation(txtName.getText())){
                    try{
                        if(Validator.contactNoValidation(txtContactNo.getText())){
                            try{
                                if(Validator.nameValidation(txtCity.getText())){
                                    if (btnUpdate.isDisabled()){
                                        btnAddOnAction();
                                    }else {
                                        btnUpdateOnAction();
                                    }
                                }else {
                                    txtCity.selectAll();

                                    Notification.showAttrntionMessage("Fill the City Name Correctly");
                                }
                            }catch (NullPointerException e){
                                txtCity.requestFocus();

                                Notification.showAttrntionMessage("Fill the City Name Correctly");
                            }
                        }else {
                            txtContactNo.requestFocus();

                            Notification.showAttrntionMessage("Fill the Contact Number Correctly");
                        }
                    }catch (NullPointerException e){
                        txtContactNo.requestFocus();

                        Notification.showAttrntionMessage("Fill the Contact Number Correctly");
                    }
                }else {
                    txtName.requestFocus();

                    Notification.showAttrntionMessage("Fill the Hotel Name Correctly");
                }
            }catch (NullPointerException e){
                txtName.requestFocus();

                Notification.showAttrntionMessage("Fill the Hotel Name Correctly");
            }
        }
        if(event.getCode()== KeyCode.LEFT){
            txtContactNo.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchHotelID.requestFocus();
        }
    }

    @FXML
    void addHotel(ActionEvent event) {
        try{
            if(Validator.nameValidation(txtName.getText())){
                try{
                    if(Validator.contactNoValidation(txtContactNo.getText())){
                        try{
                            if(Validator.nameValidation(txtCity.getText())){
                                btnAddOnAction();
                            }else {
                                txtCity.requestFocus();

                                Notification.showAttrntionMessage("Fill the City Name Correctly");
                            }
                        }catch (NullPointerException e){
                            txtCity.requestFocus();

                            Notification.showAttrntionMessage("Fill the City Name Correctly");
                        }
                    }else {
                        txtContactNo.requestFocus();

                        Notification.showAttrntionMessage("Fill the Contact Number Correctly");
                    }
                }catch (NullPointerException e){
                    txtContactNo.requestFocus();

                    Notification.showAttrntionMessage("Fill the Contact Number Correctly");
                }
            }else {
                txtName.requestFocus();

                Notification.showAttrntionMessage("Fill the Hotel Name Correctly");
            }
        }catch (NullPointerException e){
            txtName.requestFocus();

            Notification.showAttrntionMessage("Fill the Hotel Name Correctly");
        }
    }

    @FXML
    void updateHotel(ActionEvent event) {
        try{
            if(Validator.nameValidation(txtName.getText())){
                try{
                    if(Validator.contactNoValidation(txtContactNo.getText())){
                        try{
                            if(Validator.nameValidation(txtCity.getText())){
                                btnUpdateOnAction();
                            }else {
                                txtCity.requestFocus();

                                Notification.showAttrntionMessage("Fill the City Name Correctly");
                            }
                        }catch (NullPointerException e){
                            txtCity.requestFocus();

                            Notification.showAttrntionMessage("Fill the City Name Correctly");
                        }
                    }else {
                        txtContactNo.requestFocus();

                        Notification.showAttrntionMessage("Fill the Contact Number Correctly");
                    }
                }catch (NullPointerException e){
                    txtContactNo.requestFocus();

                    Notification.showAttrntionMessage("Fill the Contact Number Correctly");
                }
            }else {
                txtName.requestFocus();

                Notification.showAttrntionMessage("Fill the Hotel Name Correctly");
            }
        }catch (NullPointerException e){
            txtName.requestFocus();

            Notification.showAttrntionMessage("Fill the Hotel Name Correctly");
        }
    }

    @FXML
    void cancelAdding(ActionEvent event) {
        try {
            String hotelId = IDGenerator.getNewID("hotel","hid","H");
            txtHotelID.setText(hotelId);
        } catch (Exception e) {
            Logger.getLogger(HotelDetailController.class.getName()).log(Level.SEVERE, null, e);
        }
        txtName.setText(null);
        txtContactNo.setText(null);
        txtCity.setText(null);
    }

    @FXML
    void removeHotel(ActionEvent event) {
        try{
            String hid = tblHotelDetail.getSelectionModel().getSelectedItem().getHid();
            try {
                boolean isDeleted = hotelBO.removeHotel(hid);
                if(isDeleted){
                    btnUpdate.setDisable(true);
                    btnAdd.setDisable(false);
                    txtHotelID.requestFocus();
                    txtName.setText(null);
                    txtContactNo.setText(null);
                    txtCity.setText(null);
                    loadHotelDetail();

                    Notification.showConformationeMessage("Removed Successfully");
                }else {
                    Notification.showFailureMessage("Removing Failed");
                }
            } catch (Exception e) {
                Logger.getLogger(HotelDetailController.class.getName()).log(Level.SEVERE, null, e);
            }
        }catch (Exception e){
            Notification.showWarningMessage("Select Item First to Remove");
        }
    }

    @FXML
    void selectHotelDetail(MouseEvent event) {
        try {
            HotelDTO dto = tblHotelDetail.getSelectionModel().getSelectedItem();

            txtHotelID.setText(dto.getHid());
            txtName.setText(dto.getName());
            txtContactNo.setText(dto.getContactNo());
            txtCity.setText(dto.getCity());
        }catch (NullPointerException e){ }

        txtHotelID.requestFocus();
        btnUpdate.setDisable(false);
        btnAdd.setDisable(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblHotelDetail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Hid"));
        tblHotelDetail.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Name"));
        tblHotelDetail.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("ContactNo"));
        tblHotelDetail.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("City"));

        loadHotelDetail();
    }

    private void loadHotelDetail(){
        try {
            String hotelId=IDGenerator.getNewID("hotel","hid","H");
            txtHotelID.setText(hotelId);
        } catch (Exception e) {
            Logger.getLogger(HotelDetailController.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            tblHotelDetail.setItems(FXCollections.observableArrayList(hotelBO.getAllHotels()));
        } catch (Exception e) {
            Logger.getLogger(HotelDetailController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void btnAddOnAction() {
        String hotelIDText = txtHotelID.getText();
        String nameText = txtName.getText();
        String contactNoText = txtContactNo.getText();
        String cityText = txtCity.getText();
        HotelDTO hotelDTO=new HotelDTO(hotelIDText,nameText,contactNoText,cityText);

        try {
            boolean isAdded = hotelBO.addHotel(hotelDTO);
            if(isAdded){
                loadHotelDetail();
                txtName.setText(null);
                txtContactNo.setText(null);
                txtCity.setText(null);
                txtHotelID.requestFocus();

                Notification.showConformationeMessage("Added Successfully");
            }else {
                txtName.requestFocus();

                Notification.showFailureMessage("Adding Failed");
            }
        } catch (Exception e) {
            Logger.getLogger(HotelDetailController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    private void btnUpdateOnAction() {
        String hid = txtHotelID.getText();
        String name = txtName.getText();
        String contactNo = txtContactNo.getText();
        String city = txtCity.getText();
        HotelDTO hotelDTO=new HotelDTO(hid,name,contactNo,city);
        try {
            boolean isUpdated = hotelBO.updateHotel(hotelDTO);
            if(isUpdated){
                loadHotelDetail();
                txtName.setText(null);
                txtContactNo.setText(null);
                txtCity.setText(null);
                btnUpdate.setDisable(true);
                btnAdd.setDisable(false);
                txtHotelID.requestFocus();

                Notification.showConformationeMessage("Updated Successfully");
            }else {
                txtHotelID.requestFocus();

                Notification.showFailureMessage("Updating Failed");
            }
        } catch (Exception e) {
            Logger.getLogger(HotelDetailController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
