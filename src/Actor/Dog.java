package Actor;

import java.util.Random;

import javax.swing.ImageIcon;

import GUI.MainGame;

public class Dog  extends ShortRange {

	public Dog(MainGame MainGame) {
		super(MainGame); 
		this.loadImage(); 
		x = 650; 
		y = 200;  
		this.HP = 200;   
		this.defaultSpeed = 5;
		this.type = 5; // dog
		this.speed = defaultSpeed;
		this.atk = 5;
		this.defense = 100;
		this.MP = 1;
		this.Max_MP = 4;
		
	}
	
	public void moveDog() {
		Random randomMove = new Random();
		int Move = randomMove.nextInt(40) ;
		switch (Move) { 
		case 1:
			if ((this.Status==this.LEFT)||(this.Status==this.RIGHT)) dx=0;
			if (this.Status==this.UP) break;
			dy = -this.speed; 
			this.Status = this.UP; 
			this.image = this.image_u;
			break;
		case 15: 
			if ((this.Status==this.LEFT)||(this.Status==this.RIGHT)) dx=0;
			if (this.Status==this.DOWN) break;
			dy = +this.speed;
			this.Status = this.DOWN; 
			this.image = this.image_d;
			break; 
		case 25: 
			if (this.Status==this.LEFT) break;
			dx = -this.speed;
			this.Status = this.LEFT;
			this.image = this.image_l;
			break; 
		case 30:
			if (this.Status==this.RIGHT) break;
			dx = +this.speed;
			this.Status = this.RIGHT;
			this.image = this.image_r;
			break; 
		} super.move(); 
	}
	
	
	
	
	@Override
	public void loadImage() {
		ImageIcon iu = new ImageIcon("src//image//Dog_d.png");
		this.image_d = iu.getImage();
		ImageIcon id = new ImageIcon("src//image//Dog_u.png");
		this.image_u = id.getImage(); 
		ImageIcon il = new ImageIcon("src//image//Dog_l.png");
		this.image_l = il.getImage(); 
		ImageIcon ir = new ImageIcon("src//image//Dog_r.png");
		this.image_r = ir.getImage(); 
		
		this.image = this.image_d;
	}

}
