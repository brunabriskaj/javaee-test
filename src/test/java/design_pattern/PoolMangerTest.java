package design_pattern;
import design_patterns.singleton_pattern.PoolManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class PoolMangerTest {

    private PoolManager singletonObject;

    @Before
    public void setUp() {
        singletonObject = mock(PoolManager.class);
        Mockito.doCallRealMethod().when(singletonObject).methodToTest();
    }

    @Test
    public void testMethodToTest() {
        assertTrue(singletonObject.methodToTest());
    }
}