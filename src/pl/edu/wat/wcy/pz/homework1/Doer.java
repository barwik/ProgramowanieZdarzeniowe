package pl.edu.wat.wcy.pz.homework1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;

public class Doer implements Runnable{
	App context;
	
	public Doer(App context){
		this.context=context;
	}

	@Override
	public void run() {
		File output = new File(Integer.toString(context.rnd.nextInt())+".txt");
		PrintWriter printer=null;
		try {
			printer = new PrintWriter(output);
			printer.write(context.textArea.getText());
			context.myLogger.log(Level.INFO, "Allright!");
		} catch (IOException e1) {
			// TODO Logger
			e1.printStackTrace();
			context.myLogger.log(Level.WARNING, "Oh shit!");
		} finally {
			printer.close();
		}
	}
}
