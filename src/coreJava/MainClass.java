package coreJava;

public class MainClass {
	public static void main(String[] args) {
		String s1 = "javaj2eehibernatestruts";
		String s2 = "strutsj2eehibernatejava";

		// Step 1

		if (s1.length() != s2.length()) {
			System.out.println("s2 is not rotated version of s1");
		} else {
			// Step 2

			String s3 = s1 + s1;

			// Step 3

			if (s3.contains(s2)) {
				System.out.println("s2 is a rotated version of s1");
			} else {
				System.out.println("s2 is not rotated version of s1");
			}
		}
	}
}