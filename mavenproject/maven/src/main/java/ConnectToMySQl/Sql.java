package ConnectToMySQl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import DataToWrite.ARes;
import DataToWrite.CReq;

public class Sql {
	
	

	
	public List<ARes> getAresBydsReferenceNumber(String dsReferenceNumber) throws ClassNotFoundException, SQLException{
		Connection con = connect();

		List<ARes> li = new ArrayList<ARes>();
		ARes ares;
		String query = "select * from ares where dsReferenceNumber = ?";
		PreparedStatement pr = con.prepareStatement(query);
		pr.setInt(1, Integer.parseInt(dsReferenceNumber));
		ResultSet result = pr.executeQuery();
		
		while(result.next()) {
			ares = new ARes(result.getString(1), Integer.toString(result.getInt(2)),
					result.getString(3), result.getString(4),result.getString(5),
					result.getString(6), result.getString(7), result.getString(8),result.getString(9),
					result.getString(10), result.getString(11));
			li.add(ares);
		}
		pr.close();
		con.close();
		return li;
	}
	
	public int addARes(ARes ares) throws ClassNotFoundException, SQLException {
		Connection con = connect();
		String query = "INSERT INTO ares (threeDSServerTransID,dsReferenceNumber,acsTransId,authenticationValue,dsTransId,eci,messageType,messageVersion,transStatus,transStatusReason) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		preparedStmt.setString(1, ares.getThreeDSServerTransID());
		preparedStmt.setString(2, ares.getDsReferenceNumber());
		preparedStmt.setString(3, ares.getAcsTransId());
		preparedStmt.setString(4, ares.getAuthenticationValue());
		preparedStmt.setString(5, ares.getDsTransId());
		preparedStmt.setString(6, ares.getEci());
		preparedStmt.setString(7, ares.getMessageType());
		preparedStmt.setString(8, ares.getMessageVersion());
		preparedStmt.setString(9, ares.getTransStatus());
		preparedStmt.setString(10, ares.getTransStatusReason());
		preparedStmt.executeUpdate();
		ResultSet rs = preparedStmt.getGeneratedKeys();
		 
        int idValue = 0;
        if (rs.next()) {
            // Value of ID (Index 1 by table design).
            idValue = rs.getInt(1);
        }
        preparedStmt.close();
        con.close();
        System.out.println("ID value: " + idValue);
        return idValue;
	}
	
	public void addCReq(CReq creq) throws ClassNotFoundException, SQLException {
		Connection con = connect();
		String query = "INSERT INTO creq (threeDSServerTransID,acsTransId,challengeWindowSize,messageType,messageVersion) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		preparedStmt.setString(1, creq.getThreeDSServerTransID());
		preparedStmt.setString(2, creq.getAcsTransId());
		preparedStmt.setString(3, creq.getChallengeWindowSize());
		preparedStmt.setString(4, creq.getMessageType());
		preparedStmt.setString(5, creq.getMessageVersion());

		preparedStmt.executeUpdate();
        preparedStmt.close();
        con.close();
	}
	
	public List<ARes> getCReqByAcsTransId(String acsTransId) throws ClassNotFoundException, SQLException{

		Connection con = connect();
		List<ARes> li = new ArrayList<ARes>();
		ARes ares;
		String query = "select * from ares where acsTransId = ?";
		PreparedStatement pr = con.prepareStatement(query);
		pr.setString(1, acsTransId);
		ResultSet result = pr.executeQuery();
		
		while(result.next()) {
			
			ares = new ARes(result.getString(1), Integer.toString(result.getInt(2)),
					result.getString(3), result.getString(4),result.getString(5),
					result.getString(6), result.getString(7), result.getString(8),result.getString(9),
					result.getString(10), result.getString(11));
			li.add(ares);
		}
		pr.close();
		con.close();
		return li;
	}
	
	
	public List<ARes> getAresByAcsReferenceNumber(String acsRefenceNumber) throws ClassNotFoundException, SQLException{

		Connection con = connect();
		List<ARes> li = new ArrayList<ARes>();
		ARes ares;
		String query = "select * from ares where acsReferenceNumber = ?";
		PreparedStatement pr = con.prepareStatement(query);
		pr.setInt(1, Integer.parseInt(acsRefenceNumber));
		ResultSet result = pr.executeQuery();
		
		while(result.next()) {
			
			ares = new ARes(result.getString(1), Integer.toString(result.getInt(2)),
					result.getString(3), result.getString(4),result.getString(5),
					result.getString(6), result.getString(7), result.getString(8),result.getString(9),
					result.getString(10), result.getString(11));
			li.add(ares);
		}
		pr.close();
		con.close();
		return li;
	}
	

	
	private Connection connect() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		String ConString = "jdbc:sqlite:"+System.getProperty("user.dir")+"\\ACS.db";//directory of the sqlite.db
		Connection con = DriverManager.getConnection(ConString);
		return con;
	}
	
	
}
