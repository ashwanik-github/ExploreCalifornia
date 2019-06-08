/*
 * @author Ashwani K
 */
package com.microservices.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * The Class TourPackage.
 */
@Entity
@Data
public class TourPackage implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3218476911849837341L;

	/** The package code. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tourPackageCode;

	/** The package name. */
	@Column(name = "name")
	private String packageName;

	/**
	 * Instantiates a new tour package.
	 *
	 * @param packageCode the package code
	 * @param packageName the package name
	 */
	public TourPackage(Integer tourPackageCode, String packageName) {
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
