package com.maven.restFirst;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("myresource")
public class RestfullEmployee {
	private PersonDao ps = new PersonDao();
	private Service service = new Service();


	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> SelectAll() throws SQLException {
//		return (List<Person>) ps.selectAll();

        return service.selectAll();
	}

	@GET
	@Path("select/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person get(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
		System.out.println("id");
//		return ps.select(id);
		return service.select(id);

	}

	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Person user) throws ClassNotFoundException, SQLException {
		System.out.println(user + "created");
		ps.create(user);
		System.out.println(ps + "######");

//		return Response.status(Status.CREATED).build();
		return service.creat(user);
	}

	@PUT
	@Path("update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Person user) throws ClassNotFoundException, SQLException {

		ps.update(user);
		System.out.println(ps);

//		return Response.noContent().build();
		return service.update(id);

	}

	@DELETE
	@Path("delete/{id}")
	public Response delete(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		ps.delete(id);
//		return Response.status(202).entity("User deleted successfully !!").build();
		return service.delete(id);
	}

}
