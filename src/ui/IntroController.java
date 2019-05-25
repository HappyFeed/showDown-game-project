package ui;





import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class IntroController{

    @FXML
    private MediaView mediaView;
    private  MediaPlayer mediaPlayer;
	private  Media media;
	public void initialize() throws Exception {
		
		 media= new Media(getClass().getResource("video.mp4").toExternalForm());
	     mediaPlayer = new MediaPlayer(media);
	     mediaPlayer.setAutoPlay(true);
	     
	     Duration time= new Duration(10000);
	     Duration timeToStop= new Duration(13000);
	     mediaPlayer.setStartTime(time);
	     mediaPlayer.setStopTime(timeToStop); 

	     mediaPlayer.seek(time);
	     mediaView.setMediaPlayer(mediaPlayer);
	     mediaPlayer.play();
	     
	     mediaView.setOnMouseClicked(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent clicked) {
	                if(clicked.getClickCount() == 1) {
	                    
	                    mediaPlayer.stop();
	                }
	            }
	        });
	     
	     if(mediaPlayer.getStatus().equals(MediaPlayer.Status.STOPPED)) {
	    	 

	            Parent roota=FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
	            Scene scene= new Scene(roota);
	    		Main.stage.setScene(scene);
	    		
	    	 
	    	 
	     }
	       
	        
	      
	}

}
