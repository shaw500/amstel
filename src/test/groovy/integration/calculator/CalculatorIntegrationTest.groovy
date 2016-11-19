package integration.calculator

import amstel.calculator.Calculator
import integration.IntegrationTestBase
import org.junit.Test

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.core.IsEqual.equalTo

class CalculatorIntegrationTest extends IntegrationTestBase {

    @Test
    public void canAddTwoNumbers() throws Exception {
        def calculator = get(Calculator)

        def result = calculator.calculate(23, 'plus', 27)

        assertThat result, equalTo(50)
    }
}
