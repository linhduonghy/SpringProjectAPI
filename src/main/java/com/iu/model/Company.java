package com.iu.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// ten cong ty
	private String name;
	// ma so thue
	private String taxId;
	// von dieu le
	private Long charterCapital;
	// linh vuc hoat dong
	private String operationField;
	// so nhan vien
	private int numberOfStaff;
	// dia chi trong toa nha
	private String addressInBuilding;
	// so dien thoai
	private String phone;
	// dien tich mat bang
	private int spaceArea;

	// danh sach nhan vien trong cong ty
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)	
	@JsonIgnore
	private List<CompanyStaff> companyStaffs;

	// dich vu su dung
//	private List<Service> services;
	@OneToMany(mappedBy = "company",  cascade = CascadeType.ALL)
	//@EqualsAndHashCode.Exclude	
	private List<CompanyService> services;

	@JsonInclude()
	@Transient
	private long totalCost;
	public void setTotalCost() {
		// tien thue mat bang
		long areaSpaceCost = spaceArea * /* don gia */ 1000000; // 1 trieu dong cho 1 m2 mat bang

		// ti le don gia dich vu
		float rate = 1;
		if (numberOfStaff < 10 && spaceArea < 100) {
			// do not anything
		} else {
			int number_of_staff_over = Math.max((numberOfStaff - 10), 0);
			int space_area_over = Math.max((spaceArea - 100), 0);			
			rate += (float)(number_of_staff_over / 5) * 0.05 + (float)(space_area_over / 10) * 0.05;			
		}
		// tien su dung dich vu
		double totalServiceCost = 0;
		for (CompanyService cs : services) {
			Service service = cs.getService();
			totalServiceCost += service.getUnitPrice() * rate;
		}
		// tong tien
		
		totalCost = areaSpaceCost + Math.round(totalServiceCost);
	}
}
