package org.example;

import org.example.exceptions.InvalidCharacterException;
import org.example.exceptions.StringBlankOrEmptyException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void testGenerateAnagramsWithThreeLetters() {
        List<String> result = Main.generateAnagrams("abc");
        assertEquals(6, result.size(), "Should generate 6 permutations for 'abc'");
        assertTrue(result.contains("abc"));
        assertTrue(result.contains("acb"));
        assertTrue(result.contains("bac"));
        assertTrue(result.contains("bca"));
        assertTrue(result.contains("cab"));
        assertTrue(result.contains("cba"));
    }

    @Test
    void testGenerateAnagramsWithSingleLetter() {
        List<String> result = Main.generateAnagrams("a");
        assertEquals(1, result.size(), "Single letter should return one permutation");
        assertEquals("a", result.get(0));
    }

    @Test
    void testGenerateAnagramsWithEmptyInput() {
        assertThrows(StringBlankOrEmptyException.class, () -> Main.generateAnagrams(""));
    }

    @Test
    void testGenerateAnagramsWithInvalidCharacters() {
        assertThrows(InvalidCharacterException.class, () -> Main.generateAnagrams("a1b"));
    }
}