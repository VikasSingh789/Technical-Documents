package simpleprograms;


public class CountCharactersFromString {
	static void countCharacterFromString(String str) {
		char c[] = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			int count = 1;
			if (c[i] != ' ') {
				for (int j = i + 1; j < c.length; j++) {
					if (c[i] == c[j]) {
						c[j] = ' ';
						count++;
					}
				}
				if (count > 1) {
					System.out.print(c[i]);
					System.out.print(count + " ");
				}
			}
		}
	}

	static void countCharacterFromStringWithCollections(String str) {
		char ch[] = str.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		for (Character c : ch) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		for (Map.Entry<Character, Integer> entrySet : map.entrySet()) {
			System.out.print(entrySet.getKey() + "" + entrySet.getValue() + " ");
		}
	}

	public static void main(String[] args) {
		String str = "aabbbc";

		countCharacterFromString(str);
		System.out.println();
		System.out.println("================");
		countCharacterFromStringWithCollections(str);

	}
}

//input:-  aabbbc
//output:- a2 b3 c1 
