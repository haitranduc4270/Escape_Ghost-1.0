package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import Actor.Monster;
import Actor.Hunter;
import Actor.MyAdapter;
import Manager.Manager;
import Map.MyMap;
import Actor.Dog;
import Actor.Ghost;


@SuppressWarnings("serial")
public class MainGame extends JPanel implements ActionListener{
	private Container Container;
	
	private int mode;
	
	private Timer timer;
	private final int DELAY = 37; 
	private final int BOX_SIZE = 24;  
	private Status_Bar Bar;
	 
	
	private Monster Monster;
	private Ghost Ghost;

	private Manager Manager;
	private MyMap Maps;	
	

	public MainGame(Container Container, int mode) {  
		setFocusable(true);
		setBackground(Color.gray);
		this.setLayout(null);
		this.setBounds(0, 0, 900, 700); 
		
		this.mode = mode;
		this.prepare(Container);
	}
	

	public void prepare (Container Container) {	
		this.Container = Container;
		
		Maps = new MyMap(this);
		Maps.setMap(0);
			
		Monster = new Monster(this);
		Ghost = new Ghost(this); 

		Monster.setMainGame(this); 
		Ghost.setMainGame(this);
		
		Manager = new Manager(this);
			
		MyAdapter adapter = new MyAdapter( Monster, Ghost); 
		addKeyListener(adapter);
		timer = new Timer(DELAY, this); 
		
		Bar = new Status_Bar(); 
		Bar.setMainGame(this);
		Bar.setBounds(0, 490, 720, 80);
		this.add(Bar);
	}
	
	 
	@Override
	protected void paintComponent(Graphics g) {
		 super.paintComponent(g);

		 Maps.drawMap(g);
		 this.Maps.drawHunter(g);
		 this.Maps.drawDog(g);
		 
		 
		 if(!Monster.isDead()) {
			 g.drawImage(Monster.getImage(), Monster.getX(), Monster.getY(), this);
		 }
		
		 if(!Ghost.getDead()) {
		 g.drawImage(Ghost.getImage(), Ghost.getX(), Ghost.getY(), this);
		 Ghost.drawBullet(g);
		 } 

		 g.setColor(Color.GREEN);
		 g.fillRect(0, 480, 720, 3);
		 
		 
		}

	@Override
	public void actionPerformed(ActionEvent e) {	
		checkLose();
		Maps.checkState();
		checkMonsterAlive();
		checkGhostAlive();
		checkHunterAlive();
		checkDogAlive();
		
		this.Bar.updateStatus();
		
		if(!Monster.isDead()) {
			Monster.move();
		}
		
		if(!Ghost.isDead()) { 
			Ghost.move(); 
		} 
		 
		for (Hunter Hunter : this.Maps.getHunters()) { 
			if(!Hunter.isDead()) {  
			Hunter.moveHunter();
			Hunter.HunterShoot();  
			} 
		}
		
		for (Dog Dog : this.Maps.getDogs()) {
			if(!Dog.isDead()) {
				Dog.moveDog();
			}
		}
		 
		repaint(); 
	}
	
	
	
	
	public void checkMonsterAlive () {
		if(this.mode == 1) {
			if (this.Manager.MonsterVSBullet()) {
				if(Monster.getHP()<=0) {
					Monster.setDead(true); 
					Monster.Kill();  
				} 
			}
		}
		this.Manager.checkDogBiteChar();
		if(this.Manager.HunterShoot_Monster()) {}  // da co chuyen ve void nhung ko dc   		
		if(Monster.getHP()<=0) { 
			Monster.setDead(true);  
			Monster.Kill();  
		}
		return;
	}  
	
	   
	public void checkGhostAlive () {
		this.Manager.checkDogBiteChar();
		if(this.Manager.HunterShoot_Ghost()) {}  // da co chuyen ve void nhung ko dc   
		if(Ghost.getHP()<=0) {
			Ghost.setDead(true); 
			Ghost.Kill();
		}		
		return;
		 
	}
	
	
	public void checkHunterAlive () {
		for(Hunter Hunter : Maps.getHunters()) {
			if(this.Manager.IsHunterwasShooted(Hunter)) {
				Hunter.setHP(Hunter.getHP()+ Hunter.getDefense() - Ghost.getAtk());
			} 
			this.Manager.CheckMonsterBurnHunter(Hunter);
			if(Hunter.getHP()<=0) {
				Hunter.Kill(); 
				Hunter = null;
			}
		}
		return;
	} 
	
	public void checkDogAlive () {
		for(Dog Dog : Maps.getDogs()) {
			if(this.Manager.IsDogwasShooted(Dog)) {
				Dog.setHP(Dog.getHP()+ Dog.getDefense() - Ghost.getAtk());
			} 
			
			this.Manager.CheckMonsterBurnDog(Dog);
			if(Dog.getHP()<=0) {
				Dog.Kill(); 
				Dog = null;
			}
		} return;		
	} 
	 
	public boolean allHunterDead () {
		int i = 0;
		for (Hunter Hunter : Maps.getHunters()) {
			if(Hunter.isDead()) continue;
			i++;
		} 
		if (i == 0) return true;
		return false;
	}

	public boolean allDogDead () {
		int i = 0;
		for (Dog Dog : Maps.getDogs()) {
			if(Dog.isDead()) continue;
			i++; 
		} 
		if (i == 0) return true;
		return false;
	}
	
	public void checkLose () {
		 if (Ghost.isDead() || Monster.isDead() ) {
				timer.stop(); 
				this.Container.setShowEnd();
		 }
	}
	
	
	
	public Monster getMonster() {
		return Monster;
	}
	public Ghost getGhost() { 
		return Ghost;
	}
	public int getBOX_SIZE() {
		return BOX_SIZE;
	}
	public ArrayList<Hunter> getHunters() {
		return Maps.getHunters();
	}
	public MyMap getMaps() {
		return Maps;
	}


	public Timer getTimer() {
		return timer;
	}


	public void setTimer(Timer timer) {
		this.timer = timer;
	}


	public Container getMyContainer() {
		return Container;
	}


	public int getMode() {
		return mode;
	}


	public void setMode(int mode) {
		this.mode = mode;
	}


	

	
	}