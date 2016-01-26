package chessgame.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Handler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent e) {
		Button b = (Button) e.getSource();
		b.setStyle("-fx-base: #a5e763"); // temp
	}

}
