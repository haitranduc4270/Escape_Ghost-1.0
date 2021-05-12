package Map;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import Actor.Dog;
import Actor.Hunter;
import GUI.MainGame;
 
public class MyMap {

	private MainGame mainGame;
	private int BOX_SIZE;
	private int Location; 
	
	private int Map[][];
	
	private ArrayList <Hunter> Hunters; 
	private int numberHunter;
	private ArrayList <Dog> Dogs;
	private int numberDog;
	 
	public MyMap (MainGame maingame) { 
		this.mainGame = maingame;
		BOX_SIZE = maingame.getBOX_SIZE();
		this.initAllMapHunter(); 
		this.initAllMapDog();
		
		
	}
	
	private ArrayList <Dog> Dogs0;
	private int numberDog0;
	private int numberHunter0;
	private ArrayList <Hunter> Hunters0;
	private int map0[][] =
		{		{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
				{10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10},
				{10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10},
				{10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10},
				{10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10},
				{10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10},
				{10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10},
				{10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10},
				{10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10},
				{10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
				{10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2}, 
				{10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
				{10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
				{10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
				{10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
				{10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10},
				{10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10},
				{10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10},
				{10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10},
				{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
				
		}; 
	
	private ArrayList <Dog> Dogs1;
	private int numberDog1;
	private int numberHunter1 ;
	private ArrayList <Hunter> Hunters1;
	private int map1[][] =
		{		{7,7,7,7,7,7,0,7,7,7,7,7,7,7,7,0,7,7,7,7,7,7,7,0,7,7,7,7,7,2},
				{7,7,7,7,7,0,0,7,7,7,0,0,0,0,0,0,0,3,8,0,0,0,0,0,7,0,0,9,0,2},
				{5,2,7,7,0,0,4,0,0,0,0,0,0,0,0,0,3,8,3,8,0,0,0,7,0,0,0,0,0,2},
				{2,5,0,0,0,0,0,0,7,0,0,0,0,0,0,3,8,8,8,9,8,7,0,0,0,0,0,0,0,2},
				{2,5,7,7,7,0,0,7,7,7,7,0,0,0,0,8,3,8,8,8,7,7,0,0,0,9,0,0,2,7},
				{0,0,5,0,0,0,0,0,0,0,0,0,0,0,3,8,8,7,8,8,8,0,0,0,0,0,7,7,0,0},
				{5,2,7,7,0,0,0,0,0,0,0,0,0,0,8,8,7,7,0,0,0,0,0,0,0,0,7,0,7,7},
				{0,5,2,7,0,0,0,0,0,0,7,0,7,8,8,0,0,0,0,0,0,0,0,0,0,0,0,0,7,0},
				{10,10,5,0,0,0,0,0,0,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,5},
				{0,0,5,0,0,0,0,7,0,0,7,0,0,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
				{0,0,5,0,0,0,0,0,0,7,0,0,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,2},
				{0,0,0,0,0,0,0,0,7,0,0,7,0,0,7,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2},
				{0,0,0,0,0,0,0,0,0,0,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2},
				{0,10,2,0,0,0,0,0,0,7,7,7,7,7,0,0,0,0,0,0,7,0,0,0,0,0,0,0,2,2},
				{0,10,0,0,0,0,0,0,0,0,7,0,0,0,0,0,0,0,0,0,7,0,7,0,0,7,0,2,0,2},
				{10,10,0,0,0,0,0,0,0,0,0,7,7,0,0,0,0,7,0,7,7,7,0,0,0,0,0,7,0,5},
				{2,5,0,0,0,0,0,0,0,0,7,0,0,0,0,0,0,0,7,0,0,7,0,7,0,0,0,0,0,5},
				{2,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,7,7,0,0,7,0,0,0,9,0,0,2,2},
				{2,5,0,0,0,0,0,0,0,0,0,0,0,0,7,0,7,0,7,0,0,0,0,7,0,0,0,0,2,2},
				{2,5,0,2,2,0,0,0,0,0,0,0,0,0,0,0,7,0,0,0,0,9,0,0,0,0,0,0,0,2},
		}; 
	private ArrayList <Dog> Dogs2;
	private int numberDog2;
	private int numberHunter2 ;
	private ArrayList <Hunter> Hunters2;
	private int map2[][] =
		{		{0,0,0,5,5,0,0,7,7,5,5,5,0,0,5,0,0,0,0,0,0,2,8,8,8,8,7,7,7,0},
				{5,5,5,5,5,5,5,5,5,7,0,0,0,0,0,0,0,0,0,0,2,2,2,2,8,8,8,4,4,4},
				{5,2,7,7,5,7,4,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,2,8,8,8,4,4},
				{2,5,0,0,0,5,5,5,5,5,5,0,0,0,0,0,0,0,5,0,5,5,0,0,7,4,8,8,8,8},
				{5,5,5,5,5,5,5,5,5,5,5,5,0,0,0,0,0,0,0,0,7,0,7,7,0,4,4,2,2,8},
				{0,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,7,0,0},
				{5,2,7,7,0,0,0,0,0,0,0,0,0,0,5,5,7,7,0,0,0,0,7,0,0,0,7,0,7,7},
				{2,5,2,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,2},
				{2,5,5,0,0,0,0,0,0,0,0,0,2,2,8,2,2,2,0,0,0,0,0,0,0,0,0,0,2,2},
				{2,2,2,0,0,0,0,0,0,0,0,2,8,8,8,2,8,2,0,0,0,0,0,0,0,0,0,0,0,2}, 
				{2,2,2,0,0,0,0,0,0,7,2,8,2,8,8,8,8,8,2,2,0,0,0,0,0,0,0,0,2,2},
				{2,2,0,0,0,0,0,0,7,2,2,8,8,2,2,8,8,7,2,0,0,0,0,0,0,0,0,0,0,2},
				{2,2,0,0,0,0,0,0,0,0,8,8,2,8,8,8,2,2,0,0,0,0,0,0,0,0,0,2,0,2},
				{2,5,2,0,0,0,0,0,0,0,0,2,2,2,7,2,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
				{2,5,5,0,0,0,0,0,0,0,7,0,0,0,2,0,0,0,0,0,7,0,7,0,0,7,0,0,2,2},
				{5,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,7,0,2},
				{2,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,2,9,2},
				{2,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,0,2,9,9},
				{2,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,9,2,9,9},
				{2,5,0,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,9,9},
		}; 
	private ArrayList <Dog> Dogs3;
	private int numberDog3;
	private int numberHunter3 ; 
	private ArrayList <Hunter> Hunters3;
	private int map3[][] =
		{		{7,7,7,7,10,0,0,0,0,0,0,10,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7},
				{7,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,0,0,0,7,0,0,0,0,0,0,7},
				{8,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,0,0,0,0,0,7,0,7,7},
				{8,8,8,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,0,0,0,0,0,7,7},
				{5,2,8,8,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,0,7},
				{8,8,8,8,0,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,0,0,7,0,0,7,0,7},
				{5,8,2,8,8,8,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,7},
				{8,8,8,2,0,8,8,0,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,0,0,0,0,7},
				{2,0,0,2,2,2,8,8,8,8,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,0,7},
				{2,0,0,0,0,2,2,2,8,8,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
				{2,0,0,0,0,0,2,2,2,8,8,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,7,0,0,8},
				{2,2,0,0,0,0,0,2,0,2,8,8,8,8,2,0,2,8,0,0,0,0,0,0,0,0,0,0,8,8},
				{2,0,2,0,0,0,0,0,0,0,0,0,2,8,2,2,8,8,8,8,2,0,0,0,0,0,2,2,8,7},
				{2,0,0,0,0,0,0,0,0,0,0,2,0,2,8,8,8,2,2,8,8,8,0,0,0,2,8,8,8,8},
				{2,0,0,0,0,0,0,0,0,0,0,0,0,2,8,0,0,0,2,2,8,8,0,0,8,2,8,2,2,2},
				{2,0,2,0,2,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,2,8,8,8,8,2,0,0,0,5},
				{2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,8,8,0,0,0,0,2},
				{2,0,4,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,2,8,0,0,0,0,5,0},
				{4,4,2,0,0,2,8,0,0,2,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,0},
				{5,5,2,5,8,8,8,8,2,2,4,4,2,2,5,5,5,5,5,5,5,5,5,2,5,5,5,5,5,5},
		}; 
	
	

	
	public void drawMap (Graphics g) {
		for(int i=0; i<20; i++) {
			for(int j=0; j<30; j++) {
				if (Map[i][j]==0) {
					ImageIcon icon = new ImageIcon("src//image//grass.png");
					g.drawImage(icon.getImage(), j*BOX_SIZE, i*BOX_SIZE, this.mainGame);
				}
				if (Map[i][j]==1) {
					ImageIcon icon = new ImageIcon("src//image//concrete_L.png");
					g.drawImage(icon.getImage(), j*BOX_SIZE, i*BOX_SIZE, this.mainGame);
				}	

				if (Map[i][j]==2) { 
					ImageIcon icon = new ImageIcon("src//image//manyGrass.png");
					g.drawImage(icon.getImage(), j*BOX_SIZE, i*BOX_SIZE, this.mainGame);
				}
				
				if (Map[i][j]==3) {
					ImageIcon icon = new ImageIcon("src//image//anything.png");
					g.drawImage(icon.getImage(), j*BOX_SIZE, i*BOX_SIZE, this.mainGame);
				}
				
				if (Map[i][j]==4) {
					ImageIcon icon = new ImageIcon("src//image//musrom.png");
					g.drawImage(icon.getImage(), j*BOX_SIZE, i*BOX_SIZE, this.mainGame);
					
				}
					
				if (Map[i][j]==5) {
					ImageIcon icon = new ImageIcon("src//image//rock.png"); 
					g.drawImage(icon.getImage(), j*BOX_SIZE, i*BOX_SIZE, this.mainGame);
				}
					
				if (Map[i][j]==6) {
					ImageIcon icon = new ImageIcon("src//image//musroom2.png");
					g.drawImage(icon.getImage(), j*BOX_SIZE, i*BOX_SIZE, this.mainGame);
				}
					
				if (Map[i][j]==7) {
					ImageIcon icon = new ImageIcon("src//image//tree.png");
					g.drawImage(icon.getImage(), j*BOX_SIZE, i*BOX_SIZE, this.mainGame); 
				}
				if (Map[i][j]==8) {
					ImageIcon icon = new ImageIcon("src//image//water.png");
					g.drawImage(icon.getImage(), j*BOX_SIZE, i*BOX_SIZE, this.mainGame);
				}
				if (Map[i][j]==9) {
					ImageIcon icon = new ImageIcon("src//image//bone.png");
					g.drawImage(icon.getImage(), j*BOX_SIZE, i*BOX_SIZE, this.mainGame);
				}
				
				if (Map[i][j]==10) {
					ImageIcon icon = new ImageIcon("src//image//concrete.png");
					g.drawImage(icon.getImage(), j*BOX_SIZE, i*BOX_SIZE, this.mainGame);
				}
				}
			}
		}
	

	public void initAllMapHunter () {
		this.numberHunter0 = 0;
		this.numberHunter1 = 6;
		this.numberHunter2 = 9;
		this.numberHunter3 = 11;
		this.numberHunter = numberHunter0;
		
		Hunters0 = new ArrayList <Hunter> ();
		Hunters1 = new ArrayList <Hunter> ();
		Hunters2 = new ArrayList <Hunter> ();
		Hunters3 = new ArrayList <Hunter> ();
		Hunters = new ArrayList <Hunter> ();
		Hunters = Hunters0;
		 
		for (int i = 0; i<numberHunter0; i++) {
			this.initHunter(Hunters0, map0);
		}
		for (int i = 0; i<numberHunter1; i++) {
			this.initHunter(Hunters1, map1);
		}
		for (int i = 0; i<numberHunter2; i++) {
			this.initHunter(Hunters2, map2);
		} 
		for (int i = 0; i<numberHunter3; i++) {
			this.initHunter(Hunters3, map3);
		}	
		
	}
	
	public void initAllMapDog () {
		this.numberDog0 = 0;
		this.numberDog1 = 2;
		this.numberDog2 = 3;
		this.numberDog3 = 5;
		this.numberDog = numberDog0;
		
		Dogs0 = new ArrayList <Dog> ();
		Dogs1 = new ArrayList <Dog> ();
		Dogs2 = new ArrayList <Dog> ();
		Dogs3 = new ArrayList <Dog> ();
		Dogs = new ArrayList <Dog> ();
		Dogs = Dogs0;
		
		for (int i = 0; i<numberDog0; i++) {
			this.initDog(Dogs, map0);
		}
		for (int i = 0; i<numberDog1; i++) {
			this.initDog(Dogs1, map1);
		}
		for (int i = 0; i<numberDog2; i++) {
			this.initDog(Dogs2, map2);
		}
		for (int i = 0; i<numberDog3; i++) { 
			this.initDog(Dogs3, map3);
		}
		
		
	}

	public void initHunter (ArrayList <Hunter> Hunters, int[][] Map) {	
			Random Rx = new Random();
			Random Ry = new Random();
			int xH = Rx.nextInt(650);
			int yH = Ry.nextInt(430);		  
				if ((Map[(int)yH/24][(int)xH/24] == 0)&&
					(Map[(yH+BOX_SIZE)/24][xH/24] ==0)&&
					(Map[yH/24][(xH+BOX_SIZE)/24] == 0)&&  
					(Map[(yH+BOX_SIZE)/24][(xH+BOX_SIZE)/24] == 0)) {
						Hunter Hunter = new Hunter(mainGame);
						Hunter.setMainGame(mainGame); 
						Hunter.setX(xH);
						Hunter.setY(yH);  
						if(mainGame.getMode()==1) {
							Hunter.setHP(800); 		
							Hunter.setAtk(200);							
							Hunter.setMP(2);  
						}
						Hunters.add(Hunter); 		
						return;
				}
				else this.initHunter(Hunters, Map);
		} 
	

	public void initDog (ArrayList <Dog> Dogs, int[][] Map) {	
		Random Rx = new Random();
		Random Ry = new Random();
		int xH = Rx.nextInt(650);
		int yH = Ry.nextInt(430);		  
			if ((Map[(int)yH/24][(int)xH/24] == 0)&&
				(Map[(yH+BOX_SIZE)/24][xH/24] ==0)&&
				(Map[yH/24][(xH+BOX_SIZE)/24] == 0)&&  
				(Map[(yH+BOX_SIZE)/24][(xH+BOX_SIZE)/24] == 0)) {
					Dog Dog = new Dog(mainGame);
					Dog.setX(xH);
					Dog.setY(yH);  
					if(mainGame.getMode()==1) {
						Dog.setHP(500); 		
						Dog.setAtk(8);							
					}
					Dogs.add(Dog);		
					return;
			}
			else this.initDog(Dogs, Map);
	} 
	
	public void drawHunter(Graphics g ) {	
		for (Hunter Hunter : Hunters) {
			 if(!Hunter.isDead()) { 
				 
				 g.drawString("" + Hunter.getHP(), Hunter.getX(), Hunter.getY() - 5);
				 g.drawImage(Hunter.getImage(), Hunter.getX(),Hunter.getY() , mainGame);
				 Hunter.drawBullet(g);
			 }
		}
	}

	
	public void drawDog(Graphics g ) {	
		for (Dog Dog : Dogs) {
			 if(!Dog.isDead()) { 
				 g.drawString("" + Dog.getHP(), Dog.getX(), Dog.getY() - 5);
				 g.drawImage(Dog.getImage(),Dog.getX(),Dog.getY() , mainGame);
			 }
		}
	}
		
	
	
	
	public void setMap (int i) { 
		if(i == 0) { 
			Location = 0;
			Map = map0;
			Hunters = Hunters0;
			numberHunter = numberHunter0;
			Dogs = Dogs0;
			numberDog = numberDog0;
		}
		if(i == 1) { 
			Location = 1;
			Map = map1;
			Hunters = Hunters1;
			numberHunter = numberHunter1;
			Dogs = Dogs1;
			numberDog = numberDog1;
		}
		if(i == 2) { 
			Location = 2;
			Map = map2;
			Hunters = Hunters2;
			numberHunter = numberHunter2;
			Dogs = Dogs2;
			numberDog = numberDog2;
		}
		if(i == 3) { 
			Location = 3;
			Map = map3;
			Hunters = Hunters3;
			numberHunter = numberHunter3;
			Dogs = Dogs3;
			numberDog = numberDog3;
		}
		
	}

	public void checkState () {
		if((this.Location == 0) &&  
				(((mainGame.getGhost().getY()/BOX_SIZE>=8)		&&	(mainGame.getGhost().getY()/BOX_SIZE<=14))   && (mainGame.getGhost().getX()/BOX_SIZE >= 28) &&
				((mainGame.getMonster().getY()/BOX_SIZE >=8) 	&&  (mainGame.getMonster().getY()/BOX_SIZE<=14)) && (mainGame.getMonster().getX()/BOX_SIZE >= 28))
					) {
				this.setMap(1);
				mainGame.getGhost().setX(0);
				mainGame.getMonster().setX(0);
		}
		
		if(mainGame.allHunterDead() && mainGame.allDogDead() && (this.getLocation() == 1) && 
				(((mainGame.getGhost().getY()/BOX_SIZE>=8)		&&	(mainGame.getGhost().getY()/BOX_SIZE<=13))   && (mainGame.getGhost().getX()/BOX_SIZE >= 28) &&
				((mainGame.getMonster().getY()/BOX_SIZE >=8) 	&&  (mainGame.getMonster().getY()/BOX_SIZE<=13)) && (mainGame.getMonster().getX()/BOX_SIZE >= 28 ))
					) {
				this.setMap(2); 
				mainGame.getGhost().setX(0); 
				mainGame.getMonster().setX(0); 
		}
		
	 
		
		if(mainGame.allHunterDead() && mainGame.allDogDead() && (this.getLocation() == 2) && 
				(((mainGame.getGhost().getY()/BOX_SIZE>=7)		&&	(mainGame.getGhost().getY()/BOX_SIZE<=14))   && (mainGame.getGhost().getX()/BOX_SIZE >= 28) &&
				((mainGame.getMonster().getY()/BOX_SIZE >=7) 	&&  (mainGame.getMonster().getY()/BOX_SIZE<=14)) && (mainGame.getMonster().getX()/BOX_SIZE >= 28 ))
					) {
				this.setMap(3);
				mainGame.getGhost().setX(0);
				mainGame.getMonster().setX(0);
		}
		
		if(mainGame.allHunterDead() && mainGame.allDogDead()  && (this.getLocation() == 3) && 
				(((mainGame.getGhost().getX()/BOX_SIZE  >=5)	&&	(mainGame.getGhost().getX()/BOX_SIZE<=11))   && (mainGame.getGhost().getY()/BOX_SIZE <= 0) &&
				((mainGame.getMonster().getX()/BOX_SIZE >=5) 	&&  (mainGame.getMonster().getX()/BOX_SIZE<=11)) && (mainGame.getMonster().getY()/BOX_SIZE <= 0 ))
					) {
				mainGame.getTimer().stop();
				mainGame.getMyContainer().setShowEnd(); 
		}
		
		
	}
	
	
	
	public int[][] getMap() {
		return Map;
	}


	public ArrayList<Hunter> getHunters() {
		return Hunters;
	}


	public int getLocation() {
		return Location;
	}


	public int getNumberHunter() {
		return numberHunter;
	}


	public void setNumberHunter(int number_Hunter) {
		numberHunter = number_Hunter;
	}


	public int getNumberDog() {
		return numberDog;
	}


	public void setNumberDog(int numberDog) {
		this.numberDog = numberDog;
	}


	public ArrayList<Dog> getDogs() {
		return Dogs;
	}


	public void setDogs(ArrayList<Dog> dogs) {
		Dogs = dogs;
	}


	
	

	


	
	
	
	
}
