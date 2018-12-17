package lk.ijse.jewelryshop.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lk.ijse.jewelryshop.business.BOFactory;
import lk.ijse.jewelryshop.business.custom.JewelryTypeBO;
import lk.ijse.jewelryshop.controller.utils.Notification;
import lk.ijse.jewelryshop.dao.CrudUtil;
import lk.ijse.jewelryshop.db.DBConnection;
import lk.ijse.jewelryshop.generator.IDGenerator;
import lk.ijse.jewelryshop.model.JewelryTypeDTO;
import lk.ijse.jewelryshop.validation.PasswordUtils;
import lk.ijse.jewelryshop.validation.Validator;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SettingController implements Initializable {
    JewelryTypeBO jewelryTypeBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.JEWELRYTYPE);

    @FXML
    private TableView<JewelryTypeDTO> tblJewelryType;

    @FXML
    private JFXTextField txtJewelryTypeID;

    @FXML
    private JFXTextField txtJewelryType;

    @FXML
    private JFXTextField txtJewelryQty;

    @FXML
    private JFXButton btnAddJewelryType;

    @FXML
    private JFXButton btnUpdateJewelryType;

    @FXML
    private JFXButton btnRemoveJewelryType;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXTextField txtNewUserName;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXPasswordField txtNewPassword;

    @FXML
    private JFXButton btnLogIn;

    @FXML
    private JFXButton btnSignIn;

    @FXML
    void txtJewelryTypeOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if (Validator.nameValidation(txtJewelryType.getText())){
                    if (btnUpdateJewelryType.isDisabled()){
                        btnAddJewelryTypeOnAction();
                    }else {
                        btnUpdateJewelryTypeOnAction();
                    }
                }else {
                    txtJewelryType.selectAll();

                    Notification.showAttrntionMessage("Fill Jewelry Type Correctly");
                }
            }catch (NullPointerException e){
                txtJewelryType.selectAll();

                Notification.showAttrntionMessage("Fill Jewelry Type Correctly");
            }
        }
    }

    @FXML
    void addJewelryType(ActionEvent event) {
        try {
            if (Validator.nameValidation(txtJewelryType.getText())){
                btnAddJewelryTypeOnAction();
            }else {
                txtJewelryType.requestFocus();

                Notification.showAttrntionMessage("Fill Jewelry Type Correctly");
            }
        }catch (NullPointerException e){
            txtJewelryType.requestFocus();

            Notification.showAttrntionMessage("Fill Jewelry Type Correctly");
        }
    }

    private void btnAddJewelryTypeOnAction() {
        String jewelryTypeIDText = txtJewelryTypeID.getText();
        String jewelryTypeText = txtJewelryType.getText();
        JewelryTypeDTO dto=new JewelryTypeDTO(jewelryTypeIDText,jewelryTypeText,0);

        try {
            boolean isAdded = jewelryTypeBO.saveJewelryType(dto);
            if (isAdded){
                txtJewelryType.setText(null);
                txtJewelryType.requestFocus();
                loadJewelryType();

                Notification.showConformationeMessage("Added Successfully");
            }else {
                Notification.showFailureMessage("Adding Failed");
            }
        } catch (Exception e) {
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void removeJewelryType(ActionEvent event) {
        try {
            String jewelryTypeId = tblJewelryType.getSelectionModel().getSelectedItem().getJewelryTypeId();
            try {
                boolean isDeleted = jewelryTypeBO.deleteJewelrytype(jewelryTypeId);
                if (isDeleted) {
                    loadJewelryType();
                    txtJewelryType.setText(null);
                    txtJewelryQty.setText("0");
                    txtJewelryType.requestFocus();
                    btnUpdateJewelryType.setDisable(true);
                    btnAddJewelryType.setDisable(false);

                    Notification.showConformationeMessage("Removed Successfully");
                } else {
                    Notification.showFailureMessage("Removing Failed");
                }
            } catch (Exception e) {
                Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, e);
            }
        }catch (Exception e){
            Notification.showWarningMessage("Select Item First to Remove");
        }
    }

    @FXML
    void updateJewelryType(ActionEvent event) {
        try {
            if (Validator.nameValidation(txtJewelryType.getText())){
                btnUpdateJewelryTypeOnAction();
            }else {
                txtJewelryType.requestFocus();

                Notification.showAttrntionMessage("Fill Jewelry Type Correctly");
            }
        }catch (NullPointerException e){
            txtJewelryType.requestFocus();

            Notification.showAttrntionMessage("Fill Jewelry Type Correctly");
        }
    }

    private void btnUpdateJewelryTypeOnAction() {
        String jewelryTypeIDText = txtJewelryTypeID.getText();
        String jewelryTypeText = txtJewelryType.getText();
        JewelryTypeDTO dto=new JewelryTypeDTO(jewelryTypeIDText,jewelryTypeText,0);

        try {
            boolean isUpdated = jewelryTypeBO.updateJewelryType(dto);
            if (isUpdated){
                loadJewelryType();
                txtJewelryType.setText(null);
                txtJewelryQty.setText("0");
                txtJewelryType.requestFocus();
                btnUpdateJewelryType.setDisable(true);
                btnAddJewelryType.setDisable(false);

                Notification.showConformationeMessage("Updated Successfully");
            }else {
                Notification.showFailureMessage("Updating Failed");
            }
        } catch (Exception e) {
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void selectJewelryTypeDetail(MouseEvent event) {
        JewelryTypeDTO dto = tblJewelryType.getSelectionModel().getSelectedItem();
        txtJewelryTypeID.setText(dto.getJewelryTypeId());
        txtJewelryType.setText(dto.getName());
        txtJewelryQty.setText(Integer.toString(dto.getQuantity()));

        btnAddJewelryType.setDisable(true);
        btnUpdateJewelryType.setDisable(false);
        txtJewelryType.requestFocus();
    }

    @FXML
    void loadJewelryTypeDetailReport(ActionEvent event) {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/jewelryshop/reports/JewelryTypesDetail.jasper");

        HashMap map= new HashMap();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException e) {
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, e);
        } catch (JRException e) {
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {
        try {
            ResultSet rst = CrudUtil.executeQuery("select username from userdetail where pid=? ", "P");
            if (rst.next()){
                String dbUserName = rst.getString(1);
                try {
                    if (dbUserName.equals(txtUserName.getText())){
                        txtPassword.requestFocus();
                    }else {
                        txtUserName.selectAll();

                        Notification.showAttrntionMessage("User Name doesn't Match");
                    }
                }catch (NullPointerException e){
                    txtUserName.selectAll();

                    Notification.showAttrntionMessage("User Name doesn't Match");
                }
            }
        } catch (Exception e) {
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {
        try {
            ResultSet rst = CrudUtil.executeQuery("select * from userdetail where pid=? ", "P");
            if (rst.next()){
                String dbUserName = rst.getString(2);
                String salt = rst.getString(3);
                String securePassword = rst.getString(4);
                try {
                    if (dbUserName.equals(txtUserName.getText())){
                        txtPassword.requestFocus();
                        try {
                            if (PasswordUtils.verifyUserPassword(txtPassword.getText(),securePassword,salt)){
                                txtNewUserName.setDisable(false);
                                txtNewPassword.setDisable(false);
                                btnSignIn.setDisable(false);

                                txtUserName.clear();
                                txtPassword.clear();

                                txtNewUserName.requestFocus();
                            }else {
                                txtPassword.selectAll();

                                Notification.showAttrntionMessage("Password doesn't Match");
                            }
                        }catch (NullPointerException e){
                            txtPassword.selectAll();

                            Notification.showAttrntionMessage("Password doesn't Match");
                        }
                    }else {
                        txtUserName.requestFocus();

                        Notification.showAttrntionMessage("User Name doesn't Match");
                    }
                }catch (NullPointerException e){
                    txtUserName.requestFocus();

                    Notification.showAttrntionMessage("User Name doesn't Match");
                }
            }
        } catch (Exception e) {
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void logIn(ActionEvent event) {
        try {
            ResultSet rst = CrudUtil.executeQuery("select * from userdetail where pid=? ", "P");
            if (rst.next()){
                String dbUserName = rst.getString(2);
                String salt = rst.getString(3);
                String securePassword = rst.getString(4);
                try {
                    if (dbUserName.equals(txtUserName.getText())){
                        txtPassword.requestFocus();
                        try {
                            if (PasswordUtils.verifyUserPassword(txtPassword.getText(),securePassword,salt)){
                                txtNewUserName.setDisable(false);
                                txtNewPassword.setDisable(false);
                                btnSignIn.setDisable(false);

                                txtNewUserName.requestFocus();
                            }else {
                                txtPassword.requestFocus();

                                Notification.showAttrntionMessage("Password doesn't Match");
                            }
                        }catch (NullPointerException e){
                            txtPassword.requestFocus();

                            Notification.showAttrntionMessage("Password doesn't Match");
                        }
                    }else {
                        txtUserName.requestFocus();

                        Notification.showAttrntionMessage("User Name doesn't Match");
                    }
                }catch (NullPointerException e){
                    txtUserName.requestFocus();

                    Notification.showAttrntionMessage("User Name doesn't Match");
                }
            }
        } catch (Exception e) {
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void txtNewUserNameOnAction(ActionEvent event) {
        try {
            if (Validator.nameValidation(txtNewUserName.getText())){
                txtNewPassword.requestFocus();
            }else {
                txtNewUserName.selectAll();

                Notification.showAttrntionMessage("Please Enter Valid User Name");
            }
        }catch (NullPointerException e){
            txtNewUserName.requestFocus();

            Notification.showAttrntionMessage("Please Enter Valid User Name");
        }
    }

    @FXML
    void txtNewPasswordOnAction(ActionEvent event) {
        try {
            if (Validator.isNotEmptyValidation(txtNewPassword.getText())){
                btnSignIn.requestFocus();
            }else {
                txtNewPassword.selectAll();

                Notification.showAttrntionMessage("Please Enter Valid Password");
            }
        }catch (NullPointerException e){
            txtNewPassword.requestFocus();

            Notification.showAttrntionMessage("Please Enter Valid Password");
        }
    }

    @FXML
    void signIn(ActionEvent event) {
        try {
            if (Validator.nameValidation(txtNewUserName.getText())){
                txtNewPassword.requestFocus();
                try {
                    if (Validator.isNotEmptyValidation(txtNewPassword.getText())){
                        try {
                            String newUserName=txtNewUserName.getText();
                            String newSalt = PasswordUtils.getSalt(30);
                            String newSecurePassword = PasswordUtils.generateSecurePassword(txtNewPassword.getText(), newSalt);

                            boolean isUpdated= CrudUtil.executeUpdate("update userdetail set username=?, salt=?, securepassword=? where pid=? ",newUserName,newSalt,newSecurePassword,"P") > 0;
                            //boolean isUpdated=CrudUtil.executeUpdate("insert into userdetail values(?,?,?,?)","P",newUserName,newSalt,newSecurePassword) > 0;
                            if (isUpdated){

                                Notification.showConformationeMessage("User Settings Updated Successfully");
                            }
                        } catch (Exception e) {
                            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, e);
                        }
                    }else {
                        txtNewPassword.requestFocus();

                        Notification.showAttrntionMessage("Please Enter Valid Password");
                    }
                }catch (NullPointerException e){
                    txtNewPassword.requestFocus();

                    Notification.showAttrntionMessage("Please Enter Valid Password");
                }
            }else {
                txtNewUserName.requestFocus();

                Notification.showAttrntionMessage("Please Enter Valid User Name");
            }
        }catch (NullPointerException e){
            txtNewUserName.requestFocus();

            Notification.showAttrntionMessage("Please Enter Valid User Name");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblJewelryType.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("jewelryTypeId"));
        tblJewelryType.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblJewelryType.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("quantity"));

        loadJewelryType();
    }

    private void loadJewelryType() {
        try {
            String id=IDGenerator.getNewID("jewelrytype","jtid","JT");
            txtJewelryTypeID.setText(id);
        } catch (Exception e) {
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            tblJewelryType.setItems(FXCollections.observableArrayList(jewelryTypeBO.getAllJewelryType()));
        } catch (Exception e) {
            Logger.getLogger(SettingController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
