/*
 * @author Ashwani K
 */
package com.microservices.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.microservices.entity.TourRating;
import com.microservices.entity.TourRatingPk;

/**
 * The Interface TourRatingRepo.
 */
@RepositoryRestResource(exported = false)
public interface TourRatingRepo extends CrudRepository<TourRating, TourRatingPk> {

	/**
	 * Find by pk tour id.
	 *
	 * @param tourId the tour id
	 * @return the list
	 */
	List<TourRating> findByPkTourId(Integer tourId);

	/**
	 * Find by pk tour id and customer id.
	 *
	 * @param tourId     the tour id
	 * @param customerId the customer id
	 * @return the tour rating
	 */
	TourRating findByPkTourIdAndCustomerId(Integer tourId, Integer customerId);

}
