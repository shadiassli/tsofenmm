package DB;

import java.util.ArrayList;
import java.sql.*;

import javax.ws.rs.WebApplicationException;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

import Models.Mentee;
import Models.Mentor;
import Models.Register;

public class Operations 
{
	
	public static String addUser(Register register) throws SQLException 
	{
		String response = "";
		Connection connection = MyConnection.getConnection();
		String select = "SELECT * FROM users WHERE EMAIL = ?";
		String sql = "INSERT INTO users(EMAIL,PASSWORD,FIRSTNAME,LASTNAME,TYPE,PHONE) VALUES(?,?,?,?,?,?)";
		PreparedStatement preparedStatement1 = connection.prepareStatement(select);
		preparedStatement1.setString(1, register.getEmail());
		ResultSet result = preparedStatement1.executeQuery();
		if(result.next())
		{
			throw new WebApplicationException(302);
		}
		else
		{
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, register.getEmail());
		preparedStatement.setString(2, register.getPassword());
		preparedStatement.setString(3, register.getFirstName());
		preparedStatement.setString(4, register.getLastName());
		preparedStatement.setString(5, register.getType());
		preparedStatement.setString(6, register.getPhone());
		preparedStatement.executeUpdate();
		PreparedStatement preparedStatement2 = connection.prepareStatement(select);
		preparedStatement2.setString(1, register.getEmail());
		ResultSet result1 = preparedStatement1.executeQuery();
		if(result1.next())
		{
			response = result1.getString(1);
		}
		return response;
		}
	}
	
	public static ArrayList<Mentor> MentorList() throws SQLException{
		String response;
		ArrayList<Mentor> mentor=new ArrayList<Mentor>();
		Connection con;
		try{
		con=MyConnection.getConnection();
		String select = "SELECT * FROM MENTOR";
		Statement st=(Statement) con.createStatement();
		ResultSet rs=st.executeQuery(select);
		while(rs.next())
		{
			Mentor m=new Mentor(rs.getInt("USERID"), rs.getString("GENSER"), rs.getString("ADDRESS"), rs.getString("POSITION"), rs.getString("EXPERIENCE"), rs.getString("NOTES"));
			mentor.add(m);
		}
		return mentor;
		}
	catch(Exception e){return null;}
	}
	
	
	public static ArrayList<Mentee> MenteeList() throws SQLException{
		
		String response;
		ArrayList<Mentee> mentee=new ArrayList<Mentee>();
		Connection con;
		try{
		con=MyConnection.getConnection();
		String select = "SELECT * FROM MENTEE";
		Statement st=(Statement) con.createStatement();
		ResultSet rs=st.executeQuery(select);
		while(rs.next())
		{
			Mentee m=new Mentee(rs.getInt("USERID"), rs.getInt("MENTORID"), rs.getDate("RIGISTRATION_DATE"), rs.getString("GENDER"),
					rs.getString("ADDRESS"), rs.getString("EDUCATION_STATUS"), rs.getString("ACADIMIC_INSTITUTION"),
					rs.getInt("SEMESTERS_LEFT"), rs.getInt("TSOFEN_CURSE"),rs.getString("NOTES"));
			mentee.add(m);
		}
		return mentee;
		
		}catch(Exception e){return null;}
}
	
public static String Login(Register register) throws SQLException{
        
        String response = "";
        Connection connection = MyConnection.getConnection();
        String select = "SELECT * FROM users WHERE EMAIL = ? AND PASSWORD = ?";
        PreparedStatement preparedStatement1 = connection.prepareStatement(select);
        preparedStatement1.setString(1, register.getEmail());
        preparedStatement1.setString(2, register.getPassword());
        ResultSet result = preparedStatement1.executeQuery();
        if(result.next())
        {
            response=Integer.toString(result.getInt("ID"));
        }
        else
        {
            throw new WebApplicationException(404);
        }
        return response;
        
    }
	
	
	
	
	
	
	
	
	
	
	
}

