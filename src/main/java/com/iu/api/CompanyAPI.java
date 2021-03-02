package com.iu.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iu.data.CompanyRepository;
import com.iu.data.CompanyServiceRepo;
import com.iu.model.Company;
import com.iu.model.CompanyService;

@RestController
@RequestMapping(path = "/company", produces = "application/json")
@CrossOrigin(origins = "*")
public class CompanyAPI {

	private CompanyRepository companyRepo;
	private CompanyServiceRepo cpRepo;
	@Autowired
	EntityLinks entityLinks;	
	public CompanyAPI(CompanyRepository companyRepository, CompanyServiceRepo cpRepo) {
		this.companyRepo = companyRepository;		
		this.cpRepo = cpRepo;
	}
	
	// get
	@GetMapping("/all")
	public Iterable<Company> getAll() {
		Iterable<Company> companies = companyRepo.findAll();
		companies.forEach( company -> {
			company.setTotalCost();
		});
		return companies;
	}
	@GetMapping("/{id}")
	public Company getById(@PathVariable int id) {
		Optional<Company> optC = companyRepo.findById(id);
		if (optC.isPresent()) {
			Company company = optC.get();
			company.setTotalCost();
			return company;
		}
		return null;
	}
	@GetMapping("/name/{name}")
	public Iterable<Company> getByName(@PathVariable String name) {
		return companyRepo.findByNameIgnoreCaseContaining(name);
	}

	// post
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED) 
	public Company insertCompany(@RequestBody Company company) {	
		company = companyRepo.save(company);		
		return company;
	}
	
	// put
	@PutMapping("/{id}")
	public Company updateCompany(@RequestBody Company company, @PathVariable int id) throws Exception {
		Company c = getById(id);
		if (c == null) {
			throw new  Exception("Company not found");
		}
		return companyRepo.save(company);
	}
	
	// delete
	@DeleteMapping("/{id}")
	public void deleteCompany(@PathVariable int id) {
		companyRepo.deleteById(id);
	}
}
