/*
 * @author Ashwani K
 */
package com.microservices.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

/**
 * The Class TourRating.
 */
@Entity

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
public class TourRating {

	/** The pk. */
	@EmbeddedId
	private TourRatingPk pk;

	/** The score. */
	@Column(nullable = false)
	private Integer score;

	/** The comment. */
	@Column
	private String comment;

	/**
	 * Instantiates a new tour rating.
	 *
	 * @param pk      the pk
	 * @param score   the score
	 * @param comment the comment
	 */
	public TourRating(TourRatingPk pk, Integer score, String comment) {
		super();
		this.pk = pk;
		this.score = score;
		this.comment = comment;
	}

	/**
	 * Instantiates a new tour rating.
	 */
	protected TourRating() {
		super();
	}

}
