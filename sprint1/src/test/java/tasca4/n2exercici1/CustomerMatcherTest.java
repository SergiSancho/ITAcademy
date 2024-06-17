package tasca4.n2exercici1;


import org.junit.jupiter.api.Test;

import static tasca4.n2exercici1.CustomerMatcher.hasLength;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomerMatcherTest {
    @Test
    public void testStringLengthMatcher() {
        String testString = "Mordor";
        assertThat(testString, hasLength(8));
    }
}