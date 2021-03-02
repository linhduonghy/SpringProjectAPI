package com.iu.data;

import org.springframework.data.repository.CrudRepository;

import com.iu.model.CompanyStaff;

public interface CompanyStaffRepository extends CrudRepository<CompanyStaff, Integer>{
	Iterable<CompanyStaff> findByNameIgnoreCaseContaining(String name);
}
