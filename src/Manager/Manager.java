package Manager;

import java.util.ArrayList;

import Weapons.Bullet;
import Actor.Dog;
import Actor.Hunter;
import GUI.MainGame;



public class Manager {
	
	private MainGame MainGame;
	private ArrayList <Bullet> BulletC;
	
	 
	public Manager (MainGame MainGame) {
		this.MainGame = MainGame;
	 	this.BulletC = MainGame.getGhost().getBullets();
		 
		
	}
	
	public void checkDogBiteChar() {
		for (Dog Dog : this.MainGame.getMaps().getDogs()) {
			if (  	(MainGame.getGhost().getX() >=  (Dog.getX() - MainGame.getGhost().getWidth())) &&
					(MainGame.getGhost().getX() <=  (Dog.getX() + MainGame.getMonster().getWidth())) &&
					(MainGame.getGhost().getY() >=  (Dog.getY() - MainGame.getGhost().getHeight())) &&
					(MainGame.getGhost().getY() <=  (Dog.getY() + MainGame.getMonster().getHeight()))
					) {
				MainGame.getGhost().setHP(MainGame.getGhost().getHP() - Dog.getAtk());
			} 
			if (  	(MainGame.getMonster().getX() >=  (Dog.getX() - MainGame.getGhost().getWidth())) &&
					(MainGame.getMonster().getX() <=  (Dog.getX() + MainGame.getMonster().getWidth())) &&
					(MainGame.getMonster().getY() >=  (Dog.getY() - MainGame.getGhost().getHeight())) &&
					(MainGame.getMonster().getY() <=  (Dog.getY() + MainGame.getMonster().getHeight()))
					) {
				MainGame.getMonster().setHP(MainGame.getMonster().getHP() - Dog.getAtk());
			}
		}
		
	}
	
	public boolean CharVSMonster() {
		if (  	(MainGame.getGhost().getX() >=  (MainGame.getMonster().getX() - MainGame.getGhost().getWidth())) &&
				(MainGame.getGhost().getX() <=  (MainGame.getMonster().getX() + MainGame.getMonster().getWidth())) &&
				(MainGame.getGhost().getY() >=  (MainGame.getMonster().getY() - MainGame.getGhost().getHeight())) &&
				(MainGame.getGhost().getY() <=  (MainGame.getMonster().getY() + MainGame.getMonster().getHeight()))
				) return true;
				 
		
		
		return false;
	}
	
	public boolean MonsterVSBullet () {  
		
		for (Bullet Bullet : BulletC) {	  
			if ( 
				(   (Bullet.getX() >=  (MainGame.getMonster().getX() - Bullet.getWidth())) &&
					(Bullet.getX() <=  (MainGame.getMonster().getX() + MainGame.getMonster().getWidth())) &&
					(Bullet.getY() >=  (MainGame.getMonster().getY() - Bullet.getHeight())) &&
					(Bullet.getY() <=  (MainGame.getMonster().getY() + MainGame.getMonster().getHeight()))))
				{	
				MainGame.getMonster().setHP(MainGame.getMonster().getHP() + MainGame.getMonster().getDefense() - MainGame.getGhost().getAtk());
				BulletC.remove(Bullet);
				this.MainGame.getGhost().setMP(this.MainGame.getGhost().getMP() + 1);
				return true;
			}
		} 
		return false;
	
	}
	
	
	public boolean HunterShoot_Monster () {
		for (Hunter Hunter : MainGame.getMaps().getHunters()) {
			
			for(Bullet Bullet : Hunter.getBullets() ) {
				if ( 
						(   (Bullet.getX() >=  (MainGame.getMonster().getX() - Bullet.getWidth())) &&
							(Bullet.getX() <=  (MainGame.getMonster().getX() + MainGame.getMonster().getWidth())) &&
							(Bullet.getY() >=  (MainGame.getMonster().getY() - Bullet.getHeight())) &&
							(Bullet.getY() <=  (MainGame.getMonster().getY() + MainGame.getMonster().getHeight()))))
						{	
						
						MainGame.getMonster().setHP(MainGame.getMonster().getHP() + MainGame.getMonster().getDefense() - Hunter.getAtk());
						Hunter.getBullets().remove(Bullet);
						Hunter.setMP(Hunter.getMP()+1);
						return true; 
					} 
				} 
			
			} return false;

	}
	
	public boolean HunterShoot_Ghost () {
		for (Hunter Hunter : MainGame.getMaps().getHunters()) {
			for(Bullet Bullet : Hunter.getBullets() ) { 
				if ( 
						(   (Bullet.getX() >=  (MainGame.getGhost().getX() - Bullet.getWidth())) &&
							(Bullet.getX() <=  (MainGame.getGhost().getX() + MainGame.getGhost().getWidth())) &&
							(Bullet.getY() >=  (MainGame.getGhost().getY() - Bullet.getHeight())) &&
							(Bullet.getY() <=  (MainGame.getGhost().getY() + MainGame.getGhost().getHeight()))))
						{	
						
						MainGame.getGhost().setHP(MainGame.getGhost().getHP() + MainGame.getGhost().getDefense() - Hunter.getAtk());
						Hunter.getBullets().remove(Bullet); 
						Hunter.setMP(Hunter.getMP() + 1);
						return true;
					}
				}
			}return false;
		}

	public boolean IsHunterwasShooted (Hunter Hunter) {
		
			for (Bullet Bullet : this.MainGame.getGhost().getBullets()) {
				 
				if ( 
						(   (Bullet.getX() >=  (Hunter.getX() - Bullet.getWidth())) &&
							(Bullet.getX() <=  (Hunter.getX() + Hunter.getWidth())) &&
							(Bullet.getY() >=  (Hunter.getY() - Bullet.getHeight())) &&
							(Bullet.getY() <=  (Hunter.getY() + Hunter.getHeight()))))
						{	
							this.MainGame.getGhost().getBullets().remove(Bullet); 
							this.MainGame.getGhost().setMP(this.MainGame.getGhost().getMP()+1);
							return true;
							
						}	
				} return false; 

		}
		
	
		public void CheckMonsterBurnHunter (Hunter Hunter) {
			if (  	
					(Hunter.getX() >=  (MainGame.getMonster().getX() - MainGame.getMonster().getBurnRanger() - Hunter.getWidth())) &&
					(Hunter.getX() <=  (MainGame.getMonster().getX() + MainGame.getMonster().getBurnRanger() + MainGame.getMonster().getWidth())) &&
					(Hunter.getY() >=  (MainGame.getMonster().getY() - MainGame.getMonster().getBurnRanger() - Hunter.getHeight())) &&
					(Hunter.getY() <=  (MainGame.getMonster().getY() + MainGame.getMonster().getBurnRanger() + MainGame.getMonster().getHeight()))
					) {
				Hunter.setHP(Hunter.getHP() -  MainGame.getMonster().getAtk());
				Hunter.setSpeed(1);
				return;
			}
			Hunter.setSpeed(Hunter.getDefaultSpeed());
			return; 
		} 

		public boolean IsDogwasShooted (Dog Dog) {
			
			for (Bullet Bullet : this.MainGame.getGhost().getBullets()) {
				 
				if ( 
						(   (Bullet.getX() >=  (Dog.getX() - Bullet.getWidth())) &&
							(Bullet.getX() <=  (Dog.getX() + Dog.getWidth())) &&
							(Bullet.getY() >=  (Dog.getY() - Bullet.getHeight())) &&
							(Bullet.getY() <=  (Dog.getY() + Dog.getHeight()))))
						{	
							this.MainGame.getGhost().getBullets().remove(Bullet); 
							this.MainGame.getGhost().setMP(this.MainGame.getGhost().getMP()+1);
							return true;
							
						}	
				} return false; 

		}
		
		public void CheckMonsterBurnDog (Dog Dog) {
			if (  	
					(Dog.getX() >=  (MainGame.getMonster().getX() - MainGame.getMonster().getBurnRanger() - Dog.getWidth())) &&
					(Dog.getX() <=  (MainGame.getMonster().getX() + MainGame.getMonster().getBurnRanger() + MainGame.getMonster().getWidth())) &&
					(Dog.getY() >=  (MainGame.getMonster().getY() - MainGame.getMonster().getBurnRanger() - Dog.getHeight())) &&
					(Dog.getY() <=  (MainGame.getMonster().getY() + MainGame.getMonster().getBurnRanger() + MainGame.getMonster().getHeight()))
					) {
				Dog.setHP(Dog.getHP() -  MainGame.getMonster().getAtk());
				Dog.setSpeed(1);
				return;
			}
			Dog.setSpeed(Dog.getDefaultSpeed());
			return; 
		} 
		
}

		





		

	
	
	
	
	
