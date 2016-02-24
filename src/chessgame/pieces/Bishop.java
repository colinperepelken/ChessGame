package chessgame.pieces;

import chessgame.gui.GUI;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Bishop extends Piece {

	public Bishop(Color color) {
		super(color);
	}

	@Override
	public boolean isValidMove(int originRow, int originCol, int destRow, int destCol) {
		if(Math.abs(destCol - originCol) == Math.abs(destRow - originRow)) {
			int i = originRow;
			int j = originCol;
			while(i < destRow) {
				i++;
				if(j < destCol) j++;
				else j--;
				if(GUI.board[i][j].isOccupied()) return false;
			}
			while(i > destRow) {
				i--;
				if(j < destCol) j++;
				else j--;
				if(GUI.board[i][j].isOccupied()) return false;
			}
			return true; // no pieces blocking path
		}
		return false;
	}

	@Override
	public Image getImage() {
		if(color == Color.BLACK) {
			return loadImage("/res/bishopb.png");
		} else {
			return loadImage("/res/bishopw.png");
		}
	}
	
}
