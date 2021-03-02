package com.iu.data;

import org.springframework.data.repository.CrudRepository;

import com.iu.model.BuildingStaff;

public interface BuildingStaffRepository extends CrudRepository<BuildingStaff, Integer>{

	Iterable<BuildingStaff> findByNameIgnoreCaseContaining(String name);

}
