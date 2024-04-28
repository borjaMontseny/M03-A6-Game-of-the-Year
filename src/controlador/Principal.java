package controlador;

import java.util.Random;

//import java.util.Collections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Principal {

	@FXML
	private Button btn21;

	@FXML
	private Button btn10;

	@FXML
	private Button btn32;

	@FXML
	private Label labelRecord;

	@FXML
	private Button btn20;

	@FXML
	private Button btn31;

	@FXML
	private Button btn30;

	@FXML
	private Button btn03;

	@FXML
	private Button btn02;

	@FXML
	private Button btn13;

	@FXML
	private Button btn01;

	@FXML
	private Button btn12;

	@FXML
	private Button btn23;

	@FXML
	private Button btn11;

	@FXML
	private Button btn33;

	@FXML
	private Button btn22;

	@FXML
	private Button btn00;

	@FXML
	private Button btnStartRestart;

	@FXML
	private TextField textFieldPuntuacio;

	@FXML
	private Button btnSortir;

	// Variables de control
	int record = 0;
	int puntuacio = 0;
	Random random = new Random();
	int cantidadW = random1a3();
	String[][] arrayString = new String[4][4];

	private Button[][] taulell = new Button[4][4];

	private int random1a3() {
		return random.nextInt(3) + 1;
	}

	@FXML
	private void initialize() {
		omplirTaulell();

	}

	private void omplirTaulell() {
		taulell[0][0] = btn00;
		taulell[0][1] = btn01;
		taulell[0][2] = btn02;
		taulell[0][3] = btn03;
		taulell[1][0] = btn10;
		taulell[1][1] = btn11;
		taulell[1][2] = btn12;
		taulell[1][3] = btn13;
		taulell[2][0] = btn20;
		taulell[2][1] = btn21;
		taulell[2][2] = btn22;
		taulell[2][3] = btn23;
		taulell[3][0] = btn30;
		taulell[3][1] = btn31;
		taulell[3][2] = btn32;
		taulell[3][3] = btn33;

	}
}
