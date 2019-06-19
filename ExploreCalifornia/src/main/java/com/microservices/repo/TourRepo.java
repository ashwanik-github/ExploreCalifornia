/*
 * @author Ashwani K
 */
package com.microservices.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.microservices.entity.Tour;

/**
 * The Interface TourRepo.
 */
public interface TourRepo extends PagingAndSortingRepository<Tour, Integer> {

	/**
	 * Find by tour package code.
	 *
	 * @param code the code
	 * @param page the page
	 * @return the list
	 */
	List<Tour> findByTourPackageCode(@Param("packageCode") String code, Pageable page);

	/**
	 * Save.
	 *
	 * @param <S>    the generic type
	 * @param entity the entity
	 * @return the s
	 */
	@Override
	@RestResource(exported = false)
	<S extends Tour> S save(S entity);

	/**
	 * Find all.
	 *
	 * @return the iterable
	 */
	@Override
	@RestResource(exported = false)
	Iterable<Tour> findAll();

	/**
	 * Delete.
	 *
	 * @param entity the entity
	 */
	@Override
	@RestResource(exported = false)
	void delete(Tour entity);

	/**
	 * Save.
	 *
	 * @param <S>      the generic type
	 * @param entities the entities
	 * @return the iterable
	 */
	@Override
	@RestResource(exported = false)
	<S extends Tour> Iterable<S> save(Iterable<S> entities);

}
