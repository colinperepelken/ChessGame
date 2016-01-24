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
				Button square = new Button();
				String color;
				if((row + col) % 2 == 0) {
					color = "#f2f2f2"; // white
				} else {
					color = "#595959"; // black
				}
				
				square.setGraphic(new ImageView(getPieceImage(row, col)));
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
	
	private Image getPieceImage(int row, int col) {
		Image img = null;
		if(row == 1) {
			img = new Image(getClass().getResourceAsStream("/res/pawnb.png"));
		} else if(row == 6) {
			img = new Image(getClass().getResourceAsStream("/res/pawnw.png"));
		} else if(row == 7) {
			if(col == 0 || col == 7) img = new Image(getClass().getResourceAsStream("/res/rookw.png"));
			if(col == 1 || col == 6) img = new Image(getClass().getResourceAsStream("/res/knightw.png"));
			if(col == 2 || col == 5) img = new Image(getClass().getResourceAsStream("/res/bishopw.png"));
			if(col == 3) img = new Image(getClass().getResourceAsStream("/res/queenw.png"));
			if(col == 4) img = new Image(getClass().getResourceAsStream("/res/kingw.png"));
		} else if(row == 0) {
			if(col == 0 || col == 7) img = new Image(getClass().getResourceAsStream("/res/rookb.png"));
			if(col == 1 || col == 6) img = new Image(getClass().getResourceAsStream("/res/knightb.png"));
			if(col == 2 || col == 5) img = new Image(getClass().getResourceAsStream("/res/bishopb.png"));
			if(col == 3) img = new Image(getClass().getResourceAsStream("/res/queenb.png"));
			if(col == 4) img = new Image(getClass().getResourceAsStream("/res/kingb.png"));
		}
			
		
		// default return null... should exception handle
		return img;
	}

	public static void main(String[] args) {
		launch(args); // launch application
	}
}
