package controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.RoomInfoDTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class RoomInfoFormController implements Initializable {

    public TextField txtRoomID;
    public TextField txtPrice;
    public TextField txtType;
    public TextField txtDescription;
    ObservableList<RoomInfoDTO> roomInfoDTOS = FXCollections.observableArrayList(
            new RoomInfoDTO("R001","Double","A room assigned to a two person",20000.0),
            new RoomInfoDTO("R001","Double","A room assigned to a two person",20000.0),
            new RoomInfoDTO("R001","Double","A room assigned to a two person",20000.0)
    );

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colRoomId;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableView<RoomInfoDTO> tblRoomInfo;

  

    @FXML
    void btnAddActionOn(ActionEvent event) {

    }

    @FXML
    void btnClearActionOn(ActionEvent event) {

    }

    @FXML
    void btnDeleteActionOn(ActionEvent event) {

    }

    @FXML
    void btnUpdateActionOn(ActionEvent event) {

    }

    public void btnReloadOnAction(javafx.event.ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        tblRoomInfo.setItems(roomInfoDTOS);

        tblRoomInfo.getSelectionModel().selectedItemProperty().addListener(( observable, oldValue, newValue)->{
            if(newValue != null){
                txtRoomID.setText(newValue.getRoomID());
                txtType.setText(newValue.getType());
                txtDescription.setText(newValue.getDescription());
                txtPrice.setText(String.valueOf(newValue.getPrice()));
            }
        });
    }


    public void btnUpdateActionOn(javafx.event.ActionEvent actionEvent) {
        RoomInfoDTO selectedRoom =  tblRoomInfo.getSelectionModel().getSelectedItem();

        selectedRoom.setRoomID(txtRoomID.getText());
        selectedRoom.setType(txtType.getText());
        selectedRoom.setDescription(txtDescription.getText());
        selectedRoom.setPrice(Double.valueOf(txtPrice.getText()));

        tblRoomInfo.refresh();
    }

    public void btnAddActionOn(javafx.event.ActionEvent actionEvent) {
        String id = txtRoomID.getText();
        String type = txtType.getText();
        String description = txtDescription.getText();
        double price = Double.parseDouble(txtPrice.getText());

        RoomInfoDTO newRoom = new RoomInfoDTO(id , type, description, price);
        roomInfoDTOS.add(newRoom);

        tblRoomInfo.setItems(roomInfoDTOS);
        tblRoomInfo.refresh();

        btnClearActionOn(actionEvent);

    }

    public void btnDeleteActionOn(javafx.event.ActionEvent actionEvent) {
        RoomInfoDTO selectedItem = tblRoomInfo.getSelectionModel().getSelectedItem();
        roomInfoDTOS.remove(selectedItem);
        tblRoomInfo.refresh();
    }

    public void btnClearActionOn(javafx.event.ActionEvent actionEvent) {
        txtRoomID.setText("");
        txtType.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
    }
}