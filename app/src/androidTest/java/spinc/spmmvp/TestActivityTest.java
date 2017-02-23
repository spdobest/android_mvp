package spinc.spmmvp;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import spinc.spmmvp.espresso.TestActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class TestActivityTest {
    @Rule
    public ActivityTestRule<TestActivity> activityRule = new ActivityTestRule<>(
            TestActivity.class);

    @Test
    public void greet() {
   /*     onView(withId(R.id.buttonLogin))
                .check(matches(withText("")));

        onView(withId(R.id.buttonLogin))
                .check(matches(withText(R.string.read_text)))
                .perform(click());*/

        onView(withId(R.id.buttonLogin))
                .check(matches(withText(R.string.hello)));
    }
}