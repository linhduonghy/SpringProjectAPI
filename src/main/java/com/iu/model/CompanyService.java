package com.iu.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(CompanyServiceId.class)
public class CompanyService {

	@Id
	@ManyToOne
	@JoinColumn(name = "company_id", referencedColumnName = "id")
	@JsonIgnoreProperties("services")
	private Company company;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "service_id", referencedColumnName = "id")
	@JsonIgnoreProperties("companies")
	private Service service;

	@Column(name = "created_on")
	private Date createdOn = new Date(System.currentTimeMillis());	
}
