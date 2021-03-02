package com.iu.data;

import org.springframework.data.repository.CrudRepository;

import com.iu.model.CompanyService;
import com.iu.model.CompanyServiceId;

public interface CompanyServiceRepo extends CrudRepository<CompanyService, CompanyServiceId> {

}
