package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.CustomerInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerInfoFormController implements Initializable {

    ObservableList <CustomerInfoDTO> customerInfoDTOS = FXCollections.observableArrayList(
            new CustomerInfoDTO("C001","Isuri",20, 769975582, "Negombo"),
            new CustomerInfoDTO("C002","Hiranya",18, 769946582, "Panadura"),
            new CustomerInfoDTO("C003","Sarasi",20, 769972382, "Panadura")
    );

    @FXML
    private TableColumn<?, ?> colAge;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCusID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableView<CustomerInfoDTO> tblCustomer;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustomerID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    void btnAddActionOn(ActionEvent event) {
        String cusID = txtCustomerID.getText();
        String name = txtName.getText();
        Integer age = Integer.valueOf(txtAge.getText());
        Integer phoneNumber = Integer.valueOf(txtPhoneNumber.getText());
        String city = txtCity.getText();

        CustomerInfoDTO newCustomer = new CustomerInfoDTO(cusID, name, age, phoneNumber, city);
        customerInfoDTOS.add(newCustomer);

        tblCustomer.setItems(customerInfoDTOS);
        tblCustomer.refresh();

        ActionEvent actionEvent;
        btnClearActionOn(event);
    }

    @FXML
    void btnClearActionOn(ActionEvent event) {
        txtCustomerID.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtPhoneNumber.setText("");
        txtCity.setText("");
    }

    @FXML
    void btnDeleteActionOn(ActionEvent event) {
        CustomerInfoDTO selectedCustomer = tblCustomer.getSelectionModel().getSelectedItem();
        customerInfoDTOS.remove(selectedCustomer);
        tblCustomer.refresh();
    }

    @FXML
    void btnUpdateActionOn(ActionEvent event) {
        CustomerInfoDTO selectedCustomer = tblCustomer.getSelectionModel().getSelectedItem();

        selectedCustomer.setCusID(txtCustomerID.getText());
        selectedCustomer.setName(txtName.getText());
        selectedCustomer.setAge(Integer.valueOf(txtAge.getText()));
        selectedCustomer.setPhoneNumber(Integer.valueOf(txtPhoneNumber.getText()));
        selectedCustomer.setCity(txtCity.getText());

        tblCustomer.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCusID.setCellValueFactory(new PropertyValueFactory<>("cusID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));

        tblCustomer.setItems(customerInfoDTOS);

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
            if(newValue != null){
                txtCustomerID.setText(newValue.getCusID());
                txtName.setText(newValue.getName());
                txtAge.setText(String.valueOf(newValue.getAge()));
                txtPhoneNumber.setText(String.valueOf(newValue.getPhoneNumber()));
                txtCity.setText(newValue.getCity());
            }
        })Admin 1234;
    }
}
