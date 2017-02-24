package Services;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import DB.Operations;
import Models.Mentee;
import Models.Mentor;
import Models.Register;

@Path("MentoringServices")
public class MentoringServices
{
	static String done ;

	@GET
	public String get()
	{
//		Gson gson = new Gson();
//		Register register = new Register("sanad@live.com","1234","sanad","haj","mentor","050422");
//		return gson.toJson(register);
		return "xxx";
	}
	
	@POST
	@Path("addNewUser")
	public String addNewUser(String registerJson) 
	{
		Gson gson = new Gson();
		//System.out.println("started!"+registerJson);
		Register register = gson.fromJson(registerJson, Register.class);
		String response;
		try {
			response = (String) Operations.addUser(register);
		
		done = "done";
		return gson.toJson(response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);

		}
		return"";
	}
	@POST
	@Path("mentorlist")
	@Produces(MediaType.TEXT_PLAIN)
	public String mentorlist()
	{
		Gson gson=new Gson();
		ArrayList<Mentor> response=new ArrayList<Mentor>();
		try {
			response =  Operations.MentorList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);

		}
		return gson.toJson(response);
	}
		
	
	@POST
	@Path("menteelist")
	public String menteelist()
	{
		Gson gson=new Gson();
		ArrayList<Mentee> response=new ArrayList<Mentee>();
		try {
			response =  Operations.MenteeList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);

		}
		return gson.toJson(response);
	}
	
	
	@POST
	@Path("loginUser")
	public String loginUser(String registerJson) throws SQLException 
	{
        Gson gson = new Gson();
        System.out.println(registerJson);
        Register register = gson.fromJson(registerJson, Register.class);
        String response;
       
         response = (String) Operations.Login(register);
            return gson.toJson(response);
       
    }
	
		
		
	}
	
		
	

