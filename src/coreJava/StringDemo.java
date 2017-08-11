package coreJava;

class StringDemo {
	private static int i;
	private static int c = 0;
	private static int res;

	private static int wordcount() {
		char ch[] = new char["Viru  Tank".length()]; // in string especially we have to
											// mention the () after length
		for (i = 0; i < "Viru  Tank".length(); i++) {
			ch[i] = "Viru  Tank".charAt(i);
			if (((i > 0) && (ch[i] != ' ') && (ch[i - 1] == ' '))
					|| ((ch[0] != ' ') && (i == 0)))
				c++;
		}
		return c;
	}

	public static void main(String args[]) {
		res = StringDemo
				.wordcount();
		// string is always passed in double quotes

		System.out.println("The number of words in the String are :  " + res);
	}
}