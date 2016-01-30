package chessgame;

import chessgame.gui.GUI;

public class Game {
	public static void main(String[] args) {
		// init two players
		Player white = new Player("WHITE");
		Player black = new Player("BLACK");
		
		GUI.launch(args); // launch java fx application
	}
}
