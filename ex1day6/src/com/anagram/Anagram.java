package com.anagram;

import java.util.Arrays;

public class Anagram {

	public boolean isAnagram(String s1, String s2) {
		boolean b = false;
		if (s1 != null && s2 != null && s1.length() < 20 && s2.length() < 20) {
			s1 = s1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
			s2 = s2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
			char c1[] = s1.toCharArray();
			char c2[] = s2.toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			s1 = new String(c1);
			s2 = new String(c2);
			if (s1.equals(s2)) {
				b = true;
			}

		}

		return b;
	}

}
