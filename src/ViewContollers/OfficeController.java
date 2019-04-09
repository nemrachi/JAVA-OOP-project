package ViewContollers;

import Offices.CadastralOffice;
import Offices.Office;
import View.CheckUserStage;
import View.MakeLandStage;
import View.RegisterStage;
import javafx.scene.control.*;

public class OfficeController extends GuestController{
    private Office office = new CadastralOffice();


    //switch to make owner formula stage
    public void makeOwnerClicked (MenuItem makeOwnerItem) {
        makeOwnerItem.setOnAction(event -> {
            try {
                CheckUserStage checkUserStage = new CheckUserStage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    //switch to make land formula
    public void makeLandClicked(MenuItem makeLandItem) {
        makeLandItem.setOnAction(event -> {
            try {
                MakeLandStage makeLandStage = new MakeLandStage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void changePromptText(ChoiceBox<String> userTypeBox, TextField textField) {
        if (userTypeBox.getValue().equals("owner")) {
            textField.setPromptText("Find owner");
        } else if (userTypeBox.getValue().equals("street or city")){
            textField.setPromptText("Find street or city");
        }
    }
}
