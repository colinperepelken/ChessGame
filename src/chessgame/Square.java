package chessgame;

import java.awt.Color;

import javafx.scene.control.Button;
import chessgame.pieces.Piece;

public class Square extends Button{
	private Color color; // black or white square
	private Piece piece; // should be null if square is unoccupied
	
	public Square(Color color, Piece piece) {
		this.color = color;
		this.piece = piece;
	}
	private boolean isOccupied = false;
	private void setOccupied(boolean s){
		isOccupied = s;
	}
	private boolean checkOccupied(){
		
	}
}
