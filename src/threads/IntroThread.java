package threads;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class IntroThread extends Thread {

	public IntroThread() {
	
		
	}
	
	@Override
	public void run() {
        try {
        	Stage stage= new Stage();

        	Parent root=FXMLLoader.load(getClass().getResource("/fxml/Intro.fxml"));
            Parent roota=FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));

            Scene scene1= new Scene(root);
            Scene scene= new Scene(roota);
            scene1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent clicked) {
                    if(clicked.getClickCount() == 1) {
                        stage.setScene(scene);
                        
                    }
                }
            });
    		stage.setTitle("Pokemon Showdown v2");
    		stage.setScene(scene1);
    		stage.getIcons().add(new Image("ui/icono.png"));
    		stage.show();
			
			sleep(3000);
			
			stage.setScene(scene);

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		
	}

}
