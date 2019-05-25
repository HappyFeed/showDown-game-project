package ui;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import threads.IntroThread;

public class Main extends Application{
    
	public static Stage stage;
	
	public static void main(String[] args) 
	{
		
		
		launch();
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void start(Stage stage) throws Exception {
		
		Main.stage= new Stage();
       Parent root=FXMLLoader.load(getClass().getResource("Intro.fxml"));
        Parent roota=FXMLLoader.load(getClass().getResource("Menu.fxml"));

        Scene scene1= new Scene(root);
        Scene scene= new Scene(roota);
        scene1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent clicked) {
                if(clicked.getClickCount() == 1) {
                    Main.stage.setScene(scene);
                    
                }
            }
        });
		Main.stage.setTitle("Pokemon Showdown v2");
		Main.stage.setScene(scene1);
		Main.stage.getIcons().add(new Image("ui/icono.png"));
		Main.stage.show();
		
		IntroThread introthread = new IntroThread();
		introthread.start();
	
		Platform.runLater(introthread);
	}
     
}

