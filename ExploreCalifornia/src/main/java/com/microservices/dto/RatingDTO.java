/*
 * @author Ashwani K
 */
package com.microservices.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * The Class RatingDTO.
 */

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
public class RatingDTO {

	/** The score. */
	@Min(0)
	@Max(5)
	private Integer score;

	/** The comment. */
	@Size(max = 255)
	private String comment;

	/** The customer id. */
	@NotNull()
	private Integer customerId;

	/**
	 * Instantiates a new rating DTO.
	 *
	 * @param score      the score
	 * @param comment    the comment
	 * @param customerId the customer id
	 */
	public RatingDTO(Integer score, String comment, Integer customerId) {
		super();
		this.score = score;
		this.comment = comment;
		this.customerId = customerId;
	}

	/**
	 * Instantiates a new rating DTO.
	 */
	public RatingDTO() {
		super();
	}

}
