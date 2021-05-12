package Actor;

import GUI.MainGame;

public abstract class ShortRange extends Actor {
	 
	
	public ShortRange(MainGame MainGame) {  
		super(MainGame);
		this.loadImage();
		image = this.image_l;
		this.dead = false;
	}
			 
}
