package lk.ijse.jewelryshop.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.jewelryshop.dao.CrudUtil;
import lk.ijse.jewelryshop.validation.PasswordUtils;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogInController implements Initializable {
    @FXML
    private AnchorPane pnlLogIn;

    @FXML
    private JFXButton btnLogIn;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;

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
                    }
                }catch (NullPointerException e){
                    txtUserName.selectAll();
                }
            }
        } catch (Exception e) {
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, e);
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
                                loadHomeForm();
                            }else {
                                txtPassword.selectAll();
                            }
                        }catch (NullPointerException e){
                            txtPassword.selectAll();
                        }
                    }else {
                        txtUserName.requestFocus();
                    }
                }catch (NullPointerException e){
                    txtUserName.requestFocus();
                }
            }
        } catch (Exception e) {
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void logInToSystem(ActionEvent event) {
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
                                loadHomeForm();
                            }else {
                                txtPassword.requestFocus();
                            }
                        }catch (NullPointerException e){
                            txtPassword.requestFocus();
                        }
                    }else {
                        txtUserName.requestFocus();
                    }
                }catch (NullPointerException e){
                    txtUserName.requestFocus();
                }
            }
        } catch (Exception e) {
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, e);
        }
        //loadHomeForm();
    }

    private void loadHomeForm() {
        Parent parent= null;
        try {
            parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/jewelryshop/view/HomeForm.fxml"));
        } catch (IOException e) {
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, e);
        }
        Scene temp=new Scene(parent);
        Stage stage=(Stage) this.pnlLogIn.getScene().getWindow();
        stage.setScene(temp);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
