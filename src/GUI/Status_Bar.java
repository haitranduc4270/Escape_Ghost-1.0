package GUI;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Status_Bar extends JPanel implements ActionListener{

	private MainGame MainGame;
	private JLabel Ghost_HP;
	private JLabel Ghost_MP;
	private JLabel Monster_HP;
	private JLabel Monster_MP;
	
	private JButton btn_Menu;

	public Status_Bar () {
		super();
		this.setLayout(null); 
		this.setBounds(0, 519, 735, 81);
		this.setBackground(Color.GRAY);
		

		Ghost_HP = new JLabel ("--") ; this.Ghost_HP.setBounds(310, 0, 200, 20);
		Ghost_MP = new JLabel ("--") ; this.Ghost_MP.setBounds(310, 30, 200, 20);
		Monster_HP = new JLabel ("--") ; this.Monster_HP.setBounds(0, 0, 300, 20);
		Monster_MP = new JLabel ("--") ; this.Monster_MP.setBounds(0, 30, 300, 20);
		
		
		this.add(Ghost_HP); 
		this.add(Ghost_MP);
		this.add(Monster_HP);
		this.add(Monster_MP);
		
		ImageIcon iconM = new ImageIcon("src\\image\\Button_Menu.png");
		btn_Menu = new JButton();
		btn_Menu.setBounds(570, 10, 150, 40);
		btn_Menu.addActionListener(this);
		btn_Menu.setContentAreaFilled(false);
		btn_Menu.setBorder(null);
		btn_Menu.setIcon(iconM); 
		add(btn_Menu); 
	}

	public MainGame getMainGame() {
		return MainGame;
	}

	public void setMainGame(MainGame mainGame) {
		this.MainGame = mainGame;
	}
	
	public void updateStatus () {
		Ghost_HP.setText("Ghost HP:    "+ MainGame.getGhost().getHP());
		Ghost_MP.setText("Ghost MP :   "+ MainGame.getGhost().getMP()  +"        Ghost_ATK : " + MainGame.getGhost().getAtk() );
		Monster_HP.setText("Monster HP :     " + MainGame.getMonster().getHP() + "         Monster_ATK : " + MainGame.getMonster().getAtk()  );
		Monster_MP.setText("Monster MP :     " + MainGame.getMonster().getMP() + "           Monster AT_Ranger : " + MainGame.getMonster().getBurnRanger());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_Menu){
			MainGame.getTimer().stop();
			MainGame.getMyContainer().setShowMenu();
		}	
		
	}
	
	
}
