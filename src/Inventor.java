import java.util.*;

public class Inventor {
	
	private String name;
	private Date birthDate;
	private String nationality;
	
	public Inventor(String name, Date birthDate, String nationality) {
		this.name = name;
		this.birthDate = birthDate;
		this.nationality = nationality;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

}
