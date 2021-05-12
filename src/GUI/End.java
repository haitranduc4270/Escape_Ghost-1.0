package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class End extends JPanel implements ActionListener{
	private Container Container;
	private JButton btn_PlayAgain;
	private JButton btn_Menu;
	
	
	public End(Container Container) {
		this.Container = Container;
		setLayout(null);
		initCompts();
	}
	
	public void initCompts(){	
		setFocusable(true);
		setBackground(Color.gray);
		this.setLayout(null);
		this.setBounds(0, 0, 900, 700);  
		
		
		ImageIcon iconP = new ImageIcon("src\\image\\Button_PlayAgain.png");
		btn_PlayAgain = new JButton();
		btn_PlayAgain.setBounds(500, 450, 150, 40);
		btn_PlayAgain.addActionListener(this);
		btn_PlayAgain.setContentAreaFilled(false);
		btn_PlayAgain.setBorder(null);
		btn_PlayAgain.setIcon(iconP); 
		add(btn_PlayAgain); 
		 
		ImageIcon iconM = new ImageIcon("src\\image\\Button_Menu.png");
		btn_Menu = new JButton();
		btn_Menu.setBounds(500, 400, 150, 40);
		btn_Menu.addActionListener(this);
		btn_Menu.setContentAreaFilled(false);
		btn_Menu.setBorder(null);
		btn_Menu.setIcon(iconM); 
		add(btn_Menu); 
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (this.Container.getMainGame().getGhost().isDead() || this.Container.getMainGame().getMonster().isDead() ) {
			 ImageIcon icon = new ImageIcon ("src\\image\\Lose.png");
			 g.drawImage(icon.getImage(), 0, 0, this);
			 return; 
		 }
		  
		 if(this.Container.getMainGame().allHunterDead() && (this.Container.getMainGame().getMaps().getLocation() == 3)) {
			 ImageIcon icon = new ImageIcon ("src\\image\\Win.png");
			 g.drawImage(icon.getImage(), 0, 0, this);
			 return;
			} 
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_PlayAgain){ 		
			Container.setShowPlay(Container.getMainGame().getMode());
		}	  
		if(e.getSource()==btn_Menu){ 
			Container.setShowMenu(); 
		}	
		
	}
	
}
