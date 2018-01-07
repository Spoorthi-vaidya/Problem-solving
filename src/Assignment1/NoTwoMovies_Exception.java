package Assignment1;

import java.util.Arrays;

/*
 * Userdefined Exception 
 */
public class NoTwoMovies_Exception extends Exception {

	@Override
	public String toString() {
		return "There are NO two movies with sum of their length equal to TravelLength";
	}

}
