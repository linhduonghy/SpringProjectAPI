package com.iu.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CompanyStaff implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private String name;	
	private Date dateOfBirth;	
	private String phone;	
	// so cmnd
	private String cardNumber;	
	
	// ma cong ty
	@ManyToOne
	@JoinColumn(name = "company_id")	
	
	private Company company;
	
	@OneToMany(mappedBy = "companyStaff", cascade = CascadeType.ALL)
	private List<CompanyStaffInOut> inOuts;	
}
