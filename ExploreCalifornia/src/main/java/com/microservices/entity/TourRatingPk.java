/*
 * @author Ashwani K
 */
package com.microservices.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * The Class TourRatingPk.
 */
@Embeddable

/**
 * To string.
 *
 * @return the java.lang. string
 */

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data
public class TourRatingPk implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 829516113883826218L;

	/** The tour. */
	@ManyToOne
	private Tour tour;

	/** The customer id. */
	@Column(updatable = false, insertable = false, nullable = false)
	public Integer customerId;

	/**
	 * Instantiates a new tour rating pk.
	 *
	 * @param tour       the tour
	 * @param customerId the customer id
	 */
	public TourRatingPk(Tour tour, Integer customerId) {
		super();
		this.tour = tour;
		this.customerId = customerId;
	}

	/**
	 * Instantiates a new tour rating pk.
	 */
	protected TourRatingPk() {
		super();
	}

}
