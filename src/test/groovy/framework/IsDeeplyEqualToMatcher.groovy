package framework

import org.hamcrest.BaseMatcher
import org.hamcrest.Description
import org.skyscreamer.jsonassert.JSONCompare
import org.skyscreamer.jsonassert.JSONCompareMode
import org.skyscreamer.jsonassert.JSONCompareResult
import web.core.JsonMarshaller

class IsDeeplyEqualToMatcher extends BaseMatcher<Object> {

    private static JsonMarshaller marshaller = new JsonMarshaller()
    private String expected
    private String actual
    JSONCompareResult result

    private IsDeeplyEqualToMatcher(Object expected) {
        this.expected = toJson(expected)
    }

    public static IsDeeplyEqualToMatcher isDeeplyEqualTo(Object expected) {
        return new IsDeeplyEqualToMatcher(expected)
    }

    @Override
    boolean matches(Object actual) {
        this.actual = toJson(actual)
        result = JSONCompare.compareJSON(this.expected, this.actual, JSONCompareMode.STRICT)
        return result.passed()
    }

    private toJson(Object item) {
        if (item instanceof String) return item
        marshaller.writeValueAsString(item)
    }

    @Override
    void describeTo(Description description) {
        description.appendText("\n$expected\n")
    }

    @Override
    public void describeMismatch(Object item, Description description) {
        description.appendText("\n$actual")
        description.appendText("\nDiff:")
        description.appendText("\n${result.message}")
    }
}
