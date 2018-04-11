package UI;
	
import java.net.URL;

import gamePackage.AtidGame;
import gamePackage.NumberGame;
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
		NumberGame game = new AtidGame(100);

		try {
			URL url = getClass().getResource("GameUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: GameUI.fxml");
				Platform.exit();
			}
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = loader.load();
			GameController controller = loader.getController();

			controller.setGame(game);

			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.setTitle("Click Counter");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
//		GuessView guess = new GuessView(game);
//		game.addObserver(guess);
//		guess.run();
//		
//		CounterView counter = new CounterView(game);
//		game.addObserver(counter);
//		counter.run();


	}
	

	
	public static void main(String[] args) {
		launch(args);
	}
}
