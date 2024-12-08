import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

class StreamExampleTest {
    // Normal Test Cases
    @Test
    void testFilterEvenNumbers_NormalCase() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected = Arrays.asList(2, 4, 6, 8, 10);
        assertEquals(expected, StreamExample.filterEvenNumbers(input));
    }

    @Test
    void testMapToSquares_NormalCase() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(1, 4, 9, 16, 25);
        assertEquals(expected, StreamExample.mapToSquares(input));
    }

    @Test
    void testSumNumbers_NormalCase() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        int expected = 15;
        assertEquals(expected, StreamExample.sumNumbers(input));
    }

    // Edge Test Cases
    @Test
    void testFilterEvenNumbers_EmptyList() {
        List<Integer> input = Collections.emptyList();
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, StreamExample.filterEvenNumbers(input));
    }

    @Test
    void testMapToSquares_SingleElement() {
        List<Integer> input = Collections.singletonList(3);
        List<Integer> expected = Collections.singletonList(9);
        assertEquals(expected, StreamExample.mapToSquares(input));
    }

    @Test
    void testSumNumbers_NegativeNumbers() {
        List<Integer> input = Arrays.asList(-1, -2, -3, -4, -5);
        int expected = -15;
        assertEquals(expected, StreamExample.sumNumbers(input));
    }
}