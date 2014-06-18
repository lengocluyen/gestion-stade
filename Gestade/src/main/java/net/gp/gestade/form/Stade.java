package net.gp.gestade.form;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "Stades")
public class Stade {

	@Id
	@GeneratedValue
	@Column(name = "StadeID")
	Long stadeID;

	@Column(name = "Name")
	String name;
	
	@Column(name = "Position")
	String position;
	
	@Column(name = "Description")
	String description;
	
	@Column(name = "Type")
	String type;
	
	@Column(name = "State")
	String state;

	public Long getStadeID() {
		return stadeID;
	}

	public void setStadeID(Long stadeID) {
		this.stadeID = stadeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	

}
