package chessgame.gui;

import chessgame.Square;
import chessgame.pieces.King;
import chessgame.pieces.Piece;
import chessgame.pieces.Rook;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

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
	
	private boolean isKingInCheck(Color colorOfKing) {
		// first find position of relevant king
		int kingRow = 0, kingCol = 0;
		for(int row = 0; row < 8; row++) {
			for(int col = 0; col < 8; col++) {
				if(GUI.board[row][col].isOccupied()) {
					if(GUI.board[row][col].getPiece() instanceof King) {
						if(GUI.board[row][col].getPiece().getColor() == colorOfKing) {
							kingRow = row;
							kingCol = col;
						}
					}
				}
			}
		}
		
		// check if each piece of opposite color has a valid move to the king
		for(int row = 0; row < 8; row++) {
			for(int col = 0; col < 8; col++) {
				Square s = GUI.board[row][col];
				if(s.isOccupied()) {
					if(colorOfKing != s.getPiece().getColor()) {
						if(s.getPiece().isValidMove(row, col, kingRow, kingCol)) {
							return true; // king is in check
						}
					}
				}
			}
		}
		return false; // king is not in check
	}
	
	private void executeMove() {
		Piece p = null;
		if(dest.isOccupied()) {
			p = dest.getPiece(); // store piece in case move must be reverted
		}

		dest.setPiece(origin.removePiece());
		if(isKingInCheck(dest.getPiece().getColor())) { // move must be reverted
			System.out.println("Can't move there. King would be in check.");
			origin.setPiece(dest.getPiece());
			dest.setPiece(p);
		} else {
			if(dest.getPiece().getColor() == Color.BLACK) {
				if(isKingInCheck(Color.WHITE)) {
					System.out.println("Check");
				}
			} else {
				if(isKingInCheck(Color.BLACK)) {
					System.out.println("Check");
				}
			}
		}
	}
}
