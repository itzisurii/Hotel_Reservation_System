package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginFormController {

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsernameEmail;

    Stage stage = new Stage();
    @FXML
    void btnLoginOnAction(ActionEvent event) {
        String username = txtUsernameEmail.getText();
        String password = txtPassword.getText();

        if(username.equals("Admin")){
            if(password.equals("1234")){
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"))));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                txtUsernameEmail.setText("");
                txtPassword.setText("");
                stage.show();
            }else{
                txtUsernameEmail.setText("");
                txtPassword.setText("");
                System.out.println("Invalid Password");
            }
        }else{
            txtUsernameEmail.setText("");
            txtPassword.setText("");
            System.out.println("Invalid Username");
        }
    }

}
