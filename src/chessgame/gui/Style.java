package chessgame.gui;

public abstract class Style {
	public static final String BLACK_SQUARE = 		
			"-fx-base: #595959;" // sets color
			+"-fx-background-insets: 0;" // removes shadow
			+"-fx-background-radius: 0;" // removes rounded corners
			+"-fx-border-width: 1px;";  // border width
	public static final String WHITE_SQUARE = 
			"-fx-base: #f2f2f2;" // sets color
			+"-fx-background-insets: 0;" // removes shadow
			+"-fx-background-radius: 0;" // removes rounded corners
			+"-fx-border-width: 1px;";  // border width
	public static final String BLACK_SQUARE_SELECTED = BLACK_SQUARE + "-fx-border-color: #ff9900; -fx-border-width: 3px";
	public static final String WHITE_SQUARE_SELECTED = WHITE_SQUARE + "-fx-border-color: #ff9900; -fx-border-width: 3px";
}
