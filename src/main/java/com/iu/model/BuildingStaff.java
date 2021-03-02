package com.iu.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingStaff implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private String name;
	private Date dateOfBirth;
	private String address;
	private String phone;
	private int ranks;
	private String position;	
	
	// dich vu nhan vien thuc hien
	@ManyToOne
	@JoinColumn(name = "service_id", referencedColumnName = "id")
	private Service service;
}
