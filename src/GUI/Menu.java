package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Menu extends JPanel implements ActionListener{
	private Container Container;

	private JButton btn_Tutorial;
	private JButton btn_PlayEasy; 
	private JButton btn_PlayHard; 
	
	public Menu(Container Container) {
		this.Container = Container;
		setLayout(null);
		initCompts();
	}
	
	public void initCompts(){	
		setFocusable(true);
		setBackground(Color.gray);
		this.setLayout(null);
		this.setBounds(0, 0, 900, 700); 
		
		ImageIcon icon1 = new ImageIcon("src\\image\\Button_Tuto.png");
		btn_Tutorial = new JButton();
		btn_Tutorial.setBounds(500, 350, 150, 40);
		btn_Tutorial.addActionListener(this);
		btn_Tutorial.setContentAreaFilled(false);
	    btn_Tutorial.setBorder(null);
		btn_Tutorial.setIcon(icon1); 
		add(btn_Tutorial); 
		
		
		ImageIcon iconPE = new ImageIcon("src\\image\\Button_PlayE.png");
		btn_PlayEasy = new JButton();
		btn_PlayEasy.setBounds(500, 400, 150, 40);
		btn_PlayEasy.addActionListener(this);
		btn_PlayEasy.setContentAreaFilled(false);
		btn_PlayEasy.setBorder(null);
		btn_PlayEasy.setIcon(iconPE); 
		add(btn_PlayEasy); 
		
		ImageIcon iconPH = new ImageIcon("src\\image\\Button_PlayH.png");
		btn_PlayHard = new JButton();
		btn_PlayHard.setBounds(500, 450, 150, 40);
		btn_PlayHard.addActionListener(this);
		btn_PlayHard.setContentAreaFilled(false);
		btn_PlayHard.setBorder(null);
		btn_PlayHard.setIcon(iconPH); 
		add(btn_PlayHard); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_PlayEasy){
			Container.setShowPlay(0);  
		}	
		if(e.getSource()==btn_Tutorial){
			Container.setShowTutorial(); 
		}	
		if(e.getSource()==btn_PlayHard){
			Container.setShowPlay(1); 
		}	
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon icon = new ImageIcon("src\\image\\Menu.png");
		g.drawImage(icon.getImage(), 0, 0, this);
	
	
	
	}
	
}
