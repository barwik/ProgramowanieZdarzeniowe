package pl.edu.wat.wcy.pz.homework1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class App extends JFrame {
	public App(){
		myLogger.setLevel(Level.ALL);
		myLogger.log(Level.INFO, "I'm in!");
		setTitle("Appka Testowa");
		setSize(500, 400);
		
		JPanel buttonPanel = new JPanel();
		JPanel textPanel = new JPanel();
		
		final JTextArea textArea = new JTextArea(15, 43);
		textArea.setLineWrap(true);
		
		JButton zapisz = new JButton("Zapisz");
		
		zapisz.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				File output = new File(Integer.toString(rnd.nextInt())+".txt");
				PrintWriter printer=null;
				try {
					printer = new PrintWriter(output);
					printer.write(textArea.getText());
					myLogger.log(Level.INFO, "Allright!");
				} catch (IOException e1) {
					// TODO Logger
					e1.printStackTrace();
					myLogger.log(Level.WARNING, "Oh shit!");
				} finally {
					printer.close();
				}
			}
			
		});
		
		buttonPanel.add(zapisz);
		textPanel.add(textArea);
		add(buttonPanel, BorderLayout.SOUTH);	
		add(textPanel, BorderLayout.NORTH);
	}
	
	
	
	private Random rnd = new Random();
	private Logger myLogger = Logger.getLogger("Test zapisu!");
	
	public static void main(String[] args){
		App frame = new App();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}