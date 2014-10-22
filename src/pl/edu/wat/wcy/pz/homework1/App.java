package pl.edu.wat.wcy.pz.homework1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class App extends JFrame implements ActionListener{
	public JPanel buttonPanel = new JPanel();
	public JPanel textPanel = new JPanel();
	public final JTextArea textArea = new JTextArea(15, 43);
	public Random rnd = new Random();
	public Logger myLogger = Logger.getLogger("Test zapisu!");
	JButton zapisz;
	
	public App(){
		myLogger.setLevel(Level.ALL);
		myLogger.log(Level.INFO, "I'm in!");
		setTitle("Appka Testowa");
		setSize(500, 400);
		
		textArea.setLineWrap(true);
		
		zapisz = new JButton("Zapisz");
		
		zapisz.addActionListener(this);
		
		buttonPanel.add(zapisz);
		textPanel.add(textArea);
		add(buttonPanel, BorderLayout.SOUTH);	
		add(textPanel, BorderLayout.NORTH);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==zapisz){
			Doer d = new Doer(this);
			Thread t = new Thread(d);
			t.start();
		}
	}
	
	public static void main(String[] args){
		App frame = new App();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}