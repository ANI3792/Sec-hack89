package com.anagram.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.anagram.Anagram;

class AnagramTest {
	private static Anagram anagram;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		anagram = new Anagram();
	}

	@Test
	void testIsAnagramNull() {
		Assertions.assertFalse(anagram.isAnagram(null, "hey"));
	}

	@Test
	void testIsAnagram() {
		Assertions.assertTrue(anagram.isAnagram("true", "e u tr"));
	}

	@Test
	void testIsAnagramLenngth() {
		Assertions.assertFalse(anagram.isAnagram("helllo hiii good evening how are you doing", "e u tr"));
	}
	
	@Test
	void testIsNotAnagram() {
		Assertions.assertEquals(false, anagram.isAnagram("heyy", "hello"));
		}
	
	@Test
	void testIsAnagramSpecialChar() {
		Assertions.assertTrue(anagram.isAnagram("s-pe-c-ial", "laiceps"));
		}

}
