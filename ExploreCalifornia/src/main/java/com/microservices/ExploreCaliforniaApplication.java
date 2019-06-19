/*
 * @author Ashwani K
 */
package com.microservices;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.entity.Difficulty;
import com.microservices.entity.Region;
import com.microservices.services.TourPackageServices;
import com.microservices.services.TourServices;

/**
 * The Class ExploreCaliforniaApplication.
 */
@SpringBootApplication
public class ExploreCaliforniaApplication implements CommandLineRunner {

	/** The tour package services. */
	@Autowired
	private TourPackageServices tourPackageServices;

	/** The tour services. */
	@Autowired
	private TourServices tourServices;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ExploreCaliforniaApplication.class, args);
	}

	/**
	 * Run.
	 *
	 * @param args the args
	 * @throws Exception the exception
	 */
	@Override
	public void run(String... args) throws Exception {
		// Create the default tour packages
		tourPackageServices.createTourPackage("BC", "Backpack Cal");
		tourPackageServices.createTourPackage("CC", "California Calm");
		tourPackageServices.createTourPackage("CH", "California Hot springs");
		tourPackageServices.createTourPackage("CY", "Cycle California");
		tourPackageServices.createTourPackage("DS", "From Desert to Sea");
		tourPackageServices.createTourPackage("KC", "Kids California");
		tourPackageServices.createTourPackage("NW", "Nature Watch");
		tourPackageServices.createTourPackage("SC", "Snowboard Cali");
		tourPackageServices.createTourPackage("TC", "Taste of California");
		// doing the iteration for the list of pacakges here
		tourPackageServices.lookUpPackages().forEach(tourPackage -> System.out.println(tourPackage));
		// now we will call the static method to pass each tour information in the
		// tourPackage
		// Persist the Tours to the database
		TourFromFile.importTours()
				.forEach(t -> tourServices.createTour(t.title, t.description, t.blurb, Double.parseDouble(t.price),
						t.length, t.bullets, t.keywords, t.packageType, Difficulty.valueOf(t.difficulty),
						Region.findByLabel(t.region)));
		System.out.println("Number of tours =" + tourServices.countAllTour());

	}

	// creating the Helper class for reading the files from the file and doing
	/**
	 * The Class TourFromFile.
	 */
	// marshall and unmarshalling
	static class TourFromFile {
		
		/** The keywords. */
		private String title, blurb, description, bullets, difficulty, price, region, keywords;
		
		/** The length. */
		String length;
		
		/** The package type. */
		private String packageType;

		/**
		 * Import tours.
		 *
		 * @return the list
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		// defining the method here for reading the file
		static List<TourFromFile> importTours() throws IOException {
			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).readValue(
					TourFromFile.class.getResourceAsStream("/ExploreCalifornia.json"),
					new TypeReference<List<TourFromFile>>() {
					});
		}
	}

}
