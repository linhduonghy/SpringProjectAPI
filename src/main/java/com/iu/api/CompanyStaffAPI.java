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
import com.iu.data.CompanyStaffRepository;
import com.iu.model.Company;
import com.iu.model.CompanyStaff;

@RestController
@RequestMapping(path = "/company_staff", produces = "application/json")
@CrossOrigin(origins = "*")
public class CompanyStaffAPI {

	private CompanyStaffRepository companyStaffRepo;
	private CompanyRepository companyRepo;
	@Autowired
	EntityLinks entityLinks;
	public CompanyStaffAPI(CompanyStaffRepository companyStaffRepo, CompanyRepository cr) {
		this.companyStaffRepo = companyStaffRepo;
		this.companyRepo = cr;
	}
	
	// get
	@GetMapping("/all")
	public Iterable<CompanyStaff> getAll() {
		return companyStaffRepo.findAll();
	}
	@GetMapping("/{id}")
	public CompanyStaff getById(@PathVariable int id) {
		Optional<CompanyStaff> optStaff = companyStaffRepo.findById(id);
		if (optStaff.isPresent()) {
			return optStaff.get();
		}
		return null;
	}
	@GetMapping("/name/{name}")
	public Iterable<CompanyStaff> getByName(@PathVariable String name) {
		return companyStaffRepo.findByNameIgnoreCaseContaining(name);		
	}
	
	// post
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public CompanyStaff insertCompanyStaff(@RequestBody CompanyStaff companyStaff) {
		CompanyStaff staff = companyStaffRepo.save(companyStaff);
		
		// plus number staff of company
		Company company = staff.getCompany();
		company.setNumberOfStaff(company.getNumberOfStaff() + 1);
		companyRepo.save(company);
		
		return staff;
	}
	
	// put
	@PutMapping("/{id}")
	public CompanyStaff updateCompanyStaff(@RequestBody CompanyStaff companyStaff, @PathVariable("id") int id) throws Exception {
		CompanyStaff c = getById(id);
		if (c == null) {
			throw new Exception("CompanyStaff not found");
		}
		return companyStaffRepo.save(companyStaff);
	}

	// delete
	@DeleteMapping("/{id}")
	public void deleteCompanyStaff(@PathVariable("id") int id) throws Exception {
		CompanyStaff c = getById(id);
		if (c == null) {
			throw new Exception("CompanyStaff not found");
		}
		Company company = c.getCompany();
		company.setNumberOfStaff(company.getNumberOfStaff()  - 1);
		companyRepo.save(company);
		companyStaffRepo.deleteById(id);			
	}
}
