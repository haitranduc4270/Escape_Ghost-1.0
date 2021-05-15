package Actor;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import GUI.MainGame;

public class Monster extends ShortRange {
	protected int BurnRanger = 48;
	protected int heal ;
	 
	public Monster(MainGame MainGame) {  
		super(MainGame);
		x = 150; 
		y = 350; 
		this.HP = 4000;  
		this.type = 1; // 1 monster 
		this.speed = 3;
		this.atk = 3;
		this.defense = 100;
		this.heal = 100;
		this.MP = 200; 
	}
	 
	
	   public void keyPressed(KeyEvent e) {
		     int key = e.getKeyCode();
		     switch (key) {
		  case KeyEvent.VK_W: 
		   dy = -this.speed;
		   this.setStatus(this.UP);
		   break;
		  case KeyEvent.VK_S: 
		   dy = this.speed;
		   this.setStatus(this.DOWN);
		   break;
		  case KeyEvent.VK_A:
		   dx = -this.speed; 
		   this.setStatus(this.LEFT);
		   image = image_l;
		   break;
		  case KeyEvent.VK_D:   
		   dx = this.speed;
		   this.setStatus(this.RIGHT);
		   image = image_r;
		   break; 
		  case KeyEvent.VK_B:
			  if(this.MP < 10) break;
			  if(main.getGhost().dead == false) {
				  this.setX(this.main.getGhost().getX()-3);
				  this.setY(this.main.getGhost().getY()-3);
				  this.setMP(this.getMP() - 10);
			  }
			  break;
		  case KeyEvent.VK_N:
			  if(this.MP < 20) break;
			  if((main.getGhost().getHP() < main.getGhost().getMax_HP()) && (main.getGhost().dead == false)) {
				  if (main.getGhost().getHP() + this.getHeal() >= main.getGhost().getMax_HP() ) {
					  this.setHP(this.getHP() - (main.getGhost().getMax_HP() - main.getGhost().getHP()));
					  main.getGhost().setHP(main.getGhost().getMax_HP());
					  this.setMP(this.getMP() - 20);
					  break;
				  } 
				  else {
					  this.main.getGhost().setHP(this.main.getGhost().getHP()+this.heal);
					  this.setHP(this.getHP() - this.heal);  
					  this.setMP(this.getMP() - 20);
					  break;
				  }
				  
			  }
			  break;
		  }
	   }
		  public void keyReleased(KeyEvent e) {
		     int key = e.getKeyCode();
		     switch (key) {
		  case KeyEvent.VK_W:
		   dy = 0;	   
		   break;
		  case KeyEvent.VK_S:
		   dy = 0;
		   break;
		  case KeyEvent.VK_A:
		   dx = 0;
		   break;
		  case KeyEvent.VK_D:
		   dx = 0;
		   break;
		  case KeyEvent.VK_B:
			  break;
		  case KeyEvent.VK_N:
			  break;
		
		  } 
		 } 


	

		public void loadImage () {
			ImageIcon il = new ImageIcon("src//image//Monster_L.png");
			image_l = il.getImage();  
			ImageIcon ir = new ImageIcon("src//image//Monster_R.png");
			image_r = ir.getImage();  
			ImageIcon iu = new ImageIcon("src//image//Monster_U.png");
			image_u = iu.getImage();  
			ImageIcon id = new ImageIcon("src//image//Monster_D.png");
			image_d = id.getImage();   
			
		}


		public int getHeal() {
			return heal;
		}


		public void setHeal(int heal) {
			this.heal = heal;
		}


		public int getBurnRanger() {
			return BurnRanger;
		}
		  
		
		
		
		 
}
