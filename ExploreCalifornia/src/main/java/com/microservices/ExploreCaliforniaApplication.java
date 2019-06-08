/*
 * @author Ashwani K
 */
package com.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		tourPackageServices.createTourPackage(100, "BackPack Cal");
		tourPackageServices.createTourPackage(200, "California Calm");
		tourPackageServices.createTourPackage(300, "California Calm");
		tourPackageServices.createTourPackage(400, "Cycling Califonia");
		tourPackageServices.createTourPackage(500, "From Desert to Sea");
		tourPackageServices.createTourPackage(600, "Kids California");
		tourPackageServices.createTourPackage(700, "Taste of California");
		tourPackageServices.createTourPackage(800, "Snowbal Cal");
		// doing the iteration for the list of pacakges here
		tourServices.lookupTour().forEach(tourPackage -> System.out.println(tourPackage));
	}

}
