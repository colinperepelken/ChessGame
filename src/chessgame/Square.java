package chessgame;

import chessgame.pieces.Piece;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Square extends Button{
	private String color; // black or white square
	private Piece piece; // should be null if square is unoccupied
	private int row, col;
	
	public Square(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	public void setPiece(Piece piece){
		this.piece = piece;
		if(piece != null)
			setGraphic(new ImageView(piece.getImage()));
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	// returns piece then sets to null
	public Piece removePiece() {
		Piece p = piece;
		piece = null;
		setGraphic(null); // clear square image
		return p;
	}

	public boolean isOccupied(){
		return piece != null;
	}
	
	
	// getters and setters
	public int getRow() { return row; }
	public int getCol() { return col; }
	public void setRow(int row) { this.row = row; }
	public void setCol(int col) { this.col = col; }
	public String getColor() { return color; }
	public void setColor(String color) { this.color = color; }
}
