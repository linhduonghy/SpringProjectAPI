package com.iu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Service implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	// loai dich vu
	private String type;
	// don gia
	private long unitPrice;
	
	// danh sach cong ty su dung dich vu
	@OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
//	@JsonIgnore
	//@EqualsAndHashCode.Exclude
	
	private List<CompanyService> companies;	
	
	// danh sach nhan vien toan nha thuc hien dich vu nay
	@OneToMany(mappedBy = "service")
	@JsonIgnore
	private List<BuildingStaff> buildingStaffs;
}
