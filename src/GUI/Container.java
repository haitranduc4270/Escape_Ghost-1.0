package GUI;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Container extends JPanel {

	private static final String TAG_MAINGAME = "tag_maingame";
	private static final String TAG_TUTORIAL = "tag_tutoria";
	private static final String TAG_MENU = "tag_menu";
	private static final String TAG_END = "tag_END";
	
	private MainGame MainGame;
	private Tutorial Tutorial;
	private Menu Menu;
	private End End;
	
	private CardLayout CardLayout;
	
	 
	public Container () {
		super();
		setBackground(Color.WHITE);
		CardLayout = new CardLayout();
		setLayout(CardLayout);
		Tutorial = new Tutorial(this);
		add(Tutorial, TAG_TUTORIAL);
		Menu = new Menu(this);
		add(Menu, TAG_MENU);
		End = new End (this);
		add(End, TAG_END);
		setShowMenu();
	}
	


	public void setShowPlay(int mode){
		MainGame = new MainGame(this, mode); 
		add(MainGame, TAG_MAINGAME);
		CardLayout.show(Container.this, TAG_MAINGAME); 
		MainGame.requestFocus();
		MainGame.getTimer().start();
	}
	
	public void setShowTutorial(){
		CardLayout.show(Container.this, TAG_TUTORIAL);
		Tutorial.requestFocus();
	}
	
	public void setShowMenu(){
		CardLayout.show(Container.this, TAG_MENU);
		Menu.requestFocus();
	}
	
	public void setShowEnd() {
		CardLayout.show(Container.this, TAG_END);
		MainGame.getTimer().stop();
		End.requestFocus();
	}

  

	public MainGame getMainGame() {
		return MainGame;
	}
	public void setMainGame(MainGame mainGame) {
		MainGame = mainGame;
	}

	
	
}
