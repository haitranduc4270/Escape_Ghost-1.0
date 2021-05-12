package Actor;

import java.util.Random;

import javax.swing.ImageIcon;

import GUI.MainGame;

public class Hunter extends LongRange { 
	
	public Hunter(MainGame main) {
		super(main); 
		this.loadImage();  
		x = 650; 
		y = 200;  
		this.HP = 400;  
		this.defaultSpeed = 5;
		this.type = 3; // 3 hunter 
		this.speed = defaultSpeed;
		this.atk = 50;
		this.defense = 100;
		this.MP = 1;
		this.Max_MP = 4;
		
	}
	
	
	
	public void moveHunter () {
		Random randomMove = new Random();
		int Move = randomMove.nextInt(40) ; 
		switch (Move) { 
		case 1:
			if ((this.Status==this.LEFT)||(this.Status==this.RIGHT)) dx=0;
			if (this.Status==this.UP) break;
			dy = -this.speed; 
			this.Status = this.UP;  
			break;
		case 15: 
			if ((this.Status==this.LEFT)||(this.Status==this.RIGHT)) dx=0;
			if (this.Status==this.DOWN) break;
			dy = +this.speed;
			this.Status = this.DOWN; 
			break; 
		case 25:
			if (this.Status==this.LEFT) break;
			dx = -this.speed;
			this.Status = this.LEFT;
			break; 
		case 30:
			if (this.Status==this.RIGHT) break;
			dx = +this.speed;
			this.Status = this.RIGHT;
			break;
		} super.move();
	}
	
	
	public void HunterShoot() {
		Random randomShoot = new Random();
		int Shoot = randomShoot.nextInt(10);
		switch (Shoot) {
			case 2:
				this.ban = true; 
				break;
			case 8:
				this.ban = false;
				break;
			
		}
	}



	@Override
	public void loadImage() {
		ImageIcon ii = new ImageIcon("src//image//Hunter_Right.png");
		image = ii.getImage(); 
		
	}


	
}
