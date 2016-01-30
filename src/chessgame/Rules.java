package chessgame;

public class Rules {
	/*
	 * SPECIAL CASES AND RULES
	 */
	public static void checkForCheckmate() {
		
	}
	
	// returns true if legal pawn move
	public static boolean checkPawnCapture(Square origin, Square dest) {
		
		if(dest.isOccupied()) {
			if(origin.getCol() == dest.getCol()) {
				return false; // pawn can not take moving forwards
			} else {
				return true; // pawn can take diagonally
			}
		} else if(origin.getCol() != dest.getCol()){
			return false;
		}
		
		
		return true;
	}
	
	public static void checkPawnPromotion() {
		
	}
	
	public static void checkCastle() {
		
	}
}
