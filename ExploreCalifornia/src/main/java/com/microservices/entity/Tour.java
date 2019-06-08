/*
 * @author Ashwani K
 */
package com.microservices.entity;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * The Class Tour.
 */
@Entity
@Data
public class Tour implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2139680364484128457L;

	/** The tour id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tourId;

	/** The tour title. */
	@Column(name = "title")
	private String tourTitle;

	/** The tour desc. */
	@Column(name = "desc", length = 2000)
	private String tourDesc;

	/** The tour blurb. */
	@Column(name = "blurb", length = 2000)
	private String tourBlurb;

	/** The tour price. */
	@Column(name = "price")
	private Double tourPrice;

	/** The tour duration. */
	@Column(name = "duration")
	private Float tourDuration;

	/** The tour bullets. */
	@Column(name = "bullets", length = 2000)
	private String tourBullets;

	/** The tour keywords. */
	@Column(name = "keywords", length = 2000)
	private String tourKeywords;

	/** The tour package code. */
	@Column(name = "packageCode")
	private Integer tourPackageCode;

	/** The tour package. */
	@ManyToOne
	private TourPackage tourPackage;

	/** The tour difficulty. */
	@Column(name = "difficulty")
	private Difficulty tourDifficulty;

	/** The tour region. */
	@Column(name = "region")
	private Region tourRegion;

	/**
	 * Instantiates a new tour.
	 *
	 * @param tourId          the tour id
	 * @param tourTitle       the tour title
	 * @param tourDesc        the tour desc
	 * @param tourBlurb       the tour blurb
	 * @param tourPrice       the tour price
	 * @param tourDuration    the tour duration
	 * @param tourBullets     the tour bullets
	 * @param tourKeywords    the tour keywords
	 * @param tourPackageCode the tour package code
	 * @param tourPackage2    the tour package
	 * @param tourDifficulty  the tour difficulty
	 * @param tourRegion      the tour region
	 */
	public Tour(Integer tourId, String tourTitle, String tourDesc, String tourBlurb, Double tourPrice,
			Float tourDuration, String tourBullets, String tourKeywords, Integer tourPackageCode,
			TourPackage tourPackage, Difficulty tourDifficulty, Region tourRegion) {
		super();
		this.tourId = tourId;
		this.tourTitle = tourTitle;
		this.tourDesc = tourDesc;
		this.tourBlurb = tourBlurb;
		this.tourPrice = tourPrice;
		this.tourDuration = tourDuration;
		this.tourBullets = tourBullets;
		this.tourKeywords = tourKeywords;
		this.tourPackageCode = tourPackageCode;
		this.tourPackage = tourPackage;
		this.tourDifficulty = tourDifficulty;
		this.tourRegion = tourRegion;
	}

	/**
	 * Instantiates a new tour.
	 */
	public Tour() {
		super();
	}

	public Tour(Integer tourId, String tourTitle, String tourDesc, String tourBlurb, Double tourPrice,
			Float tourDuration, String tourBullets, String tourKeywords, Integer tourPackageCode,
			Optional<TourPackage> tourPackage, Difficulty tourDifficulty, Region tourRegion) {
		// TODO Auto-generated constructor stub
		this.tourId = tourId;
		this.tourTitle = tourTitle;
		this.tourDesc = tourDesc;
		this.tourBlurb = tourBlurb;
		this.tourPrice = tourPrice;
		this.tourDuration = tourDuration;
		this.tourBullets = tourBullets;
		this.tourKeywords = tourKeywords;
		this.tourPackageCode = tourPackageCode;
		this.tourDifficulty = tourDifficulty;
		this.tourRegion = tourRegion;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
