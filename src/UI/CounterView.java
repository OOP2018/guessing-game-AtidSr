package UI;

import java.util.Observable;

import gamePackage.NumberGame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * A Controller for a window that shows the value of a Counter.
 * This has only one component (but you can add more components),
 * so write it in code instead of FXML.
 *
 */
public class CounterView implements java.util.Observer {
	/** the stage (top-level window) for showing scene */
	private Stage stage;
	/** a counter to show value of */
	private NumberGame counter;
	/** the label that shows the counter value. */
	private Label label;
	
	/**
	 * Initialize a CounterView, which shows value of a counter.
	 * @param counter the Counter to show.
	 */
	public CounterView(NumberGame counter) {
		this.counter = counter;
		initComponents();
	}
	
	private void initComponents() {
		stage = new Stage();
		// components and containers for our window
		HBox root = new HBox();
		//TODO Set some padding around the HBox
		root.setPadding(new Insets(10));
		//TODO Align components in center of the HBox
		root.setAlignment(Pos.CENTER);
		// The label that will show the counter value.
		label = new Label("   ");
		// make the label big enough
		label.setPrefWidth(144);
		//TODO Make the text BIG. Use setFont to create a font.
		//TODO Be careful to import the correct Font class (not java.awt.Font).
		label.setFont(new Font("Arial", 80.0));
		//TODO Set the text alignment to CENTER
		label.setAlignment(Pos.CENTER);
		// Add the label to the HBox.  You can all more components, too.
		root.getChildren().add(label);
		// Create a Scene using HBox as the root element
		Scene scene = new Scene(root);
		// show the scene on the stage
		stage.setScene(scene);
		stage.setTitle("Count");
		stage.sizeToScene();
	}
	
	/** Show the window and update the counter value. */
	public void run() {
		stage.show();
		displayCount();
	}
	/**Set counter of Number game*/
	public void setCounter(NumberGame game) {
		this.counter = game;
	}
	
	/**Display count number*/
	public void displayCount() {
		label.setText( String.format("%2d", counter.getCount()) );
	}

	@Override
	public void update(Observable o, Object arg) {
		displayCount();
	}	
}
