package coreJava;

import java.util.HashMap;
import java.util.Stack;

class braces {

	public static void main(String[] args) {

		String[] s = { "}{", "{}" };
		int i=s.length;
		for (String st : s) {
			System.out.println(isValid(st));
		}

	}

	private static boolean isValid(String s) {

		HashMap<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);

			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		return stack.empty();
	}
}
