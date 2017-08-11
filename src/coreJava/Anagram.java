package coreJava;

class Anagram {
	public static void main(String[] args) {
		permutation("Malay");
		System.out.println(AreAnagrams("xyzw", "xyxy"));
	}
	private static void permutation(String str) {
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}

	private static Boolean AreAnagrams(String inOne, String inTwo) {
		boolean result = false;
		if (inOne.length() == inTwo.length()) {
			int sumOne = 0;
			int sumTwo = 0;
			char[] a = inOne.toLowerCase().toCharArray();
			char[] b = inTwo.toLowerCase().toCharArray();
			for (int i = 0; i < inOne.length(); i++) {
				sumOne += (int) a[i];
				sumTwo += (int) b[i];
			}
			result = sumOne == sumTwo;
		}
		return result;
	}
}
