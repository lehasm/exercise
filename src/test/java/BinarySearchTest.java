import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BinarySearchTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0, 1, 2, 6, 8, 15, 45, 56}, 0, 0},
                {new int[]{0, 1, 2, 6, 8, 15, 45, 56}, 2, 2},
                {new int[]{0, 1, 2, 6, 8, 15, 45, 56}, 6, 3},
                {new int[]{0, 1, 2, 6, 8, 15, 45, 56}, 7, -1},
                {new int[]{0, 1, 2, 6, 8, 15, 45, 56}, 56, 7},
                {new int[]{0, 1, 2, 6, 8, 15, 45, 56}, 65, -1},
                {new int[]{0, 1, 2, 6, 8, 15, 45, 56}, -2, -1},
                {new int[]{0, 1}, -2, -1},
                {new int[]{0, 1}, 0, 0},
                {new int[]{0}, 1, -1},
                {new int[]{0}, 0, 0},
                {new int[]{-16, -9, -5, 0, 3, 7, 12, 18, 20, 24, 30, 32, 38, 47, 50}, -30, -1},
                {new int[]{-16, -9, -5, 0, 3, 7, 12, 18, 20, 24, 30, 32, 38, 47, 50}, -16, 0},
                {new int[]{-16, -9, -5, 0, 3, 7, 12, 18, 20, 24, 30, 32, 38, 47, 50}, 7, 5},
                {new int[]{-16, -9, -5, 0, 3, 7, 12, 18, 20, 24, 30, 32, 38, 47, 50}, 20, 8},
                {new int[]{-16, -9, -5, 0, 3, 7, 12, 18, 20, 24, 30, 32, 38, 47, 50}, 24, 9},
                {new int[]{-16, -9, -5, 0, 3, 7, 12, 18, 20, 24, 30, 32, 38, 47, 50}, 40, -1},
                {new int[]{-16, -9, -5, 0, 3, 7, 12, 18, 20, 24, 30, 32, 38, 47, 50}, 50, 14},
                {new int[]{-16, -9, -5, 0, 3, 7, 12, 18, 20, 24, 30, 32, 38, 47, 50}, 60, -1},
        });
    }

    @Parameterized.Parameter
    public int[] source;

    @Parameterized.Parameter(value = 1)
    public int elem;

    @Parameterized.Parameter(value = 2)
    public int expected;

    @Test
    public void search() throws Exception {
        assertEquals(expected, BinarySearch.search(source, elem));
    }

}