import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestRunner {
    public static void start(Class<?> testClass) throws Exception {
        Method[] methods = testClass.getDeclaredMethods();

        List<Method> testMethods = new ArrayList<>();
        Method beforeSuiteMethod = null;
        Method afterSuiteMethod = null;

        for (Method method : methods) {
            if (method.isAnnotationPresent(Annotations.Test.class)) {
                testMethods.add(method);
            } else if (method.isAnnotationPresent(Annotations.BeforeSuite.class)) {
                if (beforeSuiteMethod != null) {
                    throw new RuntimeException("Multiple @BeforeSuite methods found");
                }
                beforeSuiteMethod = method;
            } else if (method.isAnnotationPresent(Annotations.AfterSuite.class)) {
                if (afterSuiteMethod != null) {
                    throw new RuntimeException("Multiple @AfterSuite methods found");
                }
                afterSuiteMethod = method;
            }
        }

        testMethods.sort(Comparator.comparingInt((Method method) ->
                method.getAnnotation(Annotations.Test.class).priority()));

        if (beforeSuiteMethod != null) {
            beforeSuiteMethod.invoke(null);
        }

        for (Method method : testMethods) {
            method.invoke(null);
        }

        if (afterSuiteMethod != null) {
            afterSuiteMethod.invoke(null);
        }
    }
}
