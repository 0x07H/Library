package gr.upatras.Library;

import javax.persistence.*;
//import java.util.List; 

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(required = false, hidden = true)
	private int id;
	private String firstName;
    private String lastName;
	private int allowance;
	

	public Student(){
    }

	public Student(String firstName, String lastName, int allowance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.allowance = allowance;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstname() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastname() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastname(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the allowance
	 */
	public int getAllowance() {
		return allowance;
	}

	/**
	 * @param allowance the allowance to set
	 */
	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}