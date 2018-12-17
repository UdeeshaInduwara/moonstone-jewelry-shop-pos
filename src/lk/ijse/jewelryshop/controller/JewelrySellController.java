package lk.ijse.jewelryshop.controller;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import lk.ijse.jewelryshop.business.custom.JewelrySellBO;
import lk.ijse.jewelryshop.controller.utils.Notification;
import lk.ijse.jewelryshop.generator.IDGenerator;
import lk.ijse.jewelryshop.model.*;
import lk.ijse.jewelryshop.validation.Validator;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JewelrySellController implements Initializable {
    JewelrySellBO jewelrySellBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.JEWELRYSELL);
    private static double total=0;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtPassportNo;

    @FXML
    private JFXTextField txtCountry;

    @FXML
    private JFXTextField txtCustomerId;

    @FXML
    private JFXComboBox<String> cmbSender;

    @FXML
    private JFXListView<String> listJewelrytype;

    @FXML
    private JFXComboBox<String> cmbJewelryId;

    @FXML
    private JFXTextField txtMetal;

    @FXML
    private JFXTextField txtGem;

    @FXML
    private JFXTextField txtWeight;

    @FXML
    private JFXTextField txtCarat;

    @FXML
    private JFXTextField txtSize;

    @FXML
    private JFXTextField txtUnitPrice;

    @FXML
    private JFXTextField txtQuantity;

    @FXML
    private TableView<JewelrySalesTableDTO> tblSelectedJewelry;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXTextField txtTotalAmount;

    @FXML
    private JFXTextField txtDiscount;

    @FXML
    private JFXTextField txtFinalAmount;

    @FXML
    private JFXRadioButton rbtnCash;

    @FXML
    private ToggleGroup payment;

    @FXML
    private JFXRadioButton rbtnCard;

    @FXML
    private JFXTextField txtPayment;

    @FXML
    private JFXTextField txtBalance;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnSaveAndPrint;

    @FXML
    private JFXTextField txtOrderId;

    @FXML
    private JFXTextField txtPaymentId;

    @FXML
    private JFXTextField txtSenderName;

    @FXML
    private TextField txtJewelryID;

    @FXML
    void txtPassportNoOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if (Validator.passportNoValidation(txtPassportNo.getText())){
                    txtCustomerName.requestFocus();
                }else {
                    txtPassportNo.selectAll();

                    Notification.showAttrntionMessage("Fill Passport Number Correctly");
                }
            }catch (NullPointerException e){
                txtPassportNo.selectAll();

                Notification.showAttrntionMessage("Fill Passport Number Correctly");
            }
        }
    }

    @FXML
    void txtCustomerNameOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try{
                if (Validator.nameValidation(txtCustomerName.getText())){
                    txtCountry.requestFocus();
                }else {
                    txtCustomerName.selectAll();

                    Notification.showAttrntionMessage("Fill Customer Name Correctly");
                }
            }catch (NullPointerException e){
                txtCustomerName.selectAll();

                Notification.showAttrntionMessage("Fill Customer Name Correctly");
            }
        }
    }

    @FXML
    void txtCountryOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if (Validator.nameValidation(txtCountry.getText())){
                    txtSenderName.requestFocus();
                }else {
                    txtCountry.selectAll();

                    Notification.showAttrntionMessage("Fill Country Correctly");
                }
            }catch (NullPointerException e){
                txtCountry.selectAll();

                Notification.showAttrntionMessage("Fill Country Correctly");
            }
        }
    }

    @FXML
    void cmbSenderOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            cmbSender.show();
        }
    }

    @FXML
    void selectSenderID(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER) {
            try {
                try {
                    String id = jewelrySellBO.searchHotelUseName(txtSenderName.getText());
                    cmbSender.getSelectionModel().select(id);
                    if (Validator.isNotEmptyValidation(cmbSender.getSelectionModel().getSelectedItem())) {
                        cmbSender.requestFocus();
                    }
                } catch (NullPointerException e) {
                    txtSenderName.requestFocus();
                }
            } catch (Exception e) {
                Logger.getLogger(JewelrySellController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    @FXML
    void selectSenderName(ActionEvent event) {
        try {
            try {
                String hotelName = jewelrySellBO.getHotelNames(cmbSender.getSelectionModel().getSelectedItem());
                txtSenderName.setText(hotelName);
            }catch (NullPointerException e){
                cmbSender.requestFocus();

                //Notification.showAttrntionMessage("Select Hotel Correctly");
            }
        } catch (Exception e) {
            Logger.getLogger(JewelrySellController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void txtCustomerIdOnAction(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            try {
                if (Validator.passportNoValidation(txtPassportNo.getText())){
                    try{
                        if (Validator.nameValidation(txtCustomerName.getText())){
                            try {
                                if (Validator.nameValidation(txtCountry.getText())){
                                    try {
                                        if (Validator.nameValidation(txtSenderName.getText())){
                                            try {
                                                if (Validator.hotelIdValidation(cmbSender.getSelectionModel().getSelectedItem())){
                                                    listJewelrytype.requestFocus();
                                                }else {
                                                    cmbSender.requestFocus();

                                                    Notification.showAttrntionMessage("Select Hotel Correctly");
                                                }
                                            }catch (NullPointerException e){
                                                cmbSender.requestFocus();

                                                Notification.showAttrntionMessage("Select Hotel Correctly");
                                            }
                                        }else {
                                            txtSenderName.requestFocus();

                                            Notification.showAttrntionMessage("Select Hotel Correctly");
                                        }
                                    }catch (NullPointerException e){
                                        txtSenderName.requestFocus();

                                        Notification.showAttrntionMessage("Select Hotel Correctly");
                                    }
                                }else {
                                    txtCountry.requestFocus();

                                    Notification.showAttrntionMessage("Fill Country Correctly");
                                }
                            }catch (NullPointerException e){
                                txtCountry.requestFocus();

                                Notification.showAttrntionMessage("Fill Country Correctly");
                            }
                        }else {
                            txtCustomerName.requestFocus();

                            Notification.showAttrntionMessage("Fill Customer Name Correctly");
                        }
                    }catch (NullPointerException e){
                        txtCustomerName.requestFocus();

                        Notification.showAttrntionMessage("Fill Customer Name Correctly");
                    }
                }else {
                    txtPassportNo.requestFocus();

                    Notification.showAttrntionMessage("Fill Passport Number Correctly");
                }
            }catch (NullPointerException e){
                txtPassportNo.requestFocus();

                Notification.showAttrntionMessage("Fill Passport Number Correctly");
            }
        }
    }

    @FXML
    void selectJewelryType(MouseEvent event) {
        String jewelryType = listJewelrytype.getSelectionModel().getSelectedItem();
        JewelryTypeDTO jewelryTypeDetail=null;

        try {
            jewelryTypeDetail = jewelrySellBO.getJewelryTypeDetail(jewelryType);
            txtQuantity.setText(Integer.toString(jewelryTypeDetail.getQuantity()));
        } catch (Exception e) {
            Logger.getLogger(JewelrySellController.class.getName()).log(Level.SEVERE, null, e);
        }

        cmbJewelryId.getItems().clear();
        try {
            ArrayList<String> jewelryIds = jewelrySellBO.getJewelryIds(jewelryTypeDetail.getJewelryTypeId());
            cmbJewelryId.setItems(FXCollections.observableArrayList(jewelryIds));
        } catch (Exception e) {
            Logger.getLogger(JewelrySellController.class.getName()).log(Level.SEVERE, null, e);
        }

        txtMetal.setText(null);
        txtGem.setText(null);
        txtWeight.setText(null);
        txtCarat.setText(null);
        txtSize.setText(null);
        txtUnitPrice.setText(null);
        cmbJewelryId.requestFocus();
    }

    @FXML
    void selectJewelry(ActionEvent event) {
        try {
            try {
                String jewelryId = cmbJewelryId.getSelectionModel().getSelectedItem();
                JewelryDTO dto = jewelrySellBO.getJewelrDetail(jewelryId);
                txtMetal.setText(dto.getMetal());
                txtGem.setText(dto.getEmbroidedgem());
                txtWeight.setText(Double.toString(dto.getWeight()));
                txtCarat.setText(Integer.toString(dto.getCarat()));
                txtSize.setText(Double.toString(dto.getJewelrySize()));
                txtUnitPrice.setText(Double.toString(dto.getPrice()));
                txtUnitPrice.requestFocus();
            }catch (NullPointerException e){}
        } catch (Exception e) {
            Logger.getLogger(JewelrySellController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void searchAndSelectJewelry(ActionEvent event) {
        try {
            try {
                String jewelryId = txtJewelryID.getText();
                JewelryDTO dto = jewelrySellBO.getJewelrDetail(jewelryId);
                JewelryTypeDTO jewelryTypeDetail = jewelrySellBO.getJewelryTypeDetailUseId(dto.getJewelryTypeId());
                listJewelrytype.getSelectionModel().select(jewelryTypeDetail.getName());

                cmbJewelryId.getSelectionModel().select(dto.getJewelryId());
                txtMetal.setText(dto.getMetal());
                txtGem.setText(dto.getEmbroidedgem());
                txtWeight.setText(Double.toString(dto.getWeight()));
                txtCarat.setText(Integer.toString(dto.getCarat()));
                txtSize.setText(Double.toString(dto.getJewelrySize()));
                txtUnitPrice.setText(Double.toString(dto.getPrice()));
                txtUnitPrice.requestFocus();
            }catch (NullPointerException e){}
        } catch (Exception e) {
            Logger.getLogger(JewelrySellController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void addJewelryToTable(ActionEvent event) {
        String jewelryType = listJewelrytype.getSelectionModel().getSelectedItem();
        String jewelryId = cmbJewelryId.getSelectionModel().getSelectedItem();
        double unitPriceText;
        try {
            unitPriceText = Double.parseDouble(txtUnitPrice.getText());
        }catch (Exception e){
            return;
        }
        JewelrySalesTableDTO dto=new JewelrySalesTableDTO(jewelryType,jewelryId,unitPriceText);

        ObservableList<JewelrySalesTableDTO> items = tblSelectedJewelry.getItems();
        for (JewelrySalesTableDTO itemDto :items) {
            if(itemDto.getJewelryId().equals(jewelryId)){
                Notification.showWarningMessage("This Item is Already Selected");

                cmbJewelryId.requestFocus();
                return;
            }
        }
        tblSelectedJewelry.getItems().add(dto);

        total+=unitPriceText;
        txtTotalAmount.setText(Double.toString(total));
    }

    @FXML
    void cancelSales(ActionEvent event) {
        txtPassportNo.setText(null);
        txtCustomerName.setText(null);
        txtCountry.setText(null);
        txtSenderName.setText(null);
        cmbSender.getSelectionModel().clearSelection();
        listJewelrytype.getSelectionModel().clearSelection();
        cmbJewelryId.getSelectionModel().clearSelection();
        txtQuantity.setText(null);
        txtMetal.setText(null);
        txtGem.setText(null);
        txtWeight.setText(null);
        txtCarat.setText(null);
        txtSize.setText(null);
        txtUnitPrice.setText(null);
        tblSelectedJewelry.getItems().clear();
        txtTotalAmount.setText("0.0");
        txtFinalAmount.setText(null);
        txtBalance.setText(null);
        txtPayment.setText(null);

        txtPassportNo.requestFocus();
    }

    @FXML
    void removeSelectedJewelry(ActionEvent event) {
        try {
            JewelrySalesTableDTO item = tblSelectedJewelry.getSelectionModel().getSelectedItem();
            tblSelectedJewelry.getItems().remove(item);

            total-=item.getUnitPrice();
            txtTotalAmount.setText(Double.toString(total));
        }catch (NullPointerException e){
            Notification.showWarningMessage("Select Item First to Remove");
        }
    }

    @FXML
    void saveSales(ActionEvent event) {
        try {
            if (Validator.passportNoValidation(txtPassportNo.getText())){
                try{
                    if (Validator.nameValidation(txtCustomerName.getText())){
                        try {
                            if (Validator.nameValidation(txtCountry.getText())){
                                try {
                                    if (Validator.nameValidation(txtSenderName.getText())){
                                        try {
                                            if (Validator.hotelIdValidation(cmbSender.getSelectionModel().getSelectedItem())){
                                                if (!tblSelectedJewelry.getItems().isEmpty()){
                                                    btnSaveAndPrintOnAction();
                                                }else {
                                                    listJewelrytype.requestFocus();

                                                    Notification.showAttrntionMessage("Select Jewelry Type Correctly");
                                                }
                                            }else {
                                                cmbSender.requestFocus();

                                                Notification.showAttrntionMessage("Select Hotel Correctly");
                                            }
                                        }catch (NullPointerException e){
                                            cmbSender.requestFocus();

                                            Notification.showAttrntionMessage("Select Hotel Correctly");
                                        }
                                    }else {
                                        txtSenderName.requestFocus();

                                        Notification.showAttrntionMessage("Select Hotel Correctly");
                                    }
                                }catch (NullPointerException e){
                                    txtSenderName.requestFocus();

                                    Notification.showAttrntionMessage("Select Hotel Correctly");
                                }
                            }else {
                                txtCountry.requestFocus();

                                Notification.showAttrntionMessage("Fill Country Correctly");
                            }
                        }catch (NullPointerException e){
                            txtCountry.requestFocus();

                            Notification.showAttrntionMessage("Fill Country Correctly");
                        }
                    }else {
                        txtCustomerName.requestFocus();

                        Notification.showAttrntionMessage("Fill Customer Name Correctly");
                    }
                }catch (NullPointerException e){
                    txtCustomerName.requestFocus();

                    Notification.showAttrntionMessage("Fill Customer Name Correctly");
                }
            }else {
                txtPassportNo.requestFocus();

                Notification.showAttrntionMessage("Fill Passport Number Correctly");
            }
        }catch (NullPointerException e){
            txtPassportNo.requestFocus();

            Notification.showAttrntionMessage("Fill Passport Number Correctly");
        }
    }

    private void btnSaveAndPrintOnAction() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String dateText = simpleDateFormat.format(date);
        //String dateText="2018-04-02";

        String orderIdText = txtOrderId.getText();
        String customerIdText = txtCustomerId.getText();
        String customerNameText = txtCustomerName.getText();
        String passportNoText = txtPassportNo.getText();
        String countryText = txtCountry.getText();
        String hotelIdText = cmbSender.getSelectionModel().getSelectedItem();
        String paymentIdText = txtPaymentId.getText();
        double totalAmountText = Double.parseDouble(txtTotalAmount.getText());
        double discountText;
        try {
            discountText=Double.parseDouble(txtDiscount.getText());
        }catch (Exception e){
            discountText=0;
        }

        ArrayList<JewelryPurchaseDetailDTO> purchaseDetailDTOS=new ArrayList<>();
        for (int i=0;i<tblSelectedJewelry.getItems().size();i++){
            String jewelryId = (String) tblSelectedJewelry.getColumns().get(1).getCellObservableValue(i).getValue();
            Object unitPriceText = tblSelectedJewelry.getColumns().get(2).getCellObservableValue(i).getValue();
            double unitPrice= Double.parseDouble(unitPriceText.toString());
            purchaseDetailDTOS.add(new JewelryPurchaseDetailDTO(orderIdText,jewelryId,unitPrice));
        }

        JewelrySellDTO jewelrySellDTO=new JewelrySellDTO(orderIdText,dateText,customerIdText,customerNameText,passportNoText,countryText,hotelIdText,paymentIdText,totalAmountText,discountText,purchaseDetailDTOS);
        try {
            boolean isAdded = jewelrySellBO.addSales(jewelrySellDTO);
            if(isAdded){
                txtPassportNo.setText(null);
                txtCustomerName.setText(null);
                txtCountry.setText(null);
                txtSenderName.setText(null);
                cmbSender.getSelectionModel().clearSelection();
                listJewelrytype.getSelectionModel().clearSelection();
                cmbJewelryId.getSelectionModel().clearSelection();
                txtQuantity.setText(null);
                txtMetal.setText(null);
                txtGem.setText(null);
                txtWeight.setText(null);
                txtCarat.setText(null);
                txtSize.setText(null);
                txtUnitPrice.setText(null);
                tblSelectedJewelry.getItems().clear();
                txtTotalAmount.setText("0.0");
                txtFinalAmount.setText(null);
                txtBalance.setText(null);
                txtPayment.setText(null);
                txtPassportNo.requestFocus();

                loadIDs();

                Notification.showConformationeMessage("Sales Done");
            }else {

                Notification.showFailureMessage("Sales Failed");
            }
        } catch (Exception e) {
            Logger.getLogger(JewelrySellController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    void txtDiscountOnAction(KeyEvent event) {
        double total = Double.parseDouble(txtTotalAmount.getText());

        if (Validator.doubleValueValidation(txtDiscount.getText())){
            if (total >= Double.parseDouble(txtDiscount.getText())){
                double discount=Double.parseDouble(txtDiscount.getText());
                double finalAmount=total-discount;
                txtFinalAmount.setText(Double.toString(finalAmount));

                if(event.getCode()== KeyCode.ENTER){
                    txtFinalAmount.requestFocus();
                }
            }else {
                txtFinalAmount.setText(Double.toString(total));
                txtDiscount.selectAll();
            }
        }else {
            txtFinalAmount.setText(Double.toString(total));
            txtDiscount.selectAll();
        }
    }

    @FXML
    void txtFinalAmountOnAction(ActionEvent event) {
        rbtnCash.requestFocus();
        if (rbtnCash.isSelected()){
            txtPayment.requestFocus();
        }
    }

    @FXML
    void rbtnCashOnAction(ActionEvent event) {
        rbtnCash.setSelected(true);
        txtPayment.setDisable(false);
        txtBalance.setDisable(false);
        txtPayment.requestFocus();

    }

    @FXML
    void rbtnCardOnAction(ActionEvent event) {
        rbtnCard.setSelected(true);
        txtPayment.setDisable(true);
        txtBalance.setDisable(true);
        btnSaveAndPrint.requestFocus();
    }

    @FXML
    void txtPaymentOnAction(KeyEvent event) {
        try {
            double finalAmount = Double.parseDouble(txtFinalAmount.getText());
            try {
                if (Validator.doubleValueValidation(txtPayment.getText())){
                    if (Double.parseDouble(txtPayment.getText()) >= finalAmount){
                        double payment = Double.parseDouble(txtPayment.getText());
                        double balnce=payment-finalAmount;
                        txtBalance.setText(Double.toString(balnce));
                    }
                }else {
                    txtPayment.selectAll();
                }
            }catch (NullPointerException e){}
        }catch (NullPointerException e){
            listJewelrytype.requestFocus();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblSelectedJewelry.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("jewelryType"));
        tblSelectedJewelry.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("jewelryId"));
        tblSelectedJewelry.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        loadIDs();
        total=0;

        try {
            ArrayList<String> jewelryTypes = jewelrySellBO.getJewelryTypes();
            listJewelrytype.setItems(FXCollections.observableArrayList(jewelryTypes));
        } catch (Exception e) {
            Logger.getLogger(JewelrySellController.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            ArrayList<String> hotelIds = jewelrySellBO.getHotelIds();
            cmbSender.setItems(FXCollections.observableArrayList(hotelIds));
        } catch (Exception e) {
            Logger.getLogger(JewelrySellController.class.getName()).log(Level.SEVERE, null, e);
        }

        getHotelNameList();
        txtPassportNo.requestFocus();

        loadAllJewelryIDs();
    }

    private void loadAllJewelryIDs() {
        try {
            ArrayList<String> jewelryIds = jewelrySellBO.getJewelryIdsList();
            TextFields.bindAutoCompletion(txtJewelryID,jewelryIds);
        } catch (Exception e) {
            Logger.getLogger(JewelrySellController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void getHotelNameList() {
        try {
            TextFields.bindAutoCompletion(txtSenderName,jewelrySellBO.getHotelNamesList());
        } catch (Exception e) {
            Logger.getLogger(JewelrySellController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadIDs() {
        try {
            String newID = IDGenerator.getNewID("customer", "custid", "CUST");
            txtCustomerId.setText(newID);
        } catch (Exception e) {
            Logger.getLogger(JewelrySellController.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            String newID = IDGenerator.getNewID("orders", "oid", "OID");
            txtOrderId.setText(newID);
        } catch (Exception e) {
            Logger.getLogger(JewelrySellController.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            String newID = IDGenerator.getNewID("payment", "payid", "PID");
            txtPaymentId.setText(newID);
        } catch (Exception e) {
            Logger.getLogger(JewelrySellController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
