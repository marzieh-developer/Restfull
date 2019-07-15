/**
 * 
 */
package com.maven.restFirst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

/**
 * @author macbook
 *
 */
public class PersonDao {
	private List<Person> persons;
	private Connection connection;
	private PreparedStatement pStatement;
	
	/**
	 * @param persons
	 * @param connection
	 * @param pStatement
	 */
	public PersonDao()
	{
	persons = new ArrayList<>();
		 connection =null;
		 pStatement = null;
				try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e1) {
										e1.printStackTrace();
				}
				try {
					connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "postgres", "12349");
				} catch (SQLException e) {
										e.printStackTrace();
				}			
	}	
	
	public List<Person> selectAll() throws SQLException {			
			pStatement = connection.prepareStatement("SELECT * FROM employee");
			ResultSet rowS = pStatement.executeQuery();
			while (rowS.next()) {
				Person p = new Person();
				p.setId(rowS.getInt("id"));
				p.setName(rowS.getString("name"));
				p.setFamily(rowS.getString("family"));
				p.setEmail(rowS.getString("email"));
				System.out.println(p.getId() + "," + p.getName());

				persons.add(p);

			}

				if (pStatement != null) {
					pStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
		return persons;

	}

	public Person select(int id) throws SQLException  {
		Person p = new Person();
			
			pStatement = connection.prepareStatement("SELECT * FROM employee  WHERE id=?");
			pStatement.setInt(1, id);
			ResultSet rowS = pStatement.executeQuery();
			if (rowS.next()) {
				p.setId(rowS.getInt("id"));
				p.setName(rowS.getString("name"));
				p.setFamily(rowS.getString("family"));
				p.setEmail(rowS.getString("email"));
			}
			try {
				if (pStatement != null) {
					pStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
			}
		
		return p;
	}

	public void create(Person user) throws SQLException  {

			pStatement = connection.prepareStatement("INSERT INTO employee(id ,name,family,email) " + "VALUES (? , ? , ? , ? )");
			pStatement.setInt(1, user.getId());
			pStatement.setString(2, user.getName());
			pStatement.setString(3, user.getFamily());
			pStatement.setString(4, user.getEmail());
			int rowI = pStatement.executeUpdate();
			if (rowI > 0) {
				System.out.println("insetr is succesfully");
			} else {
				System.out.println("insetr is not succesfully");
			}

			try {
				if (pStatement != null) {
					pStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {

			}
		System.out.println("select another number:");

	}

	public void update(Person user) throws SQLException  {
		pStatement = connection.prepareStatement("UPDATE employee SET name=? ,family=? , email=? WHERE id=? ");
			pStatement.setInt(4, user.getId());
			pStatement.setString(1, user.getName());
			pStatement.setString(2, user.getFamily());
			pStatement.setString(3, user.getEmail());

			int rowD = pStatement.executeUpdate();
			if (rowD > 0) {
				System.out.println("An existing user was updated successfully!");
			}
			try {
				if (pStatement != null) {
					pStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {

			}

	}

	public void delete(int id) throws SQLException  {

		pStatement = connection.prepareStatement("DELETE FROM  employee WHERE id=?");
			pStatement.setInt(1, id);
			int rowD = pStatement.executeUpdate();
			if (rowD > 0) {
				System.out.println("user deleted");
			} 
			try {
				if (pStatement != null) {
					pStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				System.out.println("error in delete");

			}

}
}