package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Icona
			primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/images/icon.png")));
			// Carreguem el document FXML, especificant la ruta relativa al projecte
			Parent root = FXMLLoader.load(getClass().getResource("/vista/Principal.fxml"));

			// Creem i mostrem l'escena
			Scene scene = new Scene(root);

			primaryStage.setScene(scene);
			// Títol de la finestra
			primaryStage.setTitle("A6 - The new Game of the Year");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
