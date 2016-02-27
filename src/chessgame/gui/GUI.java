package chessgame.gui;

import chessgame.Square;
import chessgame.pieces.Piece;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class GUI extends Application {
	private static final int FRAME_WIDTH = 560;
	private static final int FRAME_HEIGHT = 595; // height of toolbar is 35px
	private static final String TITLE = "Chess Game";
	
	private Stage primaryStage;
	private GridPane gridPane = new GridPane();
	private ToolBar toolbar1;
	public static Square[][] board;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		primaryStage.setTitle(TITLE);
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/res/pawnb.png"))); // set application icon
		
		initBoard();
		initToolBar();
		
		BorderPane root = new BorderPane();
		root.setTop(toolbar1);
		root.setCenter(gridPane);
		Scene scene = new Scene(root, FRAME_WIDTH, FRAME_HEIGHT);
		primaryStage.setScene(scene);
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
				gridPane.add(square, col, row);
				board[row][col] = square; // store this square in array so it can be accessed without clicking on it
			}
		}
	}
	
	private void initToolBar() {
		Button btnNew = new Button("New");
		Button btnQuit = new Button("Quit");
		toolbar1 = new ToolBar();
		toolbar1.getItems().addAll(btnNew, btnQuit);
		toolbar1.setPrefWidth(FRAME_WIDTH);
		
		// button listeners
		btnNew.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.close();
				start(new Stage());
				
			}
		});
		btnQuit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.close();
			}
		});
	}

	public static void main(String[] args) {
		launch(args); // launch application
	}
}
