package com.demoshop.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import com.github.javafaker.Faker;

public class UniqueGenerator {
	
	public static Faker fake=new Faker();
	public static String getUniqueEmail() {
		Faker faker = new Faker();
		return faker.internet().emailAddress();
	}
	
	public static String getUniqueFName() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}
	
	public static String getUniqueLName() {
		Faker faker = new Faker();
		return faker.name().lastName();
	}
	public static String getUniquePswd() {
		Faker faker = new Faker();
		return faker.internet().password();
	}
	
	public static String getUniqueCityName() {
		Faker faker = new Faker();
		return faker.address().cityName();
	}
	public static String getUniqueAddress() {
		Faker faker = new Faker();
		return faker.address().fullAddress();
	}
	
	public static String getUniquePhnNumber() {
		Faker faker = new Faker();
		return faker.phoneNumber().phoneNumber();
	}
	public static String getUniqueZipCode() {
		Faker faker = new Faker();
		return faker.address().zipCode();
	}
	public static String getCurrentDateTime() {
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());  
		  return date.replaceAll("[^0-9]", "");
	    
	}
	
	/*private static final String[] indianCities = {
	            "Mumbai", "Delhi", "Bangalore", "Hyderabad", "Ahmedabad", "Chennai", 
	            "Kolkata", "Surat", "Pune", "Jaipur", "Lucknow", "Kanpur", "Nagpur", 
	            "Indore", "Thane", "Bhopal", "Visakhapatnam", "Patna", "Vadodara", "Ghaziabad"
	    };

	private static final String[] streets = {
	            "MG Road", "Station Road", "Ring Road", "Gandhi Marg", "Nehru Street", 
	            "Lal Chowk", "Link Road", "Park Street", "Palace Road", "College Road"
	    };

	    // Indian mobile number starts with +91 followed by a 10-digit number
    private static final String[] phonePrefixes = {
	            "91"
	    };
	    
	private static final Random random = new Random();  */

	    
	

	/*public static int randomNumber() {
		int randonNum = random.nextInt(1000);
		return randonNum;*/
	
	
	
	/*public static String generateCity() {
        return indianCities[random.nextInt(indianCities.length)];
    }

    // Generates a random Indian pincode (6 digits)
    public static String generatePincode() {
        int pincode = random.nextInt(900000) + 100000;  // Generates a 6-digit pincode
        return String.valueOf(pincode);
    }

    // Generates a random address in India
    public static String generateAddress() {
        int houseNumber = random.nextInt(999) + 1;  // House number between 1 and 999
        String streetName = streets[random.nextInt(streets.length)];
        return houseNumber + " " + streetName;
    }

    // Generates a random Indian phone number in the format +91-XXXXXXXXXX
    public static String generatePhoneNumber() {
        String prefix = phonePrefixes[0];
        long phoneNumber = (long) (random.nextDouble() * 1_000_000_0000L) + 7_000_000_000L;  // Ensures a valid 10-digit mobile number
        return "+" + prefix + "-" + phoneNumber;   */
    }

