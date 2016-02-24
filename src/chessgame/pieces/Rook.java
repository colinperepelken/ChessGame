package chessgame.pieces;

import chessgame.gui.GUI;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Rook extends Piece {

	public Rook(Color color) {
		super(color);
	}
	
	@Override
	public boolean isValidMove(int originRow, int originCol, int destRow, int destCol) {
		// if destination point is on the same row or column it is a valid move
		if(originRow == destRow || originCol == destCol) {
			int i = originRow;
			int j = originCol;
			
			while(i < destRow) {
				i++;
				if(GUI.board[i][j].isOccupied()) return false;
			}
			while(i > destRow) {
				i--;
				if(GUI.board[i][j].isOccupied()) return false;
			}
			while(j < destCol) {
				j++;
				if(GUI.board[i][j].isOccupied()) return false;
			}
			while(j > destCol) {
				j--;
				if(GUI.board[i][j].isOccupied()) return false;
			}
			
			return true; // no pieces blocking path
		}
		
		return false;
	}

	@Override
	public Image getImage() {
		if(color == Color.BLACK) {
			return loadImage("/res/rookb.png");
		} else {
			return loadImage("/res/rookw.png");
		}
	}

	
}
