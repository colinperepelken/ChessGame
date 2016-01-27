package chessgame;



import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import chessgame.pieces.Piece;

public class Square extends Button{
	private Color color; // black or white square
	private Piece piece; // should be null if square is unoccupied

	public Square(Color color){
		this.color = color;
	}
	
	public Square(Color color, Piece piece) {
		this(color);
		setPiece(piece);
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
}
