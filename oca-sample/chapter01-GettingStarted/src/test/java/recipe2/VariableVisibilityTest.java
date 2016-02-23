package recipe2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by O26 on 22/02/2016.
 */
public class VariableVisibilityTest {

    private VariableVisibility variableVisibility;
    private VariableVisibility variableVisibility2;

    @Before
    public void setUp() throws Exception {
        variableVisibility = new VariableVisibility();
        variableVisibility2 = new VariableVisibility();
        variableVisibility.setLong(32768);
        variableVisibility.visibleFromEntirePackage = 3.1415926535;
    }

    @Test
    public void testVisibility() {
        assertEquals(32768L, variableVisibility.getLong());
        assertEquals(3.1415926535, variableVisibility.visibleFromEntirePackage,0E-10);
    }

    @Test
    public void testStaticVisibility() {
        assertEquals(false,variableVisibility.oneValueForAllObjects);
        assertEquals(false,variableVisibility2.oneValueForAllObjects);
        assertEquals(variableVisibility.oneValueForAllObjects,variableVisibility2.oneValueForAllObjects);
        VariableVisibility.oneValueForAllObjects = true;
        assertEquals(true,variableVisibility.oneValueForAllObjects);
        assertEquals(true,variableVisibility.oneValueForAllObjects);
        assertEquals(variableVisibility.oneValueForAllObjects,variableVisibility2.oneValueForAllObjects);
    }

    @After
    public void tearDown() throws Exception {
        variableVisibility = null;
    }
}