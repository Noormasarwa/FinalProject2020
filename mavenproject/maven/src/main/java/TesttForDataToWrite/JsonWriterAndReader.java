package TesttForDataToWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class JsonWriterAndReader {
	public JsonWriterAndReader() {
		
	}
	public void WriteIntoFileARes(String S) {
		File F = new File(System.getProperty("user.dir")+"\\JsonAResDataFile.txt");
		try {
			if(F.createNewFile()) {
				System.out.println("File Created Suuccessfully");
			}
			else {
				System.out.println("File already exists");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<String> A = ReadFromFileARes();
		int flag = 1;
		for(String C : A) {
			if(C.equals(S)) {
				flag = 0 ; 
				break;
			}
		}
		if(flag == 0 ) {
			return;
		}
		A.add(S);
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream (new File(System.getProperty("user.dir")+"\\JsonAResDataFile.txt"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(String C : A) {
				oos.writeObject(C);
			}
			oos.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}

	}
	
	
	public void WriteIntoFileAReq(String S) {
		File F = new File(System.getProperty("user.dir")+"\\JsonAReqDataFile.txt");
		try {
			if(F.createNewFile()) {
				System.out.println("File Created Suuccessfully");
			}
			else {
				System.out.println("File already exists");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<String> A = ReadFromFileAReq();
		int flag = 1;
		for(String C : A) {
			if(C.equals(S)) {
				flag = 0 ; 
				break;
			}
		}
		if(flag == 0 ) {
			return;
		}
		A.add(S);
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream (new File(System.getProperty("user.dir")+"\\JsonAReqDataFile.txt"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(String C : A) {
				oos.writeObject(C);
			}
			oos.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}

	}
	
	public ArrayList<String> ReadFromFileARes() {
		ArrayList<String> A = new ArrayList<String>();
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\JsonAResDataFile.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while(true) {
				try {
					A.add((String)ois.readObject());
				} catch (ClassNotFoundException e) {
					
					System.out.println("End OF File\n");
					break;
				}
			}
			ois.close();
			fis.close();

		} catch (FileNotFoundException e1) {
				
		}
		catch (IOException e) {
			
		}
		return A;

	}
	
	public ArrayList<String> ReadFromFileAReq() {
		ArrayList<String> A = new ArrayList<String>();
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\JsonAReqDataFile.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while(true) {
				try {
					A.add((String)ois.readObject());
				} catch (ClassNotFoundException e) {
					
					System.out.println("End OF File\n");
					break;
				}
			}
			ois.close();
			fis.close();

		} catch (FileNotFoundException e1) {
				
		}
		catch (IOException e) {
			
		}
		return A;

	}
}
