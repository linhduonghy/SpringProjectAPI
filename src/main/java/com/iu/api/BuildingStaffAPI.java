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

import com.iu.data.BuildingStaffRepository;
import com.iu.model.BuildingStaff;

@RestController
@RequestMapping(path = "/building_staff", produces = "application/json")
@CrossOrigin(origins = "*")
public class BuildingStaffAPI {
	
	private BuildingStaffRepository buildingStaffRepo;
	
	@Autowired
	EntityLinks entityLinks;
	public BuildingStaffAPI(BuildingStaffRepository buildingStaffRepo) {
		this.buildingStaffRepo = buildingStaffRepo;
	}	
	
	// get
	@GetMapping("/all")
	public Iterable<BuildingStaff> getAll() {
		return buildingStaffRepo.findAll();
	}
	@GetMapping("/{id}")
	public BuildingStaff getById(@PathVariable int id) {
		Optional<BuildingStaff> optB = buildingStaffRepo.findById(id);
		if (optB.isPresent()) {
			return optB.get();
		}
		return null;
	}
	@GetMapping("/name/{name}")
	public Iterable<BuildingStaff> getByName(@PathVariable String name) {
		return buildingStaffRepo.findByNameIgnoreCaseContaining(name);
	}
	
	// post
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public BuildingStaff insertBuildingStaff(@RequestBody BuildingStaff buildingStaff) {
		return buildingStaffRepo.save(buildingStaff);
	}
	
	// put
	@PutMapping("/{id}")
	public BuildingStaff updateBuildingStaff(@RequestBody BuildingStaff buildingStaff, @PathVariable int id) throws Exception {		
		BuildingStaff b = getById(id);
		if (b == null ) {
			throw new Exception("BuldingStaff not found");
		}
		return buildingStaffRepo.save(buildingStaff);		
	}
	
	// delete 
	@DeleteMapping("/{id}")
	public void deleteBuildingStaff(@PathVariable int id) {
		buildingStaffRepo.deleteById(id);
	}
}