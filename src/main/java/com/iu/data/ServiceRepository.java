package com.iu.data;

import org.springframework.data.repository.CrudRepository;

import com.iu.model.Service;

public interface ServiceRepository extends CrudRepository<Service, Integer>{

	Iterable<Service> findByNameIgnoreCaseContaining(String name);

}
