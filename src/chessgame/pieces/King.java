package chessgame.pieces;


public class King extends Piece {

	@Override
	public boolean isValidMove(int originRow, int originCol, int destRow, int destCol) {
		// if distance to new point is only one then it is valid
		if(Math.abs(destRow - originRow) <= 1 && Math.abs(destCol - originCol) <= 1)
			return true;
		
		return false;
	}
	
}
