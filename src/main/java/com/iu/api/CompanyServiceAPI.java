package com.iu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iu.data.CompanyRepository;
import com.iu.data.CompanyServiceRepo;
import com.iu.model.Company;
import com.iu.model.CompanyService;

@RestController
@RequestMapping(path = "/company_service", produces = "application/json")
@CrossOrigin(origins = "*")
public class CompanyServiceAPI {

	private CompanyServiceRepo csRepo;
	@Autowired
	EntityLinks entityLinks;	
	public CompanyServiceAPI(CompanyServiceRepo cpRepo) {		
		this.csRepo = cpRepo;
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED) 
	public CompanyService insertCompany(@RequestBody CompanyService companyService) {	
		return 	csRepo.save(companyService);
	}
}
