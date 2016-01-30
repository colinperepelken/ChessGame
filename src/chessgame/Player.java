package chessgame;

public class Player {
	private boolean check = false; // is the player in check
	private boolean turn = false; // is it this players turn
	private String color;
	
	public Player(String color) {
		this.color = color;
	}
	
	public boolean isWhite() {
		return color.equals("WHITE");
	}
	public boolean isBlack() {
		return color.equals("BLACK");
	}
	
	// getters and setters
	public boolean inCheck() { return check; }
	public void setCheckValue(boolean check) { this.check = check; }
	public boolean isTurn() { return turn; }
	public void setTurn(boolean turn) { this.turn = turn; }
}
