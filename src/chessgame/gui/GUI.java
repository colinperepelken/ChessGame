package chessgame.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GUI extends Application {
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Chess Game");
		Button b = new Button();
		b.setText("Play chess!");
		
		StackPane root = new StackPane();
		root.getChildren().add(b);
		primaryStage.setScene(new Scene(root, FRAME_WIDTH, FRAME_HEIGHT));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args); // launch application
	}
}
