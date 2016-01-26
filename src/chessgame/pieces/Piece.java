package chessgame.pieces;

import javafx.scene.paint.Color;

public abstract class Piece {
	protected Color color; // black or white
	
	public abstract boolean isValidMove(int originRow, int originCol, int destRow, int destCol);
	public void setColor(Color color) { this.color = color; }
	public Color getcolor() { return color; }
}
