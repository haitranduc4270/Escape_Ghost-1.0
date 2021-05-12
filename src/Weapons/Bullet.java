package Weapons;

import java.awt.Image;

import javax.swing.ImageIcon;

import Actor.LongRange;

public class Bullet {
	
	@SuppressWarnings("unused")
	private LongRange longRange;
	
	private int x;
	private int y;
	private Image image;
	 
	private int speed=20; 
	
	private Image image_u;
	private Image image_d;
	private Image image_l;
	private Image image_r;
	
	private int status ;
	
	
	
	
	public Bullet () {
		loadImage();
		image = image_r;
	}

	public void setLongRange (LongRange longRange) {
		this.longRange = longRange;
	}
	
	public void loadImage () {
		ImageIcon up = new ImageIcon ("src//image//bullet_u.png");
		image_u = up.getImage();
		
		ImageIcon down = new ImageIcon ("src//image//bullet_d.png");
		image_d = down.getImage();
	
		ImageIcon left = new ImageIcon ("src//image//bullet_l.png");
		image_l = left.getImage();
	
		ImageIcon right = new ImageIcon ("src//image//bullet_r.png");
		image_r = right.getImage();
	
	}
	 
	public Image getImage () {
		return image;
	}
	
	public void setImage (int a) {
		switch (a)
		{
		case 1:
			image = image_u;
			status = 1;
			break;
		case 2:
			image = image_d;
			status = 2;
			break;
		case 3:
			image = image_l;
			status = 3;
			break;
		case 4:
			image = image_r;
			status = 4;
			break;
		}
	}
	
	public void move () {
		switch (status) {
		case 1:
			y-=speed;
			break;
		case 2:
			y+=speed;
			break;
		case 3:
			x-=speed;
			break;
		case 4:
			x+=speed;
			break;
		}
		
	}

	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getWidth () {
		ImageIcon icon = new ImageIcon();
		icon.setImage(image);
		return icon.getIconWidth();
	}
	
	public int getHeight () {
		ImageIcon icon = new ImageIcon();
		icon.setImage(image);
		return icon.getIconHeight();
		
	}
	
	
}
