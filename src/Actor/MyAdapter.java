package Actor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import GUI.MainGame;

public class MyAdapter extends KeyAdapter {
	
	private Monster Monster;
	private Ghost Ghost; 
	private MainGame MainGame;
	
	
	public MyAdapter(Monster Monster, Ghost Char, MainGame MainGame) {
		this.MainGame = MainGame;
		this.Monster = Monster;
		this.Ghost = Char;
	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyTyped(e);
		Monster.keyPressed(e);
		Ghost.keyPressed(e);
		MainGame.keyPressed(e);
	
	}
	@Override
	public void keyReleased(KeyEvent e) {
		super.keyTyped(e);
		Monster.keyReleased(e);
		Ghost.keyReleased(e);
	
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		super.keyTyped(e);
	
	}
	
	}