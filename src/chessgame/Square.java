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
		this.color = color;
		setPiece(piece);
	}
	
	private void setPiece(Piece p){
		this.piece = p;
	}
	private boolean checkOccupied(){
		return piece!=null;
	}
}
