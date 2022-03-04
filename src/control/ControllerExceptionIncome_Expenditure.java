package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerExceptionIncome_Expenditure {
	
	@FXML
    private Button backBTN;

    @FXML
    void backAct(ActionEvent event) {
    	Stage stage = (Stage) this.backBTN.getScene().getWindow();
    	stage.close();
    }
	
}
