import com.bettercsw.unitTest.CoverageSampleMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author csw
 * @date 2020/1/9 10:09
 */
public class CoverageTest {
    @Test
    @DisplayName("line coverage sample test")
    void testLineCoverageSample() {
        CoverageSampleMethods coverageSampleMethods = new CoverageSampleMethods();
        Assertions.assertTrue(coverageSampleMethods.testMethod(1,2,0));
    }
    @ParameterizedTest
    @DisplayName("Condition coverage sample test result true")
    @CsvSource({
            "1,2,0",
            "1,0,3",
    })
    void testConditionDecisionCoverageTrue(int a,int b,int c) {
        CoverageSampleMethods coverageSampleMethods = new CoverageSampleMethods();
        Assertions.assertTrue(coverageSampleMethods.testMethod(a,b,c));
    }
    @Test
    @DisplayName("Condition Coverage sample test result false")
    void testConditionDecisionCoverageFalse() {
        CoverageSampleMethods coverageSampleMethods = new CoverageSampleMethods();
        Assertions.assertFalse(coverageSampleMethods.testMethod(0,0,0));
    }

    @ParameterizedTest
    @DisplayName("Multiple Condition Coverage sample test result true")
    @CsvSource({
            "1,2,3",
            "1,2,0",
            "1,0,3",
            "0,2,3",
            "0,0,3",
    })
    void testMultipleConditionDecisionCoverageTrue(int a,int b,int c) {
        CoverageSampleMethods coverageSampleMethods = new CoverageSampleMethods();
        Assertions.assertTrue(coverageSampleMethods.testMethod(a,b,c));
    }

    @ParameterizedTest
    @DisplayName("Multiple Condition Coverage sample test result true")
    @CsvSource({
            "0,0,0",
            "1,0,0",
            "0,2,0",
    })
    void testMultipleConditionDecisionCoverageFalse(int a,int b,int c) {
        CoverageSampleMethods coverageSampleMethods = new CoverageSampleMethods();
        Assertions.assertFalse(coverageSampleMethods.testMethod(a,b,c));
    }

    @ParameterizedTest
    @DisplayName("Path Coverage sample test result true")
    @CsvSource({
            "1,2,0",
            "1,0,3",
            "0,0,3",
    })
    void testPathCoverageSampleTrue(int a,int b,int c) {
        CoverageSampleMethods coverageSampleMethods = new CoverageSampleMethods();
        Assertions.assertTrue(coverageSampleMethods.testMethod(a,b,c));
    }

    @ParameterizedTest
    @DisplayName("Path Coverage sample test result false")
    @CsvSource({
            "1,0,0",
            "0,0,0",
    })
    void testPathCoverageSampleFalse(int a,int b,int c) {
        CoverageSampleMethods coverageSampleMethods = new CoverageSampleMethods();
        Assertions.assertFalse(coverageSampleMethods.testMethod(a,b,c));
    }

}
