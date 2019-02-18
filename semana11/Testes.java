import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class Testes {
    static JUnitCore junitCore;
    static Class<?> testClasses;

    public static void main(String[] args) {
        System.out.println("Running Junit Test Suite.");
        Result result = JUnitCore.runClasses(AllTests.class);
        System.out.println("Numero de falhas: " + result.getFailureCount() + " num total de " + result.getRunCount() + " testes");        
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

    }
}