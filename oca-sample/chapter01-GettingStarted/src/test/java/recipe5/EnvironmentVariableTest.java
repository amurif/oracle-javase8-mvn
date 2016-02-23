package recipe5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by O26 on 22/02/2016.
 */
public class EnvironmentVariableTest {

    private EnvironmentVariable environmentVariable;

    @Test
    public void testReadAllEnvVariables(){
        assertNotNull(environmentVariable.getVars());
        System.out.println(environmentVariable.getVars());
    }

    @Before
    public void setUp() throws Exception {
        environmentVariable = new EnvironmentVariable();
    }

    @After
    public void tearDown() throws Exception {
        environmentVariable = null;
    }
}