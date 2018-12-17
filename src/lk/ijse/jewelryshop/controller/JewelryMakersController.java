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
import lk.ijse.jewelryshop.business.custom.JewelryMakerBO;
import lk.ijse.jewelryshop.controller.utils.Notification;
import lk.ijse.jewelryshop.db.DBConnection;
import lk.ijse.jewelryshop.generator.IDGenerator;
import lk.ijse.jewelryshop.model.JewelryMakerDTO;
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

public class JewelryMakersController implements Initializable {
    JewelryMakerBO jewelryMakerBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.JEWELRYMAKER);

    @FXML
    private TextField txtSearchMakerID;

    @FXML
    private TextField txtSearchMakerName;

    @FXML
    private TableView<JewelryMakerDTO> tblMakersDetail;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXTextField txtMakerID;

    @FXML
    private JFXTextField txtMakerName;

    @FXML
    private JFXTextField txtContactNo;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnReport;

    @FXML
    void loadJewelryMakersDetailReport(ActionEvent event) {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/jewelryshop/reports/JewelryMakersDetail.jasper");

        HashMap map= new HashMap();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException e) {
            Logger.getLogger(JewelryMakersController.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(JewelryMakersController.class.getName()).log(Level.SEVERE, null, e);
        } catch (JRException e) {
            Logger.getLogger(JewelryMakersController.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(JewelryMakersController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchMakerUsingID(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchMakerName.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchMakerName.requestFocus();
        }
        if(event.getCode()== KeyCode.DOWN){
            txtMakerID.requestFocus();
        }

        String makerIDText = txtSearchMakerID.getText();
        try {
            ArrayList<JewelryMakerDTO> dtos = jewelryMakerBO.searchUsingId(makerIDText);
            tblMakersDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(JewelryMakersController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchMakerUsingName(KeyEvent event) {
        if(event.getCode()== KeyCode.RIGHT){
            txtSearchMakerID.requestFocus();
        }
        if(event.getCode()== KeyCode.LEFT){
            txtSearchMakerID.requestFocus();
        }
        if(event.getCode()== KeyCode.DOWN){
            txtMakerID.requestFocus();
        }

        String makerNameText = txtSearchMakerName.getText();
        try {
            ArrayList<JewelryMakerDTO> dtos = jewelryMakerBO.searchUsingName(makerNameText);
            tblMakersDetail.setItems(FXCollections.observableArrayList(dtos));
        } catch (Exception e) {
            Logger.getLogger(JewelryMakersController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void txtMakerIdOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            txtMakerName.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchMakerID.requestFocus();
        }
    }

    @FXML
    void txtMakerNameOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try{
                if(!Validator.nameValidation(txtMakerName.getText())){
                    txtMakerName.selectAll();

                    Notification.showAttrntionMessage("Fill the Jewelry Maker Name Correctly");
                }else {
                    txtContactNo.requestFocus();
                }
            }catch (NullPointerException e){
                txtMakerName.selectAll();

                Notification.showAttrntionMessage("Fill the Jewelry Maker Name Correctly");
            }
        }
        if(event.getCode()== KeyCode.LEFT){
            txtMakerID.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchMakerID.requestFocus();
        }
    }

    @FXML
    void txtContactNoOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try{
                if(Validator.nameValidation(txtMakerName.getText())){
                    try{
                        if(Validator.contactNoValidation(txtContactNo.getText())){
                            if(btnUpdate.isDisabled()){
                                btnAddOnAction();
                            }else {
                                btnUpdateOnAction();
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
                    txtMakerName.requestFocus();

                    Notification.showAttrntionMessage("Fill the Jewelry Maker Name Correctly");
                }
            }catch (NullPointerException e){
                txtMakerName.requestFocus();

                Notification.showAttrntionMessage("Fill the Jewelry Maker Name Correctly");
            }
        }
        if(event.getCode()== KeyCode.LEFT){
            txtMakerName.requestFocus();
        }
        if(event.getCode()== KeyCode.UP){
            txtSearchMakerID.requestFocus();
        }
    }

    @FXML
    void addJewelryMaker(ActionEvent event) {
        try{
            if(Validator.nameValidation(txtMakerName.getText())){
                try{
                    if(Validator.contactNoValidation(txtContactNo.getText())){
                        btnAddOnAction();
                    }else {
                        txtContactNo.requestFocus();

                        Notification.showAttrntionMessage("Fill the Contact Number Correctly");
                    }
                }catch (NullPointerException e){
                    txtContactNo.requestFocus();

                    Notification.showAttrntionMessage("Fill the Contact Number Correctly");
                }
            }else {
                txtMakerName.requestFocus();

                Notification.showAttrntionMessage("Fill the Jewelry Maker Name Correctly");
            }
        }catch (NullPointerException e){
            txtMakerName.requestFocus();

            Notification.showAttrntionMessage("Fill the Jewelry Maker Name Correctly");
        }
    }

    @FXML
    void updateJewelryMaker(ActionEvent event) {
        try{
            if(Validator.nameValidation(txtMakerName.getText())){
                try{
                    if(Validator.contactNoValidation(txtContactNo.getText())){
                        btnUpdateOnAction();
                    }else {
                        txtContactNo.requestFocus();

                        Notification.showAttrntionMessage("Fill the Contact Number Correctly");
                    }
                }catch (NullPointerException e){
                    txtContactNo.requestFocus();

                    Notification.showAttrntionMessage("Fill the Contact Number Correctly");
                }
            }else {
                txtMakerName.requestFocus();

                Notification.showAttrntionMessage("Fill the Jewelry Maker Name Correctly");
            }
        }catch (NullPointerException e){
            txtMakerName.requestFocus();

            Notification.showAttrntionMessage("Fill the Jewelry Maker Name Correctly");
        }
    }

    @FXML
    void cancelAdding(ActionEvent event) {
        try {
            String newID = IDGenerator.getNewID("jewelryMaker", "jmid", "JMAK");
            txtMakerID.setText(newID);
        } catch (Exception e) {
            Logger.getLogger(JewelryMakersController.class.getName()).log(Level.SEVERE, null, e);
        }

        txtMakerName.setText(null);
        txtContactNo.setText(null);
    }

    @FXML
    void removeMakers(ActionEvent event) {
        try{
            String jmid = tblMakersDetail.getSelectionModel().getSelectedItem().getJmid();
            try {
                boolean isRemoved = jewelryMakerBO.removeJewelryMaker(jmid);
                if(isRemoved){
                    loadJewelryMakers();
                    txtMakerName.setText(null);
                    txtContactNo.setText(null);
                    btnUpdate.setDisable(true);
                    btnAdd.setDisable(false);

                    Notification.showConformationeMessage("Removed Successfully");
                }else {
                    Notification.showFailureMessage("Removing Failed");
                }
            } catch (Exception e) {
                Logger.getLogger(JewelryMakersController.class.getName()).log(Level.SEVERE, null, e);
            }
        }catch (Exception e){
            Notification.showWarningMessage("Select Item First to Remove");
        }
    }

    @FXML
    void selectMaker(MouseEvent event) {
        try {
            JewelryMakerDTO dto = tblMakersDetail.getSelectionModel().getSelectedItem();

            txtMakerID.setText(dto.getJmid());
            txtMakerName.setText(dto.getName());
            txtContactNo.setText(dto.getContactNo());
        }catch (NullPointerException e){}

        txtMakerID.requestFocus();
        btnUpdate.setDisable(false);
        btnAdd.setDisable(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblMakersDetail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("jmid"));
        tblMakersDetail.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblMakersDetail.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contactNo"));

        loadJewelryMakers();
    }

    private void loadJewelryMakers(){
        try {
            String newID = IDGenerator.getNewID("jewelryMaker", "jmid", "JMAK");
            txtMakerID.setText(newID);
        } catch (Exception e) {
            Logger.getLogger(JewelryMakersController.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            tblMakersDetail.setItems(FXCollections.observableArrayList(jewelryMakerBO.getAllJewelryMakers()));
        } catch (Exception e) {
            Logger.getLogger(JewelryMakersController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void btnAddOnAction() {
        String id = txtMakerID.getText();
        String name = txtMakerName.getText();
        String contactNo = txtContactNo.getText();
        JewelryMakerDTO jewelryMakerDTO=new JewelryMakerDTO(id,name,contactNo);

        try {
            boolean isAdded = jewelryMakerBO.addJewelryMaker(jewelryMakerDTO);
            if(isAdded){
                loadJewelryMakers();
                txtMakerID.requestFocus();
                txtMakerName.setText(null);
                txtContactNo.setText(null);

                Notification.showConformationeMessage("Added Successfully");
            }else {
                txtMakerID.requestFocus();

                Notification.showFailureMessage("Adding Failed");
            }
        } catch (Exception e) {
            Logger.getLogger(JewelryMakersController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void btnUpdateOnAction() {
        String id = txtMakerID.getText();
        String name = txtMakerName.getText();
        String contactNo = txtContactNo.getText();
        JewelryMakerDTO jewelryMakerDTO=new JewelryMakerDTO(id,name,contactNo);
        try {
            boolean isUpdated = jewelryMakerBO.updateJewelryMaker(jewelryMakerDTO);
            if(isUpdated){
                loadJewelryMakers();
                txtMakerID.requestFocus();
                txtMakerName.setText(null);
                txtContactNo.setText(null);
                btnUpdate.setDisable(true);
                btnAdd.setDisable(false);

                Notification.showConformationeMessage("Updated Successfully");
            }else {
                txtMakerID.requestFocus();

                Notification.showFailureMessage("Updating Failed");
            }
        } catch (Exception e) {
            Logger.getLogger(JewelryMakersController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
