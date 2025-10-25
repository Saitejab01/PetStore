package genericUtilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseUtil {
	FileUtil flib = new FileUtil();
	Connection con =null;
	public void connectToDB() throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dBUrl=flib.getValueFromPropertiesFile("DBUrl");
		String dBuserName=flib.getValueFromPropertiesFile("DBUsername");
		String dBPassword=flib.getValueFromPropertiesFile("DBPassword");
		con=DriverManager.getConnection(dBUrl,dBuserName,dBPassword);
	}
	public boolean getDataFromDBAndVerify(String query,int colNum , String ExceptedText) throws SQLException {
		try {
			ResultSet result=con.createStatement().executeQuery(query);
			while (result.next()) {
				if (result.getString(colNum).equals(ExceptedText)) {
					System.out.println(ExceptedText+" is verified in DB");
					return true;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(ExceptedText+" is not present in DB");
		return false;
	}
	public void closeConnection() throws SQLException {
		con.close();
	}
}
