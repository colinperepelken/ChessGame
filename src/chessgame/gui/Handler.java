package chessgame.gui;

import chessgame.Square;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Handler implements EventHandler<ActionEvent> {

	private static Square selectedSquare = null;
	
	@Override
	public void handle(ActionEvent e) {
		Square square = (Square) e.getSource();
		
		if(selectedSquare == null) {
			selectedSquare = square;
			//square.setStyle("-fx-base: #a5e763"); // temp
		} else {
			if(selectedSquare.isOccupied()) {
				System.out.println(selectedSquare.getPiece()
						.isValidMove(selectedSquare.getRow(), selectedSquare.getCol(), 
								square.getRow(), square.getCol()));
				selectedSquare = null; // clear
			}
		}
	}

}
