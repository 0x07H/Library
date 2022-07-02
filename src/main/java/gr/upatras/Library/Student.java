package gr.upatras.Library;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String Name;
	private int allowance;
	
    public Student(){
    }
	
	public Student(int id, String Name, int allowance) {
		this.Name = Name;
		this.allowance = allowance;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}


	/**
	 * @return the allowance
	 */
	public int getAllowance() {
		return allowance;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.Name = name;
	}


	/**
	 * @param allowance the allowance to set
	 */
	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}
}
	
	