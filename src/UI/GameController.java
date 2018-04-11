package UI;



import java.util.Optional;

import gamePackage.AtidGame;
import gamePackage.NumberGame;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * Controller of gussing game and counter
 * @author Atid Srisukhantapuek
 */
public class GameController {
	@FXML
	private TextField guessTextFleld;
	@FXML
	private Button enterButton;
	@FXML
	private Label hint;
	@FXML
	private Label count;
	private NumberGame game;
	private CounterView counter = new CounterView(game);
	

	/**
	 *Set game and counter
	 *@param number game
	 * 
	 */
	public void setGame(NumberGame game) {
		this.game = game;
		counter.setCounter(game);
	}
	
	
	/**
	 * Show result of gussing from user input 
	 */
	public void enterClickHandler(ActionEvent event) {
		int guessNum = -1;
		String guess = "";
		try {
			 guess = guessTextFleld.getText().trim();
			guessNum = Integer.parseInt(guess);
			boolean correct = game.guess(guessNum);
			count.setText("count :" + game.getCount());
			if(correct) {
				hint.setText(game.getMessage());
				guessTextFleld.clear();
				guessTextFleld.setEditable(false);
				resetGame();
				
			}else {
				hint.setText(game.getMessage());
				guessTextFleld.clear();
				}
			
			game.addObserver(counter);
			counter.run();
			
		} catch (NumberFormatException e) {

			 Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.setTitle("Error ");
	            alert.setHeaderText("Invalid input!!");
	            alert.setContentText("Input is not a number: "+guess);
	            alert.showAndWait();
		} 
	}
	
	/**
	 * Show secret number of number game 
	 */
	public void giveUpHandler() {

		hint.setText("The secret number is "+game.getSecretNumber());
		
	}
	
	
	/**
	 * Rest number game 
	 * 
	 */
	public void resetGame() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Correct!!");
		alert.setHeaderText("Do you want to play again?");
		alert.setContentText(game.getMessage());
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			game = new AtidGame(100);
			counter.setCounter(game);
			hint.setText("");
			guessTextFleld.setEditable(true);

		} else {
			Platform.exit();
		}
	}

	
}
