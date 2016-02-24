package chessgame.gui;

import chessgame.Square;
import chessgame.pieces.Piece;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class GUI extends Application {
	private static final int FRAME_WIDTH = 560;
	private static final int FRAME_HEIGHT = 560;
	private static final String TITLE = "Chess Game";
	
	private GridPane root = new GridPane();
	public static Square[][] board;
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle(TITLE);
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/res/pawnb.png"))); // set application icon
		
		initBoard();
		
		primaryStage.setScene(new Scene(root, FRAME_WIDTH, FRAME_HEIGHT));
		primaryStage.show();
	}
	
	private void initBoard() {
		board = new Square[8][8];
		for(int row = 0; row < 8; row++) {
			for(int col = 0; col < 8; col++) {
				Square square = new Square(row, col);
				
				// determine if black or white square
				if((row + col) % 2 == 0) {
					square.setStyle(Style.WHITE_SQUARE); // white
				} else {
					square.setStyle(Style.BLACK_SQUARE); // black
				}
				
				// set piece to square
				square.setPiece(Piece.loadPiece(row, col));
	
				// set button sizes
				square.setMinHeight(70);
				square.setMinWidth(70);
				square.setMaxHeight(70);
				square.setMaxWidth(70);
				
				
				// add event handler to button
				square.setOnAction(new Handler());
				root.add(square, col, row);
				board[row][col] = square; // store this square in array so it can be accessed without clicking on it
			}
		}
	}

	public static void main(String[] args) {
		launch(args); // launch application
	}
}
