/*
 * @author Ashwani K
 */
package com.microservices.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.microservices.entity.TourPackage;

/**
 * The Interface TourPackageRepo.
 */
@RepositoryRestResource(collectionResourceRel = "packages", path = "packages")
public interface TourPackageRepo extends CrudRepository<TourPackage, String> {

	/**
	 * Find by package name.
	 *
	 * @param packageName the package name
	 * @return the tour package
	 */
	// create a method here to findByName for the PackageName in Json
	TourPackage findByPackageName(@Param("packageName") String packageName);

	/**
	 * Save.
	 *
	 * @param <S>    the generic type
	 * @param entity the entity
	 * @return the s
	 */
	@Override
	@RestResource(exported = false)
	<S extends TourPackage> S save(S entity);

	/**
	 * Save.
	 *
	 * @param <S>      the generic type
	 * @param entities the entities
	 * @return the iterable
	 */
	@Override
	@RestResource(exported = false)
	<S extends TourPackage> Iterable<S> save(Iterable<S> entities);

	/**
	 * Find all.
	 *
	 * @param ids the ids
	 * @return the iterable
	 */
	@Override
	@RestResource(exported = false)
	Iterable<TourPackage> findAll(Iterable<String> ids);

	/**
	 * Count.
	 *
	 * @return the long
	 */
	@Override
	@RestResource(exported = false)
	long count();

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	@Override
	@RestResource(exported = false)
	void delete(String id);

	/**
	 * Delete.
	 *
	 * @param entities the entities
	 */
	@Override
	@RestResource(exported = false)
	void delete(Iterable<? extends TourPackage> entities);

	/**
	 * Delete all.
	 */
	@Override
	@RestResource(exported = false)
	void deleteAll();

}
