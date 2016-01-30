package chessgame.gui;

public abstract class Style {
	// colors
	public static final String BLACK_HEX = "#595959;";
	public static final String WHITE_HEX = "#f2f2f2;";
	public static final String SELECTED_HEX = "#ff9900;";
	
	public static final String BLACK_SQUARE = 		
			"-fx-base: " + BLACK_HEX // sets color
			+"-fx-background-insets: 0;" // removes shadow
			+"-fx-background-radius: 0;" // removes rounded corners
			+"-fx-border-width: 1px;"; // border width
	public static final String WHITE_SQUARE = 
			"-fx-base: " + WHITE_HEX // sets color
			+"-fx-background-insets: 0;" // removes shadow
			+"-fx-background-radius: 0;" // removes rounded corners
			+"-fx-border-width: 1px;";  // border width
	public static final String BLACK_SQUARE_SELECTED = BLACK_SQUARE + "-fx-border-color: " + SELECTED_HEX + "-fx-border-width: 3px";
	public static final String WHITE_SQUARE_SELECTED = WHITE_SQUARE + "-fx-border-color: " + SELECTED_HEX + "-fx-border-width: 3px";
}
