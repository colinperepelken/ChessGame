package chessgame;

import java.awt.Color;

import chessgame.pieces.Piece;

public class Square {
	private Color color; // black or white square
	private Piece piece; // should be null if square is unoccupied
	
	public Square(Color color, Piece piece) {
		this.color = color;
		this.piece = piece;
	}
}
