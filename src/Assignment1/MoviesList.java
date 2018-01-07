package Assignment1;

import java.util.*;
import java.io.*;

public class MoviesList {

	static final int noofmovies = 10;

	final HashMap<Integer, MovieKeys> movielist = new HashMap<Integer, MovieKeys>(
			noofmovies);

	public MoviesList() {
		super();
		this.pair_movie_length();

	}

	/*
	 * Functionality: Add available movies into Hashmap
	 */

	final void pair_movie_length() {

		movielist.put(1, new MovieKeys("Bahubali", 180));
		movielist.put(2, new MovieKeys("IronMan", 120));
		movielist.put(3, new MovieKeys("Transformer", 140));
		movielist.put(4, new MovieKeys("Titanic", 160));
		movielist.put(5, new MovieKeys("Oscar", 150));
		movielist.put(6, new MovieKeys("Jumanji", 190));
		movielist.put(7, new MovieKeys("SpiderMan", 120));
		movielist.put(8, new MovieKeys("BatMan", 144));
		movielist.put(9, new MovieKeys("SuperMan", 154));
		movielist.put(10, new MovieKeys("Krishh", 166));

	}

}
