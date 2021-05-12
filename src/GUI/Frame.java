package GUI;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame{
	public Frame() {
		this.setTitle("Escape_Ghost");
		add(new Container());
		setSize(735, 580);  
		
		setVisible(true); 
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
	}
	public static void main(String[] args) {
		new Frame(); 
	}
	

	
	}