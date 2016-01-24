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
			/*
			 * player chooses piece to move... piece is highlighted/selected
			 * player chooses destination
			 * validity of destination is checked (can the piece legally move there?)
			 * piece makes a legal move with capture logic
			 * check for checkmate/stalemate
			 */
		}
	}
	
	// will take arguments to move a piece
	private static void move() {
		
	}
}
