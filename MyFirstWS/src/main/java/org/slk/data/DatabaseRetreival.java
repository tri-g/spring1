package org.slk.data;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.slk.data.User;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
@Path("/data")
public class DatabaseRetreival 
{
@GET
@Path("/getData")
//@Produces(MediaType.TEXT_PLAIN)
public List<User> getData()
{
	List<User> listuser=new ArrayList<User>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?useSSL=false","root","1234");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from department");
		while(rs.next())
		{
			
			listuser.add(new User(rs.getInt("id"),rs.getString("name"),rs.getString("desc")));
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	return listuser;
	
}

}
