package application.view;

import application.musicPlayer.PlayerFunctions;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class Main extends Application{

	@FXML Button playBtn;
	@FXML ImageView btnImg;
	PlayerFunctions pf;
	
	@FXML
	public void initialize(){
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			scene.setOnKeyPressed((KeyEvent)->keyBoardHandler(KeyEvent) );
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@FXML
	public void keyBoardHandler(KeyEvent ke){
		if(ke.getCode()==ke.getCode().S){
			if(PlayerFunctions.isRunning()){
				stopSongThread();
			}
			else{
				//stopSongThread();
				startSongThread();
			}
		}
	}
	
	@FXML
	public void startSongThread(){
		if(PlayerFunctions.isRunning()==false){
			pf = new PlayerFunctions();
			pf.startSong();
		}
		else{pf.pauseSong();}
	}
	
	@FXML
	public void stopSongThread(){
		if(PlayerFunctions.isRunning()==true){
			pf.pauseSong();
		}
	}
}
