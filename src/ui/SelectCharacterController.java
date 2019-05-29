package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import customeExceptions.BigNameException;
import customeExceptions.NoDataException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.StageStyle;
import model.Game;

public class SelectCharacterController {

	 private ArrayList<Image> avatars;
	 private Image img;
	 public static final String PATH = "pic/avatars.csv";
	
    @FXML
    private Button character1;

    @FXML
    private Button character2;

    @FXML
    private Button character3;

    @FXML
    private Button character10;

    @FXML
    private Button character9;

    @FXML
    private Button character4;

    @FXML
    private Button character5;

    @FXML
    private Button character6;

    @FXML
    private Button character7;

    @FXML
    private Button character8;

    @FXML
    private Button character11;

    @FXML
    private Button character12;

    @FXML
    private Button character13;

    @FXML
    private Button character14;

    @FXML
    private Button character15;

    @FXML
    private Button character16;

    @FXML
    private Button next;

    @FXML
    private Button back;

    @FXML
    private Button nextPage;

    @FXML
    private Button backPage;
    
    @FXML
    private Button saveButton;
    
    @FXML
    private TextField namePlayers;
    
    @FXML
    private Label selectPlayer;
    
    @FXML
    private Label pages;

    private Game g;
    
    /*This method allow load game
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Game loaded
	 */
    
    public void recibirGame(Game newGame) throws IOException {
    	g= newGame;
    	loadAvatars();
    	showAvatars();
    }
    
    @FXML
    /*This method allow initialize scene
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: scene initialized
	 */
    
    void initialize() {
    	next.setVisible(false);
    	selectPlayer.setText("1");
    }
    
    @FXML
    
    /*This method allow save players
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Players saved
	 */
    void savePlayers(ActionEvent event) {   	
    	try {
			if(g.addPlayer(namePlayers.getText(), img)==true) {
				Alert score = new Alert(AlertType.INFORMATION);
			    score.setTitle("FinalFinal5EnElProyecto-Game");
			    score.initStyle(StageStyle.DECORATED);
			    score.setContentText("Saved");
			    score.show();
			    namePlayers.setText("");
			    selectPlayer.setText("2");
			    img=null;
			    if(g.getFirstPlayer().getNextPlayer()!=null) {
			        saveButton.setVisible(false);
			    	next.setVisible(true);
			    	namePlayers.setVisible(false);	
			    	selectPlayer.setText("Not more");
			    }
			}
		} catch (BigNameException bne ) {
			Alert score = new Alert(AlertType.ERROR);
		    score.setTitle("FinalFinal5EnElProyecto-Game");
		    score.initStyle(StageStyle.DECORATED);
		    score.setContentText(bne.getMessage());
		    score.show();
		    namePlayers.setText("");			
		}catch(NoDataException nde) {
			Alert score = new Alert(AlertType.ERROR);
		    score.setTitle("FinalFinal5EnElProyecto-Game");
		    score.initStyle(StageStyle.DECORATED);
		    score.setContentText(nde.getMessage());
		    score.show();
		    namePlayers.setText("");			
		}
    }
    
    @FXML
    /*This method allow go to back page
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Go to back page
	 */
    
    void backPage(ActionEvent event) throws IOException {
        int newPage= Integer.parseInt(pages.getText())-1;
        if(newPage>0) {
        	pages.setText(newPage+"");
        	clearData();
        	showAvatars();
        }
    }

    @FXML
    
    /*This method allow go to next page
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Go to next page
	 */
    
    void nextPage(ActionEvent event) throws IOException {
    	int newPage= Integer.parseInt(pages.getText())+1;
        if(newPage<(50/16)+2) {
        	pages.setText(newPage+"");
        	clearData();
        	showAvatars();
        }
    }
    
    @FXML
    
    /*This method allow go to back stage
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Go to back stage
	 */
    void backToStage(ActionEvent event) {
    	
    
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	


    }


    /*This method allow go to next stage
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Go to next stage
	 */
    @FXML
    void nextToStage(ActionEvent event) {
		try {
			FXMLLoader loader= new FXMLLoader(getClass().getResource("SelectTeam.fxml"));
			Parent root=loader.load();
			SelectTeamController stc= (SelectTeamController) loader.getController();
	    	stc.setPlayers(g.getFirstPlayer(),g); 
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	

    }
    
    /*This method allow select character
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Character selected
	 */

    @FXML
    void selectThisCharacter1(ActionEvent event) {
      if(pages.getText().equals("1")) {
    	  img=avatars.get(0);
      }else if(pages.getText().equals("2")) {
    	  img=avatars.get(16);
      }else  if(pages.getText().equals("3")){
    	  img=avatars.get(32);
      }else {
    	  img=avatars.get(48);
      }
      
      character1.setVisible(false);
    }
    
    /*This method allow select character
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Character selected
	 */

    @FXML
    void selectThisCharacter10(ActionEvent event) {
        if(pages.getText().equals("1")) {
        	  img=avatars.get(9);
          }else if(pages.getText().equals("2")) {
        	  img=avatars.get(25);
          }else {
        	  img=avatars.get(41);
          }
        
        character10.setVisible(false);

    }
    
    /*This method allow select character
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Character selected
	 */

    @FXML
    void selectThisCharacter11(ActionEvent event) {
        if(pages.getText().equals("1")) {
      	  img=avatars.get(10);
        }else if(pages.getText().equals("2")) {
      	  img=avatars.get(26);
        }else {
      	  img=avatars.get(42);
        }
        
        character11.setVisible(false);

    }
    
    /*This method allow select character
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Character selected
	 */

    @FXML
    void selectThisCharacter12(ActionEvent event) {
        if(pages.getText().equals("1")) {
        	  img=avatars.get(11);
          }else if(pages.getText().equals("2")) {
        	  img=avatars.get(27);
          }else {
        	  img=avatars.get(43);
          }
        
        character12.setVisible(false);

    }
    
    /*This method allow select character
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Character selected
	 */

    @FXML
    void selectThisCharacter13(ActionEvent event) {
        if(pages.getText().equals("1")) {
      	  img=avatars.get(12);
        }else if(pages.getText().equals("2")) {
      	  img=avatars.get(28);
        }else {
      	  img=avatars.get(44);
        }
        
        character13.setVisible(false);

    }
    
    /*This method allow select character
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Character selected
	 */

    @FXML
    void selectThisCharacter14(ActionEvent event) {
        if(pages.getText().equals("1")) {
        	  img=avatars.get(13);
          }else if(pages.getText().equals("2")) {
        	  img=avatars.get(29);
          }else {
        	  img=avatars.get(45);
          }
        
        character14.setVisible(false);

    }
    
    /*This method allow select character
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Character selected
	 */

    @FXML
    void selectThisCharacter15(ActionEvent event) {
        if(pages.getText().equals("1")) {
      	  img=avatars.get(14);
        }else if(pages.getText().equals("2")) {
      	  img=avatars.get(30);
        }else {
      	  img=avatars.get(46);
        }
        
        character15.setVisible(false);

    }
    
    /*This method allow select character
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Character selected
	 */

    @FXML
    void selectThisCharacter16(ActionEvent event) {
        if(pages.getText().equals("1")) {
      	  img=avatars.get(15);
        }else if(pages.getText().equals("2")) {
      	  img=avatars.get(31);
        }else {
      	  img=avatars.get(47);
        }
        
        character16.setVisible(false);

    }
    
    /*This method allow select character
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Character selected
	 */

    @FXML
    void selectThisCharacter2(ActionEvent event) {
        if(pages.getText().equals("1")) {
      	  img=avatars.get(1);
        }else if(pages.getText().equals("2")) {
      	  img=avatars.get(17);
        }else  if(pages.getText().equals("3")){
      	  img=avatars.get(33);
        }else {
      	  img=avatars.get(49);
        }
        
        character2.setVisible(false);

    }
    
    /*This method allow select character
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Character selected
	 */

    @FXML
    void selectThisCharacter3(ActionEvent event) {
        if(pages.getText().equals("1")) {
        	  img=avatars.get(2);
          }else if(pages.getText().equals("2")) {
        	  img=avatars.get(18);
          }else {
        	  img=avatars.get(34);
          }
        
        character3.setVisible(false);

    }
    
    /*This method allow select character
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Character selected
	 */

    @FXML
    void selectThisCharacter4(ActionEvent event) {
        if(pages.getText().equals("1")) {
      	  img=avatars.get(3);
        }else if(pages.getText().equals("2")) {
      	  img=avatars.get(19);
        }else {
      	  img=avatars.get(35);
        }
        
        character4.setVisible(false);

    }
    
    /*This method allow select character
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Character selected
	 */

    @FXML
    void selectThisCharacter5(ActionEvent event) {
        if(pages.getText().equals("1")) {
        	  img=avatars.get(4);
          }else if(pages.getText().equals("2")) {
        	  img=avatars.get(20);
          }else {
        	  img=avatars.get(36);
          }
        
        character5.setVisible(false);

    }
    
    /*This method allow select character
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Character selected
	 */

    @FXML
    void selectThisCharacter6(ActionEvent event) {
        if(pages.getText().equals("1")) {
        	  img=avatars.get(5);
          }else if(pages.getText().equals("2")) {
        	  img=avatars.get(21);
          }else {
        	  img=avatars.get(37);
          }
        
        character6.setVisible(false);

    }
    
    /*This method allow select character
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Character selected
	 */

    @FXML
    void selectThisCharacter7(ActionEvent event) {
        if(pages.getText().equals("1")) {
      	  img=avatars.get(6);
        }else if(pages.getText().equals("2")) {
      	  img=avatars.get(22);
        }else {
      	  img=avatars.get(38);
        }
        
        character7.setVisible(false);

    }
    
    /*This method allow select character
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Character selected
	 */

    @FXML
    void selectThisCharacter8(ActionEvent event) {
        if(pages.getText().equals("1")) {
        	  img=avatars.get(7);
          }else if(pages.getText().equals("2")) {
        	  img=avatars.get(23);
          }else {
        	  img=avatars.get(39);
          }
        
        character8.setVisible(false);

    }
    
    /*This method allow select character
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Character selected
	 */

    @FXML
    void selectThisCharacter9(ActionEvent event) {
        if(pages.getText().equals("1")) {
      	  img=avatars.get(8);
        }else if(pages.getText().equals("2")) {
      	  img=avatars.get(24);
        }else {
      	  img=avatars.get(40);
        }
        
        character9.setVisible(false);

    }
    
    /*This method allow load avatar
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Avatars loaded
	 */
    
	public void loadAvatars() throws IOException {
		File file = new File(PATH);
		 avatars= new ArrayList<Image>();
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		String line = br.readLine();
		line = br.readLine();
		while(line != null){
			String[] parts = line.split(",");
			URL url = new URL(parts[0]);
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);	
			avatars.add(img);
			line = br.readLine();
		}
		fileReader.close();		
		br.close();
	
	}
	
	/*This method allow show avatars
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Avatars showed
	 */
	
    public void showAvatars() throws IOException {
    	List<Button>b=addButtons();
    	int pagesN=avatars.size()/16;
    	if(avatars.size()%16>0) {
    		pagesN+=1;
    	}
    	Boolean flag=true;
    	for(int j=0;j<pagesN&&flag;j++){    	
    		if(j+1==Integer.parseInt(pages.getText())){    
    	    	int bottonN=0;
    			for (int i = (16*j); i <16+(16*j) && i<avatars.size(); i++) {
    	    			if(i>=b.size()) {
    	    				b.get(bottonN).setVisible(true);
    	    				b.get(bottonN).setBackground(new Background(new BackgroundImage(avatars.get(i),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));  
    	    				bottonN++;
    	    				if(bottonN>=b.size()) {
    	    					bottonN=0;
    	    				}
    	    				
    	    			}else {
    	    				b.get(i).setVisible(true);
    	    				b.get(i).setBackground(new Background(new BackgroundImage(avatars.get(i),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT))); 
    	    			}
    		    }
    	    	flag=false;
    	    }
		}
    }
    
    /*This method allow clean data
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: Data cleaned
	 */
    
    public void clearData() {
    	character1.setVisible(false);
    	character2.setVisible(false);
    	character3.setVisible(false);
    	character4.setVisible(false);
    	character5.setVisible(false);
    	character6.setVisible(false);
    	character7.setVisible(false);
    	character8.setVisible(false);
    	character9.setVisible(false);
    	character10.setVisible(false);
    	character11.setVisible(false);
    	character12.setVisible(false);
    	character13.setVisible(false);
    	character14.setVisible(false);
    	character15.setVisible(false);
    	character16.setVisible(false);
    }
    
    /*This method allow create a list of buttom with the character
	 * @pre: game != null
	 * @param: ActionEvent event
	 * @return: This method return void
	 * @post: List of buttoms 
	 */
    
    public List<Button> addButtons() {
    	List<Button> l= new ArrayList<Button>();
    	l.add(character1);
    	l.add(character2);
    	l.add(character3);
    	l.add(character4);
    	l.add(character5);
    	l.add(character6);
    	l.add(character7);
    	l.add(character8);
    	l.add(character9);
    	l.add(character10);
    	l.add(character11);
    	l.add(character12);
    	l.add(character13);
    	l.add(character14);
    	l.add(character15);
    	l.add(character16);
    	return l;
    }
    
}

