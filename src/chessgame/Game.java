package chessgame;

public class Game {
	private static boolean running = false;
	private Board board;
	
	public Game() {
		board = new Board(); // init board
		running = true;
		run();
	}
	
	private void run() {
		while(running) { // main game loop
			// player chooses piece to move
			
			// piece makes legal move with capture logic
			
			// check for checkmate/stalemate
		}
	}
	
	// will take arguments to move a piece
	private static void move() {
		
	}
	
	public static void main(String[] args) {
		new Game();
	}
}
