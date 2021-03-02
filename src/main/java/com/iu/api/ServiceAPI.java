package com.iu.api;

import java.util.ArrayList;
import java.util.List;
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

import com.iu.data.ServiceRepository;
import com.iu.model.Service;

@RestController
@RequestMapping(path = "/service", produces = "application/json")
@CrossOrigin(origins = "*")
public class ServiceAPI {
	
	private ServiceRepository serviceRepo;
	
	@Autowired
	EntityLinks entityLinks;
	public ServiceAPI(ServiceRepository repository) {
		this.serviceRepo = repository;
	}
	
	// get
	@GetMapping("/all")
	public Iterable<Service> getAll() {
		return serviceRepo.findAll();
	}
	@GetMapping("/{id}")
	public Service getById(@PathVariable int id) {
		Optional<Service> optService = serviceRepo.findById(id);
		if (optService.isPresent()) {
			return optService.get();
		}
		return null;
	}
	// dich vu mac dinh cac cong ty phai su dung
	@GetMapping("/default_company_service")
	public List<Service> getDefault() {
		Iterable<Service> f = serviceRepo.findByNameIgnoreCaseContaining("Bảo vệ");
		Iterable<Service> s = serviceRepo.findByNameIgnoreCaseContaining("Vệ sinh");
		List<Service> res = new ArrayList<Service>();
		res.add(f.iterator().next());
		res.add(s.iterator().next());
		return res;
	}
	@GetMapping("/name/{name}")
	public Iterable<Service> getByName(@PathVariable String name) {
		return serviceRepo.findByNameIgnoreCaseContaining(name);		
	}
	
	// post
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Service insertService(@RequestBody Service service) {		
		return serviceRepo.save(service);
	}
	
	// put
	@PutMapping("/{id}")
	public Service updateService(@RequestBody Service service, @PathVariable("id") int id) throws Exception {
		Service s = getById(id);
		if (s == null) {
			throw new Exception("Service not found!");
		}
		return serviceRepo.save(service);
	}
	
	// delete
	@DeleteMapping("/{id}")
	public void deleteService(@PathVariable int id) {
		serviceRepo.deleteById(id);		
	}
	
	
	
}
