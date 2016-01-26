package chessgame.pieces;

public class Rook extends Piece {

	@Override
	public boolean isValidMove(int originRow, int originCol, int destRow, int destCol) {
		// if destination point is on the same row or column it is a valid move
		if(originRow == destRow || originCol == destCol) return true;
		
		return false;
	}

	
}
