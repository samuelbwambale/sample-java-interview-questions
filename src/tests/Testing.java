package tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static miu.Longest2CharSubstring.longest2CharacterSubstring;
import static miu.Longest2CharSubstring.numberOfUniques;
import static org.junit.Assert.assertEquals;

public class Testing {

    @Test
    public void testFirstNonRepeatedCharacter() {
        assertEquals('b', miu.FirstUniqueChar.firstNonRepeatedCharacter("abcdefghija"));
        assertEquals('h', miu.FirstUniqueChar.firstNonRepeatedCharacter("hello"));
        assertEquals('J', miu.FirstUniqueChar.firstNonRepeatedCharacter("Java"));
        assertEquals('i', miu.FirstUniqueChar.firstNonRepeatedCharacter("simplest"));
    }

//    @Test
//    public void testRemoveEvenOccurance() {
//        assertEquals("abca", miu.EvenOccuranceRemoved.removeEvenOccurance("aabbccaa"));
//        assertEquals("a1b2c", miu.EvenOccuranceRemoved.removeEvenOccurance("a1ab2bc1c"));
//        assertEquals("abcabc", miu.EvenOccuranceRemoved.removeEvenOccurance("abcabcabccba"));
//    }

    @Test
    public void testLongest2CharacterSubstring() {
        assertEquals("bcbbbbcccb", longest2CharacterSubstring("abcbbbbcccbdddadacb"));
        assertEquals(2, numberOfUniques(longest2CharacterSubstring("abcbbbbcccbdddadacb")));
    }
}
