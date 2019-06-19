/*
 * @author Ashwani K
 */
package com.microservices.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * The Class TourPackage.
 */
@Entity

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data
public class TourPackage implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3218476911849837341L;

	/** The tour package code. */
	@Id
	private String tourPackageCode;

	/** The package name. */
	@Column(name = "name")
	private String packageName;

	/**
	 * Instantiates a new tour package.
	 *
	 * @param tourPackageCode the tour package code
	 * @param packageName     the package name
	 */
	public TourPackage(String tourPackageCode, String packageName) {
		super();
		this.tourPackageCode = tourPackageCode;
		this.packageName = packageName;
	}

	/**
	 * Instantiates a new tour package.
	 */
	protected TourPackage() {
		super();
	}

}
