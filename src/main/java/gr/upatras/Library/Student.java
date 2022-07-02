package gr.upatras.Library;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstname;
    private String lastname;
	private int allowance;
	
    public Student(){
    }
	
	public Student(int id, String firstname, String lastname, int allowance) {
		this.firstname = firstname;
        this.lastname = lastname;
		this.allowance = allowance;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
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

}