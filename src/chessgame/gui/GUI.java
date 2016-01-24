package chessgame.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;
	
	private GridPane root = new GridPane();
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Chess Game");
		
		// init board
		for(int row = 0; row < 8; row++) {
			for(int col = 0; col < 8; col++) {
				Button square = new Button();
				String color;
				if((row + col) % 2 == 0) {
					color = "#ffffff"; // white
				} else {
					color = "#000000"; // black
				}
				square.setStyle("-fx-base: " + color); // set button color using CSS
				// set button sizes
				square.setMinHeight(50);
				square.setMinWidth(50);
				root.add(square, col, row);
			}
		}
		primaryStage.setScene(new Scene(root, FRAME_WIDTH, FRAME_HEIGHT));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args); // launch application
	}
}
