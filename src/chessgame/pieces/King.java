package chessgame.pieces;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class King extends Piece {

	public King(Color color) {
		super(color);
	}

	@Override
	public boolean isValidMove(int originRow, int originCol, int destRow, int destCol) {
		// if distance to new point is only one then it is valid
		if(Math.abs(destRow - originRow) <= 1 && Math.abs(destCol - originCol) <= 1)
			return true;
		
		return false;
	}

	@Override
	public Image getImage() {
		if(color == Color.BLACK) {
			return loadImage("/res/kingb.png");
		} else {
			return loadImage("/res/kingw.png");
		}
	}
	
}
