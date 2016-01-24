package chessgame.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GUI extends Application {
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;
	
	private GridPane root = new GridPane();
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Chess Game");
		Button b = new Button();
		b.setText("Play chess!");
		
		for(int row = 0; row < 8; row++) {
			for(int col = 0; col < 8; col++) {
				Rectangle square = new Rectangle();
				Color color;
				if((row + col) % 2 == 0) {
					color = Color.WHITE;
				} else {
					color = Color.BLACK;
				}
				square.setFill(color);
				root.add(square, col, row);
				square.widthProperty().bind(root.widthProperty().divide(8));
				square.heightProperty().bind(root.heightProperty().divide(8));
			}
		}
		primaryStage.setScene(new Scene(root, FRAME_WIDTH, FRAME_HEIGHT));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args); // launch application
	}
}
