package com.maleficus.homework2.task8;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Vitalii Umanets
 */
public class ListImplTest {

    ListImpl<Integer> sampleList;
    public ListImplTest() {
    }

    @Before
    public void initSampleList(){
        sampleList = new ListImpl<Integer>(){{
            put(0);
            put(1);
            put(2);
            put(3);
            put(4);
            put(5);
        }};
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetElementAt() {
        int index = 3;
        Integer expResult = 3;
        Integer result = sampleList.getElementAt(index);
        assertEquals("Get third element from [0 1 2 3 4 5]", expResult, result);
        sampleList.getElementAt(-1);//Should throw IndexOutOfBoundsException
        sampleList.getElementAt(sampleList.getSize());//Should throw IndexOutOfBoundsException
    }

    @Test
    public void testPut() {
        sampleList.put(6);
        Integer expResult = 6;
        Integer result = sampleList.getElementAt(sampleList.getSize()-1);
        assertEquals("Should add 6 as the last element", expResult, result);
    }

    @Test
    public void testPutAt() {
        sampleList.putAt(2, 6);//[0 1 6 2 3 4 5]
        Integer expResult = 6;
        Integer result = sampleList.getElementAt(2);
        assertEquals("Should add 6 as the second element", expResult, result);
        expResult = 2;
        result = sampleList.getElementAt(3);
        assertEquals("Should not mess up the order.", expResult, result);
        sampleList.putAt(0, -1);//[-1 0 1 6 2 3 4 5]
        expResult = -1;
        result = sampleList.getElementAt(0);
        assertEquals("Should be possible to set a new head.", expResult, result);
        expResult = 0;
        result = sampleList.getElementAt(1);
        assertEquals("Setting a new head should keep the ordering.", expResult, result);

    }

    @Test
    public void testRemove() {
        sampleList.remove(2);
        Integer expResult = 3;
        Integer result = sampleList.getElementAt(2);
        assertEquals("Second element should be 3 after removal of previous one", expResult, result);
        assertEquals("Size should now be 5", 5, sampleList.getSize());
        expResult = 1;
        result = sampleList.getElementAt(1);
        assertEquals("First element should stay the same.", expResult, result);
        sampleList.remove(0);
        result = sampleList.getElementAt(0);
        assertEquals("Deleting head shouln't break the list", expResult, result);
        assertEquals("Size should now be 4", 4, sampleList.getSize());

    }

}
