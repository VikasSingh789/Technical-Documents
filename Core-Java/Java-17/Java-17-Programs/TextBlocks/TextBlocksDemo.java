package com.programs.java17.textBlocks;

public class TextBlocksDemo {

	public static void main(String[] args) {
		String str = """
				This is String
				It can Span Multiple Lines
				""";
		System.out.println(str);
		
		String stripIndent = """
				Line 1
					Line 2
				Line 3
				""";
		System.out.println("Original Text");
		System.out.println(stripIndent);
		
		String stripped = stripIndent.stripIndent();
		System.out.println("After StripIndent");
		System.out.println(stripped);
		
		String translatedEscapes = """
				First Line\\nSecond Line\\tTabbed
				""";
		System.out.println("Before translatedEscapes():");
		System.out.println(translatedEscapes);
		
		String translated = translatedEscapes.translateEscapes();
		System.out.println("After translatedEscapes():");
		System.out.println(translated);
		
		
		String json = """
				Name: %s
				Age: %d
				City: %s
				""";
		String result = json.formatted("Alice",25,"London");
		System.out.println(result);
	}

}
