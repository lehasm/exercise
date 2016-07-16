import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BitCountTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {8, 1},
                {Integer.MIN_VALUE, 1},
                {Integer.MAX_VALUE, 31},
                {-1, 2},
                {7, 3}
        });
    }

    @Parameterized.Parameter
    public int number;

    @Parameterized.Parameter(value = 1)
    public int expectedCount;

    @Test
    public void count() throws Exception {
        assertEquals(expectedCount, BitCount.count(number));
    }

}