package chessgame.pieces;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Queen extends Piece {

	public Queen(Color color) {
		super(color);
	}

	@Override
	public boolean isValidMove(int originRow, int originCol, int destRow, int destCol) {
		if(new Rook(this.getColor()).isValidMove(originRow, originCol, destRow, destCol)
				|| new Bishop(this.getColor()).isValidMove(originRow, originCol, destRow, destCol)) {
			return true;
		}
		return false;
	}

	@Override
	public Image getImage() {
		if(color == Color.BLACK) {
			return loadImage("/res/queenb.png");
		} else {
			return loadImage("/res/queenw.png");
		}
	}
}
