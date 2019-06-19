/*
 * @author Ashwani K
 */
package com.microservices.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.dto.RatingDTO;
import com.microservices.entity.Tour;
import com.microservices.entity.TourRating;
import com.microservices.repo.TourRatingRepo;
import com.microservices.repo.TourRepo;

/**
 * The Class TourRatingController.
 */
@RestController
@RequestMapping(path = "/tours/{tourId}/ratings")
public class TourRatingController {

	/** The tour rating repository. */
	TourRatingRepo tourRatingRepository;

	/** The tour repo. */
	TourRepo tourRepo;

	/**
	 * Instantiates a new tour rating controller.
	 *
	 * @param tourRatingRepository the tour rating repository
	 * @param tourRepo             the tour repo
	 */
	@Autowired
	public TourRatingController(TourRatingRepo tourRatingRepository, TourRepo tourRepo) {
		super();
		this.tourRatingRepository = tourRatingRepository;
		this.tourRepo = tourRepo;
	}

	/**
	 * Instantiates a new tour rating controller.
	 */
	protected TourRatingController() {

	}

	/**
	 * To DTO.
	 *
	 * @param tourRating the tour rating
	 * @return the rating DTO
	 */
	private RatingDTO toDTO(TourRating tourRating) {
		return new RatingDTO(tourRating.getScore(), tourRating.getComment(), tourRating.getPk().customerId);
	}

	/**
	 * Verify tour.
	 *
	 * @param tourId the tour id
	 * @return the tour
	 * @throws NoSuchElementException the no such element exception
	 */
	private Tour verifyTour(int tourId) throws NoSuchElementException {
		Tour tour = tourRepo.findOne(tourId);
		if (tour == null) {
			throw new NoSuchElementException("The" + tourId + "you are looking doesn't Exists ");
		}
		return tour;
	}

	/**
	 * Return 400.
	 *
	 * @param ne the ne
	 * @return the string
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public String return400(NoSuchElementException ne) {
		return (ne.getMessage());
	}
}
