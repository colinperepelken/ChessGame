package chessgame.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 600;
	
	private GridPane root = new GridPane();
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Chess Game");
		
		initBoard();
		
		primaryStage.setScene(new Scene(root, FRAME_WIDTH, FRAME_HEIGHT));
		primaryStage.show();
	}
	
	private void initBoard() {
		for(int row = 0; row < 8; row++) {
			for(int col = 0; col < 8; col++) {
				Button square = new Button();
				String color;
				if((row + col) % 2 == 0) {
					color = "#ffffff"; // white
				} else {
					color = "#000000"; // black
				}
				
				Image img = new Image(getClass().getResourceAsStream("/res/rookw.png"));
				square.setGraphic(new ImageView(img));
				// CSS styling of button
				square.setStyle(
						"-fx-base: " + color + ";" // sets color
						+"-fx-background-insets: 0;" // removes shadow
						+"-fx-background-radius: 0;"); // removes rounded corners
				// set button sizes
				square.setMinHeight(70);
				square.setMinWidth(70);
				square.setMaxHeight(70);
				square.setMaxWidth(70);
			
				root.add(square, col, row);
			}
		}
	}

	public static void main(String[] args) {
		launch(args); // launch application
	}
}
