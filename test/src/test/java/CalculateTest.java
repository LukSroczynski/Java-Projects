import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lukasz S. on 26.05.2017.
 */
public class CalculateTest {

    Calculate calculate = new Calculate();
    int sum = calculate.sum(2,5);
    int testSum = 7;

    @Test
    public void sum() throws Exception {
        assertEquals(testSum, sum);
    }

}