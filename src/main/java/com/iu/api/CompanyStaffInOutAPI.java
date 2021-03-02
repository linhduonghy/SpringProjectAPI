package com.iu.api;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iu.data.CompanyStaffInOutRepository;
import com.iu.data.CompanyStaffRepository;
import com.iu.model.CompanyStaff;
import com.iu.model.CompanyStaffInOut;

@RestController
@RequestMapping(path = "/staff_inout", produces = "application/json")
@CrossOrigin(origins = "*")
public class CompanyStaffInOutAPI {
	private CompanyStaffInOutRepository staffInOutRepo;
	private CompanyStaffRepository staffRepo;

	@Autowired
	public CompanyStaffInOutAPI(CompanyStaffInOutRepository staffInOutRepo, CompanyStaffRepository staffRepo) {

		this.staffInOutRepo = staffInOutRepo;
		this.staffRepo = staffRepo;
	}

	// get
	@GetMapping("/all")
	public Iterable<CompanyStaffInOut> getAll() {
		return staffInOutRepo.findAll();
	}
	
	@GetMapping("/staff/{id}")
	public List<CompanyStaffInOut> getByStaff(@PathVariable int id) {
		Optional<CompanyStaff> staff = staffRepo.findById(id);
		if (staff.isPresent()) {
			List<CompanyStaffInOut> staffInOut = staffInOutRepo.findByCompanyStaff(staff.get());
			return staffInOut;
		}
		return null;
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public CompanyStaffInOut insert(@RequestBody CompanyStaffInOut csio) {
		staffInOutRepo.save(csio);
		return null;
	}
	
	// report
	@GetMapping("/report/{staffId}/{date}")
	public List<CompanyStaffInOut> report(@PathVariable("staffId") int staffId, @PathVariable("date") Date date) {
		Optional<CompanyStaff> staff = staffRepo.findById(staffId);
		if (staff.isPresent()) {
			CompanyStaff s = staff.get();			
			List<CompanyStaffInOut> staffInOut = staffInOutRepo.
					findByCompanyStaffAndTimeGreaterThanEqualAndTimeLessThan(
							s, date, new Date(date.getTime() + (1000 * 60 * 60 * 24)));			
			return staffInOut;
		}
		return null;
	}
}
