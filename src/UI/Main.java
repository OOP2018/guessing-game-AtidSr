package UI;
	
import java.net.URL;

import counter.Counter;
import defaultPackage.AtidGame;
import defaultPackage.NumberGame;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.fxml.FXMLLoader;

/**
 * Create a JavaFX user interface with 1 input view
 * and 2 observers that show the counter value, so that all
 * the views refer to the same Counter object.
 * 
 */
public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		// Create the Counter object (the "model" part of our app)
		NumberGame game = new AtidGame(100);

		try {
			URL url = getClass().getResource("GameUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: GameUI.fxml");
				Platform.exit();
			}
			// Load the FXML and get reference to the loader
			FXMLLoader loader = new FXMLLoader(url);
			// Create the UI. This will instantiate the controller object, too.
			Parent root = loader.load();
			// Now we can get the controller object from the FXMLloader.
			// This is interesting -- we don't need to use a cast!
			GameController controller = loader.getController();
			
			// Dependency Injection:
			// Set the Counter object we want the view to update.
			controller.setGame(game);

			//TODO set a reference to Counter in the controller

			// Build and show the scene
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.setTitle("Click Counter");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}


	}
	

	
	public static void main(String[] args) {
		launch(args);
	}
}
