package chessgame.pieces;

public class Bishop extends Piece {

	@Override
	public boolean isValidMove(int originRow, int originCol, int destRow, int destCol) {
		if(destRow != originRow && destCol != originCol) {
			
		}
		return false;
	}
	
}
