package Actor;

import java.awt.Image;

import javax.swing.ImageIcon;

import GUI.MainGame;


public abstract class Actor {
	protected int dx;
	protected int dy;
	protected int x; 
	protected int y;

	
	protected Image image_d;
	protected Image image_u;
	protected Image image_l;
	protected Image image_r;
	
	protected Image image;
	
	protected int Status;
	protected int UP = 1; 
	protected int DOWN = 2; 
	protected int LEFT = 3; 
	protected int RIGHT = 4; 
	protected boolean dead = false;
	
	protected int type;
	protected int HP, Max_HP;
	protected int MP, Max_MP;
	protected int defaultSpeed, speed;
	protected int defense;
	protected int atk;

	protected MainGame main;
	
	public Actor(MainGame MainGame) {
		 this.main = MainGame;
	}
	
	public abstract void loadImage(); 
	
	public void move() {
		if ( ((dx>0)&&(x>=713-this.getWidth())) || ((dx<0)&&(x<=0)) ) return;
		else x += dx;  
		/* *****xetvacham****** */
		if(dx>0) { 
			if ((main.getMaps().getMap()[y/(main.getBOX_SIZE())][(x+this.getWidth())/(main.getBOX_SIZE())] >= 3 )||(main.getMaps().getMap()[(y+this.getHeight())/24][(x+this.getWidth())/(main.getBOX_SIZE())] >= 3)) { 
				x-=dx;  
				return; 
			}   
		}
		if (dx<0) { 
			if((main.getMaps().getMap()[y/(main.getBOX_SIZE())][x/(main.getBOX_SIZE())] >= 3) || (main.getMaps().getMap()[(y+this.getHeight())/(main.getBOX_SIZE())][x/(main.getBOX_SIZE())] >=3)) {
				x-=dx;
				return;  
			}
		} 
		
		/* ******xetvacham***** */
		if ( ((dy>0)&&(y>=473-this.getHeight())) || ((dy<0)&&(y<=0)) ) return;
		else y += dy;
		 
		/* *****xetVSmap******* */ 
		if(dy>0) {
			if ((main.getMaps().getMap()[(y+this.getHeight())/(main.getBOX_SIZE())][x/(main.getBOX_SIZE())] >= 3) || (main.getMaps().getMap()[(y+this.getHeight())/(main.getBOX_SIZE())][(x+this.getWidth())/(main.getBOX_SIZE())]) >= 3) {
				y-=dy;
				return;
			}
		}
		
		if(dy<0) {
			if ((main.getMaps().getMap()[y/(main.getBOX_SIZE())][x/(main.getBOX_SIZE())] >=3 ) || (main.getMaps().getMap()[y/(main.getBOX_SIZE())][(x+this.getWidth())/(main.getBOX_SIZE())] >=3 )) {
				y-=dy;
				return;
			}
		}
		
		/* **********xetVSmap********** */
	
}
	
	
	
	public int getX() {
		return x;
    	}

    public int getY() {
        return y;
    }
    public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public Image getImage() {
        return image;
    }
    
    public void setMainGame (MainGame main) {
    	this.main = main;
    }
    
    public MainGame getMainGame () {
    	return this.main;
    }
    
    public void setDead (boolean a) {
    	this.dead = a;
    }
    
    public boolean getDead () {
    	return this.dead;
    }
	
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
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
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	public boolean isDead() {
		return dead;
	}
	public int getMP() {
		return MP;
	}
	public void setMP(int mP) {
		MP = mP;
	}


	public int getMax_HP() {
		return Max_HP;
	}


	public int getMax_MP() {
		return Max_MP;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getDefaultSpeed() {
		return defaultSpeed;
	}


	public void setDefaultSpeed(int defaultSpeed) {
		this.defaultSpeed = defaultSpeed;
	}

	public void Kill () {
		this.setDead(true);
		x = 760;
		y = 530;
	}
    
    
    
    
    
}
