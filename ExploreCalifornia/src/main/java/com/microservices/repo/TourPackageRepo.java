/*
 * @author Ashwani K
 */
package com.microservices.repo;

import org.springframework.data.repository.CrudRepository;

import com.microservices.entity.TourPackage;

/**
 * The Interface TourPackageRepo.
 */
public interface TourPackageRepo extends CrudRepository<TourPackage, Integer> {

	@Override
	TourPackage findOne(Integer tourPackageCode);

}
