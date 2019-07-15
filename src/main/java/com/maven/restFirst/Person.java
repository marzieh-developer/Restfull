/**
 * 
 */
package com.maven.restFirst;

/**
 * @author macbook
 *
 */
public class Person {
	/**
	 * @param name
	 * @param family
	 * @param email
	 * @param id
	 */
	public Person(int id ,String name, String family, String email ) {
		super();
		this.id = id;
		this.name = name;
		this.family = family;
		this.email = email;
		
	}
	public Person() {
		
	}
	private int id;
	private String name;
	private String family;
	private String email;
//	*******getters and setters*********
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	


}
