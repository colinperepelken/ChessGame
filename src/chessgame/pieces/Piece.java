package chessgame.pieces;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public abstract class Piece {
	protected Color color; // black or white
	private int row, col; // location of the piece
	
	// constructor to set color of piece
	public Piece(Color color) {
		this.color = color;
	}
	
	// instantiates and returns appropriate piece given row and column on board (starting position)
	public static Piece loadPiece(int row, int col) {
		Piece p = null;
		
		if(row == 1) {
			p = new Pawn(Color.BLACK);
		} else if(row == 6) {
			p = new Pawn(Color.WHITE);
		} else if(row == 7) {
			if(col == 0 || col == 7) p = new Rook(Color.WHITE);
			if(col == 1 || col == 6) p = new Knight(Color.WHITE);
			if(col == 2 || col == 5) p = new Bishop(Color.WHITE);
			if(col == 3) p = new Queen(Color.WHITE);
			if(col == 4) p = new King(Color.WHITE);
		} else if(row == 0) {
			if(col == 0 || col == 7) p = new Rook(Color.BLACK);
			if(col == 1 || col == 6) p = new Knight(Color.BLACK);
			if(col == 2 || col == 5) p = new Bishop(Color.BLACK);
			if(col == 3) p = new Queen(Color.BLACK);
			if(col == 4) p = new King(Color.BLACK);
		}
		return p;
	}
	
	// load an image from resources
	protected Image loadImage(String path) {
		try {
			return new Image(getClass().getResourceAsStream(path));
		} catch(Exception e) {
			System.out.println("Error fetching piece image.\n\n");
			e.printStackTrace();
			return null;
		}
	}
	
	public abstract Image getImage();
	public abstract boolean isValidMove(int originRow, int originCol, int destRow, int destCol);
	public void setColor(Color color) { this.color = color; }
	public Color getcolor() { return color; }
	
	// row and column getters and setters
	public int getRow() { return row; }
	public int getCol() { return col; }
	public void setRow(int row) { this.row = row; }
	public void setCol(int col) { this.col = col; }
}
