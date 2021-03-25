package TesttForDataToWrite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Httpsend {
	public  void sendinformationtohttp(String pass, String creq) {
		try (FileWriter writer = new FileWriter(System.getProperty("user.dir")+"\\Second Server\\public\\response.txt");
        BufferedWriter bw = new BufferedWriter(writer)) {
			bw.write(pass);	
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
            
        }
		
		
		try (FileWriter writer = new FileWriter(System.getProperty("user.dir")+"\\Second Server\\public\\creq.txt");
		        BufferedWriter bw = new BufferedWriter(writer)) {
					bw.write(creq.toString());	
		        } catch (IOException e) {
		            System.err.format("IOException: %s%n", e);
		            
		        }
    }
}