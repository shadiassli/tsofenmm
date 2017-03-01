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
import Models.Login;
import Models.Mentee;
import Models.MenteeProfile;
import Models.Mentor;
import Models.Register;
import Test.registertest;
import myFile.NewFile;

@Path("MentoringServices")
public class MentoringServices
{
	static String done ;

	@GET
	public String get()
	{
		
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
			System.out.println(register.getType());
			response = (String) Operations.addUser(register);
		
		done = "done";
		return gson.toJson(response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
			registertest.writelogger("addNewUser");

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
			registertest.writelogger("mentorlist");

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
			registertest.writelogger("menteelist");

		}
		return gson.toJson(response);
	}
	
	
	@POST
	@Path("loginUser")
	public String loginUser(String registerJson)  
	{
		try{
        Gson gson = new Gson();
        System.out.println(registerJson);
        Login register = gson.fromJson(registerJson, Login.class);
        Login response;
       
         response =  Operations.Login(register);
         System.out.println(response);
            return gson.toJson(response);
		}catch(Exception e)
		{
			e.printStackTrace();
			registertest.writelogger("loginUser");
			return null;
			
		}
    }
	
	   @POST
	   @Path("/updateMenteeProfile")
	   public void updateMenteeProfile(String json) 
	   {
		   try{
	       System.out.println("updateMenteeProfile - accessed");
	       Gson gson = new Gson();
	       MenteeProfile menteeProfile = gson.fromJson(json,MenteeProfile.class);
	       System.out.println(json);
	       if(menteeProfile.getGradeSheetFile()!=null)
	       {
	          NewFile pdfFile = new NewFile(menteeProfile.getGradeSheetFile());
	           pdfFile.run();
	       }
	       if(menteeProfile.getImageFile()!=null)
	       {
	    	   NewFile imageFile = new NewFile(menteeProfile.getImageFile());
	           imageFile.run();
	       }
	       if(menteeProfile.getResumeFile()!=null)
	       {
	    	   NewFile docxFile = new NewFile(menteeProfile.getResumeFile());
	           docxFile.run();
	       }
 
	       Operations.MenteePro(menteeProfile);
		   }catch(Exception e)
		   {
			   e.printStackTrace();
		   }

	   }
	
		
		
	}
	
		
	

