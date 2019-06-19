/*
 * @author Ashwani K
 */
package com.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.entity.Difficulty;
import com.microservices.entity.Region;
import com.microservices.entity.Tour;
import com.microservices.entity.TourPackage;
import com.microservices.repo.TourPackageRepo;
import com.microservices.repo.TourRepo;

/**
 * The Class TourServices.
 */
@Service
public class TourServices {

	/** The tour package repo. */
	// injecting the TourPackage Service and TourPackageRepo
	private TourPackageRepo tourPackageRepo;

	/** The tour repo. */
	private TourRepo tourRepo;

	/**
	 * Instantiates a new tour services.
	 *
	 * @param tourPackageRepo the tour package repo
	 * @param tourRepo        the tour repo
	 */
	@Autowired
	public TourServices(TourPackageRepo tourPackageRepo, TourRepo tourRepo) {
		super();
		this.tourPackageRepo = tourPackageRepo;
		this.tourRepo = tourRepo;
	}

	/**
	 * Instantiates a new tour services.
	 */
	public TourServices() {
		super();
	}

	/**
	 * Creates the tour.
	 *
	 * @param tourTitle       the tour title
	 * @param tourDesc        the tour desc
	 * @param tourBlurb       the tour blurb
	 * @param tourPrice       the tour price
	 * @param tourDuration    the tour duration
	 * @param tourBullets     the tour bullets
	 * @param tourKeywords    the tour keywords
	 * @param tourPackageName the tour package name
	 * @param tourDifficulty  the tour difficulty
	 * @param tourRegion      the tour region
	 * @return the tour
	 */
	public Tour createTour(String tourTitle, String tourDesc, String tourBlurb, Double tourPrice, String tourDuration,
			String tourBullets, String tourKeywords, String tourPackageName, Difficulty tourDifficulty,
			Region tourRegion) {
		TourPackage tourPackage = tourPackageRepo.findByPackageName(tourPackageName);
		if (tourPackage == null) {
			throw new RuntimeException("The TourPackage doesn't exists: " + tourPackageName);
		}
		return tourRepo.save(new Tour(tourTitle, tourDesc, tourBlurb, tourPrice, tourDuration, tourBullets,
				tourKeywords, tourPackageName, tourPackage, tourDifficulty, tourRegion));

	}

	/**
	 * Lookup tour.
	 *
	 * @return the iterable
	 */
	public Iterable<Tour> lookupTour() {
		return tourRepo.findAll();
	}

	/**
	 * Count all tour.
	 *
	 * @return the long
	 */
	public long countAllTour() {
		return tourRepo.count();
	}

}
