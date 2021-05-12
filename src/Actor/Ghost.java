package Actor;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import GUI.MainGame;

public class Ghost extends LongRange {
	 
	public Ghost(MainGame maingame) {
		super(maingame);
		this.loadImage();
		image = image_d;  

		x = 125;   
		y = 350; 
		
		this.type = 2; // char
		
		this.Max_HP = 1000;
		this.Max_MP = 4;
		
		
		this.speed = 6;
		this.HP = 1000;
		this.MP = 2;
		this.atk = 400; 
		
	}
	
	public void loadImage () {
		ImageIcon i0 = new ImageIcon("src//image//char_front.png");
		image_d = i0.getImage();

		ImageIcon i1 = new ImageIcon("src//image//char_back.png");
		image_u = i1.getImage();

		ImageIcon i2 = new ImageIcon("src//image//char_left.png");
		image_l = i2.getImage();

		ImageIcon i3 = new ImageIcon("src//image//char_right.png");
		image_r = i3.getImage();
	}
 

	public void keyPressed(KeyEvent e) { 
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_UP:
			dy = -this.speed;
			image = image_u;
			this.Status = this.UP;
			break;
		case KeyEvent.VK_DOWN:
			dy = this.speed;
			image = image_d;
			this.Status = this.DOWN;
			break;
		case KeyEvent.VK_LEFT:
			dx = -this.speed;
			image = image_l; 
			this.Status = this.LEFT;
			break;
		case KeyEvent.VK_RIGHT:
			dx = this.speed;
			image = image_r; 
			this.Status = this.RIGHT;
			break;
		case KeyEvent.VK_ENTER:
			ban = true;
			break;
		}

	}


	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_UP:
			dy = 0;
			break;
		case KeyEvent.VK_DOWN:
			dy = 0;
			break;
		case KeyEvent.VK_LEFT:
			dx = 0;
			break;
		case KeyEvent.VK_RIGHT:
			dx = 0;
			break;
		case KeyEvent.VK_ENTER:
			ban = false;
			break;
		}
	}

	
	
}
