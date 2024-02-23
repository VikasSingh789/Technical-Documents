package com.programs;

import java.util.*;
import java.util.stream.IntStream;

public class MissingDominosTiles {

	public static String missingTileWithJava7(List<String> tiles) {
		Set<String> set = new HashSet<>(tiles);

		for (String result : tiles) {
			set.add(new StringBuffer(result).reverse().toString());
		}

		for (int i = 0; i <= 6; i++) {
			for (int j = 0; j <= 6; j++) {

				String tile = i + "-" + j;
				if (!set.contains(tile)) {
					return tile;
				}
			}
		}
		return "";
	}

	public static String missingTileWithJava8Stream(List<String> tiles) {

		Set<String> set = new HashSet<String>(tiles);

		tiles.forEach(n -> set.add(new StringBuffer(n).reverse().toString()));

		return IntStream.rangeClosed(0, 6).boxed().flatMap(i -> IntStream.rangeClosed(0, 6).mapToObj(j -> i + "-" + j))
				.filter(tile -> !set.contains(tile)).findFirst().orElse("");
	}

	public static void main(String[] args) {

		String[] tilesArray = { "0-0", "0-1", "0-2", "0-3", "1-0", "1-1", "1-2", "1-3" };
		List<String> tiles = Arrays.asList(tilesArray);

		System.out.println("With Java 7: " + MissingDominosTiles.missingTileWithJava7(tiles));
		System.out.println("With Java 8: " + MissingDominosTiles.missingTileWithJava8Stream(tiles));
	}

}

//input:-   "0-0", "0-1", "0-2", "0-3", "1-0", "1-1", "1-2", "1-3"

//output:-  With Java 7: 0-4
//          With Java 8: 0-4
