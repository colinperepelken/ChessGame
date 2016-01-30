package chessgame.pieces;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Pawn extends Piece {

	public Pawn(Color color) {
		super(color);
	}

	@Override
	public boolean isValidMove(int originRow, int originCol, int destRow, int destCol) {
		if(destCol == originCol) {
			if(color == Color.BLACK) {
				if((originRow + 1) == destRow) return true; // move 1 down on board
				if(originRow == 1 && originRow + 2 == destRow) return true; // can move 2 for first move
			} else if(color == Color.WHITE) {
				if((originRow - 1) == destRow) return true; // move 1 up on board
				if(originRow == 6 && originRow - 2 == destRow) return true; // can move 2 for first move
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
