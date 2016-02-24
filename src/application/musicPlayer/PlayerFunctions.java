package application.musicPlayer;
import java.nio.file.Paths;

import application.view.Main;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PlayerFunctions implements Runnable{
	Thread th;
	String song = Paths.get("//Users/daniel/Documents/javayh/kurs4/kurs4WorkSpace/MusicPlayer/src/application/resources/music/NahkoAndMedicineForThePeople/DarkAsNight/AlohaKeAkuna.mp3").toUri().toString();
	Media hit;
	MediaPlayer mp;
	Main mn;
	
	//An instance of media player has been made
	public static boolean running=false;
	
	//The instance of media player has been paused or not.
	public static boolean pause=false;
	
	public static boolean isRunning() {
		return running;
	}

	public static void setRunning(boolean trueOrFalse) {
		running = trueOrFalse;
	}

	public PlayerFunctions(){
		th = new Thread(this);
		hit = new Media(song);
		mp = new MediaPlayer(hit);
	}
	
	public void startSong(){
		setRunning(true);
		th.start();
	}
	
	public void pauseSong(){
		setRunning(false);
		mp.pause();
		try {
			th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(running){
			mp.play();
		}
	}
}
