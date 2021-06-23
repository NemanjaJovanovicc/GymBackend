package gym.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EMPLOYEE_ID_GENERATOR", sequenceName="EMPLOYEE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEE_ID_GENERATOR")
	private Integer id;

	private String contact;

	private String name;

	private String password;

	private String surname;

	private String username;

	//bi-directional many-to-one association to GymCard
	@JsonIgnore
	@OneToMany(mappedBy="employee")
	private List<GymCard> gymCards;

	public Employee() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<GymCard> getGymCards() {
		return this.gymCards;
	}

	public void setGymCards(List<GymCard> gymCards) {
		this.gymCards = gymCards;
	}

	public GymCard addGymCard(GymCard gymCard) {
		getGymCards().add(gymCard);
		gymCard.setEmployee(this);

		return gymCard;
	}

	public GymCard removeGymCard(GymCard gymCard) {
		getGymCards().remove(gymCard);
		gymCard.setEmployee(null);

		return gymCard;
	}

}