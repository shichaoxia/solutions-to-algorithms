package chapter2.section5.exercise2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompoundWordTest {

    @Test
    void findCompoundWords() {
        String[] words = {"after", "thought", "afterthought", "pic", "fine", "picture", "ture"};
        String[] expected = {"afterthought", "picture"};
        assertArrayEquals(expected, CompoundWord.findCompoundWords(words).toArray());
    }
}