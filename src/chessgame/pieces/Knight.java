package chessgame.pieces;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Knight extends Piece {

	public Knight(Color color) {
		super(color);
	}

	@Override
	public boolean isValidMove(int originRow, int originCol, int destRow, int destCol) {
		if((originCol - 2 == destCol) && (originRow + 1 == destRow))
			return true;
		if((originCol - 2 == destCol) && (originRow - 1 == destRow))
			return true;
		if((originCol + 2 == destCol) && (originRow + 1 == destRow))
			return true;
		if((originCol + 2 == destCol) && (originRow - 1 == destRow))
			return true;
		if((originCol + 1 == destCol) && (originRow - 2 == destRow))
			return true;
		if((originCol + 1 == destCol) && (originRow + 2 == destRow))
			return true;
		if((originCol - 1 == destCol) && (originRow + 2 == destRow))
			return true;
		if((originCol - 1 == destCol) && (originRow - 2 == destRow))
			return true;
		
		return false;
	}

	@Override
	public Image getImage() {
		if(color == Color.BLACK) {
			return loadImage("/res/knightb.png");
		} else {
			return loadImage("/res/knightw.png");
		}
	}

}
