import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;

public class GOIFrame extends JFrame {
	private JButton buttonStart;
	private JButton buttonNext;
	private JPanel panel;
	
	public GOIFrame() {
		super("Game of life");
		this.setDefaultCloseOperation (EXIT_ON_CLOSE) ;
		buttonStart=new JButton("Start");
		buttonNext=new JButton("Next");
		Container panel=getContentPane();
		
		panel.add(new JPanel (new GridLayout ( 5,2,20,50 )));
		//this.panel = new JPanel ( new GridLayout ( 5,2,20,50 ) );
		/*JPanel panel = new JPanel ( new GridLayout ( 5,2,20,50 ) ) ;*/
		panel.add ( new JLabel ( " étiquette pour la ligne 1 ")); 
		panel.add ( new JTextField (5) ) ; 
		panel.add ( new JLabel ( " Row différente de l'étiquette 2 ")); 
		panel.add ( new JTextField (3) ) ; 
		panel.add ( new JLabel ( " un autre label:" ) ) ;
		panel.add ( new JTextField (3) ) ;
		panel.add ( new JLabel ( "et maintenant 4 "));
		panel.add ( new JTextField (3) ) ; 
		panel.add ( new JButton (" My Button ")); 
		//panel.add ( new JButton ( " Another Button " ) ) ;
		 
	}
	
	public void displayGOIFrame() {
		//JPanel panel = new JPanel ( new GridLayout ( 5,2,20,50 ) ) ;
		/*this.panel.add ( new JLabel ( " étiquette pour la ligne 1 ")); 
		this.panel.add ( new JTextField (5) ) ; 
		this.panel.add ( new JLabel ( " Row différente de l'étiquette 2 ")); 
		this.panel.add ( new JTextField (3) ) ; 
		this.panel.add ( new JLabel ( " un autre label:" ) ) ;
		this.panel.add ( new JTextField (3) ) ;
		this.panel.add ( new JLabel ( "et maintenant 4 "));
		this.panel.add ( new JTextField (3) ) ; 
		this.panel.add ( new JButton (" My Button ")); 
		this.panel.add ( new JButton ( " Another Button " ) ) ; */
	}
	
	public static void main(String[] args) {
		GOIFrame mainWindow=new GOIFrame();
		//mainWindow.displayGOIFrame();
		mainWindow.setSize ( 400,400 );
		//mainWindow.pack();
		mainWindow.setVisible(true);
	}
}
