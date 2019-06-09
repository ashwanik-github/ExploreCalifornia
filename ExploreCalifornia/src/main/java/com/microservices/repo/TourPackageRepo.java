/*
 * @author Ashwani K
 */
package com.microservices.repo;

import org.springframework.data.repository.CrudRepository;

import com.microservices.entity.TourPackage;

/**
 * The Interface TourPackageRepo.
 */
public interface TourPackageRepo extends CrudRepository<TourPackage, String> {

	// create a method here to findByName for the PackageName in Json
	TourPackage findByName(String name);

}
