package com.iu.data;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iu.model.CompanyStaff;
import com.iu.model.CompanyStaffInOut;

public interface CompanyStaffInOutRepository extends CrudRepository<CompanyStaffInOut, Integer> {
	
	List<CompanyStaffInOut> findByCompanyStaff(CompanyStaff companyStaff);

	List<CompanyStaffInOut> findByCompanyStaffAndTimeGreaterThanEqualAndTimeLessThan(CompanyStaff companyStaff, Date start,Date end);
}
