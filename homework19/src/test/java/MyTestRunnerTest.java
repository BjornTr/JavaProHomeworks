import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyTestRunnerTest {
    @Annotations.BeforeSuite
    public static void setupBeforeSuite() {
        System.out.println("BeforeSuite method");
    }

    @Annotations.Test(priority = 2)
    public static void testMethod1() {
        System.out.println("TestMethod1");
        Assertions.assertTrue(true);
    }

    @Annotations.Test(priority = 1)
    public static void testMethod2() {
        System.out.println("TestMethod2");
        Assertions.assertEquals(2, 2);
    }
    @Annotations.Test(priority = 2)
    public static void testMethod3() {
        System.out.println("TestMethod3");
        Assertions.assertFalse(false);
    }
    @Annotations.Test(priority = 4)
    public static void testMethod4() {
        System.out.println("TestMethod4");
        Assertions.assertNotEquals(2, 3);
    }

    @Annotations.AfterSuite
    public static void teardownAfterSuite() {
        System.out.println("AfterSuite method");
    }

    @Test
    public void runTests() throws Exception {
        TestRunner.start(MyTestRunnerTest.class);
    }
}
