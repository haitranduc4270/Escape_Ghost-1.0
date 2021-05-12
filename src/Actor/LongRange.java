package Actor;

import java.awt.Graphics;
import java.util.ArrayList;

import GUI.MainGame;
import Weapons.Bullet;

public abstract class LongRange extends Actor {
	protected boolean ban = false;
	protected ArrayList <Bullet> Bullets;  
	
	public LongRange(MainGame maingame) {	
		super (maingame);
		this.loadImage();
		image = image_d;   
		this.dead = false;
		this.Bullets = new ArrayList <Bullet> ();
		this.main = maingame;
	}
	
	public abstract void loadImage (); 
	
	public void drawBullet (Graphics g) {
		if((this.isBan()) && Bullets.size() <= this.getMP()) {
			MP--;
			Bullet Bullet = new Bullet();
			Bullet.setLongRange(this); 
			Bullets.add(Bullet);
			switch (this.getStatus()) { 
			case 1:  
				Bullet.setImage(1); 
				Bullet.setX(this.getX()+11);
				Bullet.setY(this.getY()-20);
				g.drawImage(Bullet.getImage(), this.getX()+11, this.getY()-20,this.main);
				break;
			case 2: 
				Bullet.setImage(2);
				Bullet.setX(this.getX()+11);
				Bullet.setY(this.getY()+24);
				g.drawImage(Bullet.getImage(), this.getX()+11, this.getY()+24,this.main);
				break;
			case 3:
				Bullet.setImage(3);
				Bullet.setX(this.getX()-20);
				Bullet.setY(this.getY()+11);
				g.drawImage(Bullet.getImage(), this.getX()-20, this.getY()+11,this.main);
				break;
			case 4:
				Bullet.setImage(4);
				Bullet.setX(this.getX()+24);
				Bullet.setY(this.getY()+10);
				g.drawImage(Bullet.getImage(), this.getX()+24, this.getY()+10,this.main);
				break;
		
			}
		}
		  
		else {
			for (Bullet Bullet : Bullets) {	
				if((Bullet.getX()>=720)||(Bullet.getX()<=0)||(Bullet.getY()<=0)||Bullet.getY()>=480) {
				Bullets.remove(Bullet);
				MP++;
				break;
			}
			Bullet.move();
			g.drawImage(Bullet.getImage(), Bullet.getX(), Bullet.getY(), this.main);
		}
	}
}

	public ArrayList<Bullet> getBullets() {
		return Bullets;
	}

	public void setBullets(ArrayList<Bullet> bullets) {
		Bullets = bullets;
	}


	public boolean isBan() {
		return ban;
	}

	public void setBan(boolean ban) {
		this.ban = ban;
	}
	

	

		
	

	
}
