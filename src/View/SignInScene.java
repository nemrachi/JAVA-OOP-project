package View;

import ViewContollers.SignInController;
import javafx.collections.FXCollections;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class SignInScene extends FlowPane {
    //View controller
    private SignInController signInController = new SignInController();

    //Stuff on scene
    private TextField username = new TextField();
    private PasswordField password = new PasswordField();
    private ChoiceBox<String> userTypeBox =
            new ChoiceBox<>(FXCollections.observableArrayList( "User", "Office", "Guest"));
    private Button signIn = new Button();
    private Button registerBtn = new Button();

    //Constructor
    public SignInScene(Stage primaryStage) throws Exception {
        //Setting scene
        setScene(primaryStage);

        //Actions on scene
        sceneEvents(primaryStage);

        primaryStage.show();

    }


    private void setScene(Stage primaryStage) {
        primaryStage.setScene(new Scene(this, primaryStage.getWidth(), primaryStage.getHeight()));

        this.getChildren().addAll(username, password, userTypeBox,
                signIn, registerBtn);
        this.setPrefSize(primaryStage.getWidth(), primaryStage.getHeight());
        this.setAlignment(Pos.CENTER);
        this.setOrientation(Orientation.VERTICAL);
        this.setVgap(20);

        username.setPromptText("Username");

        password.setPromptText("Password");

        userTypeBox.show();
        userTypeBox.getSelectionModel().selectFirst();

        signIn.setText("Sign In");
        signIn.setPrefWidth(280);

        registerBtn.setText("Register");
    }

    private void sceneEvents (Stage primaryStage) {
        //Automatically switch to Guest scene, if "Guest" is selected
        signInController.checkGuest(userTypeBox, primaryStage);

        //Button event
        signInController.signInClicked(signIn, username, password,
                userTypeBox, primaryStage);

        //Register switch stage ... upravit do controlleru
        signInController.switchRegisterStage(registerBtn);

}

}


