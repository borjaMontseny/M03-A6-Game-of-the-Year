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

public class Principal {

	@FXML
	private Label labelRecord;

	@FXML
	private Button btn0;

	@FXML
	private Button btn1;

	@FXML
	private Button btn2;

	@FXML
	private Button btn3;

	@FXML
	private Button btn4;

	@FXML
	private Button btn5;

	@FXML
	private Button btn6;

	@FXML
	private Button btn7;

	@FXML
	private Button btn8;

	@FXML
	private Button btn9;

	@FXML
	private Button btn10;

	@FXML
	private Button btn11;

	@FXML
	private Button btn12;

	@FXML
	private Button btn13;

	@FXML
	private Button btn14;

	@FXML
	private Button btn15;

	@FXML
	private TextField textFieldPuntuacio;

	@FXML
	private Button btnSortir;

	@FXML
	private Button btnStartRestart;

	// Variables de control
	int record = 0;
	int puntuacio = 0;
	private Random random = new Random();
	int quantitatW = random1a3();
	private String[] arrayString = new String[16];
	private Button[] arrayBtns = new Button[16];
	int contadorW = 0;
	int contadorX = 0;
	String lletraAleatoria = "";

	@FXML
	void startGame(ActionEvent event) {
		btnStartRestart.setText("Reiniciar Pantalla");
		omplirArrayString(arrayString);
		actualitzarMarcadors();
		omplirTaulell();
	}

	private void actualitzarMarcadors() {
		// Actualitza el marcador de punts
		textFieldPuntuacio.setText(Integer.toString(puntuacio));
		// Si els punts són superiors o igual al record, actualitzem el record
		// i el marcador de record
		if (puntuacio >= record) {
			record = puntuacio;
			labelRecord.setText("Rècord: " + record + " punts");
		}
	}

	// Alerta al acabar la partida
	private void gameOver(int record) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("GAME OVER");
		alert.setHeaderText("Has obtingut " + record + " punts.");
		alert.show();

		puntuacio = 0;
		textFieldPuntuacio.setText(Integer.toString(puntuacio));

		// Deshabilitem els botons per a que no es pugui continuar jugant
		for (int i = 0; i < arrayBtns.length; i++) {
			arrayBtns[i].setDisable(true);
		}

	}

	@FXML
	void actionSortir(ActionEvent event) {
		Platform.exit();
	}

	@FXML
	private void accionarBtn(ActionEvent event) {
		// Obtindre el botó clicat
		Button botoClicat = (Button) event.getSource();

		for (int i = 0; i < arrayBtns.length; i++) {
			if (arrayBtns[i] == botoClicat) {
				arrayBtns[i].setText(arrayString[i]);
				switch (arrayString[i]) {
				case "O":
					puntuacio++;
					actualitzarMarcadors();
					break;
				case "W":
					puntuacio = puntuacio * 2;
					actualitzarMarcadors();
					break;
				case "X":
					gameOver(record);
					break;

				default:
					break;
				}
				System.out.println(arrayString[i]);
			}
		}
	}

	private void omplirTaulell() {
		arrayBtns[0] = btn0;
		arrayBtns[1] = btn1;
		arrayBtns[2] = btn2;
		arrayBtns[3] = btn3;
		arrayBtns[4] = btn4;
		arrayBtns[5] = btn5;
		arrayBtns[6] = btn6;
		arrayBtns[7] = btn7;
		arrayBtns[8] = btn8;
		arrayBtns[9] = btn9;
		arrayBtns[10] = btn10;
		arrayBtns[11] = btn11;
		arrayBtns[12] = btn12;
		arrayBtns[13] = btn13;
		arrayBtns[14] = btn14;
		arrayBtns[15] = btn15;

		for (int i = 0; i < arrayBtns.length; i++) {
			arrayBtns[i].setDisable(false);
			arrayBtns[i].setText("?");
		}
	}

	private void omplirArrayString(String[] arrayString) {

		// Buidar l'array prèviament
		for (int fil = 0; fil < arrayString.length; fil++) {
			arrayString[fil] = null;
		}

		// Reiniciar contadors
		quantitatW = random1a3();
		contadorW = 0;
		contadorX = 0;

		// Omplir amb X
		while (contadorX < 2) {
			for (int fil = 0; fil < arrayString.length; fil++) {
				lletraAleatoria = crearLletraAleatoria();
				if (arrayString[fil] == null && lletraAleatoria == "X" && contadorX < 2) {
					contadorX++;
					arrayString[fil] = lletraAleatoria;
				}
			}
		}

		// Omplir amb W
		while (contadorW < quantitatW) {
			for (int fil = 0; fil < arrayString.length; fil++) {
				lletraAleatoria = crearLletraAleatoria();
				if (arrayString[fil] == null && lletraAleatoria == "W" && contadorW < quantitatW) {
					contadorW++;
					arrayString[fil] = lletraAleatoria;
				}
			}
		}

		// Omplir amb O
		for (int fil = 0; fil < arrayString.length; fil++) {
			if (arrayString[fil] == null) {
				arrayString[fil] = "O";
			}
		}

		for (int fil = 0; fil < arrayString.length; fil++) {
			if ((fil + 1) % 4 == 0 && fil > 0) {
				System.out.println(arrayString[fil]);
			} else {
				System.out.print(arrayString[fil]);
			}
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
}
