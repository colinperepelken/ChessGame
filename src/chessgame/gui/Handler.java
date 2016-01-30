package chessgame.gui;

import chessgame.Rules;
import chessgame.Square;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Handler implements EventHandler<ActionEvent> {

	private static Square origin = null;
	
	@Override
	public void handle(ActionEvent e) {
		Square dest = (Square) e.getSource();
		
		// set origin square
		if(origin == null && dest.isOccupied()) {
			origin = dest;
			// add orange border around selected origin square
			if(origin.isBlack()) {
				origin.setStyle(Style.BLACK_SQUARE_SELECTED);
			} else if(origin.isWhite()){
				origin.setStyle(Style.WHITE_SQUARE_SELECTED);
			}
		} else if(origin != null){ // then this click is for destination square
			
			// remove orange border, restore default square color
			if(origin.isBlack()) {
				origin.setStyle(Style.BLACK_SQUARE);
			} else if(origin.isWhite()){
				origin.setStyle(Style.WHITE_SQUARE);
			}
			
			// check for valid move and execute move
			if(origin.getPiece().isValidMove(origin.getRow(), origin.getCol(), 
							dest.getRow(), dest.getCol())) {
				
				if(dest.getPiece() != null) {
					// if there is a destination piece and it is not the same color as origin piece
					if(origin.getPiece().getColor() != dest.getPiece().getColor()) {
						executeMove(dest);
					} else {
						// do not move
					}
				} else {
					executeMove(dest); // if moving to an empty square then execute the move
				}
			}
				
			origin = null; // clear
		}
	}
	
	// check rules and attempt to execute a move
	private void executeMove(Square dest) {
		//if(Rules.checkPawnCapture(origin, dest)) {
			dest.setPiece(origin.removePiece());
		//}
	}
}
