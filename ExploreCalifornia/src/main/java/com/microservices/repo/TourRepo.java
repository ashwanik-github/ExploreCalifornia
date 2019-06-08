/*
 * @author Ashwani K
 */
package com.microservices.repo;

import org.springframework.data.repository.CrudRepository;

import com.microservices.entity.Tour;

/**
 * The Interface TourRepo.
 */
public interface TourRepo extends CrudRepository<Tour, Integer> {

}
