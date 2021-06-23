package gym.jpa;

import java.io.Serializable;
import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the card_category database table.
 * 
 */
@Entity

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="card_category")
@NamedQuery(name="CardCategory.findAll", query="SELECT c FROM CardCategory c")
public class CardCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CARD_CATEGORY_ID_GENERATOR", sequenceName="CARD_CATEGORY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARD_CATEGORY_ID_GENERATOR")
	private Integer id;

	private String description;

	private String mark;

	private String name;

	//bi-directional many-to-one association to Member
	@JsonIgnore
	@OneToMany(mappedBy="cardCategory")
	private List<Member> members;

	public CardCategory() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Member> getMembers() {
		return this.members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public Member addMember(Member member) {
		getMembers().add(member);
		member.setCardCategory(this);

		return member;
	}

	public Member removeMember(Member member) {
		getMembers().remove(member);
		member.setCardCategory(null);

		return member;
	}

}