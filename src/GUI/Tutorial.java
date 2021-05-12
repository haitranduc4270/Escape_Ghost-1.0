package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Tutorial extends JPanel implements ActionListener{
	private Container Container;
	private JButton btn_Menu;
	
	
	public Tutorial(Container Container) {
		this.Container = Container;
		setLayout(null);
		initCompts();
	}
	
	public void initCompts(){	
		setFocusable(true);
		setBackground(Color.gray);
		this.setLayout(null);
		this.setBounds(0, 0, 900, 700);  
		
		
		ImageIcon iconM = new ImageIcon("src\\image\\Button_Menu.png");
		btn_Menu = new JButton();
		btn_Menu.setBounds(500, 450, 150, 40);
		btn_Menu.addActionListener(this);
		btn_Menu.setContentAreaFilled(false);
		btn_Menu.setBorder(null);
		btn_Menu.setIcon(iconM); 
		add(btn_Menu); 
	}
 

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon icon = new ImageIcon("src\\image\\Tutorial_Bg.png");
		g.drawImage(icon.getImage(), 0, 0, this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_Menu){
			Container.setShowMenu();
		}	
		
	}
	
}
