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
@Table(name = "Equipments")
public class Equipment {
	@Id
	@GeneratedValue
	@Column(name = "EquipmentID")
	Integer equipmentID;

	@Column(name = "Name")
	String name;
	
	@Column(name = "Quantity")
	String quantity;
	
	@Column(name = "DateImport")
	String dateImport;
	
	@Column(name = "UserImport")
	String userImport;

	public Integer getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(Integer equipmentID) {
		this.equipmentID = equipmentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getDateImport() {
		return dateImport;
	}

	public void setDateImport(String dateImport) {
		this.dateImport = dateImport;
	}

	public String getUserImport() {
		return userImport;
	}

	public void setUserImport(String userImport) {
		this.userImport = userImport;
	}

	

}
