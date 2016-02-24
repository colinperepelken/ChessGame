package chessgame.pieces;

import chessgame.gui.GUI;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Pawn extends Piece {

	public Pawn(Color color) {
		super(color);
	}

	@Override
	public boolean isValidMove(int originRow, int originCol, int destRow, int destCol) {
		if(destCol == originCol) {
			if(!GUI.board[destRow][destCol].isOccupied()) { // if the pawn is moving forward the destination must not be occupied
				if(color == Color.BLACK) {
					if(!GUI.board[originRow + 1][destCol].isOccupied()) { // check that there is no piece in the way
						if((originRow + 1) == destRow) return true; // move 1 down
						if(originRow == 1 && originRow + 2 == destRow) return true; // can move 2 for first move
					}
				} else if(color == Color.WHITE) {
					if(!GUI.board[originRow - 1][destCol].isOccupied()) { // check that there is no piece in the way
						if((originRow - 1) == destRow) return true; // move 1 up on board
						if(originRow == 6 && originRow - 2 == destRow) return true; // can move 2 for first move
					}	
				}
			}
			
			// Handler class checks if the victim piece is opposite color so don't have to worry about that
		} else if(Math.abs(destCol - originCol) == 1) { // else if it is taking a piece diagonally
			if(color == Color.BLACK) {
				if(originRow + 1 == destRow) {
					if(GUI.board[destRow][destCol].isOccupied()) return true; // must be taking a piece to move diagonally
				}
			} else if(color == Color.WHITE) {
				if(originRow - 1 == destRow) {
					if(GUI.board[destRow][destCol].isOccupied()) return true;
				}
			}
		}

		return false;
	}

	@Override
	public Image getImage() {
		if(color == Color.BLACK) {
			return loadImage("/res/pawnb.png");
		} else {
			return loadImage("/res/pawnw.png");
		}
	}

}
