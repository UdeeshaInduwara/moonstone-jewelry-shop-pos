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
import lk.ijse.jewelryshop.business.custom.MetalStockBO;
import lk.ijse.jewelryshop.business.custom.MetalBusinessmanBO;
import lk.ijse.jewelryshop.controller.utils.Notification;
import lk.ijse.jewelryshop.db.DBConnection;
import lk.ijse.jewelryshop.generator.IDGenerator;
import lk.ijse.jewelryshop.model.MetalBusinessmanDTO;
import lk.ijse.jewelryshop.model.MetalStockDTO;
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

public class MetalStockController implements Initializable {
    MetalStockBO metalStockBO =BOFactory.getInstance().getBO(BOFactory.BOTypes.METALSTOCK);
    MetalBusinessmanBO metalBusinessmanBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.METALBUSINESSMAN);

    @FXML
    private TextField txtSearchMetalId;

    @FXML
    private TextField txtSearchMetal;

    @FXML
    private TextField txtSearchCarat;

    @FXML
    private TextField txtSearchWeight;

    @FXML
    private TextField txtSearchPurchaseDate;

    @FXML
    private TextField txtSearchBusinessmanId;

    @FXML
    private TextField txtSearchBusinessmanName;

    @FXML
    private TableView<MetalStockDTO> tblMetalStockDetail;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXTextField txtMetalId;

    @FXML
    private JFXTextField txtMetal;

    @FXML
    private JFXTextField txtCarat;

    @FXML
    private JFXTextField txtWeight;

    @FXML
    private JFXComboBox<String> cmbBusinessmanId;

    @FXML
    private JFXTextField txtBusinessmanName;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private DatePicker txtPurchaseDate;

    @FXML
    private JFXButton btnReport;

    @FXML
    void loadMetalStockDetailReport(ActionEvent event) {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/jewelryshop/reports/MetalStockDetail.jasper");

        HashMap map= new HashMap();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException e) {
            Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
        } catch (JRException e) {
            Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingMetalId(KeyEvent event) {
        if(event.getCode()== KeyCode.DOWN){
            txtSearchMetal.requestFocus();
        }
        if(event.getCode()== KeyCode.RIGHT){
            txtMetalId.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchBusinessmanName.requestFocus();
        }

        String metalIdText = txtSearchMetalId.getText();
        try {
            ArrayList<MetalStockDTO> dtos = metalStockBO.searchMetalStockUsingMetalId(metalIdText);
            tblMetalStockDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingMetal(KeyEvent event) {
        if(event.getCode()== KeyCode.DOWN){
            txtSearchCarat.requestFocus();
        }
        if(event.getCode()== KeyCode.RIGHT){
            txtMetalId.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchMetalId.requestFocus();
        }

        String metalText = txtSearchMetal.getText();
        try {
            ArrayList<MetalStockDTO> dtos = metalStockBO.searchMetalStockUsingMetal(metalText);
            tblMetalStockDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingCarat(KeyEvent event) {
        if(event.getCode()== KeyCode.DOWN){
            txtSearchWeight.requestFocus();
        }
        if(event.getCode()== KeyCode.RIGHT){
            txtMetalId.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchMetal.requestFocus();
        }

        if(Validator.isNotEmptyValidation(txtSearchCarat.getText())){
            int caratText = Integer.parseInt(txtSearchCarat.getText());
            try {
                ArrayList<MetalStockDTO> dtos = metalStockBO.searchMetalStockUsingCarat(caratText);
                tblMetalStockDetail.setItems(FXCollections.observableArrayList(dtos));
            } catch (Exception e) {
                Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
            }
        }else {
            loadMetalStockDetail();
        }
    }

    @FXML
    void searchUsingWeight(KeyEvent event) {
        if(event.getCode()== KeyCode.DOWN){
            txtSearchPurchaseDate.requestFocus();
        }
        if(event.getCode()== KeyCode.RIGHT){
            txtMetalId.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchCarat.requestFocus();
        }

        if(Validator.isNotEmptyValidation(txtSearchWeight.getText())){
            double weightText = Double.parseDouble(txtSearchWeight.getText());
            try {
                ArrayList<MetalStockDTO> dtos = metalStockBO.searchMetalStockUsingWeight(weightText);
                tblMetalStockDetail.setItems(FXCollections.observableArrayList(dtos));
            } catch (Exception e) {
                Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
            }
        }else {
            loadMetalStockDetail();
        }
    }

    @FXML
    void searchUsingPurchaseDate(KeyEvent event) {
        if(event.getCode()== KeyCode.DOWN){
            txtSearchBusinessmanId.requestFocus();
        }
        if(event.getCode()== KeyCode.RIGHT){
            txtMetalId.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchWeight.requestFocus();
        }

        String purchaseDateText = txtSearchPurchaseDate.getText();
        try {
            ArrayList<MetalStockDTO> dtos = metalStockBO.searchMetalStockUsingPurchaseDate(purchaseDateText);
            tblMetalStockDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingBusinessmanId(KeyEvent event) {
        if(event.getCode()== KeyCode.DOWN){
            txtSearchBusinessmanName.requestFocus();
        }
        if(event.getCode()== KeyCode.RIGHT){
            txtMetalId.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchPurchaseDate.requestFocus();
        }

        String businessmanIdText = txtSearchBusinessmanId.getText();
        try {
            ArrayList<MetalStockDTO> dtos = metalStockBO.searchMetalStockUsingBusinessmanId(businessmanIdText);
            tblMetalStockDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingBusinessmanName(KeyEvent event) {
        if(event.getCode()== KeyCode.DOWN){
            txtSearchMetalId.requestFocus();
        }
        if(event.getCode()== KeyCode.RIGHT){
            txtMetalId.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchBusinessmanId.requestFocus();
        }

        String businessmanNameText = txtSearchBusinessmanName.getText();
        try {
            ArrayList<MetalStockDTO> dtos = metalStockBO.searchMetalStockUsingBusinessmanName(businessmanNameText);
            tblMetalStockDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void txtMetalIdOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            txtMetal.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchMetalId.requestFocus();
        }
    }

    @FXML
    void txtMetalOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if(!Validator.nameValidation(txtMetal.getText())){
                    txtMetal.selectAll();

                    Notification.showAttrntionMessage("Fill Metal Correctly");
                }else {
                    txtCarat.requestFocus();
                }
            }catch (NullPointerException e){
                txtMetal.selectAll();

                Notification.showAttrntionMessage("Fill Metal Correctly");
            }
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchMetalId.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtMetalId.requestFocus();
        }
    }

    @FXML
    void txtCaratOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if(!Validator.intValueValidation(txtCarat.getText())){
                    txtCarat.selectAll();

                    Notification.showAttrntionMessage("Fill the Metal Carat Value Correctly");
                }else {
                    txtWeight.requestFocus();
                }
            }catch (NullPointerException e){
                txtCarat.selectAll();

                Notification.showAttrntionMessage("Fill the Metal Carat Value Correctly");
            }
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchMetalId.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtMetal.requestFocus();
        }
    }

    @FXML
    void txtWeightOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if(!Validator.doubleValueValidation(txtWeight.getText())){
                    txtWeight.selectAll();

                    Notification.showAttrntionMessage("Fill the Weight Correctly");
                }else {
                    txtPurchaseDate.requestFocus();
                }
            }catch (NullPointerException e){
                txtWeight.selectAll();

                Notification.showAttrntionMessage("Fill the Weight Correctly");
            }
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchMetalId.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtCarat.requestFocus();
        }
    }

    @FXML
    void txtPurchaseDateOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.SHIFT){
            txtPurchaseDate.show();
            if(txtPurchaseDate.isShowing()){
                cmbBusinessmanId.requestFocus();
            }
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchMetalId.requestFocus();
        }
        if(event.getCode()== KeyCode.CONTROL){
            txtWeight.requestFocus();
        }
    }

    @FXML
    void cmbMetalBusinessmanIdOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            cmbBusinessmanId.show();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchMetalId.requestFocus();
        }
        if(event.getCode()== KeyCode.CONTROL){
            txtPurchaseDate.requestFocus();
        }
    }

    @FXML
    void txtBusinessmanNameOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if(Validator.nameValidation(txtMetal.getText())){
                    try {
                        if (Validator.intValueValidation(txtCarat.getText())){
                            try {
                                if(Validator.doubleValueValidation(txtWeight.getText())){
                                    try {
                                        txtPurchaseDate.getValue().toString();
                                        try {
                                            if(Validator.metalBusinessmenIdValidation(cmbBusinessmanId.getSelectionModel().getSelectedItem())){
                                                if(Validator.isNotEmptyValidation(txtBusinessmanName.getText())){
                                                    if(btnUpdate.isDisabled()){
                                                        btnAddOnAction();
                                                    }else {
                                                        btnUpdateOnAction();
                                                    }
                                                }else {
                                                    txtBusinessmanName.requestFocus();

                                                    Notification.showAttrntionMessage("Fill Metal Businessman Name Correctly");
                                                }
                                            }else {
                                                cmbBusinessmanId.requestFocus();

                                                Notification.showAttrntionMessage("Select Metal Businessman ID Correctly");
                                            }
                                        }catch (NullPointerException e){
                                            cmbBusinessmanId.requestFocus();

                                            Notification.showAttrntionMessage("Select Metal Businessman ID Correctly");
                                        }
                                    }catch (NullPointerException e){
                                        txtPurchaseDate.requestFocus();

                                        Notification.showAttrntionMessage("Select Purchase Date Correctly");
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

                            Notification.showAttrntionMessage("Fill Metal Carat Value Correctly");
                        }
                    }catch (NullPointerException e){
                        txtCarat.requestFocus();

                        Notification.showAttrntionMessage("Fill Metal Carat Value Correctly");
                    }
                }else {
                    txtMetal.requestFocus();

                    Notification.showAttrntionMessage("Fill the Metal Correctly");
                }
            }catch (NullPointerException e){
                txtMetal.requestFocus();

                Notification.showAttrntionMessage("Fill the Metal Correctly");
            }
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchMetalId.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            cmbBusinessmanId.requestFocus();
        }
    }

    @FXML
    void addMetalStock(ActionEvent event) {
        try {
            if(Validator.nameValidation(txtMetal.getText())){
                try {
                    if (Validator.intValueValidation(txtCarat.getText())){
                        try {
                            if(Validator.doubleValueValidation(txtWeight.getText())){
                                try {
                                    txtPurchaseDate.getValue().toString();
                                    try {
                                        if(Validator.metalBusinessmenIdValidation(cmbBusinessmanId.getSelectionModel().getSelectedItem())){
                                            if(Validator.isNotEmptyValidation(txtBusinessmanName.getText())){
                                                btnAddOnAction();
                                            }else {
                                                txtBusinessmanName.requestFocus();

                                                Notification.showAttrntionMessage("Fill Metal Businessman Name Correctly");
                                            }
                                        }else {
                                            cmbBusinessmanId.requestFocus();

                                            Notification.showAttrntionMessage("Select Metal Businessman ID Correctly");
                                        }
                                    }catch (NullPointerException e){
                                        cmbBusinessmanId.requestFocus();

                                        Notification.showAttrntionMessage("Select Metal Businessman ID Correctly");
                                    }
                                }catch (NullPointerException e){
                                    txtPurchaseDate.requestFocus();

                                    Notification.showAttrntionMessage("Select Purchase Date Correctly");
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

                        Notification.showAttrntionMessage("Fill Metal Carat Value Correctly");
                    }
                }catch (NullPointerException e){
                    txtCarat.requestFocus();

                    Notification.showAttrntionMessage("Fill Metal Carat Value Correctly");
                }
            }else {
                txtMetal.requestFocus();

                Notification.showAttrntionMessage("Fill the Metal Correctly");
            }
        }catch (NullPointerException e){
            txtMetal.requestFocus();

            Notification.showAttrntionMessage("Fill the Metal Correctly");
        }
    }

    @FXML
    void updateMetalStock(ActionEvent event) {
        try {
            if(Validator.nameValidation(txtMetal.getText())){
                try {
                    if (Validator.intValueValidation(txtCarat.getText())){
                        try {
                            if(Validator.doubleValueValidation(txtWeight.getText())){
                                try {
                                    txtPurchaseDate.getValue().toString();
                                    try {
                                        if(Validator.metalBusinessmenIdValidation(cmbBusinessmanId.getSelectionModel().getSelectedItem())){
                                            if(Validator.isNotEmptyValidation(txtBusinessmanName.getText())){
                                                btnUpdateOnAction();
                                            }else {
                                                txtBusinessmanName.requestFocus();

                                                Notification.showAttrntionMessage("Fill Metal Businessman Name Correctly");
                                            }
                                        }else {
                                            cmbBusinessmanId.requestFocus();

                                            Notification.showAttrntionMessage("Select Metal Businessman ID Correctly");
                                        }
                                    }catch (NullPointerException e){
                                        cmbBusinessmanId.requestFocus();

                                        Notification.showAttrntionMessage("Select Metal Businessman ID Correctly");
                                    }
                                }catch (NullPointerException e){
                                    txtPurchaseDate.requestFocus();

                                    Notification.showAttrntionMessage("Select Purchase Date Correctly");
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

                        Notification.showAttrntionMessage("Fill Metal Carat Value Correctly");
                    }
                }catch (NullPointerException e){
                    txtCarat.requestFocus();

                    Notification.showAttrntionMessage("Fill Metal Carat Value Correctly");
                }
            }else {
                txtMetal.requestFocus();

                Notification.showAttrntionMessage("Fill the Metal Correctly");
            }
        }catch (NullPointerException e){
            txtMetal.requestFocus();

            Notification.showAttrntionMessage("Fill the Metal Correctly");
        }
    }

    @FXML
    void cancelAdding(ActionEvent event) {
        try {
            String newID = IDGenerator.getNewID("metal", "metid", "MET");
            txtMetalId.setText(newID);
        } catch (Exception e) {
            Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
        }
        txtMetal.setText(null);
        txtCarat.setText(null);
        txtWeight.setText(null);
        txtPurchaseDate.setValue(null);
        cmbBusinessmanId.getSelectionModel().clearSelection();
        txtBusinessmanName.setText(null);
    }

    @FXML
    void removeMetalStock(ActionEvent event) {
        try{
            String id = tblMetalStockDetail.getSelectionModel().getSelectedItem().getMetalId();
            try {
                boolean isDeleted = metalStockBO.removeMetalStock(id);
                if(isDeleted){
                    loadMetalStockDetail();
                    txtMetal.setText(null);
                    txtCarat.setText(null);
                    txtWeight.setText(null);
                    txtPurchaseDate.setValue(null);
                    cmbBusinessmanId.getSelectionModel().clearSelection();
                    txtBusinessmanName.setText(null);
                    btnUpdate.setDisable(true);
                    btnAdd.setDisable(false);

                    Notification.showConformationeMessage("Removed Successfully");
                }else {
                    Notification.showFailureMessage("Removing Failed");
                }
            } catch (Exception e) {
                Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
            }
        }catch (Exception e){
            Notification.showWarningMessage("Select Item First to Remove");
        }
    }

    @FXML
    void selectMetalStock(MouseEvent event) {
        try {
            MetalStockDTO dto = tblMetalStockDetail.getSelectionModel().getSelectedItem();
            cmbBusinessmanId.getSelectionModel().select(dto.getBusinessmanId());
            txtCarat.setText(Integer.toString(dto.getCarat()));
            txtMetalId.setText(dto.getMetalId());
            txtMetal.setText(dto.getMetal());
            txtWeight.setText(Double.toString(dto.getWeight()));
            txtBusinessmanName.setText(dto.getBusinessmanName());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(dto.getPurchaseDate(), formatter);
            txtPurchaseDate.setValue(localDate);
        }catch (NullPointerException e){}

        btnUpdate.setDisable(false);
        btnAdd.setDisable(true);
        txtMetalId.requestFocus();
    }

    @FXML
    void selectMetalBusinessman(ActionEvent event) {
        String businessmanIdText = cmbBusinessmanId.getSelectionModel().getSelectedItem();
        try {

            try {
                MetalBusinessmanDTO dto = metalBusinessmanBO.searchMetalBusinessmanUseId(businessmanIdText);
                txtBusinessmanName.setText(dto.getName());
            }catch (NullPointerException e){}

        } catch (Exception e) {
            Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void selectMetalBusinessmanId(ActionEvent event) {
        String businessmanNameText = txtBusinessmanName.getText();
        try {

            try {
                MetalBusinessmanDTO dto = metalBusinessmanBO.searchMetalBusinessmanUseName(businessmanNameText);
                cmbBusinessmanId.getSelectionModel().select(dto.getMetbid());
            }catch (NullPointerException e){}

        } catch (Exception e) {
            Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> metalBusinessmenIds = null;
        try {
            metalBusinessmenIds = metalBusinessmanBO.getMetalBusinessmenIds();
            cmbBusinessmanId.setItems(FXCollections.observableArrayList(metalBusinessmenIds));
        } catch (Exception e) {
            Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
        }

        tblMetalStockDetail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("metalId"));
        tblMetalStockDetail.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("metal"));
        tblMetalStockDetail.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("carat"));
        tblMetalStockDetail.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("weight"));
        tblMetalStockDetail.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));
        tblMetalStockDetail.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("businessmanId"));
        tblMetalStockDetail.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("businessmanName"));

        loadMetalStockDetail();
        loadMetalBusinessmenNames();
    }

    private void loadMetalStockDetail(){
        try {
            String newID = IDGenerator.getNewID("metal", "metid", "MET");
            txtMetalId.setText(newID);
        } catch (Exception e) {
            Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            ArrayList<MetalStockDTO> metalStockDetails = metalStockBO.getMetalStockDetails();
            tblMetalStockDetail.setItems(FXCollections.observableArrayList(metalStockDetails));
        } catch (Exception e) {
            Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void btnAddOnAction() {
        String metalIdText = txtMetalId.getText();
        String metalText = txtMetal.getText();
        int caratText = Integer.parseInt(txtCarat.getText());
        double weightText = Double.parseDouble(txtWeight.getText());
        String dateText = txtPurchaseDate.getValue().toString();
        String businessmanIdText = cmbBusinessmanId.getSelectionModel().getSelectedItem();
        String businessmanNameText = txtBusinessmanName.getText();
        MetalStockDTO dto=new MetalStockDTO(metalIdText,metalText,caratText,weightText,dateText,businessmanIdText,businessmanNameText);

        try {
            boolean isAdded = metalStockBO.addMetalStock(dto);
            if(isAdded){
                loadMetalStockDetail();
                txtMetal.setText(null);
                txtCarat.setText(null);
                txtWeight.setText(null);
                txtPurchaseDate.setValue(null);
                cmbBusinessmanId.getSelectionModel().clearSelection();
                txtBusinessmanName.setText(null);
                txtMetalId.requestFocus();

                Notification.showConformationeMessage("Added Successfully");
            }else {
                txtMetalId.requestFocus();

                Notification.showFailureMessage("Adding Failed");
            }
        } catch (Exception e) {
            Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void btnUpdateOnAction() {
        String metalIdText = txtMetalId.getText();
        String metalText = txtMetal.getText();
        int caratText = Integer.parseInt(txtCarat.getText());
        double weightText = Double.parseDouble(txtWeight.getText());
        String dateText = txtPurchaseDate.getValue().toString();
        String businessmanIdText = cmbBusinessmanId.getSelectionModel().getSelectedItem();
        String businessmanNameText = txtBusinessmanName.getText();
        MetalStockDTO dto=new MetalStockDTO(metalIdText,metalText,caratText,weightText,dateText,businessmanIdText,businessmanNameText);

        try {
            boolean isUpdated = metalStockBO.updateMetalStock(dto);

            if(isUpdated){
                loadMetalStockDetail();
                txtMetal.setText(null);
                txtCarat.setText(null);
                txtWeight.setText(null);
                txtPurchaseDate.setValue(null);
                cmbBusinessmanId.getSelectionModel().clearSelection();
                txtBusinessmanName.setText(null);
                btnUpdate.setDisable(true);
                btnAdd.setDisable(false);
                txtMetalId.requestFocus();

                Notification.showConformationeMessage("Updated Successfully");
            }else {
                txtMetalId.requestFocus();

                Notification.showFailureMessage("Updating Failed");
            }
        } catch (Exception e) {
            Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadMetalBusinessmenNames() {
        try {
            TextFields.bindAutoCompletion(txtBusinessmanName,metalBusinessmanBO.getMetalBusinessmenNames());
        } catch (Exception e) {
            Logger.getLogger(MetalStockController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
