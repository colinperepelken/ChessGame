package chessgame.gui;

import chessgame.Square;
import chessgame.pieces.King;
import chessgame.pieces.Rook;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Handler implements EventHandler<ActionEvent> {

	private static Square origin = null;
	private Square dest;
	
	@Override
	public void handle(ActionEvent e) {
		dest = (Square) e.getSource();
		
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
						executeMove();
					} else {
						checkForCastle(); // check if player is trying to castle
					}
				} else {
					executeMove(); // if moving to an empty square then execute the move
				}
			}
				
			origin = null; // clear
		}
	}
	
	// will check for and execute a player castling
	private void checkForCastle() {
		if(origin.getPiece() instanceof King && dest.getPiece() instanceof Rook) {
			if(!((King)origin.getPiece()).hasMoved() && !((Rook)dest.getPiece()).hasMoved()) {
				if(dest.getCol() > origin.getCol()) { // if castling to right
					GUI.board[dest.getRow()][dest.getCol() - 1].setPiece(origin.removePiece());
					GUI.board[origin.getRow()][origin.getCol() + 1].setPiece(dest.removePiece());
				} else { // if castling to left
					GUI.board[dest.getRow()][origin.getCol() - 2].setPiece(origin.removePiece());
					GUI.board[origin.getRow()][origin.getCol() - 1].setPiece(dest.removePiece());
				}
			}
		}
	}
	
	private void executeMove() {
			dest.setPiece(origin.removePiece());
	}
}
