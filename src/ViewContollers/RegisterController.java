package ViewContollers;

import OtherFunctionality.PopUpAlert;
import OtherFunctionality.SerializableUtility;
import UserObject.Database;
import UserObject.User;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.HashMap;

public class RegisterController {
    private Database usersDatabase = new Database();

    public void registerUser(Stage stage, Button registerBtn, TextField username, TextField password, ChoiceBox<String> userType) {
        usersDatabase.setUsersDataHM(SerializableUtility.loadUsers());
        registerBtn.setOnAction(event -> {
            if((username.getText() == null || username.getText().trim().isEmpty()) ||
                    (password.getText() == null || password.getText().trim().isEmpty())) {
                PopUpAlert alert = new PopUpAlert(Alert.AlertType.ERROR, "Username and password fields must be filled");
                alert.setTitle("Missing username or password");
            } else {
                if (usersDatabase.existingUser(username.getText())) {
                    PopUpAlert alert = new PopUpAlert(Alert.AlertType.WARNING, "Username "+username.getText()+" is already used.");
                } else {
                    usersDatabase.addUser(username.getText(), password.getText(), userType.getValue());
                    stage.close();
                }
            }
        });
    }
}