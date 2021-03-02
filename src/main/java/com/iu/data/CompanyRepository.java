package com.iu.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iu.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

	Iterable<Company> findByNameIgnoreCaseContaining(String name);

}
