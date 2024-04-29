package controlador;

import java.util.Random;

import javafx.application.Platform;
import javafx.event.ActionEvent;
//import java.util.Collections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Principal {

	@FXML
	private Label labelRecord;

	@FXML
	private Button btn00;

	@FXML
	private Button btn01;

	@FXML
	private Button btn02;

	@FXML
	private Button btn03;

	@FXML
	private Button btn10;

	@FXML
	private Button btn11;

	@FXML
	private Button btn12;

	@FXML
	private Button btn13;

	@FXML
	private Button btn20;

	@FXML
	private Button btn21;

	@FXML
	private Button btn22;

	@FXML
	private Button btn23;

	@FXML
	private Button btn30;

	@FXML
	private Button btn31;

	@FXML
	private Button btn32;

	@FXML
	private Button btn33;

	@FXML
	private Button btnSortir;

	@FXML
	private Button btnStartRestart;

	@FXML
	private TextField textFieldPuntuacio;

	// Variables de control
	int record = 0;
	int puntuacio = 0;
	private Random random = new Random();
	int quantitatW = random1a3();
	private String[][] arrayString = new String[4][4];
	private Button[][] arrayBtns = new Button[4][4];
	int contadorW = 0;
	int contadorX = 0;
	String lletraAleatoria = "";

	@FXML
	void startGame(ActionEvent event) {
		btnStartRestart.setText("Reiniciar Pantalla");
		omplirArrayString(arrayString);

	}

	private void actualitzarRecord() {
		if (puntuacio >= record) {
			record = puntuacio;
			labelRecord.setText("Rècord: " + record + " punts");
		}
	}

	private void actualitzarPuntuacio() {
		textFieldPuntuacio.setText(Integer.toString(puntuacio));
	}

	// Alerta al acabar la partida
	private void alertEndGame(int record) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("GAME OVER");
		alert.setHeaderText("Has obtingut " + record + " punts.");
		alert.setContentText("Has obtingut " + record + " punts.");
		alert.show();
	}

	@FXML
	void actionSortir(ActionEvent event) {
		Platform.exit();
	}

	@FXML
	private void accionarBtn(ActionEvent event) {
		// Obtén el botón que ha sido clicado
		Button botonClicado = (Button) event.getSource();

		// Obtén la fila y columna del botón clicado
		int fila = GridPane.getRowIndex(botonClicado) - 1;
		int columna = GridPane.getColumnIndex(botonClicado) - 1;

		System.out.println(arrayString[fila][columna]);

		// arrayBtns[fila][columna].setText(arrayString[fila][columna]);

	}

	private void omplirTaulell() {
		arrayBtns[0][0] = btn00;
		arrayBtns[0][1] = btn01;
		arrayBtns[0][2] = btn02;
		arrayBtns[0][3] = btn03;
		arrayBtns[1][0] = btn10;
		arrayBtns[1][1] = btn11;
		arrayBtns[1][2] = btn12;
		arrayBtns[1][3] = btn13;
		arrayBtns[2][0] = btn20;
		arrayBtns[2][1] = btn21;
		arrayBtns[2][2] = btn22;
		arrayBtns[2][3] = btn23;
		arrayBtns[3][0] = btn30;
		arrayBtns[3][1] = btn31;
		arrayBtns[3][2] = btn32;
		arrayBtns[3][3] = btn33;
	}

	private void omplirArrayString(String[][] arrayString) {

		// Omplir amb X
		while (contadorX < 2) {
			for (int fil = 0; fil < arrayString.length; fil++) {
				for (int col = 0; col < arrayString[fil].length; col++) {
					lletraAleatoria = crearLletraAleatoria();
					if (arrayString[fil][col] == null && lletraAleatoria == "X" && contadorX < 2) {
						contadorX++;
						arrayString[fil][col] = lletraAleatoria;
					}
				}
			}
		}

		// Omplir amb W
		while (contadorW < quantitatW) {
			for (int fil = 0; fil < arrayString.length; fil++) {
				for (int col = 0; col < arrayString[fil].length; col++) {
					lletraAleatoria = crearLletraAleatoria();
					if (arrayString[fil][col] == null && lletraAleatoria == "W" && contadorW < quantitatW) {
						contadorW++;
						arrayString[fil][col] = lletraAleatoria;
					}
				}
			}
		}

		// Omplir amb O
		for (int fil = 0; fil < arrayString.length; fil++) {
			for (int col = 0; col < arrayString[fil].length; col++) {
				if (arrayString[fil][col] == null) {
					arrayString[fil][col] = "O";
				}

			}
		}

		for (int fil = 0; fil < arrayString.length; fil++) {
			for (int col = 0; col < arrayString[fil].length; col++) {
				System.out.print(arrayString[fil][col]);
			}
			System.out.println();
		}

	}

	private int random1a3() {
		return random.nextInt(3) + 1;
	}

	private String crearLletraAleatoria() {
		int numAleatori = random1a3();
		switch (numAleatori) {
		case 1:
			return "O";
		case 2:
			return "W";
		case 3:
			return "X";
		default:
			return "Error";
		}
	}

	@FXML
	private void initialize() {
		actualitzarRecord();
		actualitzarPuntuacio();
		omplirTaulell();
	}

}
