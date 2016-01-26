package chessgame.pieces;

import javafx.scene.paint.Color;

public class Pawn extends Piece {

	@Override
	public boolean isValidMove(int originRow, int originCol, int destRow, int destCol) {
		if(destCol == originCol) {
			if(color == Color.BLACK) {
				if((originRow + 1) == destRow) return true; // move 1 down on board
			} else if(color == Color.WHITE) {
				if((originRow - 1) == destRow) return true; // move 1 up on board
			}
		}

		return false;
	}

}
