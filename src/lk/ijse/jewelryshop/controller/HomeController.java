/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.jewelryshop.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.jewelryshop.dao.CrudUtil;


public class HomeController implements Initializable{
    @FXML
    private AnchorPane homePane;

    @FXML
    private AnchorPane pnlMain;

    @FXML
    private JFXButton btnSellJewelry;

    @FXML
    private JFXButton btnJewelryStock;

    @FXML
    private JFXButton btnGemSuply;

    @FXML
    private JFXButton btnMetalSuply;

    @FXML
    private JFXButton btnMetalStock;

    @FXML
    private JFXButton btnJewelryMakers;

    @FXML
    private JFXButton btnMetalBusinessmen;

    @FXML
    private JFXButton btnHotels;

    @FXML
    private JFXButton btnReport;

    @FXML
    private JFXButton btnSetting;

    @FXML
    private JFXButton btnUser;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    void loadSettingForm(ActionEvent event) {

        AnchorPane pane= null;
        try {
            pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/jewelryshop/view/SettingsForm.fxml"));
        } catch (IOException e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, e);
        }
        pnlMain.getChildren().setAll(pane);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), pnlMain);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    @FXML
    void loadUserForm(ActionEvent event) {

        AnchorPane pane= null;
        try {
            pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/jewelryshop/view/SettingsForm.fxml"));
        } catch (IOException e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, e);
        }
        pnlMain.getChildren().setAll(pane);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), pnlMain);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    @FXML
    void loadReportForm(ActionEvent event) {

        AnchorPane pane= null;
        try {
            pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/jewelryshop/view/ReportsForm.fxml"));
        } catch (IOException e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, e);
        }
        pnlMain.getChildren().setAll(pane);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), pnlMain);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    @FXML
    void loadGemSuplyForm(ActionEvent event) {

        AnchorPane pane= null;
        try {
            pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/jewelryshop/view/GemSuplyForm.fxml"));
        } catch (IOException e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, e);
        }
        pnlMain.getChildren().setAll(pane);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), pnlMain);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    @FXML
    void loadHotelsForm(ActionEvent event) {

        AnchorPane pane= null;
        try {
            pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/jewelryshop/view/HotelDetailForm.fxml"));
        } catch (IOException e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, e);
        }
        pnlMain.getChildren().setAll(pane);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), pnlMain);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    @FXML
    void loadJewelryMakersForm(ActionEvent event) {

        AnchorPane pane= null;
        try {
            pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/jewelryshop/view/JewelryMakersForm.fxml"));
        } catch (IOException e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, e);
        }
        pnlMain.getChildren().setAll(pane);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), pnlMain);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    @FXML
    void loadJewelryStockForm(ActionEvent event) {

        AnchorPane pane= null;
        try {
            pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/jewelryshop/view/JewelryStockForm.fxml"));
        } catch (IOException e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, e);
        }
        pnlMain.getChildren().setAll(pane);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), pnlMain);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    @FXML
    void loadMetalBusinessmenForm(ActionEvent event) {

        AnchorPane pane= null;
        try {
            pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/jewelryshop/view/MetalBusinessmenForm.fxml"));
        } catch (IOException e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, e);
        }
        pnlMain.getChildren().setAll(pane);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), pnlMain);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    @FXML
    void loadMetalStockForm(ActionEvent event) {

        AnchorPane pane= null;
        try {
            pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/jewelryshop/view/MetalStockForm.fxml"));
        } catch (IOException e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, e);
        }
        pnlMain.getChildren().setAll(pane);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), pnlMain);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    @FXML
    void loadMetalSuplyForm(ActionEvent event) {

        AnchorPane pane= null;
        try {
            pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/jewelryshop/view/MetalSuplyForm.fxml"));
        } catch (IOException e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, e);
        }
        pnlMain.getChildren().setAll(pane);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), pnlMain);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    @FXML
    void loadSellJewelryForm(ActionEvent event) {

        startJewelryForm();

        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), pnlMain);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(3000), homePane);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        startJewelryForm();

        setDateAndTime();

        try {
            ResultSet rst = CrudUtil.executeQuery("select username from userdetail where pid=? ", "P");
            if (rst.next()) {
                btnUser.setText(rst.getString(1));
            }
        } catch (Exception e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    private void setDateAndTime() {
        Timeline newTimeLine=new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                lblDate.setText(new SimpleDateFormat("YYYY-MM-dd" ).format(new Date()));
                lblTime.setText(new SimpleDateFormat("hh:mm:ss a" ).format(new Date()));
            }

        }),new KeyFrame(Duration.seconds(1)));
        newTimeLine.setCycleCount(Animation.INDEFINITE);
        newTimeLine.play();
    }

    void startJewelryForm(){
        AnchorPane pane= null;
        try {
            pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/jewelryshop/view/JewelrySellForm.fxml"));
        } catch (IOException e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, e);
        }
        pnlMain.getChildren().setAll(pane);
    }
}
