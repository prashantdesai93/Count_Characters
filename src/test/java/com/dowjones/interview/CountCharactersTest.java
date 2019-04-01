package com.dowjones.interview;

import com.dowjones.interview.exception.InvalidRangeException;
import org.junit.Assert;
import org.junit.Test;

import static com.dowjones.interview.app.CountCharacters.countChars;

public class CountCharactersTest {

    /**
     * this test case takes start and finish in a valid range
     */
    @Test
    public void validNumberRangeTest() throws InvalidRangeException {
        Assert.assertEquals("TenElevenTwelveThirteen".length(), countChars(10,13));
    }

    /**
     * this test case takes start and finish with same number
     */
    @Test
    public void validNumberTest() throws InvalidRangeException {
        Assert.assertEquals("Ninetynine".length(), countChars(99,99));
    }

    /**
     * this test case takes start and finish with smallest number as per requirement
     */
    @Test
    public void validSmallestNumberTest() throws InvalidRangeException {
        Assert.assertEquals("Zero".length(), countChars(0,0));
    }

    /**
     * this test case takes start and finish with largest number as per requirement
     */
    @Test
    public void validLargestNumberTest() throws InvalidRangeException {
        Assert.assertEquals("OneThousand".length(), countChars(1000,1000));
    }

    /**
     * this test case takes start and finish in an invalid range
     */
    @Test(expected = InvalidRangeException.class)
    public void invalidNumberRangeTest() throws InvalidRangeException {
        countChars(-1,-1);
    }

    /**
     * this test case takes start and finish in an invalid range
     */
    @Test(expected = InvalidRangeException.class)
    public void invalidNumberTest() throws InvalidRangeException {
        countChars(1001,1001);
    }
}
