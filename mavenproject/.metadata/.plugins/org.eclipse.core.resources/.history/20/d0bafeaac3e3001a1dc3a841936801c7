package ConnectToMySQl;

import java.sql.SQLException;
import java.util.List;

import DataToWrite.ARes;

public class MainTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Sql sql = new Sql();

		

		List<ARes> l = sql.getAresByAcsReferenceNumber("2");
		for(ARes r : l) {
			System.out.println(r);
		}
		
		List<ARes> g = sql.getAresByAcsReferenceNumber("3");
		for(ARes r : g) {
			System.out.println(r);
		}
		
	}

}
