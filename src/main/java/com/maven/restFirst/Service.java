/**
 * 
 */
package com.maven.restFirst;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * @author macbook
 *
 */
public class Service {
	
	PersonDao ps =new PersonDao();
	

	public Response delete(int id) {
		if (id!=0) {		
			return Response.status(202).entity("User deleted successfully !!").build();
		}else 
		return null;

			
	}

	public Response update(int id) {

		// TODO Auto-generated method stub
		return Response.noContent().build();
		
	}

	public Response creat(Person user) {
		// TODO Auto-generated method stub
		return Response.status(Status.CREATED).build();
	}

	public Person select(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return ps.select(id);
	}

	public List<Person> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return (List<Person>) ps.selectAll();
	}

}
