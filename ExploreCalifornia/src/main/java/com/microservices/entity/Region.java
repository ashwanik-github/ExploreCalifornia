/*
 * @author Ashwani K
 */
package com.microservices.entity;

/**
 * The Enum Region.
 */
public enum Region {

	/** The Central coast. */
	Central_Coast("Central Coast"),
	/** The Southern california. */
	Southern_California("Southern California"),

	/** The Northern california. */
	Northern_California("Northern_California"),
	/** The Varies. */
	Varies("Varies");

	/** The label. */
	private String label;

	/**
	 * Instantiates a new region.
	 *
	 * @param label the label
	 */
	private Region(String label) {
		this.label = label;
	}

	/**
	 * Find by label.
	 *
	 * @param byLabel the by label
	 * @return the region
	 */
	public static Region findByLabel(String byLabel) {
		for (Region region : Region.values()) {
			if (region.label.equalsIgnoreCase(byLabel))
				return region;
		}
		return null;
	}
}
