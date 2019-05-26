package threads;



public class IntroThread extends Thread {

	public IntroThread() {
	
        /*try {
        	
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
			
			sleep(4000);
			
			Main.stage.setScene(scene);

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}*/
	}
	
	@Override
	public void run() {


		
	}

}
