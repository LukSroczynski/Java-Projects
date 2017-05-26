import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lukasz S. on 26.05.2017.
 */


@Ignore
public class ListOfThingsTest {

    ListOfThings listOfThings = new ListOfThings();
    String[] bag1 = { "Books", "Notebooks", "Pens" };
    String[] bag2 = { "Books", "Notebooks", "Pens", "Pencils"};

    @Test
    public void prepareMyBag() throws Exception {
        assertArrayEquals(bag1, listOfThings.prepareMyBag());
    }

    @Test
    public void addPencils() throws Exception {
        assertArrayEquals(bag2, listOfThings.addPencils());
    }

}