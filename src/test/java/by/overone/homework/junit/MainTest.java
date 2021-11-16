package by.overone.homework.junit;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static Main main;

    @BeforeAll
    public static void setUp() {
        main = new Main();
    }

    @Test
    public void isAmountWordsInLine() {
        assertEquals(main.amountWordsInLine("My name is Pavel. Ar"), 5);
    }

    @RepeatedTest(7)
    public void isEditLine() {
        assertArrayEquals(main.editLine(" name is Pavel ").toCharArray(), "n%me is P%vel".toCharArray());
    }

    @Ignore
    @Test
    public void isLineIsEmpty() {
        assertTrue(main.lineIsEmpty(""));
    }

    @Ignore("Pasha say")
    @Test
    public void isLineIsNotEmpty() {
        assertFalse(main.lineIsEmpty("My name is Pavel. Ar"));
    }

    private static Stream<Arguments> dataTest() {
        return Stream.of(Arguments.of("Privet pavlik eto vasha kasha", "pavlik eto vasha"),
                Arguments.of("My name", ""),
                Arguments.of("", ""),
                Arguments.of("Pavel is lavel", "is"));
    }

    @ParameterizedTest
    @MethodSource("dataTest")
    public void checkTest(String pass, String expected) {
        assertArrayEquals(expected.toCharArray(), main.lineWithoutFirstAndLastWords(pass).toCharArray());
    }
}