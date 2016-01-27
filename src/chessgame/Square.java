package chessgame;



import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import chessgame.pieces.Piece;

public class Square extends Button{
	private Color color; // black or white square
	private Piece piece; // should be null if square is unoccupied
	private int row, col;

	public Square(Color color, int row, int col){
		this.color = color;
		this.row = row;
		this.col = col;
	}
	
	public void setPiece(Piece piece){
		this.piece = piece;
	}
	
	public Piece getPiece() {
		return piece;
	}

	public boolean isOccupied(){
		return piece != null;
	}
	
	// row and column getters and setters
	public int getRow() { return row; }
	public int getCol() { return col; }
	public void setRow(int row) { this.row = row; }
	public void setCol(int col) { this.col = col; }
}
