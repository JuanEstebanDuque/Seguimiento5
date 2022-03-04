package control;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;
import model.Gasto;
import model.GastoData;
import model.Ingreso;
import model.IngresoData;

public class ControllerNewIncome_Expenditure implements Initializable{
	
	@FXML
    private Button añadirBTN;

    @FXML
    private Button backBTM;

    @FXML
    private TextField descripcionTF;

    @FXML
    private DatePicker fechaDP;

    @FXML
    private TextField montoTF;

    @FXML
    private ComboBox<String> tipoCMB;

    @FXML
    void añadirMontoAct(ActionEvent event) throws IOException {
    	double monto = Integer.parseInt(montoTF.getText());
    	String descripcion = descripcionTF.getText();
    	LocalDate actualDate = fechaDP.getValue();
    	String tipo = tipoCMB.getSelectionModel().getSelectedItem();
    	if(descripcion.equals("") || actualDate == null || tipo.equals("")) {
    		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/ExceptionIncome_Expenditure.fxml"));
    		loader.setController(new ControllerExceptionIncome_Expenditure());
    		Parent parent = (Parent) loader.load();
    		Stage stage = new Stage();
    		Scene scene = new Scene(parent);
    		stage.setScene(scene);
    		stage.show();
    	} else {
			if (tipo.equalsIgnoreCase("Ingreso")) {
				IngresoData.ingreso.add(new Ingreso(monto, descripcion, actualDate));
			} else if (tipo.equalsIgnoreCase("Gasto")) {
				GastoData.gasto.add(new Gasto(monto, descripcion, actualDate));
			}
			Stage stage = (Stage) this.añadirBTN.getScene().getWindow();
			stage.close();
    	}
    }

    @FXML
    void backAct(ActionEvent event) {
    	Stage stage = (Stage) this.backBTM.getScene().getWindow();
    	stage.close();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = FXCollections.observableArrayList();
		list.add("ingreso");
		list.add("Gasto");
		tipoCMB.setItems(list);
	}
	
}
