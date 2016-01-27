package chessgame.gui;

import chessgame.Square;
import chessgame.pieces.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class GUI extends Application {
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 600;
	private static final String TITLE = "Chess Game";
	
	private GridPane root = new GridPane();

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle(TITLE);
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/res/pawnb.png"))); // set application icon
		
		initBoard();
		
		primaryStage.setScene(new Scene(root, FRAME_WIDTH, FRAME_HEIGHT));
		primaryStage.show();
	}
	
	private void initBoard() {
		for(int row = 0; row < 8; row++) {
			for(int col = 0; col < 8; col++) {
				Square square = new Square(Color.BLACK, row, col);
				String color;
				if((row + col) % 2 == 0) {
					color = "#f2f2f2"; // white
				} else {
					color = "#595959"; // black
				}
				
				// set piece to square
				square.setPiece(Piece.loadPiece(row, col));
				// set images
				if(square.isOccupied()) {
					square.setGraphic(new ImageView(square.getPiece().getImage()));
				}
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
				
				
				// add event handler to button
				square.setOnAction(new Handler());
				root.add(square, col, row);
			}
		}
	}

	public static void main(String[] args) {
		launch(args); // launch application
	}
}
