package chessgame.pieces;

import chessgame.gui.GUI;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class King extends Piece {
	private boolean moved = false;
	
	public King(Color color) {
		super(color);
	}

	@Override
	public boolean isValidMove(int originRow, int originCol, int destRow, int destCol) {
		// if distance to new point is only one then it is valid
		if(Math.abs(destRow - originRow) <= 1 && Math.abs(destCol - originCol) <= 1) {
			moved = true;
			return true;
		} else if(destRow == originRow) { // castle
			if(GUI.board[destRow][destCol].getPiece() instanceof Rook) {
				if(destCol - originCol == 3) { // castle to right
					if(!GUI.board[destRow][destCol - 1].isOccupied() && !GUI.board[destRow][originCol + 1].isOccupied()) {
						return true;	
					}
				} else if(originCol - destCol == 4) { // castle to left
					if(!GUI.board[destRow][originCol - 1].isOccupied() && !GUI.board[destRow][originCol - 2].isOccupied()
							&& !GUI.board[destRow][originCol - 3].isOccupied()) {
						return true;
					}
				}
			}
		}
		
		
		return false;
	}
	
	public boolean hasMoved() {
		return moved;
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
