package recipe3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by O26 on 22/02/2016.
 */
public class StringConversionTest {
    private StringConversion stringConversion;

    @Test
    public void testConvertToString() throws Exception {
        assertEquals("3.14", Double.toString(stringConversion.getPi()));
        assertEquals("3.14", String.valueOf(stringConversion.getPi()));
        assertEquals("3.14", stringConversion.getStringValue());
    }

    @Test
    public void testtConvertFromString() throws Exception {
        assertEquals(3.14, Double.valueOf(stringConversion.getStringValue()),0.01);
    }

    @Before
    public void setUp() throws Exception {
        stringConversion = new StringConversion();
    }

    @After
    public void tearDown() throws Exception {
        stringConversion = null;
    }
}