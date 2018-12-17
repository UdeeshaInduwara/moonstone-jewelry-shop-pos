package lk.ijse.jewelryshop.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lk.ijse.jewelryshop.business.BOFactory;
import lk.ijse.jewelryshop.business.custom.GemSuplyBO;
import lk.ijse.jewelryshop.business.custom.JewelryMakerBO;
import lk.ijse.jewelryshop.controller.utils.Notification;
import lk.ijse.jewelryshop.db.DBConnection;
import lk.ijse.jewelryshop.generator.IDGenerator;
import lk.ijse.jewelryshop.model.GemSuplyDTO;
import lk.ijse.jewelryshop.model.JewelryMakerDTO;
import lk.ijse.jewelryshop.validation.Validator;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GemSuplyController implements Initializable {
    GemSuplyBO gemSuplyBO =BOFactory.getInstance().getBO(BOFactory.BOTypes.GEM);
    JewelryMakerBO jewelryMakerBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.JEWELRYMAKER);

    @FXML
    private TextField txtSearchGemId;

    @FXML
    private TextField txtSearchGemCarat;

    @FXML
    private TextField txtSearchSuplyDate;

    @FXML
    private TextField txtSearchMakerId;

    @FXML
    private TextField txtSearchMakerName;

    @FXML
    private TableView<GemSuplyDTO> tblGemSupplyDetail;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXTextField txtGemID;

    @FXML
    private JFXTextField txtCarat;

    @FXML
    private JFXComboBox<String> cmbMakerId;

    @FXML
    private JFXTextField txtMakerName;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private DatePicker txtSuplyDate;

    @FXML
    private JFXButton btnReport;

    @FXML
    void loadGemSupplyDetailReport(ActionEvent event) {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/jewelryshop/reports/GemSupplyDetail.jasper");

        HashMap map= new HashMap();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException e) {
            Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
        } catch (JRException e) {
            Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingGemId(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchGemCarat.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchMakerName.requestFocus();
        }
        if(event.getCode()== KeyCode.DOWN){
            txtGemID.requestFocus();
        }

        String gemIdText = txtSearchGemId.getText();
        try {
            ArrayList<GemSuplyDTO> dtos = gemSuplyBO.searchGemUsingGemId(gemIdText);
            tblGemSupplyDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingCarat(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchSuplyDate.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchGemId.requestFocus();
        }
        if(event.getCode()== KeyCode.DOWN){
            txtGemID.requestFocus();
        }

        if(Validator.isNotEmptyValidation(txtSearchGemCarat.getText())){
            double caratText = Double.parseDouble(txtSearchGemCarat.getText());
            try {
                ArrayList<GemSuplyDTO> dtos = gemSuplyBO.searchGemUsingCarat(caratText);
                tblGemSupplyDetail.setItems(FXCollections.observableArrayList(dtos));
            } catch (Exception e) {
                Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
            }
        }else {
            loadGemDetails();
        }
    }

    @FXML
    void searchUsingSupplyDate(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchMakerId.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchGemCarat.requestFocus();
        }
        if(event.getCode()== KeyCode.DOWN){
            txtGemID.requestFocus();
        }

        String suplyDateText = txtSearchSuplyDate.getText();
        try {
            ArrayList<GemSuplyDTO> dtos = gemSuplyBO.searchGemUsingSuplyDate(suplyDateText);
            tblGemSupplyDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingMakerId(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchMakerName.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchSuplyDate.requestFocus();
        }
        if(event.getCode()== KeyCode.DOWN){
            txtGemID.requestFocus();
        }

        String makerIdText = txtSearchMakerId.getText();
        try {
            ArrayList<GemSuplyDTO> dtos = gemSuplyBO.searchGemUsingMakerId(makerIdText);
            tblGemSupplyDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingMakerName(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchGemId.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchMakerId.requestFocus();
        }
        if(event.getCode()== KeyCode.DOWN){
            txtGemID.requestFocus();
        }

        String makerNameText = txtSearchMakerName.getText();
        try {
            ArrayList<GemSuplyDTO> dtos = gemSuplyBO.searchGemUsingMakerName(makerNameText);
            tblGemSupplyDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void txtGemIdOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            txtCarat.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchGemId.requestFocus();
        }
    }

    @FXML
    void txtCaratOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if(!Validator.doubleValueValidation(txtCarat.getText())){
                    txtCarat.selectAll();

                    Notification.showAttrntionMessage("Fill Gem Carat Value Correctly");
                }else {
                    txtSuplyDate.requestFocus();
                }
            }catch (NullPointerException e){
                txtCarat.selectAll();

                Notification.showAttrntionMessage("Fill Gem Carat Value Correctly");
            }
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchGemId.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtGemID.requestFocus();
        }
    }

    @FXML
    void txtDateOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.SHIFT){
            txtSuplyDate.show();
            if(txtSuplyDate.isShowing()){
                cmbMakerId.requestFocus();
            }
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchGemId.requestFocus();
        }
        if(event.getCode()== KeyCode.CONTROL){
            txtCarat.requestFocus();
        }
    }

    @FXML
    void cmbMakerIdOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            cmbMakerId.show();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchGemId.requestFocus();
        }
    }

    @FXML
    void txtMakerNameOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER) {
            try {
                if (Validator.doubleValueValidation(txtCarat.getText())) {
                    try {
                        txtSuplyDate.getValue().toString();
                        try {
                            if (Validator.jewelryMakerIdValidation(cmbMakerId.getSelectionModel().getSelectedItem())) {
                                if (Validator.isNotEmptyValidation(txtMakerName.getText())) {
                                    if (btnUpdate.isDisabled()) {
                                        btnAddOnAction();
                                    } else {
                                        btnUpdateOnAction();
                                    }
                                } else {
                                    txtMakerName.requestFocus();

                                    Notification.showAttrntionMessage("Fill Jewelry Maker Name Correctly");
                                }
                            } else {
                                cmbMakerId.requestFocus();

                                Notification.showAttrntionMessage("Fill Jewelry Maker ID Correctly");
                            }
                        } catch (NullPointerException e) {
                            cmbMakerId.requestFocus();

                            Notification.showAttrntionMessage("Fill Jewelry Maker ID Correctly");
                        }
                    } catch (NullPointerException e) {
                        txtSuplyDate.requestFocus();

                        Notification.showAttrntionMessage("Select Supply Date Correctly");
                    }
                } else {
                    txtCarat.requestFocus();

                    Notification.showAttrntionMessage("Fill Gem Carat Value Correctly");
                }
            } catch (NullPointerException e) {
                txtCarat.requestFocus();

                Notification.showAttrntionMessage("Fill Gem Carat Value Correctly");
            }
        }
    }

    @FXML
    void addGem(ActionEvent event) {
        try{
            if(Validator.doubleValueValidation(txtCarat.getText())){
                try{
                    txtSuplyDate.getValue().toString();
                    try{
                        if(Validator.jewelryMakerIdValidation(cmbMakerId.getSelectionModel().getSelectedItem())){
                            if(Validator.isNotEmptyValidation(txtMakerName.getText())){
                                btnAddOnAction();
                            }else {
                                txtMakerName.requestFocus();

                                Notification.showAttrntionMessage("Fill Jewelry Maker Name Correctly");
                            }
                        }else {
                            cmbMakerId.requestFocus();

                            Notification.showAttrntionMessage("Fill Jewelry Maker ID Correctly");
                        }
                    }catch (NullPointerException e){
                        cmbMakerId.requestFocus();

                        Notification.showAttrntionMessage("Fill Jewelry Maker ID Correctly");
                    }
                }catch (NullPointerException e){
                    txtSuplyDate.requestFocus();

                    Notification.showAttrntionMessage("Select Supply Date Correctly");
                }
            }else {
                txtCarat.requestFocus();

                Notification.showAttrntionMessage("Fill Gem Carat Value Correctly");
            }
        }catch (NullPointerException e){
            txtCarat.requestFocus();

            Notification.showAttrntionMessage("Fill Gem Carat Value Correctly");
        }
    }

    @FXML
    void updateGem(ActionEvent event) {
        try{
            if(Validator.doubleValueValidation(txtCarat.getText())){
                try{
                    txtSuplyDate.getValue().toString();
                    try{
                        if(Validator.jewelryMakerIdValidation(cmbMakerId.getSelectionModel().getSelectedItem())){
                            if(Validator.isNotEmptyValidation(txtMakerName.getText())){
                                btnUpdateOnAction();
                            }else {
                                txtMakerName.requestFocus();

                                Notification.showAttrntionMessage("Fill Jewelry Maker Name Correctly");
                            }
                        }else {
                            cmbMakerId.requestFocus();

                            Notification.showAttrntionMessage("Fill Jewelry Maker ID Correctly");
                        }
                    }catch (NullPointerException e){
                        cmbMakerId.requestFocus();

                        Notification.showAttrntionMessage("Fill Jewelry Maker ID Correctly");
                    }
                }catch (NullPointerException e){
                    txtSuplyDate.requestFocus();

                    Notification.showAttrntionMessage("Select Supply Date Correctly");
                }
            }else {
                txtCarat.requestFocus();

                Notification.showAttrntionMessage("Fill Gem Carat Value Correctly");
            }
        }catch (NullPointerException e){
            txtCarat.requestFocus();

            Notification.showAttrntionMessage("Fill Gem Carat Value Correctly");
        }
    }

    @FXML
    void cancelAdding(ActionEvent event) {
        try {
            String newID = IDGenerator.getNewID("gem", "gemid", "GEM");
            txtGemID.setText(newID);
        } catch (Exception e) {
            Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
        txtCarat.setText(null);
        txtSuplyDate.setValue(null);
        cmbMakerId.getSelectionModel().clearSelection();
        txtMakerName.setText(null);
    }

    @FXML
    void removeGem(ActionEvent event) {
        try {
            String gemid = tblGemSupplyDetail.getSelectionModel().getSelectedItem().getGemid();
            try {
                boolean isDeleted = gemSuplyBO.removeGem(gemid);
                if(isDeleted){
                    loadGemDetails();
                    txtCarat.setText(null);
                    txtSuplyDate.setValue(null);
                    cmbMakerId.getSelectionModel().clearSelection();
                    txtMakerName.setText(null);
                    btnUpdate.setDisable(true);
                    btnAdd.setDisable(false);

                    Notification.showConformationeMessage("Removed Successfully");
                }else {
                    Notification.showFailureMessage("Removing Failed");
                }
            } catch (Exception e) {
                Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
            }
        }catch (Exception e){
            Notification.showWarningMessage("Select Item First to Remove");
        }
    }

    @FXML
    void selectGem(MouseEvent event) {
        try {
            GemSuplyDTO dto = tblGemSupplyDetail.getSelectionModel().getSelectedItem();
            txtGemID.setText(dto.getGemid());
            txtCarat.setText(Double.toString(dto.getCarat()));
            txtMakerName.setText(dto.getMakerName());
            cmbMakerId.getSelectionModel().select(dto.getMakerId());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(dto.getSuplyDate(), formatter);
            txtSuplyDate.setValue(localDate);
        }catch (NullPointerException e){}

        txtGemID.requestFocus();
        btnUpdate.setDisable(false);
        btnAdd.setDisable(true);
    }

    @FXML
    void selectMaker(ActionEvent event) {
        String makerIDText = cmbMakerId.getSelectionModel().getSelectedItem();
        try {

            try{
                JewelryMakerDTO dto = jewelryMakerBO.searchJewelryMakerUseId(makerIDText);
                txtMakerName.setText(dto.getName());
            }catch (NullPointerException e){ }

        } catch (Exception e) {
            Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void selectMakerID(ActionEvent event) {
        String makerNameText = txtMakerName.getText();
        try {

            try{
                JewelryMakerDTO dto = jewelryMakerBO.searchJewelryMakerUseName(makerNameText);
                cmbMakerId.getSelectionModel().select(dto.getJmid());
            }catch (NullPointerException e){}

        } catch (Exception e) {
            Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ArrayList<String> jewelryMakersIDs = jewelryMakerBO.getJewelryMakersIDs();
            cmbMakerId.setItems(FXCollections.observableArrayList(jewelryMakersIDs));
        } catch (Exception e) {
            Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }

        tblGemSupplyDetail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("gemid"));
        tblGemSupplyDetail.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("carat"));
        tblGemSupplyDetail.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("suplyDate"));
        tblGemSupplyDetail.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("makerId"));
        tblGemSupplyDetail.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("makerName"));

        loadGemDetails();
        loadJewelryMakersNames();

       }

    private void loadGemDetails() {
        try {
            String newID = IDGenerator.getNewID("gem", "gemid", "GEM");
            txtGemID.setText(newID);
        } catch (Exception e) {
            Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            ArrayList<GemSuplyDTO> allGemDetails = gemSuplyBO.getAllGemDetails();
            tblGemSupplyDetail.setItems(FXCollections.observableArrayList(allGemDetails));
        } catch (Exception e) {
            Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void btnAddOnAction() {
        String gemIDText = txtGemID.getText();
        double caratText = Double.parseDouble(txtCarat.getText());
        String dateText = txtSuplyDate.getValue().toString();
        String makerIDText = cmbMakerId.getSelectionModel().getSelectedItem();
        String makerNameText = txtMakerName.getText();
        GemSuplyDTO gemDTO=new GemSuplyDTO(gemIDText,caratText,dateText,makerIDText,makerNameText);
        try {
            boolean isAdded = gemSuplyBO.addGem(gemDTO);
            if(isAdded){
                loadGemDetails();
                cmbMakerId.getSelectionModel().clearSelection();
                txtCarat.setText(null);
                txtSuplyDate.setValue(null);
                txtMakerName.setText(null);
                txtGemID.requestFocus();

                Notification.showConformationeMessage("Added Successfully");
            }else {
                txtGemID.requestFocus();

                Notification.showFailureMessage("Adding Failed");
            }
        } catch (Exception e) {
            Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void btnUpdateOnAction() {
        String gemId = txtGemID.getText();
        double carat = Double.parseDouble(txtCarat.getText());
        String date = txtSuplyDate.getValue().toString();
        String makerId = cmbMakerId.getSelectionModel().getSelectedItem();
        String makerName = txtMakerName.getText();
        GemSuplyDTO gemDTO=new GemSuplyDTO(gemId,carat,date,makerId,makerName);
        try {
            boolean isUpdated = gemSuplyBO.updateGem(gemDTO);
            if(isUpdated){
                loadGemDetails();
                cmbMakerId.getSelectionModel().clearSelection();
                txtCarat.setText(null);
                txtSuplyDate.setValue(null);
                txtMakerName.setText(null);
                txtGemID.requestFocus();
                btnUpdate.setDisable(true);
                btnAdd.setDisable(false);

                Notification.showConformationeMessage("Updated Successfully");
            }else {
                txtGemID.requestFocus();

                Notification.showFailureMessage("Updating Failed");
            }
        } catch (Exception e) {
            Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadJewelryMakersNames(){
        try {
            TextFields.bindAutoCompletion(txtMakerName,jewelryMakerBO.getJewelryMakersNames());
        } catch (Exception e) {
            Logger.getLogger(GemSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
