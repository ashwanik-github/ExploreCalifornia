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
	protected TourServices() {
		super();
	}

	/**
	 * Creates the tour.
	 *
	 * @param tourId          the tour id
	 * @param tourTitle       the tour title
	 * @param tourDesc        the tour desc
	 * @param tourBlurb       the tour blurb
	 * @param tourPrice       the tour price
	 * @param tourDuration    the tour duration
	 * @param tourBullets     the tour bullets
	 * @param tourKeywords    the tour keywords
	 * @param tourPackageCode the tour package code
	 * @param tourDifficulty  the tour difficulty
	 * @param tourRegion      the tour region
	 * @return the tour
	 */
	public Tour createTour(Integer tourId, String tourTitle, String tourDesc, String tourBlurb, Double tourPrice,
			Float tourDuration, String tourBullets, String tourKeywords, Integer tourPackageCode,
			Difficulty tourDifficulty, Region tourRegion) {
		TourPackage tourPackage = tourPackageRepo.findOne(tourPackageCode);
		if (tourPackage == null) {
			throw new RuntimeException("The TourPackage doesn't exists: " + tourPackageCode);
		}
		return tourRepo.save(new Tour(tourId, tourTitle, tourDesc, tourBlurb, tourPrice, tourDuration, tourBullets,
				tourKeywords, tourPackageCode, tourPackage, tourDifficulty, tourRegion));

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
