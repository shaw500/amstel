package integration.calculator

import integration.IntegrationTestBase
import org.junit.Test

import static framework.IsDeeplyEqualToMatcher.isDeeplyEqualTo
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.core.IsEqual.equalTo

class CalculatorApiTests extends IntegrationTestBase {

    @Test
    public void canAddTwoNumbers() throws Exception {
        def response = get('api/calculate/23/plus/27')

        assertThat response.statusCode, equalTo(200)
        assertThat response.body.text, isDeeplyEqualTo(result: 50)
    }
}
