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
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * The Class Tour.
 */
@Entity

/**
 * To string.
 *
 * @return the java.lang. string
 */
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
	private String tourDuration;

	/** The tour bullets. */
	@Column(name = "bullets", length = 2000)
	private String tourBullets;

	/** The tour keywords. */
	@Column(name = "keywords", length = 2000)
	private String tourKeywords;

	/** The tour package code. */
	@Column(name = "packageCode")
	private String tourPackageCode;

	/** The tour package. */
	@ManyToOne(targetEntity = TourPackage.class)
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
	 * @param tourTitle       the tour title
	 * @param tourDesc        the tour desc
	 * @param tourBlurb       the tour blurb
	 * @param tourPrice       the tour price
	 * @param tourDuration    the tour duration
	 * @param tourBullets     the tour bullets
	 * @param tourKeywords    the tour keywords
	 * @param tourPackageCode the tour package code
	 * @param tourPackage     the tour package
	 * @param tourDifficulty  the tour difficulty
	 * @param tourRegion      the tour region
	 */
	public Tour(String tourTitle, String tourDesc, String tourBlurb, Double tourPrice, String tourDuration,
			String tourBullets, String tourKeywords, String tourPackageCode, TourPackage tourPackage,
			Difficulty tourDifficulty, Region tourRegion) {
		super();
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

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
