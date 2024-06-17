package tasca4.n2exercici1;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

import static org.hamcrest.CoreMatchers.is;

public class CustomerMatcher {
    public static Matcher<String> hasLength(int length) {
        return new FeatureMatcher<String, Integer>(is(length), "una cadena amb longitud", "longitud") {
            @Override
            protected Integer featureValueOf(String actual) {
                return actual.length();
            }
        };
    }
}