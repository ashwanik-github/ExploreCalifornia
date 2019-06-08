/*
 * @author Ashwani K
 */
package com.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.entity.TourPackage;
import com.microservices.repo.TourPackageRepo;

/**
 * The Class TourPackageServices.
 */
@Service
public class TourPackageServices {

	/** The tour package repo. */
	// inject the TourPackageRepository here
	private TourPackageRepo tourPackageRepo;

	/**
	 * Instantiates a new tour package services.
	 *
	 * @param tourPackageRepo the tour package repo
	 */
	@Autowired
	protected TourPackageServices(TourPackageRepo tourPackageRepo) {
		super();
		this.tourPackageRepo = tourPackageRepo;
	}

	/**
	 * Creates the tour package.
	 *
	 * @param code the code
	 * @param name the name
	 * @return the tour package
	 */
	// creating the tour package hereby
	public TourPackage createTourPackage(Integer code, String name) {
		if (!tourPackageRepo.exists(code)) {
			tourPackageRepo.save(new TourPackage(code, name));
		}
		return null;
	}

	/**
	 * Look up all.
	 *
	 * @return the iterable
	 */
	// return all the tourPackage hereby
	public Iterable<TourPackage> lookUpAll() {
		return tourPackageRepo.findAll();
	}

	/**
	 * Count all.
	 *
	 * @return the long
	 */
	// return count of all the tourPackageCount hereby
	public long countAll() {
		return tourPackageRepo.count();
	}
}
