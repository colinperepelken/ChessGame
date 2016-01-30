package chessgame.gui;

import chessgame.Square;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Handler implements EventHandler<ActionEvent> {

	private static Square selectedSquare = null;
	
	@Override
	public void handle(ActionEvent e) {
		Square square = (Square) e.getSource();
		if(selectedSquare == null && square.isOccupied()) {
			selectedSquare = square;
			if(selectedSquare.isBlack()) {
				selectedSquare.setStyle(Style.BLACK_SQUARE_SELECTED);
			} else if(selectedSquare.isWhite()){
				selectedSquare.setStyle(Style.WHITE_SQUARE_SELECTED);
			}
		} else if(selectedSquare != null){
			
			if(selectedSquare.isBlack()) {
				selectedSquare.setStyle(Style.BLACK_SQUARE);
			} else if(selectedSquare.isWhite()){
				selectedSquare.setStyle(Style.WHITE_SQUARE);
			}
			
			if(selectedSquare.getPiece().isValidMove(selectedSquare.getRow(), selectedSquare.getCol(), 
							square.getRow(), square.getCol())) {
				square.setPiece(selectedSquare.removePiece());
			}
				
			selectedSquare = null; // clear
		}
	}

}
