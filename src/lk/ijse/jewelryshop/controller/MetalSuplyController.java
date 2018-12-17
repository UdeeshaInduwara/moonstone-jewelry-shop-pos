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
import lk.ijse.jewelryshop.business.custom.JewelryMakerBO;
import lk.ijse.jewelryshop.business.custom.MetalSuplyBO;
import lk.ijse.jewelryshop.controller.utils.Notification;
import lk.ijse.jewelryshop.db.DBConnection;
import lk.ijse.jewelryshop.generator.IDGenerator;
import lk.ijse.jewelryshop.model.JewelryMakerDTO;
import lk.ijse.jewelryshop.model.MetalDTO;
import lk.ijse.jewelryshop.model.MetalSuplyDTO;
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

public class MetalSuplyController implements Initializable {
    MetalSuplyBO metalSuplyBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.METALSUPLY);
    JewelryMakerBO jewelryMakerBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.JEWELRYMAKER);

    @FXML
    private TextField txtSearchMakerId;

    @FXML
    private TextField txtSearchMetalId;

    @FXML
    private TextField txtSearchMetal;

    @FXML
    private TextField txtSearchSupliedDate;

    @FXML
    private TextField txtSearchSupliedWeight;

    @FXML
    private TextField txtSearchCarat;

    @FXML
    private TableView<MetalSuplyDTO> tblMetalSupliedDetail;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableView<MetalDTO> tblMetalStock;

    @FXML
    private JFXComboBox<String> cmbMakerId;

    @FXML
    private JFXTextField txtMakerName;

    @FXML
    private JFXTextField txtSuplyMetalWeight;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtSearchMakerName;

    @FXML
    private JFXTextField txtMetalSuplyId;

    @FXML
    private TextField txtSearchSuplyId;

    @FXML
    private JFXTextField txtMetalId;

    @FXML
    private JFXTextField txtMetal;

    @FXML
    private JFXTextField txtCarat;

    @FXML
    private JFXTextField txtAvailableWeight;

    @FXML
    private JFXButton btnReport;

    @FXML
    void loadMetalSupplyDetailReport(ActionEvent event) {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/jewelryshop/reports/MetalSupplyDetail.jasper");

        HashMap map= new HashMap();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        } catch (JRException e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingSuplyId(KeyEvent event) {
        if(event.getCode()== KeyCode.DOWN){
            txtSearchMetalId.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchSupliedDate.requestFocus();
        }

        String suplyIdText = txtSearchSuplyId.getText();
        try {
            ArrayList<MetalSuplyDTO> dtos = metalSuplyBO.searchMetalSuplyUsingSuplyId(suplyIdText);
            tblMetalSupliedDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingMetalId(KeyEvent event) {
        if(event.getCode()== KeyCode.DOWN){
            txtSearchMetal.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchSuplyId.requestFocus();
        }

        String metalIdText = txtSearchMetalId.getText();
        try {
            ArrayList<MetalSuplyDTO> dtos = metalSuplyBO.searchMetalSuplyUsingMetalId(metalIdText);
            tblMetalSupliedDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingMetal(KeyEvent event) {
        if(event.getCode()== KeyCode.DOWN){
            txtSearchMakerId.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchMetalId.requestFocus();
        }

        String metalText = txtSearchMetal.getText();
        try {
            ArrayList<MetalSuplyDTO> dtos = metalSuplyBO.searchMetalSuplyUsingMetal(metalText);
            tblMetalSupliedDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingMakerId(KeyEvent event) {
        if(event.getCode()== KeyCode.DOWN){
            txtSearchMakerName.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchMetal.requestFocus();
        }

        String makerIdText = txtSearchMakerId.getText();
        try {
            ArrayList<MetalSuplyDTO> dtos = metalSuplyBO.searchMetalSuplyUsingMakerId(makerIdText);
            tblMetalSupliedDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingMakerName(KeyEvent event) {
        if(event.getCode()== KeyCode.DOWN){
            txtSearchSupliedWeight.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchMakerId.requestFocus();
        }

        String makerNameText = txtSearchMakerName.getText();
        try {
            ArrayList<MetalSuplyDTO> dtos = metalSuplyBO.searchMetalSuplyUsingMakerName(makerNameText);
            tblMetalSupliedDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingWeight(KeyEvent event) {
        if(event.getCode()== KeyCode.DOWN){
            txtSearchCarat.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchMakerName.requestFocus();
        }

        if(Validator.isNotEmptyValidation(txtSearchSupliedWeight.getText())){
            double supliedWeightText = Double.parseDouble(txtSearchSupliedWeight.getText());
            try {
                ArrayList<MetalSuplyDTO> dtos = metalSuplyBO.searchMetalSuplyUsingWeight(supliedWeightText);
                tblMetalSupliedDetail.setItems(FXCollections.observableArrayList(dtos));
            } catch (Exception e) {
                Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
            }
        }else {
            loadMetalSuplyTable();
        }
    }

    @FXML
    void searchUsingCarat(KeyEvent event) {
        if(event.getCode()== KeyCode.DOWN){
            txtSearchSupliedDate.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchSupliedWeight.requestFocus();
        }

        if(Validator.isNotEmptyValidation(txtSearchCarat.getText())){
            int caratText = Integer.parseInt(txtSearchCarat.getText());
            try {
                ArrayList<MetalSuplyDTO> dtos = metalSuplyBO.searchMetalSuplyUsingCarat(caratText);
                tblMetalSupliedDetail.setItems(FXCollections.observableArrayList(dtos));
            } catch (Exception e) {
                Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
            }
        }else {
            loadMetalSuplyTable();
        }
    }

    @FXML
    void searchUsingSuplyDate(KeyEvent event) {
        if(event.getCode()== KeyCode.DOWN){
            txtSearchSuplyId.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchCarat.requestFocus();
        }

        String supliedDateText = txtSearchSupliedDate.getText();
        try {
            ArrayList<MetalSuplyDTO> dtos = metalSuplyBO.searchMetalSuplyUsingSuplyDate(supliedDateText);
            tblMetalSupliedDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void txtSupplyWeightOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                try {
                    if (txtMetalId.getText().equals(metalSuplyBO.searchMetal(txtMetalId.getText()).getMetid())) {
                        try {
                            if (Validator.doubleValueValidation(txtAvailableWeight.getText())) {
                                try {
                                    if (Validator.doubleValueValidation(txtSuplyMetalWeight.getText())){
                                        if (Double.parseDouble(txtSuplyMetalWeight.getText()) > Double.parseDouble(txtAvailableWeight.getText())||
                                                Double.parseDouble(txtSuplyMetalWeight.getText()) <= 0){
                                            txtSuplyMetalWeight.selectAll();

                                            Notification.showAttrntionMessage("Fill the Weight Correctly");
                                        }else {
                                            txtDate.requestFocus();
                                        }
                                    }else {
                                        txtSuplyMetalWeight.selectAll();

                                        Notification.showAttrntionMessage("Fill the Weight Correctly");
                                    }
                                }catch (NullPointerException e){
                                    txtSuplyMetalWeight.selectAll();

                                    Notification.showAttrntionMessage("Fill the Weight Correctly");
                                }
                            }else {
                                tblMetalStock.requestFocus();

                                Notification.showAttrntionMessage("Fill Metal Dedtail Correctly");
                            }
                        }catch (NullPointerException e){
                            tblMetalStock.requestFocus();

                            Notification.showAttrntionMessage("Fill Metal Dedtail Correctly");
                        }
                    } else {
                        tblMetalStock.requestFocus();

                        Notification.showAttrntionMessage("Fill Metal Dedtail Correctly");
                    }
                }catch (NullPointerException e){
                    tblMetalStock.requestFocus();

                    Notification.showAttrntionMessage("Fill Metal Dedtail Correctly");
                }
            } catch (Exception e) {
                Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        if(event.getCode()== KeyCode.UP) {
            txtSearchSuplyId.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT) {
            tblMetalStock.requestFocus();
        }
    }

    @FXML
    void txtSupplyDateOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.SHIFT) {
            txtDate.show();
            if (txtDate.isShowing()){
                cmbMakerId.requestFocus();
            }
        }
        if(event.getCode()== KeyCode.CONTROL) {
            txtSuplyMetalWeight.requestFocus();
        }
    }
    @FXML
    void cmbMakerIDOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER) {
            cmbMakerId.show();
        }
        if(event.getCode()== KeyCode.UP) {
            txtSearchSuplyId.requestFocus();
        }
    }

    @FXML
    void txtMakerNameOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER) {
            try {
                try {
                    if (txtMetalId.getText().equals(metalSuplyBO.searchMetal(txtMetalId.getText()).getMetid())) {
                        try {
                            if (Validator.doubleValueValidation(txtAvailableWeight.getText())) {
                                try {
                                    if (Validator.doubleValueValidation(txtSuplyMetalWeight.getText())){
                                        if (Double.parseDouble(txtSuplyMetalWeight.getText()) > Double.parseDouble(txtAvailableWeight.getText())||
                                                Double.parseDouble(txtSuplyMetalWeight.getText()) <= 0){
                                            txtSuplyMetalWeight.requestFocus();
                                        }else {
                                            try {
                                                txtDate.getValue().toString();
                                                try {
                                                    if (Validator.jewelryMakerIdValidation(cmbMakerId.getSelectionModel().getSelectedItem())){
                                                        if (Validator.isNotEmptyValidation(txtMakerName.getText())){
                                                            if (btnUpdate.isDisabled()) {
                                                                btnAddOnAction();
                                                            } else {
                                                                btnUpdateOnAction();
                                                            }
                                                        }else {
                                                            txtMakerName.requestFocus();

                                                            Notification.showAttrntionMessage("Fill Maker Name Correctly");
                                                        }
                                                    }else {
                                                        cmbMakerId.requestFocus();

                                                        Notification.showAttrntionMessage("Fill Maker ID Correctly");
                                                    }
                                                }catch (NullPointerException e){
                                                    cmbMakerId.requestFocus();

                                                    Notification.showAttrntionMessage("Fill Maker ID Correctly");
                                                }
                                            }catch (NullPointerException e){
                                                txtDate.requestFocus();

                                                Notification.showAttrntionMessage("Fill Supply Date Correctly");
                                            }
                                        }
                                    }else {
                                        txtSuplyMetalWeight.requestFocus();

                                        Notification.showAttrntionMessage("Fill the Weightt Correctly");
                                    }
                                }catch (NullPointerException e){
                                    txtSuplyMetalWeight.requestFocus();

                                    Notification.showAttrntionMessage("Fill the Weightt Correctly");
                                }
                            }else {
                                tblMetalStock.requestFocus();

                                Notification.showAttrntionMessage("Fill Metal Dedtail Correctly");
                            }
                        }catch (NullPointerException e){
                            tblMetalStock.requestFocus();

                            Notification.showAttrntionMessage("Fill Metal Dedtail Correctly");
                        }
                    } else {
                        tblMetalStock.requestFocus();

                        Notification.showAttrntionMessage("Fill Metal Dedtail Correctly");
                    }
                }catch (NullPointerException e){
                    tblMetalStock.requestFocus();

                    Notification.showAttrntionMessage("Fill Metal Dedtail Correctly");
                }
            } catch (Exception e) {
                Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        if(event.getCode()== KeyCode.UP) {
            txtSearchSuplyId.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT) {
            cmbMakerId.requestFocus();
        }
    }

    @FXML
    void addMetalSuply(ActionEvent event) {
        try {
            try {
                if (txtMetalId.getText().equals(metalSuplyBO.searchMetal(txtMetalId.getText()).getMetid())) {
                    try {
                        if (Validator.doubleValueValidation(txtAvailableWeight.getText())) {
                            try {
                                if (Validator.doubleValueValidation(txtSuplyMetalWeight.getText())){
                                    if (Double.parseDouble(txtSuplyMetalWeight.getText()) > Double.parseDouble(txtAvailableWeight.getText())||
                                            Double.parseDouble(txtSuplyMetalWeight.getText()) <= 0){
                                        txtSuplyMetalWeight.requestFocus();
                                    }else {
                                        try {
                                            txtDate.getValue().toString();
                                            try {
                                                if (Validator.jewelryMakerIdValidation(cmbMakerId.getSelectionModel().getSelectedItem())){
                                                    if (Validator.isNotEmptyValidation(txtMakerName.getText())){
                                                        btnAddOnAction();
                                                    }else {
                                                        txtMakerName.requestFocus();

                                                        Notification.showAttrntionMessage("Fill Maker Name Correctly");
                                                    }
                                                }else {
                                                    cmbMakerId.requestFocus();

                                                    Notification.showAttrntionMessage("Fill Maker ID Correctly");
                                                }
                                            }catch (NullPointerException e){
                                                cmbMakerId.requestFocus();

                                                Notification.showAttrntionMessage("Fill Maker ID Correctly");
                                            }
                                        }catch (NullPointerException e){
                                            txtDate.requestFocus();

                                            Notification.showAttrntionMessage("Fill Supply Date Correctly");
                                        }
                                    }
                                }else {
                                    txtSuplyMetalWeight.requestFocus();

                                    Notification.showAttrntionMessage("Fill the Weightt Correctly");
                                }
                            }catch (NullPointerException e){
                                txtSuplyMetalWeight.requestFocus();

                                Notification.showAttrntionMessage("Fill the Weightt Correctly");
                            }
                        }else {
                            tblMetalStock.requestFocus();

                            Notification.showAttrntionMessage("Fill Metal Dedtail Correctly");
                        }
                    }catch (NullPointerException e){
                        tblMetalStock.requestFocus();

                        Notification.showAttrntionMessage("Fill Metal Dedtail Correctly");
                    }
                } else {
                    tblMetalStock.requestFocus();

                    Notification.showAttrntionMessage("Fill Metal Dedtail Correctly");
                }
            }catch (NullPointerException e){
                tblMetalStock.requestFocus();

                Notification.showAttrntionMessage("Fill Metal Dedtail Correctly");
            }
        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void updateMetalSuply(ActionEvent event) {
        try {
            try {
                if (txtMetalId.getText().equals(metalSuplyBO.searchMetal(txtMetalId.getText()).getMetid())) {
                    try {
                        if (Validator.doubleValueValidation(txtAvailableWeight.getText())) {
                            try {
                                if (Validator.doubleValueValidation(txtSuplyMetalWeight.getText())){
                                    if (Double.parseDouble(txtSuplyMetalWeight.getText()) > Double.parseDouble(txtAvailableWeight.getText())||
                                            Double.parseDouble(txtSuplyMetalWeight.getText()) <= 0){
                                        txtSuplyMetalWeight.requestFocus();
                                    }else {
                                        try {
                                            txtDate.getValue().toString();
                                            try {
                                                if (Validator.jewelryMakerIdValidation(cmbMakerId.getSelectionModel().getSelectedItem())){
                                                    if (Validator.isNotEmptyValidation(txtMakerName.getText())){
                                                        btnUpdateOnAction();
                                                    }else {
                                                        txtMakerName.requestFocus();

                                                        Notification.showAttrntionMessage("Fill Maker Name Correctly");
                                                    }
                                                }else {
                                                    cmbMakerId.requestFocus();

                                                    Notification.showAttrntionMessage("Fill Maker ID Correctly");
                                                }
                                            }catch (NullPointerException e){
                                                cmbMakerId.requestFocus();

                                                Notification.showAttrntionMessage("Fill Maker ID Correctly");
                                            }
                                        }catch (NullPointerException e){
                                            txtDate.requestFocus();

                                            Notification.showAttrntionMessage("Fill Supply Date Correctly");
                                        }
                                    }
                                }else {
                                    txtSuplyMetalWeight.requestFocus();

                                    Notification.showAttrntionMessage("Fill the Weightt Correctly");
                                }
                            }catch (NullPointerException e){
                                txtSuplyMetalWeight.requestFocus();

                                Notification.showAttrntionMessage("Fill the Weightt Correctly");
                            }
                        }else {
                            tblMetalStock.requestFocus();

                            Notification.showAttrntionMessage("Fill Metal Dedtail Correctly");
                        }
                    }catch (NullPointerException e){
                        tblMetalStock.requestFocus();

                        Notification.showAttrntionMessage("Fill Metal Dedtail Correctly");
                    }
                } else {
                    tblMetalStock.requestFocus();

                    Notification.showAttrntionMessage("Fill Metal Dedtail Correctly");
                }
            }catch (NullPointerException e){
                tblMetalStock.requestFocus();

                Notification.showAttrntionMessage("Fill Metal Dedtail Correctly");
            }
        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void cancelAdding(ActionEvent event) {
        try {
            String newID = IDGenerator.getNewID("metalSuplyDetail", "metsupid", "MSUP");
            txtMetalSuplyId.setText(newID);
        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
        txtAvailableWeight.setDisable(false);
        txtMetalId.setText(null);
        txtMetal.setText(null);
        txtCarat.setText(null);
        txtAvailableWeight.setText(null);
        txtSuplyMetalWeight.setText(null);
        txtDate.setValue(null);
        cmbMakerId.getSelectionModel().clearSelection();
        txtMakerName.setText(null);
        tblMetalStock.getSelectionModel().clearSelection();
    }

    @FXML
    void removeMetalSuply(ActionEvent event) {
        try {
            String metalSuplyId = tblMetalSupliedDetail.getSelectionModel().getSelectedItem().getMetalSuplyId();
            try {
                boolean isDeleted = metalSuplyBO.removeMetalSuplies(metalSuplyId);
                if(isDeleted){
                    txtMetalId.setText(null);
                    txtMetal.setText(null);
                    txtCarat.setText(null);
                    txtAvailableWeight.setText(null);
                    txtSuplyMetalWeight.setText(null);
                    txtDate.setValue(null);
                    cmbMakerId.getSelectionModel().clearSelection();
                    txtMakerName.setText(null);
                    btnAdd.setDisable(false);
                    btnUpdate.setDisable(true);
                    loadMetalSuplyTable();
                    loadMetalStock();

                    Notification.showConformationeMessage("Removed Successfully");
                }else {
                    Notification.showFailureMessage("Removing Failed");
                }
            } catch (Exception e) {
                Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
            }
        }catch (Exception e){
            Notification.showWarningMessage("Select Item First to Remove");
        }
    }

    @FXML
    void selectMaker(ActionEvent event) {
        String makerId = cmbMakerId.getSelectionModel().getSelectedItem();
        try {
            try {
                JewelryMakerDTO dto = jewelryMakerBO.searchJewelryMakerUseId(makerId);
                txtMakerName.setText(dto.getName());
            }catch (NullPointerException e){}
        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void selectMakerId(ActionEvent event) {
        String makerNameText = txtMakerName.getText();
        try {

            try{
                JewelryMakerDTO dto = jewelryMakerBO.searchJewelryMakerUseName(makerNameText);
                cmbMakerId.getSelectionModel().select(dto.getJmid());
            }catch (NullPointerException e){}

        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void selectMetalSuply(MouseEvent event) {
        try {
            MetalSuplyDTO dto = tblMetalSupliedDetail.getSelectionModel().getSelectedItem();
            txtMetalSuplyId.setText(dto.getMetalSuplyId());
            txtMetalId.setText(dto.getMetalId());
            txtMetal.setText(dto.getMetal());
            txtCarat.setText(Integer.toString(dto.getCarat()));
            cmbMakerId.getSelectionModel().select(dto.getMakerId());
            txtMakerName.setText(dto.getMakerName());
            txtSuplyMetalWeight.setText(Double.toString(dto.getSupliedWeight()));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(dto.getSupliedDate(), formatter);
            txtDate.setValue(localDate);

            try {
                MetalDTO metalDTO = metalSuplyBO.searchMetal(dto.getMetalId());
                txtAvailableWeight.setText(Double.toString(metalDTO.getAvailableWeight()));
            } catch (Exception e) {
                Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
            }
        }catch (NullPointerException e){}

        btnAdd.setDisable(true);
        btnUpdate.setDisable(false);
        txtSuplyMetalWeight.requestFocus();
        tblMetalStock.getSelectionModel().clearSelection();

    }

    @FXML
    void selectCurrentMetalStock(MouseEvent event) {
        try {
            String newID = IDGenerator.getNewID("metalSuplyDetail", "metsupid", "MSUP");
            txtMetalSuplyId.setText(newID);
        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
        txtMetalId.setText(null);
        txtMetal.setText(null);
        txtCarat.setText(null);
        txtAvailableWeight.setText(null);
        txtSuplyMetalWeight.setText(null);
        txtDate.setValue(null);
        cmbMakerId.getSelectionModel().clearSelection();
        txtMakerName.setText(null);
        btnAdd.setDisable(false);
        btnUpdate.setDisable(true);
        txtAvailableWeight.setDisable(false);

        MetalDTO dto = tblMetalStock.getSelectionModel().getSelectedItem();
        if (dto.getAvailableWeight()!=0){
            txtMetalId.setText(dto.getMetid());
            txtMetal.setText(dto.getMetalType());
            txtCarat.setText(Integer.toString(dto.getCarat()));
            txtAvailableWeight.setText(Double.toString(dto.getAvailableWeight()));
            txtSuplyMetalWeight.requestFocus();
            tblMetalSupliedDetail.getSelectionModel().clearSelection();
        }else {
            tblMetalStock.requestFocus();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblMetalStock.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("metid"));
        tblMetalStock.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("metalType"));
        tblMetalStock.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("carat"));
        tblMetalStock.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("availableWeight"));
        loadMetalStock();

        tblMetalSupliedDetail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("metalSuplyId"));
        tblMetalSupliedDetail.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("metalId"));
        tblMetalSupliedDetail.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("metal"));
        tblMetalSupliedDetail.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("carat"));
        tblMetalSupliedDetail.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("supliedWeight"));
        tblMetalSupliedDetail.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("makerId"));
        tblMetalSupliedDetail.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("makerName"));
        tblMetalSupliedDetail.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("supliedDate"));
        loadMetalSuplyTable();

        try {
            ArrayList<String> jewelryMakersIDs = jewelryMakerBO.getJewelryMakersIDs();
            cmbMakerId.setItems(FXCollections.observableArrayList(jewelryMakersIDs));
        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }

        loadJewelryMakersNames();
    }

    private void loadJewelryMakersNames() {
        try {
            TextFields.bindAutoCompletion(txtMakerName,jewelryMakerBO.getJewelryMakersNames());
        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadMetalSuplyTable() {
        try {
            String newID = IDGenerator.getNewID("metalSuplyDetail", "metsupid", "MSUP");
            txtMetalSuplyId.setText(newID);
        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            ArrayList<MetalSuplyDTO> allMetalSuplies = metalSuplyBO.getAllMetalSuplies();
            tblMetalSupliedDetail.setItems(FXCollections.observableArrayList(allMetalSuplies));
        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadMetalStock() {
        try {
            ArrayList<MetalDTO> allMetalDetails = metalSuplyBO.getAllMetalDetails();
            tblMetalStock.setItems(FXCollections.observableArrayList(allMetalDetails));
        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void btnAddOnAction() {
        String metalSuplyIdText = txtMetalSuplyId.getText();
        double metalWeightText = Double.parseDouble(txtSuplyMetalWeight.getText());
        String makerId = cmbMakerId.getSelectionModel().getSelectedItem();
        String makerNameText = txtMakerName.getText();
        String supliedDate = txtDate.getValue().toString();
        String metalIdText = txtMetalId.getText();
        String metalText = txtMetal.getText();
        int caratText = Integer.parseInt(txtCarat.getText());

        MetalSuplyDTO metalSuplyDTO=new MetalSuplyDTO(metalSuplyIdText,metalIdText,metalText,caratText,metalWeightText,makerId,makerNameText,supliedDate);
        try {
            boolean isAdded = metalSuplyBO.addMetalSuplies(metalSuplyDTO);
            if(isAdded){
                txtMetalId.setText(null);
                txtMetal.setText(null);
                txtCarat.setText(null);
                txtAvailableWeight.setText(null);
                txtSuplyMetalWeight.setText(null);
                txtDate.setValue(null);
                cmbMakerId.getSelectionModel().clearSelection();
                txtMakerName.setText(null);
                txtMetalSuplyId.requestFocus();
                loadMetalStock();
                loadMetalSuplyTable();

                Notification.showConformationeMessage("Added Successfully");
            }else {
                Notification.showFailureMessage("Adding Failed");
            }
        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void btnUpdateOnAction() {
        String metalSuplyIdText = txtMetalSuplyId.getText();
        double metalWeightText = Double.parseDouble(txtSuplyMetalWeight.getText());
        String makerId = cmbMakerId.getSelectionModel().getSelectedItem();
        String makerNameText = txtMakerName.getText();
        String supliedDate = txtDate.getValue().toString();
        String metalIdText = txtMetalId.getText();
        String metalText = txtMetal.getText();
        int caratText = Integer.parseInt(txtCarat.getText());

        MetalSuplyDTO metalSuplyDTO=new MetalSuplyDTO(metalSuplyIdText,metalIdText,metalText,caratText,metalWeightText,makerId,makerNameText,supliedDate);

        try {
            boolean isUpdated = metalSuplyBO.updateMetalSuplies(metalSuplyDTO);
            if(isUpdated){
                txtMetalId.setText(null);
                txtMetal.setText(null);
                txtCarat.setText(null);
                txtAvailableWeight.setText(null);
                txtSuplyMetalWeight.setText(null);
                txtDate.setValue(null);
                cmbMakerId.getSelectionModel().clearSelection();
                txtMakerName.setText(null);
                txtMetalSuplyId.requestFocus();
                btnUpdate.setDisable(true);
                btnAdd.setDisable(false);
                loadMetalStock();
                loadMetalSuplyTable();

                Notification.showConformationeMessage("Updated Successfully");
            }else {
                Notification.showFailureMessage("Updating Failed");
            }
        } catch (Exception e) {
            Logger.getLogger(MetalSuplyController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
