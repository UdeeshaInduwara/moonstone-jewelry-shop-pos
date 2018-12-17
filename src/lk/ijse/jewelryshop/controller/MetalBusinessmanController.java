package lk.ijse.jewelryshop.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lk.ijse.jewelryshop.business.BOFactory;
import lk.ijse.jewelryshop.business.custom.MetalBusinessmanBO;
import lk.ijse.jewelryshop.controller.utils.Notification;
import lk.ijse.jewelryshop.db.DBConnection;
import lk.ijse.jewelryshop.generator.IDGenerator;
import lk.ijse.jewelryshop.model.MetalBusinessmanDTO;
import lk.ijse.jewelryshop.validation.Validator;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MetalBusinessmanController implements Initializable {
    MetalBusinessmanBO metalBusinessmanBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.METALBUSINESSMAN);
    @FXML
    private TextField txtSearchBusinessmanID;

    @FXML
    private TextField txtSearchName;

    @FXML
    private TableView<MetalBusinessmanDTO> tblBusinessmanDetail;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXTextField txtBusinessmanID;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtContactNo;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXTextField txtViewContactNo;

    @FXML
    private JFXTextField txtViewAddress;

    @FXML
    private JFXButton btnReport;

    @FXML
    void loadMetalBusinessmanDetailReport(ActionEvent event) {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/jewelryshop/reports/MetalBusinessmenDetail.jasper");

        HashMap map= new HashMap();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException e) {
            Logger.getLogger(MetalBusinessmanController.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(MetalBusinessmanController.class.getName()).log(Level.SEVERE, null, e);
        } catch (JRException e) {
            Logger.getLogger(MetalBusinessmanController.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(MetalBusinessmanController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingID(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchName.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchName.requestFocus();
        }
        if(event.getCode()== KeyCode.DOWN){
            txtBusinessmanID.requestFocus();
        }

        String idText = txtSearchBusinessmanID.getText();
        try {
            ArrayList<MetalBusinessmanDTO> dtos = metalBusinessmanBO.searchUsingId(idText);
            tblBusinessmanDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(MetalBusinessmanController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchUsingName(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchBusinessmanID.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchBusinessmanID.requestFocus();
        }
        if(event.getCode()== KeyCode.DOWN){
            txtBusinessmanID.requestFocus();
        }

        String nameText = txtSearchName.getText();
        try {
            ArrayList<MetalBusinessmanDTO> dtos = metalBusinessmanBO.searchUsingName(nameText);
            tblBusinessmanDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(MetalBusinessmanController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void txtBusinessmanIdOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            txtName.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchBusinessmanID.requestFocus();
        }
    }

    @FXML
    void txtNameOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if(!Validator.nameValidation(txtName.getText())){
                    txtName.selectAll();

                    Notification.showAttrntionMessage("Fill the Metal Businessman Name Correctly");
                }else {
                    txtContactNo.requestFocus();
                }
            }catch (NullPointerException e){
                txtName.selectAll();

                Notification.showAttrntionMessage("Fill the Metal Businessman Name Correctly");
            }
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchBusinessmanID.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtBusinessmanID.requestFocus();
        }
    }

    @FXML
    void txtContactNoOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if(!Validator.contactNoValidation(txtContactNo.getText())){
                    txtContactNo.selectAll();

                    Notification.showAttrntionMessage("Fill the Contact Number Correctly");
                }else {
                    txtAddress.requestFocus();
                }
            }catch (NullPointerException e){
                txtContactNo.selectAll();

                Notification.showAttrntionMessage("Fill the Contact Number Correctly");
            }
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchBusinessmanID.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtName.requestFocus();
        }
    }

    @FXML
    void txtAddressOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try{
                if(Validator.nameValidation(txtName.getText())){
                    try{
                        if(Validator.contactNoValidation(txtContactNo.getText())){
                            try{
                                if(Validator.addressValidation(txtAddress.getText())){
                                    if(btnUpdate.isDisabled()){
                                        btnAddOnAction();
                                    }else {
                                        btnUpdateOnAction();
                                    }
                                }else {
                                    txtAddress.requestFocus();

                                    Notification.showAttrntionMessage("Fill the Address Correctly");
                                }
                            }catch (NullPointerException e){
                                txtAddress.requestFocus();

                                Notification.showAttrntionMessage("Fill the Address Correctly");
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

                    Notification.showAttrntionMessage("Fill the Metal Businessman Name Correctly");
                }
            }catch (NullPointerException e){
                txtName.requestFocus();

                Notification.showAttrntionMessage("Fill the Metal Businessman Name Correctly");
            }
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchBusinessmanID.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtContactNo.requestFocus();
        }
    }

    @FXML
    void addMetalBusinessman(ActionEvent event) {
        try{
            if(Validator.nameValidation(txtName.getText())){
                try{
                    if(Validator.contactNoValidation(txtContactNo.getText())){
                        try{
                            if(Validator.addressValidation(txtAddress.getText())){
                                btnAddOnAction();
                            }else {
                                txtAddress.requestFocus();

                                Notification.showAttrntionMessage("Fill the Address Correctly");
                            }
                        }catch (NullPointerException e){
                            txtAddress.requestFocus();

                            Notification.showAttrntionMessage("Fill the Address Correctly");
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

                Notification.showAttrntionMessage("Fill the Metal Businessman Name Correctly");
            }
        }catch (NullPointerException e){
            txtName.requestFocus();

            Notification.showAttrntionMessage("Fill the Metal Businessman Name Correctly");
        }
    }

    @FXML
    void updateMetalBusinessman(ActionEvent event) {
        try{
            if(Validator.nameValidation(txtName.getText())){
                try{
                    if(Validator.contactNoValidation(txtContactNo.getText())){
                        try{
                            if(Validator.addressValidation(txtAddress.getText())){
                                btnUpdateOnAction();
                            }else {
                                txtAddress.requestFocus();

                                Notification.showAttrntionMessage("Fill the Address Correctly");
                            }
                        }catch (NullPointerException e){
                            txtAddress.requestFocus();

                            Notification.showAttrntionMessage("Fill the Address Correctly");
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

                Notification.showAttrntionMessage("Fill the Metal Businessman Name Correctly");
            }
        }catch (NullPointerException e){
            txtName.requestFocus();

            Notification.showAttrntionMessage("Fill the Metal Businessman Name Correctly");
        }
    }

    @FXML
    void cancelAdding(ActionEvent event) {
        try {
            String newID = IDGenerator.getNewID("metalBusinessman", "metbid", "METB");
            txtBusinessmanID.setText(newID);
        } catch (Exception e) {
            Logger.getLogger(MetalBusinessmanController.class.getName()).log(Level.SEVERE, null, e);
        }
        txtName.setText(null);
        txtContactNo.setText(null);
        txtAddress.setText(null);
    }

    @FXML
    void removeBusinessman(ActionEvent event) {
        try{
            String metbid = tblBusinessmanDetail.getSelectionModel().getSelectedItem().getMetbid();
            try {
                boolean isDeleted = metalBusinessmanBO.removeMetalBusinessman(metbid);
                if(isDeleted){
                    loadMetalBusinessmen();
                    txtName.setText(null);
                    txtContactNo.setText(null);
                    txtAddress.setText(null);
                    btnUpdate.setDisable(true);
                    btnAdd.setDisable(false);

                    Notification.showConformationeMessage("Removed Successfully");
                }else {
                    Notification.showFailureMessage("Removing Failed");
                }
            } catch (Exception e) {
                Logger.getLogger(MetalBusinessmanController.class.getName()).log(Level.SEVERE, null, e);
            }
        }catch (Exception e){
            Notification.showWarningMessage("Select Item First to Remove");
        }
    }

    @FXML
    void selectBusinessman(MouseEvent event) {
        try {
            MetalBusinessmanDTO dto = tblBusinessmanDetail.getSelectionModel().getSelectedItem();
            txtBusinessmanID.setText(dto.getMetbid());
            txtName.setText(dto.getName());
            txtContactNo.setText(dto.getContactNo());
            txtAddress.setText(dto.getAddress());
        }catch (NullPointerException e){}

        btnUpdate.setDisable(false);
        btnAdd.setDisable(true);
        txtBusinessmanID.requestFocus();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblBusinessmanDetail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("metbid"));
        tblBusinessmanDetail.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblBusinessmanDetail.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        tblBusinessmanDetail.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));

        loadMetalBusinessmen();
    }

    private void loadMetalBusinessmen(){
        try {
            String newID = IDGenerator.getNewID("metalBusinessman", "metbid", "METB");
            txtBusinessmanID.setText(newID);
        } catch (Exception e) {
            Logger.getLogger(MetalBusinessmanController.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            tblBusinessmanDetail.setItems(FXCollections.observableArrayList(metalBusinessmanBO.getAllMetalBusinessmen()));
        } catch (Exception e) {
            Logger.getLogger(MetalBusinessmanController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void btnAddOnAction() {
        String businessmanIDText = txtBusinessmanID.getText();
        String nameText = txtName.getText();
        String contactNoText = txtContactNo.getText();
        String addressText = txtAddress.getText();
        MetalBusinessmanDTO dto=new MetalBusinessmanDTO(businessmanIDText,nameText,contactNoText,addressText);
        try {
            boolean isAdded = metalBusinessmanBO.addMetalBusinessman(dto);
            if(isAdded){
                loadMetalBusinessmen();
                txtName.setText(null);
                txtContactNo.setText(null);
                txtAddress.setText(null);
                txtBusinessmanID.requestFocus();

                Notification.showConformationeMessage("Added Successfully");
            }else {
                txtBusinessmanID.requestFocus();

                Notification.showFailureMessage("Adding Failed");
            }
        } catch (Exception e) {
            Logger.getLogger(MetalBusinessmanController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void btnUpdateOnAction() {
        String id = txtBusinessmanID.getText();
        String name = txtName.getText();
        String contactNo = txtContactNo.getText();
        String address = txtAddress.getText();
        MetalBusinessmanDTO metalBusinessmanDTO=new MetalBusinessmanDTO(id,name,contactNo,address);
        try {
            boolean isUpdated = metalBusinessmanBO.updateMetalBusinessman(metalBusinessmanDTO);
            if(isUpdated){
                loadMetalBusinessmen();
                txtName.setText(null);
                txtContactNo.setText(null);
                txtAddress.setText(null);
                txtBusinessmanID.requestFocus();
                btnUpdate.setDisable(true);
                btnAdd.setDisable(false);

                Notification.showConformationeMessage("Updated Successfully");
            }else {
                txtBusinessmanID.requestFocus();

                Notification.showFailureMessage("Updating Failed");
            }
        } catch (Exception e) {
            Logger.getLogger(MetalBusinessmanController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
