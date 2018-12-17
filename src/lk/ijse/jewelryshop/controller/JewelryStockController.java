package lk.ijse.jewelryshop.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
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
import lk.ijse.jewelryshop.business.custom.JewelryStockBO;
import lk.ijse.jewelryshop.controller.utils.Notification;
import lk.ijse.jewelryshop.db.DBConnection;
import lk.ijse.jewelryshop.generator.IDGenerator;
import lk.ijse.jewelryshop.model.JewelryMakerDTO;
import lk.ijse.jewelryshop.model.JewelryStockDTO;
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

public class JewelryStockController implements Initializable {
    JewelryStockBO jewelryStockBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.JEWELRYSTOCK);
    JewelryMakerBO jewelryMakerBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.JEWELRYMAKER);

    @FXML
    private TextField txtSearchJewelryID;

    @FXML
    private TextField txtSearchMetal;

    @FXML
    private TextField txtSearchCarat;

    @FXML
    private TextField txtSearchWeight;

    @FXML
    private TextField txtSearchSize;

    @FXML
    private TextField txtSearchGem;

    @FXML
    private JFXListView<String> listJewelryType;

    @FXML
    private JFXTextField txtJewelryID;

    @FXML
    private JFXTextField txtMetal;

    @FXML
    private JFXTextField txtCarat;

    @FXML
    private JFXTextField txtWeight;

    @FXML
    private JFXTextField txtSize;

    @FXML
    private JFXTextField txtGem;

    @FXML
    private JFXComboBox<String> cmbMakerID;

    @FXML
    private JFXTextField txtMakerName;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private TextField txtSearchJewelryType;

    @FXML
    private TextField txtSearchMakerId;

    @FXML
    private TextField txtSearchMakeDate;

    @FXML
    private TextField txtSearchPrice;

    @FXML
    private TextField txtSearchMakerName;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private DatePicker txtMakedDate;

    @FXML
    private TableView<JewelryStockDTO> tblJewelryDetail;

    @FXML
    private JFXButton btnReport;

    @FXML
    void loadJewelryStockDetailReport(ActionEvent event) {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/jewelryshop/reports/JewelryStockDetail.jasper");

        HashMap map= new HashMap();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        } catch (JRException e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingJewID(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchMetal.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchPrice.requestFocus();
        }

        String text = txtSearchJewelryID.getText();
        try {
            ArrayList<JewelryStockDTO> dtos = jewelryStockBO.searchJewelryStockUsingJewelryId(text);
            tblJewelryDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingMetal(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchCarat.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchJewelryID.requestFocus();
        }

        String text = txtSearchMetal.getText();
        try {
            ArrayList<JewelryStockDTO> dtos = jewelryStockBO.searchJewelryStockUsingMetal(text);
            tblJewelryDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchusingCarat(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchWeight.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchMetal.requestFocus();
        }

        if(Validator.isNotEmptyValidation(txtSearchCarat.getText())){
            int text = Integer.parseInt(txtSearchCarat.getText());
            try {
                ArrayList<JewelryStockDTO> dtos = jewelryStockBO.searchJewelryStockUsingCarat(text);
                tblJewelryDetail.setItems(FXCollections.observableArrayList(dtos));
            } catch (Exception e) {
                Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
            }
        }else {
            loadJewelryStock();
        }
    }

    @FXML
    void searchUsingWeight(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchSize.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchCarat.requestFocus();
        }

        if(Validator.isNotEmptyValidation(txtSearchWeight.getText())){
            double text = Double.parseDouble(txtSearchWeight.getText());
            try {
                ArrayList<JewelryStockDTO> dtos = jewelryStockBO.searchJewelryStockUsingWeight(text);
                tblJewelryDetail.setItems(FXCollections.observableArrayList(dtos));
            } catch (Exception e) {
                Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
            }
        }else {
            loadJewelryStock();
        }
    }

    @FXML
    void searchUsingSize(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchGem.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchWeight.requestFocus();
        }

        if(Validator.isNotEmptyValidation(txtSearchSize.getText())){
            double text = Double.parseDouble(txtSearchSize.getText());
            try {
                ArrayList<JewelryStockDTO> dtos = jewelryStockBO.searchJewelryStockUsingSize(text);
                tblJewelryDetail.setItems(FXCollections.observableArrayList(dtos));
            } catch (Exception e) {
                Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
            }
        }else {
            loadJewelryStock();
        }
    }

    @FXML
    void searchUsingGem(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchJewelryType.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchSize.requestFocus();
        }

        String text = txtSearchGem.getText();
        try {
            ArrayList<JewelryStockDTO> dtos = jewelryStockBO.searchJewelryStockUsingGem(text);
            tblJewelryDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingJewelryType(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchMakerId.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchGem.requestFocus();
        }

        String text = txtSearchJewelryType.getText();
        try {
            ArrayList<JewelryStockDTO> dtos = jewelryStockBO.searchJewelryStockUsingJewelryType(text);
            tblJewelryDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingMakerId(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchMakerName.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchJewelryType.requestFocus();
        }

        String text = txtSearchMakerId.getText();
        try {
            ArrayList<JewelryStockDTO> dtos = jewelryStockBO.searchJewelryStockUsingMakerId(text);
            tblJewelryDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingMakerName(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchMakeDate.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchMakerId.requestFocus();
        }

        String text = txtSearchMakerName.getText();
        try {
            ArrayList<JewelryStockDTO> dtos = jewelryStockBO.searchJewelryStockUsingMakerName(text);
            tblJewelryDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingMakeDate(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchPrice.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchMakerName.requestFocus();
        }

        String text = txtSearchMakeDate.getText();
        try {
            ArrayList<JewelryStockDTO> dtos = jewelryStockBO.searchJewelryStockUsingMakeDate(text);
            tblJewelryDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingPrice(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchJewelryID.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchMakeDate.requestFocus();
        }

        if(Validator.isNotEmptyValidation(txtSearchPrice.getText())){
            double text = Double.parseDouble(txtSearchPrice.getText());
            try {
                ArrayList<JewelryStockDTO> dtos = jewelryStockBO.searchJewelryStockUsingPrice(text);
                tblJewelryDetail.setItems(FXCollections.observableArrayList(dtos));
            } catch (Exception e) {
                Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
            }
        }else {
            loadJewelryStock();
        }
    }

    @FXML
    void listJewelrytypeOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            txtJewelryID.requestFocus();
        }
    }

    @FXML
    void txtJewelryIdOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            txtMetal.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            listJewelryType.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchJewelryID.requestFocus();
        }
    }

    @FXML
    void txtMetalOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if(!Validator.nameValidation(txtMetal.getText())){
                    txtMetal.selectAll();

                    Notification.showAttrntionMessage("Fill Metal Correctly");
                }else{
                    txtCarat.requestFocus();
                }
            }catch (NullPointerException e){
                txtMetal.selectAll();

                Notification.showAttrntionMessage("Fill Metal Correctly");
            }
        }
        if(event.getCode()== KeyCode.LEFT){
            txtJewelryID.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchJewelryID.requestFocus();
        }
    }

    @FXML
    void txtCaratOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if(!Validator.intValueValidation(txtCarat.getText())){
                    txtCarat.selectAll();

                    Notification.showAttrntionMessage("Fill Carat Value Correctly");
                }else {
                    txtWeight.requestFocus();
                }
            }catch (NullPointerException e){
                txtCarat.selectAll();

                Notification.showAttrntionMessage("Fill Carat Value Correctly");
            }
        }
        if(event.getCode()== KeyCode.LEFT){
            txtMetal.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchJewelryID.requestFocus();
        }
    }

    @FXML
    void txtWeightOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if(!Validator.doubleValueValidation(txtWeight.getText())){
                    txtWeight.selectAll();

                    Notification.showAttrntionMessage("Fill Weight Correctly");
                }else {
                    txtSize.requestFocus();
                }
            }catch (NullPointerException e){
                txtWeight.selectAll();

                Notification.showAttrntionMessage("Fill Weight Correctly");
            }
        }
        if(event.getCode()== KeyCode.LEFT){
            txtCarat.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchJewelryID.requestFocus();
        }
    }

    @FXML
    void txtSizeOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if(!Validator.doubleValueValidation(txtSize.getText())){
                    txtSize.selectAll();

                    Notification.showAttrntionMessage("Fill Size Correctly");
                }else {
                    txtGem.requestFocus();
                }
            }catch (NullPointerException e){
                txtSize.selectAll();

                Notification.showAttrntionMessage("Fill Size Correctly");
            }
        }
        if(event.getCode()== KeyCode.LEFT){
            txtWeight.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchJewelryID.requestFocus();
        }
    }

    @FXML
    void txtGemOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if(!Validator.nameValidation(txtGem.getText())){
                    txtGem.selectAll();

                    Notification.showAttrntionMessage("Fill Gem Type Correctly");
                }else{
                    txtPrice.requestFocus();
                }
            }catch (NullPointerException e){
                txtGem.selectAll();

                Notification.showAttrntionMessage("Fill Gem Type Correctly");
            }
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSize.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchJewelryID.requestFocus();
        }
    }

    @FXML
    void txtPriceOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if(!Validator.doubleValueValidation(txtPrice.getText())){
                    txtPrice.selectAll();

                    Notification.showAttrntionMessage("Fill Price Correctly");
                }else {
                    txtMakedDate.requestFocus();
                }
            }catch (NullPointerException e){
                txtPrice.selectAll();

                Notification.showAttrntionMessage("Fill Price Correctly");
            }
        }
        if(event.getCode()== KeyCode.LEFT){
            txtGem.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchJewelryID.requestFocus();
        }
    }

    @FXML
    void txtDateOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.SHIFT){
            txtMakedDate.show();
            if(txtMakedDate.isShowing()){
                cmbMakerID.requestFocus();
            }
        }
        if(event.getCode()== KeyCode.CONTROL){
            txtPrice.requestFocus();
        }
    }

    @FXML
    void cmbMakerIdOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            cmbMakerID.show();
        }
        if(event.getCode()== KeyCode.CONTROL){
            txtMakedDate.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchJewelryID.requestFocus();
        }
    }

    @FXML
    void txtMakerNameOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if(Validator.isNotEmptyValidation(listJewelryType.getSelectionModel().getSelectedItem())){
                    try {
                        if(Validator.jewelryIdValidation(txtJewelryID.getText())){
                            try {
                                if(Validator.nameValidation(txtMetal.getText())){
                                    try {
                                        if(Validator.intValueValidation(txtCarat.getText())){
                                            try {
                                                if(Validator.doubleValueValidation(txtWeight.getText())){
                                                    try {
                                                        if(Validator.doubleValueValidation(txtSize.getText())){
                                                            try {
                                                                if(Validator.nameValidation(txtGem.getText())){
                                                                    try {
                                                                        if(Validator.doubleValueValidation(txtPrice.getText())){
                                                                            try {
                                                                                txtMakedDate.getValue().toString();
                                                                                try {
                                                                                    if(Validator.jewelryMakerIdValidation(cmbMakerID.getSelectionModel().getSelectedItem())){
                                                                                        if (Validator.nameValidation(txtMakerName.getText())){
                                                                                            if(btnUpdate.isDisabled()){
                                                                                                btnAddOnAction();
                                                                                            }else {
                                                                                                btnUpdateOnAction();
                                                                                            }
                                                                                        }else {
                                                                                            txtMakerName.requestFocus();

                                                                                            Notification.showAttrntionMessage("Fill Maker Name Correctly");
                                                                                        }
                                                                                    }else {
                                                                                        cmbMakerID.requestFocus();

                                                                                        Notification.showAttrntionMessage("Select Maker ID Correctly");
                                                                                    }
                                                                                }catch (NullPointerException e){
                                                                                    cmbMakerID.requestFocus();

                                                                                    Notification.showAttrntionMessage("Select Maker ID Correctly");
                                                                                }
                                                                            }catch (NullPointerException e){
                                                                                txtMakedDate.requestFocus();

                                                                                Notification.showAttrntionMessage("Select Make Date Correctly");
                                                                            }
                                                                        }else {
                                                                            txtPrice.requestFocus();

                                                                            Notification.showAttrntionMessage("Fill Price Correctly");
                                                                        }
                                                                    }catch (NullPointerException e){
                                                                        txtPrice.requestFocus();

                                                                        Notification.showAttrntionMessage("Fill Price Correctly");
                                                                    }
                                                                }else {
                                                                    txtGem.requestFocus();

                                                                    Notification.showAttrntionMessage("Fill Gem Correctly");
                                                                }
                                                            }catch (NullPointerException e){
                                                                txtGem.requestFocus();

                                                                Notification.showAttrntionMessage("Fill Gem Correctly");
                                                            }
                                                        }else {
                                                            txtSize.requestFocus();

                                                            Notification.showAttrntionMessage("Fill Size Correctly");
                                                        }
                                                    }catch (NullPointerException e){
                                                        txtSize.requestFocus();

                                                        Notification.showAttrntionMessage("Fill Size Correctly");
                                                    }
                                                }else {
                                                    txtWeight.requestFocus();

                                                    Notification.showAttrntionMessage("Fill Weight Correctly");
                                                }
                                            }catch (NullPointerException e){
                                                txtWeight.requestFocus();

                                                Notification.showAttrntionMessage("Fill Weight Correctly");
                                            }
                                        }else {
                                            txtCarat.requestFocus();

                                            Notification.showAttrntionMessage("Fill Carat Value Correctly");
                                        }
                                    }catch (NullPointerException e){
                                        txtCarat.requestFocus();

                                        Notification.showAttrntionMessage("Fill Carat Value Correctly");
                                    }
                                }else {
                                    txtMetal.requestFocus();

                                    Notification.showAttrntionMessage("Fill Metal Correctly");
                                }
                            }catch (NullPointerException e){
                                txtMetal.requestFocus();

                                Notification.showAttrntionMessage("Fill Metal Correctly");
                            }
                        }else {
                            txtJewelryID.requestFocus();

                            Notification.showAttrntionMessage("Fill Jewelry ID Correctly");
                        }
                    }catch (NullPointerException e){
                        txtJewelryID.requestFocus();

                        Notification.showAttrntionMessage("Fill Jewelry ID Correctly");
                    }
                }else {
                    listJewelryType.requestFocus();

                    Notification.showAttrntionMessage("Fill Jewelry Type Correctly");
                }
            }catch (NullPointerException e){
                listJewelryType.requestFocus();

                Notification.showAttrntionMessage("Fill Jewelry Type Correctly");
            }
        }
        if(event.getCode()== KeyCode.LEFT){
            cmbMakerID.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchJewelryID.requestFocus();
        }
    }

    @FXML
    void addJewelry(ActionEvent event) {
        try {
            if(Validator.isNotEmptyValidation(listJewelryType.getSelectionModel().getSelectedItem())){
                try {
                    if(Validator.jewelryIdValidation(txtJewelryID.getText())){
                        try {
                            if(Validator.nameValidation(txtMetal.getText())){
                                try {
                                    if(Validator.intValueValidation(txtCarat.getText())){
                                        try {
                                            if(Validator.doubleValueValidation(txtWeight.getText())){
                                                try {
                                                    if(Validator.doubleValueValidation(txtSize.getText())){
                                                        try {
                                                            if(Validator.nameValidation(txtGem.getText())){
                                                                try {
                                                                    if(Validator.doubleValueValidation(txtPrice.getText())){
                                                                        try {
                                                                            txtMakedDate.getValue().toString();
                                                                            try {
                                                                                if(Validator.jewelryMakerIdValidation(cmbMakerID.getSelectionModel().getSelectedItem())){
                                                                                    if (Validator.nameValidation(txtMakerName.getText())){
                                                                                        btnAddOnAction();
                                                                                    }else {
                                                                                        txtMakerName.requestFocus();

                                                                                        Notification.showAttrntionMessage("Fill Maker Name Correctly");
                                                                                    }
                                                                                }else {
                                                                                    cmbMakerID.requestFocus();

                                                                                    Notification.showAttrntionMessage("Select Maker ID Correctly");
                                                                                }
                                                                            }catch (NullPointerException e){
                                                                                cmbMakerID.requestFocus();

                                                                                Notification.showAttrntionMessage("Select Maker ID Correctly");
                                                                            }
                                                                        }catch (NullPointerException e){
                                                                            txtMakedDate.requestFocus();

                                                                            Notification.showAttrntionMessage("Select Make Date Correctly");
                                                                        }
                                                                    }else {
                                                                        txtPrice.requestFocus();

                                                                        Notification.showAttrntionMessage("Fill Price Correctly");
                                                                    }
                                                                }catch (NullPointerException e){
                                                                    txtPrice.requestFocus();

                                                                    Notification.showAttrntionMessage("Fill Price Correctly");
                                                                }
                                                            }else {
                                                                txtGem.requestFocus();

                                                                Notification.showAttrntionMessage("Fill Gem Correctly");
                                                            }
                                                        }catch (NullPointerException e){
                                                            txtGem.requestFocus();

                                                            Notification.showAttrntionMessage("Fill Gem Correctly");
                                                        }
                                                    }else {
                                                        txtSize.requestFocus();

                                                        Notification.showAttrntionMessage("Fill Size Correctly");
                                                    }
                                                }catch (NullPointerException e){
                                                    txtSize.requestFocus();

                                                    Notification.showAttrntionMessage("Fill Size Correctly");
                                                }
                                            }else {
                                                txtWeight.requestFocus();

                                                Notification.showAttrntionMessage("Fill Weight Correctly");
                                            }
                                        }catch (NullPointerException e){
                                            txtWeight.requestFocus();

                                            Notification.showAttrntionMessage("Fill Weight Correctly");
                                        }
                                    }else {
                                        txtCarat.requestFocus();

                                        Notification.showAttrntionMessage("Fill Carat Value Correctly");
                                    }
                                }catch (NullPointerException e){
                                    txtCarat.requestFocus();

                                    Notification.showAttrntionMessage("Fill Carat Value Correctly");
                                }
                            }else {
                                txtMetal.requestFocus();

                                Notification.showAttrntionMessage("Fill Metal Correctly");
                            }
                        }catch (NullPointerException e){
                            txtMetal.requestFocus();

                            Notification.showAttrntionMessage("Fill Metal Correctly");
                        }
                    }else {
                        txtJewelryID.requestFocus();

                        Notification.showAttrntionMessage("Fill Jewelry ID Correctly");
                    }
                }catch (NullPointerException e){
                    txtJewelryID.requestFocus();

                    Notification.showAttrntionMessage("Fill Jewelry ID Correctly");
                }
            }else {
                listJewelryType.requestFocus();

                Notification.showAttrntionMessage("Fill Jewelry Type Correctly");
            }
        }catch (NullPointerException e){
            listJewelryType.requestFocus();

            Notification.showAttrntionMessage("Fill Jewelry Type Correctly");
        }
    }

    @FXML
    void updateJewelry(ActionEvent event) {
        try {
            if(Validator.isNotEmptyValidation(listJewelryType.getSelectionModel().getSelectedItem())){
                try {
                    if(Validator.jewelryIdValidation(txtJewelryID.getText())){
                        try {
                            if(Validator.nameValidation(txtMetal.getText())){
                                try {
                                    if(Validator.intValueValidation(txtCarat.getText())){
                                        try {
                                            if(Validator.doubleValueValidation(txtWeight.getText())){
                                                try {
                                                    if(Validator.doubleValueValidation(txtSize.getText())){
                                                        try {
                                                            if(Validator.nameValidation(txtGem.getText())){
                                                                try {
                                                                    if(Validator.doubleValueValidation(txtPrice.getText())){
                                                                        try {
                                                                            txtMakedDate.getValue().toString();
                                                                            try {
                                                                                if(Validator.jewelryMakerIdValidation(cmbMakerID.getSelectionModel().getSelectedItem())){
                                                                                    if (Validator.nameValidation(txtMakerName.getText())){
                                                                                        btnUpdateOnAction();
                                                                                    }else {
                                                                                        txtMakerName.requestFocus();

                                                                                        Notification.showAttrntionMessage("Fill Maker Name Correctly");
                                                                                    }
                                                                                }else {
                                                                                    cmbMakerID.requestFocus();

                                                                                    Notification.showAttrntionMessage("Select Maker ID Correctly");
                                                                                }
                                                                            }catch (NullPointerException e){
                                                                                cmbMakerID.requestFocus();

                                                                                Notification.showAttrntionMessage("Select Maker ID Correctly");
                                                                            }
                                                                        }catch (NullPointerException e){
                                                                            txtMakedDate.requestFocus();

                                                                            Notification.showAttrntionMessage("Select Make Date Correctly");
                                                                        }
                                                                    }else {
                                                                        txtPrice.requestFocus();

                                                                        Notification.showAttrntionMessage("Fill Price Correctly");
                                                                    }
                                                                }catch (NullPointerException e){
                                                                    txtPrice.requestFocus();

                                                                    Notification.showAttrntionMessage("Fill Price Correctly");
                                                                }
                                                            }else {
                                                                txtGem.requestFocus();

                                                                Notification.showAttrntionMessage("Fill Gem Correctly");
                                                            }
                                                        }catch (NullPointerException e){
                                                            txtGem.requestFocus();

                                                            Notification.showAttrntionMessage("Fill Gem Correctly");
                                                        }
                                                    }else {
                                                        txtSize.requestFocus();

                                                        Notification.showAttrntionMessage("Fill Size Correctly");
                                                    }
                                                }catch (NullPointerException e){
                                                    txtSize.requestFocus();

                                                    Notification.showAttrntionMessage("Fill Size Correctly");
                                                }
                                            }else {
                                                txtWeight.requestFocus();

                                                Notification.showAttrntionMessage("Fill Weight Correctly");
                                            }
                                        }catch (NullPointerException e){
                                            txtWeight.requestFocus();

                                            Notification.showAttrntionMessage("Fill Weight Correctly");
                                        }
                                    }else {
                                        txtCarat.requestFocus();

                                        Notification.showAttrntionMessage("Fill Carat Value Correctly");
                                    }
                                }catch (NullPointerException e){
                                    txtCarat.requestFocus();

                                    Notification.showAttrntionMessage("Fill Carat Value Correctly");
                                }
                            }else {
                                txtMetal.requestFocus();

                                Notification.showAttrntionMessage("Fill Metal Correctly");
                            }
                        }catch (NullPointerException e){
                            txtMetal.requestFocus();

                            Notification.showAttrntionMessage("Fill Metal Correctly");
                        }
                    }else {
                        txtJewelryID.requestFocus();

                        Notification.showAttrntionMessage("Fill Jewelry ID Correctly");
                    }
                }catch (NullPointerException e){
                    txtJewelryID.requestFocus();

                    Notification.showAttrntionMessage("Fill Jewelry ID Correctly");
                }
            }else {
                listJewelryType.requestFocus();

                Notification.showAttrntionMessage("Fill Jewelry Type Correctly");
            }
        }catch (NullPointerException e){
            listJewelryType.requestFocus();

            Notification.showAttrntionMessage("Fill Jewelry Type Correctly");
        }
    }

    @FXML
    void cancelAdding(ActionEvent event) {
        try {
            String newID = IDGenerator.getNewID("jewelry", "jewid", "JEW");
            txtJewelryID.setText(newID);
        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }
        listJewelryType.getSelectionModel().clearSelection();
        txtMetal.setText(null);
        txtCarat.setText(null);
        txtWeight.setText(null);
        txtSize.setText(null);
        txtGem.setText(null);
        txtPrice.setText(null);
        txtMakedDate.setValue(null);
        cmbMakerID.getSelectionModel().clearSelection();
        txtMakerName.setText(null);
    }

    @FXML
    void removeJewelry(ActionEvent event) {
        try {
            JewelryStockDTO dto = tblJewelryDetail.getSelectionModel().getSelectedItem();
            String jewelryId=dto.getJewelryId();
            String jewelrytypeId=dto.getJewelryTypeId();
            try {
                boolean isDeleted = jewelryStockBO.removeJewelryStock(jewelryId,jewelrytypeId);
                if(isDeleted){
                    loadJewelryStock();
                    listJewelryType.getSelectionModel().clearSelection();
                    txtMetal.setText(null);
                    txtCarat.setText(null);
                    txtWeight.setText(null);
                    txtSize.setText(null);
                    txtGem.setText(null);
                    txtPrice.setText(null);
                    txtMakedDate.setValue(null);
                    cmbMakerID.getSelectionModel().clearSelection();
                    txtMakerName.setText(null);
                    btnUpdate.setDisable(true);
                    btnAdd.setDisable(false);

                    Notification.showConformationeMessage("Removed Successfully");
                }else {
                    Notification.showFailureMessage("Removing Failed");
                }
            } catch (Exception e) {
                Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
            }
        }catch (Exception e){
            Notification.showWarningMessage("Select Item First to Remove");
        }
    }

    @FXML
    void selectJewelry(MouseEvent event) {
        try {
            JewelryStockDTO dto = tblJewelryDetail.getSelectionModel().getSelectedItem();
            listJewelryType.getSelectionModel().select(dto.getJewelryType());
            txtJewelryID.setText(dto.getJewelryId());
            txtMetal.setText(dto.getMetal());
            txtCarat.setText(Integer.toString(dto.getCarat()));
            txtWeight.setText(Double.toString(dto.getWeight()));
            txtGem.setText(dto.getGem());
            txtSize.setText(Double.toString(dto.getSize()));
            txtPrice.setText(Double.toString(dto.getPrice()));
            txtMakerName.setText(dto.getMakerName());
            cmbMakerID.getSelectionModel().select(dto.getMakerId());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(dto.getDate(), formatter);
            txtMakedDate.setValue(localDate);
        }catch (NullPointerException e){}

        btnUpdate.setDisable(false);
        btnAdd.setDisable(true);
        txtJewelryID.requestFocus();
    }

    @FXML
    void selectMaker(ActionEvent event) {
        String makerIDText = cmbMakerID.getSelectionModel().getSelectedItem();
        try {

            try {
                JewelryMakerDTO dto = jewelryMakerBO.searchJewelryMakerUseId(makerIDText);
                txtMakerName.setText(dto.getName());
            }catch (NullPointerException e){}

        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void selectMakerID(ActionEvent event) {
        String makerNameText = txtMakerName.getText();
        try {

            try{
                JewelryMakerDTO dto = jewelryMakerBO.searchJewelryMakerUseName(makerNameText);
                cmbMakerID.getSelectionModel().select(dto.getJmid());
            }catch (NullPointerException e){}

        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ArrayList<String> jewelryMakersIDs = jewelryMakerBO.getJewelryMakersIDs();
            cmbMakerID.setItems(FXCollections.observableArrayList(jewelryMakersIDs));
        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }

        tblJewelryDetail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("jewelryType"));
        tblJewelryDetail.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("jewelryId"));
        tblJewelryDetail.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("metal"));
        tblJewelryDetail.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("carat"));
        tblJewelryDetail.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("weight"));
        tblJewelryDetail.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("size"));
        tblJewelryDetail.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("gem"));
        tblJewelryDetail.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("makerId"));
        tblJewelryDetail.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("makerName"));
        tblJewelryDetail.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblJewelryDetail.getColumns().get(10).setCellValueFactory(new PropertyValueFactory<>("Price"));

        loadJewelryStock();

        loadJewelryMakersNames();

        try {
            ArrayList<String> jewelryTypes = jewelryStockBO.getJewelryTypes();
            listJewelryType.setItems(FXCollections.observableArrayList(jewelryTypes));
        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadJewelryMakersNames() {
        try {
            TextFields.bindAutoCompletion(txtMakerName,jewelryMakerBO.getJewelryMakersNames());
        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadJewelryStock(){
        try {
            String newID = IDGenerator.getNewID("jewelry", "jewid", "JEW");
            txtJewelryID.setText(newID);
        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            ArrayList<JewelryStockDTO> dto = jewelryStockBO.getJewelryStockDetails();
            tblJewelryDetail.setItems(FXCollections.observableArrayList(dto));
        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void btnAddOnAction() {
        String jewelryType=listJewelryType.getSelectionModel().getSelectedItem();
        String jewlryTypeId=null;
        try {
            jewlryTypeId=jewelryStockBO.getJewelryTypeId(jewelryType);
        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }
        String jewelryIDText = txtJewelryID.getText();
        String metalText = txtMetal.getText();
        int caratText = Integer.parseInt(txtCarat.getText());
        double weightText = Double.parseDouble(txtWeight.getText());
        double sizeText = Double.parseDouble(txtSize.getText());
        String gemText = txtGem.getText();
        double priceText = Double.parseDouble(txtPrice.getText());
        String makerIDText = cmbMakerID.getSelectionModel().getSelectedItem();
        String makerNameText = txtMakerName.getText();
        String date = txtMakedDate.getValue().toString();

        JewelryStockDTO dto=new JewelryStockDTO(jewelryType,jewlryTypeId,jewelryIDText,metalText,caratText,weightText,sizeText,gemText,priceText,makerIDText,makerNameText,date);
        try {
            boolean isAdded = jewelryStockBO.addJewelryStock(dto);
            if(isAdded){
                loadJewelryStock();
                listJewelryType.getSelectionModel().clearSelection();
                txtMetal.setText(null);
                txtCarat.setText(null);
                txtWeight.setText(null);
                txtSize.setText(null);
                txtGem.setText(null);
                txtPrice.setText(null);
                txtMakedDate.setValue(null);
                cmbMakerID.getSelectionModel().clearSelection();
                txtMakerName.setText(null);
                listJewelryType.requestFocus();

                Notification.showConformationeMessage("Added Successfully");
            }else {
                txtJewelryID.requestFocus();

                Notification.showFailureMessage("Adding Failed");
            }
        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void btnUpdateOnAction() {
        String jewelryType = listJewelryType.getSelectionModel().getSelectedItem();
        String jewlryTypeId = null;
        try {
            jewlryTypeId = jewelryStockBO.getJewelryTypeId(jewelryType);
        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }
        String jewelryIDText = txtJewelryID.getText();
        String metalText = txtMetal.getText();
        int caratText = Integer.parseInt(txtCarat.getText());
        double weightText = Double.parseDouble(txtWeight.getText());
        double sizeText = Double.parseDouble(txtSize.getText());
        String gemText = txtGem.getText();
        double priceText = Double.parseDouble(txtPrice.getText());
        String makerIDText = cmbMakerID.getSelectionModel().getSelectedItem();
        String makerNameText = txtMakerName.getText();
        String date = txtMakedDate.getValue().toString();
        JewelryStockDTO dto = new JewelryStockDTO(jewelryType, jewlryTypeId, jewelryIDText, metalText, caratText, weightText, sizeText, gemText, priceText, makerIDText, makerNameText, date);
        try {
            boolean isUpdated = jewelryStockBO.updateJewlryStock(dto);
            if (isUpdated) {
                loadJewelryStock();
                listJewelryType.getSelectionModel().clearSelection();
                txtMetal.setText(null);
                txtCarat.setText(null);
                txtWeight.setText(null);
                txtSize.setText(null);
                txtGem.setText(null);
                txtPrice.setText(null);
                txtMakedDate.setValue(null);
                cmbMakerID.getSelectionModel().clearSelection();
                txtMakerName.setText(null);
                btnUpdate.setDisable(true);
                btnAdd.setDisable(false);
                listJewelryType.requestFocus();

                Notification.showConformationeMessage("Updated Successfully");
            }else {
                txtJewelryID.requestFocus();

                Notification.showFailureMessage("Updating Failed");
            }
        } catch (Exception e) {
            Logger.getLogger(JewelryStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
