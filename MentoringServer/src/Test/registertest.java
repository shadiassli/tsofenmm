package Test;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class registertest {

	public static final Logger LOGGER =Logger.getLogger(registertest.class.getName());
	//private static final Level one =null;
	public static void main() throws IOException {		

	}
	
	public static  void writelogger(String funame){
        System.out.println("logeer1");
		try {
	        System.out.println("logeer 2");
			registertest demo = new registertest();
			Handler fileHandler=null;
			fileHandler = new FileHandler("./mentoormentee.log");
		    LOGGER.addHandler(new FileHandler("LogToFile.xml"));
	        print(demo.getLevel(LOGGER),funame);
			LOGGER.addHandler(fileHandler);
		} catch (SecurityException e) {
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}   
	}
	public static Level getLevel(Logger logger) {
		System.out.println("level logeer");
        Level level = logger.getLevel();
        if (level == null && logger.getParent() != null) {
            level = logger.getParent().getLevel();
        }
        return level;
    }
	public static void print(Level level, String funame) throws IOException{
		System.out.println("print logger");
		try {
		    BufferedWriter out = new BufferedWriter(new FileWriter("test.txt",false));
		    out.write(funame);  
		                                            
		    out.close();
		}
		catch (IOException e)
		{
		    System.out.println("Exception logeer" + funame);

		}

		 LOGGER.info(funame);
		LOGGER.config(funame);
	System.out.println(funame);	
		
}
}




