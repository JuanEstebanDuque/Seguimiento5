package control;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.Main;
import model.Gasto;
import model.GastoData;
import model.Ingreso;
import model.IngresoData;

public class ControllerMainBankPage implements Initializable{
	
	@FXML
	private Button actualizarIng_GasBTN1;

	@FXML
	private Text balanceTX;

	@FXML
	private TableColumn<Gasto, String> descripcionGastoCol;

	@FXML
	private TableColumn<Ingreso, String> descripcionIngresoCol;

	@FXML
	private DatePicker fechaFinalDP;

	@FXML
	private TableColumn<Gasto, LocalDate> fechaGastoCol;

	@FXML
	private TableColumn<Ingreso, LocalDate> fechaIngresoCol;

	@FXML
	private DatePicker fechaInicioDP;

	@FXML
	private TableView<Gasto> gastoTV;

	@FXML
	private Text gastoTX;

	@FXML
	private TableView<Ingreso> ingresoTV;

	@FXML
	private Text ingresoTX;

	@FXML
	private TableColumn<Gasto, Double> montoGastoCol;

	@FXML
	private TableColumn<Ingreso, Double> montoIngresoCol;

	@FXML
	private Button removerDateBTN;

	@FXML
	private Button removerIng_GasBTN;
	
	@FXML
    private Button searchDateBTN;

	@FXML
	private Text totalTX;
	
	Ingreso stClicked;
	Gasto stClicked_2;

	@FXML
	void buscarDate(ActionEvent event) {
		LocalDate fechaInicio = fechaInicioDP.getValue();
		LocalDate fechaFinal = fechaFinalDP.getValue();
		for (int i=0;i<IngresoData.ingreso.size();i++) {
			if(fechaInicio.isBefore(IngresoData.ingreso.get(i).getDate()) && fechaFinal.isAfter(IngresoData.ingreso.get(i).getDate())) {
				IngresoData.ingresoFechas.add(new Ingreso(IngresoData.ingreso.get(i).getIngreso(),IngresoData.ingreso.get(i).getDescripcion(),IngresoData.ingreso.get(i).getDate()));
			}
		}
		for (int u=0;u<GastoData.gasto.size();u++) {
			if(fechaInicio.isBefore(GastoData.gasto.get(u).getDate()) && fechaFinal.isAfter(GastoData.gasto.get(u).getDate())) {
				GastoData.gastoFechas.add(new Gasto(GastoData.gasto.get(u).getGasto(),GastoData.gasto.get(u).getDescripcion(),GastoData.gasto.get(u).getDate()));
			}
			
		}
		ingresoTV.setItems(IngresoData.ingresoFechas);
		gastoTV.setItems(GastoData.gastoFechas);
	}

	@FXML
	void removeDate(ActionEvent event) {
		fechaInicioDP.setValue(null);
		fechaFinalDP.setValue(null);
		ingresoTV.setItems(IngresoData.ingreso);
		gastoTV.setItems(GastoData.gasto);
	}

	@FXML
	void removerAct(ActionEvent event) {
		if(stClicked == ingresoTV.getSelectionModel().getSelectedItem()) {
			IngresoData.ingreso.remove(stClicked);
		} else {
			GastoData.gasto.remove(stClicked_2);
		}
	}
	
	@FXML
    void addMoney(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/NewIncome_Expenditure.fxml"));
		loader.setController(new ControllerNewIncome_Expenditure());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
		
    }

	@FXML
    void actualizarAct(ActionEvent event) {
		double ingreso = 0;
		double gasto = 0;
		double total = 0;
		for (int i=0;i<IngresoData.ingreso.size();i++) {
			ingreso += IngresoData.ingreso.get(i).getIngreso();
		}
		for (int i=0;i<GastoData.gasto.size();i++) {
			gasto += GastoData.gasto.get(i).getGasto();
		}
		total = ingreso - gasto;
		ingresoTX.setText(ingreso+"");
		gastoTX.setText(gasto+"");
		balanceTX.setText(total+"");
		totalTX.setText(total+"");
		//removerDateBTN.setStyle("-fx-background-color: #ffffff; ");
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		montoIngresoCol.setCellValueFactory(new PropertyValueFactory<>("ingreso"));
		descripcionIngresoCol.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
		fechaIngresoCol.setCellValueFactory(new PropertyValueFactory<>("date"));
		ingresoTV.setItems(IngresoData.ingreso);
		
		montoGastoCol.setCellValueFactory(new PropertyValueFactory<>("gasto"));
		descripcionGastoCol.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
		fechaGastoCol.setCellValueFactory(new PropertyValueFactory<>("date"));
		gastoTV.setItems(GastoData.gasto);
		
		ingresoTV.setOnMouseClicked(event -> {
			stClicked = ingresoTV.getSelectionModel().getSelectedItem();
		});
		
		gastoTV.setOnMouseClicked(event ->{
			stClicked_2 = gastoTV.getSelectionModel().getSelectedItem();
		});
	}
}
