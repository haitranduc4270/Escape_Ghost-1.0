package Actor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyAdapter extends KeyAdapter {
	
	private Monster Monster;
	private Ghost Ghost; 
	
	
	public MyAdapter(Monster Monster, Ghost Char) {

		this.Monster = Monster;
		this.Ghost = Char;
	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		Monster.keyPressed(e);
		Ghost.keyPressed(e);
	
	}
	@Override
	public void keyReleased(KeyEvent e) {
	
		Monster.keyReleased(e);
		Ghost.keyReleased(e);
	
	}
	}