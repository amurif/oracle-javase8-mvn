package recipe6;

import javafx.application.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by O26 on 22/02/2016.
 */
public class BehaviorAsArgumentTest {

    private BehaviorAsArgument behaviorAsArgument;

    @Test
    public void testStartApplication() throws Exception {
        behaviorAsArgument.run();
    }

    @Before
    public void setUp() throws Exception {
        behaviorAsArgument = new BehaviorAsArgument();
    }

    @After
    public void tearDown() throws Exception {

    }
}